package de.dagegenstand.qtech.data.datagen;

import de.dagegenstand.qtech.QuanTech;
import de.dagegenstand.qtech.common.data.materials.Material;
import de.dagegenstand.qtech.common.data.materials.MaterialFlags;
import de.dagegenstand.qtech.common.data.materials.Materials;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {


    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, QuanTech.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {


        Map<String, Set<TagKey<Block>>> subTags = new HashMap<>();

        Materials.getAllMaterials().forEach(material ->
                material.getBlocks().forEach((type, block) -> {

                    //Base tags
                    for (Material.MaterialIngredientBaseTags baseTag : type.getMaterialTags()) {

                        String nameSpace = baseTag.getNamespace();
                        String folder = baseTag.getTagFolder();

                        String materialName = material.getName();

                        TagKey<Block> materialTag = TagKey.create(
                                Registries.BLOCK,
                                ResourceLocation.fromNamespaceAndPath(nameSpace, folder + "/" + materialName)
                        );

                        tag(materialTag).add(block.get());

                        subTags.computeIfAbsent(folder, f -> new HashSet<>()).add(materialTag);
                    }

                    //Needs tool level tags
                    if(material.getBlockFlags(type).needsToolLevel()) {
                        MaterialFlags flags = material.getBlockFlags(type);

                        tag(flags.getRequiredToolLevelTag()).add(block.get());
                    }
                })
        );

        subTags.forEach((folder, tags) -> {

            TagKey<Block> topTag = TagKey.create(
                    Registries.BLOCK,
                    ResourceLocation.fromNamespaceAndPath(Material.MaterialIngredientBaseTags.getNamespaceByFolder(folder), folder)
            );

            tags.forEach(subTag -> tag(topTag).addTag(subTag));
        });
    }
}
