package de.dagegenstand.qtech.data.datagen;

import de.dagegenstand.qtech.QuanTech;
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

        for(var entry : RegisterUtils.toRegisterItems) {
            String[] textures = entry.getTextureStrings();
            if(textures != null && textures.length > 0) {
                multiLayerBasicItem(((DeferredItem<?>) entry.entry).asItem(), entry.getTextureStrings());
            }
        }
    }

    private void differentTextureBasicItem(Item item, String resourcePath) {
        ResourceLocation itemLoc = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        this.getBuilder(itemLoc.toString()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", resourcePath);
    }

    private void multiLayerBasicItem(Item item, String[] resourcePaths) {
        ResourceLocation itemLoc = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        var builder = this.getBuilder(itemLoc.toString()).parent(new ModelFile.UncheckedModelFile("item/generated"));

        for(int i = 0; i < resourcePaths.length; i++) {
            if(resourcePaths[i] == null) continue;
            builder.texture("layer" + i, resourcePaths[i]);
        }
    }

    private void blockItemModelFromTextures(Item item, String[] textures) {
        ResourceLocation itemLoc = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        var builder = this.getBuilder(itemLoc.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"));

        // Verwende die erste Textur für Block Items
        if(textures.length > 0 && textures[0] != null) {
            String texture = textures[0].startsWith("block/") ? textures[0].replace("block/", "") : textures[0];
            builder.texture("layer0", "item/" + texture);
        }
    }
}
