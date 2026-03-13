package de.dagegenstand.qtech.data.datagen;

import de.dagegenstand.qtech.QuanTech;
import de.dagegenstand.qtech.common.blocks.ModBlocks;
import de.dagegenstand.qtech.common.data.materials.Materials;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Objects;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, QuanTech.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BASE_METAL_BLOCK);

        Materials.getAllMaterials().forEach(material -> {
            material.getAllBlocks().forEach(block -> {
                String[] textureBases = material.getTextureStrings(block);
                if(textureBases != null && textureBases.length > 0) {
                    blockWithTintedTopLayer(block, "tinted_cube_with_top_layer", textureBases);
                }else{
                    assert textureBases != null;
                    blockWithTintedTopLayer(block, "tinted_cube_with_top_layer", textureBases);
                }
            });
        });
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockWithTintedTopLayer(DeferredBlock<?> deferredBlock, String modelName, String[] textureBases) {
        Block block = deferredBlock.get();
        ResourceLocation blockLoc = Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(block));

        var model = models().getBuilder(blockLoc.toString())
                .parent(new ModelFile.UncheckedModelFile("qtech:block/" + modelName))
                .texture("base", (textureBases.length == 1) ? textureBases[0] : textureBases[1])
                .texture("overlay", textureBases[0]);

        simpleBlockWithItem(block, model);
    }
}