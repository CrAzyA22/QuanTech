package de.dagegenstand.qtech.data.datagen;

import de.dagegenstand.qtech.QuanTech;
import de.dagegenstand.qtech.common.data.materials.Materials;
import de.dagegenstand.qtech.common.items.ModItems;
import de.dagegenstand.qtech.util.common.RegisterUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, QuanTech.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BASE_INGOT.get());

        Materials.getAllMaterials().forEach(material -> {
            material.getAllItems().forEach(item -> {
                String[] textures = material.getTextureStrings(item);
                if(!material.getItemFlags(item).isBlockItem()) {
                    if (textures != null && textures.length > 0) {
                        if (material.getAllItemFlags().get(item) != null && material.getAllItemFlags().get(item).hasAlternativeTexture()) {
                            multiLayerBasicItem(item.asItem(), textures);
                        } else {
                            differentTextureBasicItem(item.asItem(), textures[0]);
                        }
                    } else {
                        basicItem(item.asItem());
                    }
                }
            });
        });
    }

    private void differentTextureBasicItem(Item item, String resourcePath) {
        ResourceLocation itemLoc = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        String cleanPath = resourcePath.replace("item/", "").replace("block/", "");
        this.getBuilder(itemLoc.toString()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", "item/" + cleanPath);
    }

    private void multiLayerBasicItem(Item item, String[] resourcePaths) {
        ResourceLocation itemLoc = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        var builder = this.getBuilder(itemLoc.toString()).parent(new ModelFile.UncheckedModelFile("item/generated"));

        for(int i = 0; i < resourcePaths.length; i++) {
            if(resourcePaths[i] == null) continue;
            String cleanPath = resourcePaths[i].replace("item/", "").replace("block/", "");
            builder.texture("layer" + i, "item/" + cleanPath);
        }
    }
}
