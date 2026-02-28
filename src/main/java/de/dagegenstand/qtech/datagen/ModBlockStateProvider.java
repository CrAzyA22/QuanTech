package de.dagegenstand.qtech.datagen;

import de.dagegenstand.qtech.QuanTech;
import de.dagegenstand.qtech.content.blocks.ModBlocks;
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
        basicCustomModelBlock(ModBlocks.STEEL_BLOCK, "tinted_cube_all","base_metal_block");
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void basicCustomModelBlock(DeferredBlock<?> deferredBlock, String modelPath, String resourcePath) {
        Block block = deferredBlock.get();
        ResourceLocation blockLoc = Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(block));

        var model = models().getBuilder(blockLoc.toString())
                .parent(new ModelFile.UncheckedModelFile("qtech:block/" + modelPath))
                .texture("all", "block/" + resourcePath);
        simpleBlockWithItem(block, model);
    }
}