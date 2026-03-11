package de.dagegenstand.qtech.common.data.materials;

import de.dagegenstand.qtech.common.blocks.BaseTintableBlock;
import de.dagegenstand.qtech.common.blocks.ModBlocks;
import de.dagegenstand.qtech.common.items.BaseTintableItem;
import de.dagegenstand.qtech.common.items.ModItems;
import de.dagegenstand.qtech.data.datagen.ModLangProvider;
import de.dagegenstand.qtech.util.common.RegisterUtils;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ResourceSetBuilder {
    public String name;
    public String displayName;
    public int color;
    public Set<MaterialCraftingIngredientsMetal> ingredients;

    public HashMap<MaterialCraftingIngredientsMetal, String[]> alternativeTextures = new HashMap<>();

    public ResourceSetBuilder(String name, String displayName, int color) {
        this.name = name;
        this.displayName = displayName;
        this.color = color;
        this.ingredients = new HashSet<>();
    }

    public ResourceSetBuilder setAlternativeTexture(MaterialCraftingIngredientsMetal ingredient, String... textureString) {
        alternativeTextures.put(ingredient, textureString);
        return this;
    }

    public ResourceSetBuilder addIngredient(MaterialCraftingIngredientsMetal ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public ResourceSetBuilder addIngredients(MaterialCraftingIngredientsMetal... ingredients) {
        for(MaterialCraftingIngredientsMetal ingredient : ingredients) {
            addIngredient(ingredient);
        }
        return this;
    }

    public ResourceSetBuilder addAllIngredients(boolean includeNatural) {
        //Add all ingredients
        for(MaterialCraftingIngredientsMetal ingredient : MaterialCraftingIngredientsMetal.values()) {
            addIngredient(ingredient);
        }

        //Remove gem
        removeIngredient(MaterialCraftingIngredientsMetal.GEM);

        //Remove ores if not wanted
        if(!includeNatural) {
            removeIngredient(MaterialCraftingIngredientsMetal.ORE);
            removeIngredient(MaterialCraftingIngredientsMetal.DEEPSLATE_ORE);
            removeIngredient(MaterialCraftingIngredientsMetal.NETHER_ORE);
            removeIngredient(MaterialCraftingIngredientsMetal.BASALT_ORE);
            removeIngredient(MaterialCraftingIngredientsMetal.BLACKSTONE_ORE);
            removeIngredient(MaterialCraftingIngredientsMetal.RAW_ORE);
            removeIngredient(MaterialCraftingIngredientsMetal.CRUSHED);
            removeIngredient(MaterialCraftingIngredientsMetal.RAW_ORE_BLOCK);
        }
        return this;
    }

    public ResourceSetBuilder removeNetherOres() {
        removeIngredient(MaterialCraftingIngredientsMetal.NETHER_ORE);
        removeIngredient(MaterialCraftingIngredientsMetal.BASALT_ORE);
        removeIngredient(MaterialCraftingIngredientsMetal.BLACKSTONE_ORE);
        return this;
    }

    public ResourceSetBuilder removeOverworldOres() {
        removeIngredient(MaterialCraftingIngredientsMetal.ORE);
        removeIngredient(MaterialCraftingIngredientsMetal.DEEPSLATE_ORE);
        return this;
    }

    public ResourceSetBuilder removeFlexible() {
        removeIngredient(MaterialCraftingIngredientsMetal.WIRE);
        removeIngredient(MaterialCraftingIngredientsMetal.WIRE);
        removeIngredient(MaterialCraftingIngredientsMetal.WIRE_COIL);
        removeIngredient(MaterialCraftingIngredientsMetal.SHEET);
        removeIngredient(MaterialCraftingIngredientsMetal.FOIL);

        return this;
    }

    public ResourceSetBuilder removeConductive() {
        removeIngredient(MaterialCraftingIngredientsMetal.WIRE);
        removeIngredient(MaterialCraftingIngredientsMetal.WIRE_COIL);

        return this;
    }

    public ResourceSetBuilder removeIngredient(MaterialCraftingIngredientsMetal ingredient) {
        this.ingredients.remove(ingredient);
        return this;
    }

    public ResourceSetBuilder removeIngredients(MaterialCraftingIngredientsMetal... ingredients) {
        for(MaterialCraftingIngredientsMetal ingredient : ingredients) {
            removeIngredient(ingredient);
        }
        return this;
    }

    public ResourceSetBuilder isGem() {
        addIngredient(MaterialCraftingIngredientsMetal.GEM);

        removeIngredient(MaterialCraftingIngredientsMetal.INGOT);
        removeIngredient(MaterialCraftingIngredientsMetal.NUGGET);
        removeIngredient(MaterialCraftingIngredientsMetal.RAW_ORE);

        return this;
    }

    public ResourceSetBuilder changeOreOverlay(String overlay) {
        setAlternativeTexture(MaterialCraftingIngredientsMetal.ORE, overlay, "minecraft:block/stone");
        setAlternativeTexture(MaterialCraftingIngredientsMetal.DEEPSLATE_ORE, overlay, "minecraft:block/deepslate");
        setAlternativeTexture(MaterialCraftingIngredientsMetal.NETHER_ORE, overlay, "minecraft:block/netherrack");
        setAlternativeTexture(MaterialCraftingIngredientsMetal.BASALT_ORE, overlay, "minecraft:block/smooth_basalt");
        setAlternativeTexture(MaterialCraftingIngredientsMetal.BLACKSTONE_ORE, overlay, "minecraft:block/blackstone");
        return this;
    }

    public void build() {
        for(MaterialCraftingIngredientsMetal ingredient : ingredients) {
            if(ingredient.isBlock()) {
                //Block
                var deferredBlock = ModBlocks.BLOCKS.register(MaterialCraftingIngredientsMetal.getItemName(ingredient, name), () -> new BaseTintableBlock(color, BlockBehaviour.Properties.of()));
                //Add block for color tinting
                if(alternativeTextures.containsKey(ingredient)) {
                    RegisterUtils.toRegisterBlocks.add(new RegisterUtils.RegisterEntry(ingredient, deferredBlock, alternativeTextures.get(ingredient)));
                }else{
                    RegisterUtils.toRegisterBlocks.add(new RegisterUtils.RegisterEntry(ingredient, deferredBlock));
                }

                //Block Item
                var deferredBlockItem = ModBlocks.registerBlockItemAndGetDeferredItem(MaterialCraftingIngredientsMetal.getItemName(ingredient, name), deferredBlock);
                //Add block to creative tab
                RegisterUtils.toCreativeResourceTab.add(deferredBlockItem);

                //Lang
                ModLangProvider.toTranslate.put("block.qtech." + MaterialCraftingIngredientsMetal.getItemName(ingredient, name), MaterialCraftingIngredientsMetal.getDisplayName(ingredient, displayName));
            } else {
                //Item
                var deferredItem = ModItems.ITEMS.register(MaterialCraftingIngredientsMetal.getItemName(ingredient, name), () -> new BaseTintableItem(color, new Item.Properties()));
                //Add item for color tinting
                if(alternativeTextures.containsKey(ingredient)) {
                    RegisterUtils.toRegisterItems.add(new RegisterUtils.RegisterEntry(ingredient, deferredItem, alternativeTextures.get(ingredient)));
                }else{
                    RegisterUtils.toRegisterItems.add(new RegisterUtils.RegisterEntry(ingredient, deferredItem));
                }
                //Add item to creative tab
                RegisterUtils.toCreativeResourceTab.add(deferredItem);

                //Lang
                ModLangProvider.toTranslate.put("item.qtech." + MaterialCraftingIngredientsMetal.getItemName(ingredient, name), MaterialCraftingIngredientsMetal.getDisplayName(ingredient, displayName));
            }
        }
    }
}
