package de.dagegenstand.qtech.common.data.materials;

import de.dagegenstand.qtech.common.blocks.BaseTintableBlock;
import de.dagegenstand.qtech.common.blocks.ModBlocks;
import de.dagegenstand.qtech.common.items.BaseTintableItem;
import de.dagegenstand.qtech.common.items.ModCreativeModeTabs;
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
    public Set<MaterialCraftingIngredients> ingredients;

    public HashMap<MaterialCraftingIngredients, String[]> alternativeTextures = new HashMap<>();

    public ResourceSetBuilder(String name, String displayName, int color) {
        this.name = name;
        this.displayName = displayName;
        this.color = color;
        this.ingredients = new HashSet<>();
    }

    public ResourceSetBuilder setAlternativeTexture(MaterialCraftingIngredients ingredient, String... textureString) {
        alternativeTextures.put(ingredient, textureString);
        return this;
    }

    public ResourceSetBuilder addIngredient(MaterialCraftingIngredients ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public ResourceSetBuilder addIngredients(MaterialCraftingIngredients... ingredients) {
        for(MaterialCraftingIngredients ingredient : ingredients) {
            addIngredient(ingredient);
        }
        return this;
    }

    public ResourceSetBuilder addAllIngredients(Material.MaterialType materialType, boolean includeNatural) {
        //Add all ingredients
        for(MaterialCraftingIngredients ingredient : MaterialCraftingIngredients.values()) {
            if(ingredient.isMaterialType(materialType)) addIngredient(ingredient);
        }

        //Remove ores if not wanted
        if(!includeNatural) {
            removeIngredient(MaterialCraftingIngredients.ORE);
            removeIngredient(MaterialCraftingIngredients.DEEPSLATE_ORE);
            removeIngredient(MaterialCraftingIngredients.NETHER_ORE);
            removeIngredient(MaterialCraftingIngredients.BASALT_ORE);
            removeIngredient(MaterialCraftingIngredients.BLACKSTONE_ORE);
            removeIngredient(MaterialCraftingIngredients.RAW_ORE);
            removeIngredient(MaterialCraftingIngredients.CRUSHED);
            removeIngredient(MaterialCraftingIngredients.RAW_ORE_BLOCK);
        }
        return this;
    }

    public ResourceSetBuilder removeNetherOres() {
        removeIngredient(MaterialCraftingIngredients.NETHER_ORE);
        removeIngredient(MaterialCraftingIngredients.BASALT_ORE);
        removeIngredient(MaterialCraftingIngredients.BLACKSTONE_ORE);
        return this;
    }

    public ResourceSetBuilder removeOverworldOres() {
        removeIngredient(MaterialCraftingIngredients.ORE);
        removeIngredient(MaterialCraftingIngredients.DEEPSLATE_ORE);
        return this;
    }

    public ResourceSetBuilder removeFlexible() {
        removeIngredient(MaterialCraftingIngredients.WIRE);
        removeIngredient(MaterialCraftingIngredients.WIRE);
        removeIngredient(MaterialCraftingIngredients.WIRE_COIL);
        removeIngredient(MaterialCraftingIngredients.SHEET);
        removeIngredient(MaterialCraftingIngredients.FOIL);

        return this;
    }

    public ResourceSetBuilder removeConductive() {
        removeIngredient(MaterialCraftingIngredients.WIRE);
        removeIngredient(MaterialCraftingIngredients.WIRE_COIL);

        return this;
    }

    public ResourceSetBuilder removeIngredient(MaterialCraftingIngredients ingredient) {
        this.ingredients.remove(ingredient);
        return this;
    }

    public ResourceSetBuilder removeIngredients(MaterialCraftingIngredients... ingredients) {
        for(MaterialCraftingIngredients ingredient : ingredients) {
            removeIngredient(ingredient);
        }
        return this;
    }

    public ResourceSetBuilder changeOreOverlay(String overlay) {
        setAlternativeTexture(MaterialCraftingIngredients.ORE, overlay, "minecraft:block/stone");
        setAlternativeTexture(MaterialCraftingIngredients.DEEPSLATE_ORE, overlay, "minecraft:block/deepslate");
        setAlternativeTexture(MaterialCraftingIngredients.NETHER_ORE, overlay, "minecraft:block/netherrack");
        setAlternativeTexture(MaterialCraftingIngredients.BASALT_ORE, overlay, "minecraft:block/smooth_basalt");
        setAlternativeTexture(MaterialCraftingIngredients.BLACKSTONE_ORE, overlay, "minecraft:block/blackstone");
        return this;
    }

    public void build() {
        Material material = new Material(name, displayName, color);

        for(MaterialCraftingIngredients ingredient : ingredients) {
            if(ingredient.isBlock()) {
                //Block
                var deferredBlock = ModBlocks.BLOCKS.register(MaterialCraftingIngredients.getItemName(ingredient, name), () -> new BaseTintableBlock(color, BlockBehaviour.Properties.of()));
                material.addBlock(ingredient, deferredBlock);

                //Block Item
                var deferredBlockItem = ModBlocks.registerBlockItemAndGetDeferredItem(MaterialCraftingIngredients.getItemName(ingredient, name), deferredBlock);
                material.addItem(ingredient, deferredBlockItem);

                //Block flags
                MaterialFlags blockFlags = new MaterialFlags().addTint(color).addTranslation("block.qtech." + MaterialCraftingIngredients.getItemName(ingredient, name), MaterialCraftingIngredients.getDisplayName(ingredient, displayName));

                if(alternativeTextures.containsKey(ingredient)) {
                    material.setBlockFlags(ingredient, blockFlags.addAlternativeTexture(alternativeTextures.get(ingredient)));
                }else{
                    material.setBlockFlags(ingredient, blockFlags);
                }

                //Item flags
                MaterialFlags itemFlags = new MaterialFlags().addCreativeTab(ModCreativeModeTabs.ModCreativeTabs.RESOURCES).setBlockItem();
                material.setItemFlags(ingredient, itemFlags);
            } else {
                //Item
                var deferredItem = ModItems.ITEMS.register(MaterialCraftingIngredients.getItemName(ingredient, name), () -> new BaseTintableItem(color, new Item.Properties()));
                material.addItem(ingredient, deferredItem);

                //Item flags
                MaterialFlags itemFlags = new MaterialFlags().addTint(color).addCreativeTab(ModCreativeModeTabs.ModCreativeTabs.RESOURCES).addTranslation("item.qtech." + MaterialCraftingIngredients.getItemName(ingredient, name), MaterialCraftingIngredients.getDisplayName(ingredient, displayName));

                if(alternativeTextures.containsKey(ingredient)) {
                    material.setItemFlags(ingredient, itemFlags.addAlternativeTexture(alternativeTextures.get(ingredient)));
                }else{
                    material.setItemFlags(ingredient, itemFlags);
                }
            }
        }

        Materials.registerMaterial(material);
    }
}
