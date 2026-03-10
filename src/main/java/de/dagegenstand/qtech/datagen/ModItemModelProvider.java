package de.dagegenstand.qtech.datagen;

import de.dagegenstand.qtech.QuanTech;
import de.dagegenstand.qtech.content.items.ModItems;
import de.dagegenstand.qtech.util.RegisterUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
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
            String texturePath = entry.ingredient.isBlock() ? "block/" : "item/";
            texturePath += entry.ingredient.getBaseTexture();
            differentTextureBasicItem(((DeferredItem<?>) entry.entry).get(), texturePath);
        }
    }

    private void differentTextureBasicItem(Item item, String resourcePath) {
        ResourceLocation itemLoc = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
        this.getBuilder(itemLoc.toString()).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", resourcePath);
    }
}
