package de.dagegenstand.qtech.content.resources;

import de.dagegenstand.qtech.content.blocks.BaseTintableBlock;
import de.dagegenstand.qtech.content.blocks.ModBlocks;
import de.dagegenstand.qtech.content.items.BaseTintableItem;
import de.dagegenstand.qtech.content.items.ModItems;
import de.dagegenstand.qtech.datagen.ModLangProvider;
import de.dagegenstand.qtech.util.RegisterUtils;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ResourceSetBuilder {
    public String name;
    public String displayName;
    public int color;
    public Set<MetalCraftingIngredient> ingredients;

    public HashMap<MetalCraftingIngredient, String[]> alternativeTextures = new HashMap<>();

    public ResourceSetBuilder(String name, String displayName, int color) {
        this.name = name;
        this.displayName = displayName;
        this.color = color;
        this.ingredients = new HashSet<>();
    }

    public ResourceSetBuilder setAlternativeTexture(MetalCraftingIngredient ingredient, String... textureString) {
        alternativeTextures.put(ingredient, textureString);
        return this;
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
        //Add all ingredients
        for(MetalCraftingIngredient ingredient : MetalCraftingIngredient.values()) {
            addIngredient(ingredient);
        }

        //Remove gem
        removeIngredient(MetalCraftingIngredient.GEM);

        //Remove ores if not wanted
        if(!includeNatural) {
            removeIngredient(MetalCraftingIngredient.ORE);
            removeIngredient(MetalCraftingIngredient.DEEPSLATE_ORE);
            removeIngredient(MetalCraftingIngredient.NETHER_ORE);
            removeIngredient(MetalCraftingIngredient.BASALT_ORE);
            removeIngredient(MetalCraftingIngredient.BLACKSTONE_ORE);
            removeIngredient(MetalCraftingIngredient.RAW_ORE);
            removeIngredient(MetalCraftingIngredient.CRUSHED);
            removeIngredient(MetalCraftingIngredient.RAW_ORE_BLOCK);
        }
        return this;
    }

    public ResourceSetBuilder removeNetherOres() {
        removeIngredient(MetalCraftingIngredient.NETHER_ORE);
        removeIngredient(MetalCraftingIngredient.BASALT_ORE);
        removeIngredient(MetalCraftingIngredient.BLACKSTONE_ORE);
        return this;
    }

    public ResourceSetBuilder removeOverworldOres() {
        removeIngredient(MetalCraftingIngredient.ORE);
        removeIngredient(MetalCraftingIngredient.DEEPSLATE_ORE);
        return this;
    }

    public ResourceSetBuilder removeFlexible() {
        removeIngredient(MetalCraftingIngredient.WIRE);
        removeIngredient(MetalCraftingIngredient.WIRE);
        removeIngredient(MetalCraftingIngredient.SHEET);
        removeIngredient(MetalCraftingIngredient.FOIL);

        return this;
    }

    public ResourceSetBuilder removeConductive() {
        removeIngredient(MetalCraftingIngredient.WIRE);
        removeIngredient(MetalCraftingIngredient.WIRE_COIL);

        return this;
    }

    public ResourceSetBuilder removeIngredient(MetalCraftingIngredient ingredient) {
        this.ingredients.remove(ingredient);
        return this;
    }

    public ResourceSetBuilder removeIngredients(MetalCraftingIngredient... ingredients) {
        for(MetalCraftingIngredient ingredient : ingredients) {
            removeIngredient(ingredient);
        }
        return this;
    }

    public ResourceSetBuilder isGem() {
        addIngredient(MetalCraftingIngredient.GEM);

        removeIngredient(MetalCraftingIngredient.INGOT);
        removeIngredient(MetalCraftingIngredient.NUGGET);
        removeIngredient(MetalCraftingIngredient.RAW_ORE);

        return this;
    }

    public ResourceSetBuilder changeOreOverlay(String overlay) {
        setAlternativeTexture(MetalCraftingIngredient.ORE, overlay, "minecraft:block/stone");
        setAlternativeTexture(MetalCraftingIngredient.DEEPSLATE_ORE, overlay, "minecraft:block/deepslate");
        setAlternativeTexture(MetalCraftingIngredient.NETHER_ORE, overlay, "minecraft:block/netherrack");
        setAlternativeTexture(MetalCraftingIngredient.BASALT_ORE, overlay, "minecraft:block/smooth_basalt");
        setAlternativeTexture(MetalCraftingIngredient.BLACKSTONE_ORE, overlay, "minecraft:block/blackstone");
        return this;
    }

    public void build() {
        for(MetalCraftingIngredient ingredient : ingredients) {
            if(ingredient.isBlock()) {
                //Block
                var deferredBlock = ModBlocks.BLOCKS.register(MetalCraftingIngredient.getItemName(ingredient, name), () -> new BaseTintableBlock(color, BlockBehaviour.Properties.of()));
                //Add block for color tinting
                if(alternativeTextures.containsKey(ingredient)) {
                    RegisterUtils.toRegisterBlocks.add(new RegisterUtils.RegisterEntry(ingredient, deferredBlock, alternativeTextures.get(ingredient)));
                }else{
                    RegisterUtils.toRegisterBlocks.add(new RegisterUtils.RegisterEntry(ingredient, deferredBlock));
                }

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
                if(alternativeTextures.containsKey(ingredient)) {
                    RegisterUtils.toRegisterItems.add(new RegisterUtils.RegisterEntry(ingredient, deferredItem, alternativeTextures.get(ingredient)));
                }else{
                    RegisterUtils.toRegisterItems.add(new RegisterUtils.RegisterEntry(ingredient, deferredItem));
                }
                //Add item to creative tab
                RegisterUtils.toCreativeResourceTab.add(deferredItem);

                //Lang
                ModLangProvider.toTranslate.put("item.qtech." + MetalCraftingIngredient.getItemName(ingredient, name), MetalCraftingIngredient.getDisplayName(ingredient, displayName));
            }
        }
    }
}
