package de.dagegenstand.qtech.content.resources;

import de.dagegenstand.qtech.content.blocks.BaseTintableBlock;
import de.dagegenstand.qtech.content.blocks.ModBlocks;
import de.dagegenstand.qtech.content.items.BaseTintableItem;
import de.dagegenstand.qtech.content.items.ModItems;
import de.dagegenstand.qtech.datagen.ModLangProvider;
import de.dagegenstand.qtech.util.RegisterUtils;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.HashSet;
import java.util.Set;

public class ResourceSetBuilder {
    public String name;
    public String displayName;
    public int color;
    boolean alloy;
    public Set<MetalCraftingIngredient> ingredients;

    public ResourceSetBuilder(String name, String displayName, int color) {
        this.name = name;
        this.displayName = displayName;
        this.color = color;
        this.alloy = alloy;
        this.ingredients = new HashSet<>();
    }

    public ResourceSetBuilder addIngredient(MetalCraftingIngredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public ResourceSetBuilder addIngredients(MetalCraftingIngredient... ingredients) {
        for(MetalCraftingIngredient ingredient : ingredients) {
            addIngredient(ingredient);
        }
        return this;
    }

    public ResourceSetBuilder addAllIngredients(boolean includeNatural) {
        for(MetalCraftingIngredient ingredient : MetalCraftingIngredient.values()) {
            addIngredient(ingredient);
        }
        if(!includeNatural) {
            removeIngredient(MetalCraftingIngredient.ORE);
            removeIngredient(MetalCraftingIngredient.DEEPSLATE_ORE);
            removeIngredient(MetalCraftingIngredient.NETHER_ORE);
            removeIngredient(MetalCraftingIngredient.BASALT_ORE);
            removeIngredient(MetalCraftingIngredient.BLACKSTONE_ORE);
            removeIngredient(MetalCraftingIngredient.RAW_ORE);
            removeIngredient(MetalCraftingIngredient.CRUSHED);
        }
        return this;
    }

    public ResourceSetBuilder removeNetherOres() {
        removeIngredient(MetalCraftingIngredient.NETHER_ORE);
        removeIngredient(MetalCraftingIngredient.BASALT_ORE);
        removeIngredient(MetalCraftingIngredient.BLACKSTONE_ORE);
        return this;
    }

    public ResourceSetBuilder removeIngredient(MetalCraftingIngredient ingredient) {
        this.ingredients.remove(ingredient);
        return this;
    }

    public void build() {
        for(MetalCraftingIngredient ingredient : ingredients) {
            if(ingredient.isBlock()) {
                //Block
                var deferredBlock = ModBlocks.BLOCKS.register(MetalCraftingIngredient.getItemName(ingredient, name), () -> new BaseTintableBlock(color, BlockBehaviour.Properties.of()));
                //Add block for color tinting
                RegisterUtils.toRegisterBlocks.add(new RegisterUtils.RegisterEntry(ingredient, deferredBlock));

                //Block Item
                var deferredBlockItem = ModBlocks.registerBlockItemAndGetDeferredItem(MetalCraftingIngredient.getItemName(ingredient, name), deferredBlock);
                //Add block to creative tab
                RegisterUtils.toCreativeResourceTab.add(deferredBlockItem);

                //Lang
                ModLangProvider.toTranslate.put("block.qtech." + MetalCraftingIngredient.getItemName(ingredient, name), MetalCraftingIngredient.getDisplayName(ingredient, displayName));
            } else {
                //Item
                var deferredItem = ModItems.ITEMS.register(MetalCraftingIngredient.getItemName(ingredient, name), () -> new BaseTintableItem(color, new Item.Properties()));
                //Add item for color tinting
                RegisterUtils.toRegisterItems.add(new RegisterUtils.RegisterEntry(ingredient, deferredItem));
                //Add item to creative tab
                RegisterUtils.toCreativeResourceTab.add(deferredItem);

                //Lang
                ModLangProvider.toTranslate.put("item.qtech." + MetalCraftingIngredient.getItemName(ingredient, name), MetalCraftingIngredient.getDisplayName(ingredient, displayName));
            }
        }
    }
}
