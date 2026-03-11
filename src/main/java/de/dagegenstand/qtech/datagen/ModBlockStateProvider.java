package de.dagegenstand.qtech.datagen;

import de.dagegenstand.qtech.QuanTech;
import de.dagegenstand.qtech.content.blocks.ModBlocks;
import de.dagegenstand.qtech.util.RegisterUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Arrays;
import java.util.Objects;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, QuanTech.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BASE_METAL_BLOCK);

        for(var entry : RegisterUtils.toRegisterBlocks) {
            blockWithTintedTopLayer((DeferredBlock<?>) entry.entry, "ore_tinted", entry.getTextureStrings());
        }
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

    /*
    private void basicCustomModelBlock(DeferredBlock<?> deferredBlock, String modelPath, String... resourcePath) {
        Block block = deferredBlock.get();
        ResourceLocation blockLoc = Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(block));

        if(resourcePath.length == 0 || resourcePath[0] == null) {return;}

        var model = models().getBuilder(blockLoc.toString())
                .parent(new ModelFile.UncheckedModelFile("qtech:block/" + modelPath))
                .texture("all", "block/" + resourcePath[0]);
        simpleBlockWithItem(block, model);
    }
    */
}