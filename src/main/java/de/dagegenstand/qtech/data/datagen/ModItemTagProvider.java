package de.dagegenstand.qtech.data.datagen;

import de.dagegenstand.qtech.QuanTech;
import de.dagegenstand.qtech.common.data.materials.Material;
import de.dagegenstand.qtech.common.data.materials.MaterialCraftingIngredients;
import de.dagegenstand.qtech.common.data.materials.Materials;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, QuanTech.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        Map<String, Set<TagKey<Item>>> subTags = new HashMap<>();

        Materials.getAllMaterials().forEach(material -> material.getItems().forEach((type, item) -> {
            for(Material.MaterialIngredientBaseTags baseTag : type.getMaterialTags()) {

                String nameSpace = baseTag.getNamespace();
                String folder = baseTag.getTagFolder();

                //Create material tag
                String materialName = material.getName();

                TagKey<Item> materialTag = TagKey.create(
                        Registries.ITEM,
                        ResourceLocation.fromNamespaceAndPath(nameSpace, folder + "/" + materialName)
                );

                //Add item to material tag<
                tag(materialTag).add(item.get());

                //Add subTags to top tags
                subTags.computeIfAbsent(folder, f -> new HashSet<>()).add(materialTag);
            }
        }));

        subTags.forEach((folder, tags) -> {
            //Create top tag
            TagKey<Item> topTag = TagKey.create(
                    Registries.ITEM,
                    ResourceLocation.fromNamespaceAndPath(Material.MaterialIngredientBaseTags.getNamespaceByFolder(folder), folder)
            );

            tags.forEach(subTag -> tag(topTag).addTag(subTag));
        });
    }
}
