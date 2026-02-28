package de.dagegenstand.qtech.content.blocks;

import de.dagegenstand.qtech.QuanTech;
import de.dagegenstand.qtech.content.items.ModItems;
import de.dagegenstand.qtech.content.items.TintableBlockItem;
import de.dagegenstand.qtech.content.resources.MetalCraftingIngredient;
import de.dagegenstand.qtech.util.items.ITintable;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(QuanTech.MODID);

    public static List<BlockEntry> toRegisterBlocks = new ArrayList<>();

    public static class BlockEntry {
        public final MetalCraftingIngredient ingredient;
        public final DeferredBlock<?> block;

        public BlockEntry(MetalCraftingIngredient ingredient, DeferredBlock<?> block) {
            this.ingredient = ingredient;
            this.block = block;
        }

        public DeferredBlock<?> get() {
            return block;
        }
    }

    public static final DeferredBlock<Block> BASE_METAL_BLOCK = registerBlockItem("base_metal_block", () -> new Block(Block.Properties.of().mapColor(MapColor.METAL).strength(5.0f, 6.0f)));

    public static <T extends Block> DeferredBlock<T> registerBlockItem(String name, Supplier<T> blockSupplier) {
        DeferredBlock<T> block = BLOCKS.register(name, blockSupplier);
        registerBlockItem(name, block);
        return block;
    }

    public static <T extends Block> DeferredItem<?> registerBlockItemAndGetDeferredItem(String name, DeferredBlock<T> block) {
        return ModItems.ITEMS.register(name, () -> {
            Block blockInstance = block.get();
            if (blockInstance instanceof ITintable tintableBlock) {
                return new TintableBlockItem(blockInstance, new Item.Properties(), tintableBlock.getTintColor());
            } else {
                return new BlockItem(blockInstance, new Item.Properties());
            }
        });
    }

    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        registerBlockItemAndGetDeferredItem(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
