package de.dagegenstand.qtech.common.data.materials;

import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Collection;
import java.util.HashMap;

public class Material {
    private String name;
    private String displayName;
    private int color;

    private HashMap<MaterialCraftingIngredients, DeferredItem<?>> items;
    private HashMap<MaterialCraftingIngredients, DeferredBlock<?>> blocks;

    private HashMap<MaterialCraftingIngredients, MaterialFlags> itemIngredientFlags;
    private HashMap<MaterialCraftingIngredients, MaterialFlags> blockIngredientFlags;

    public Material(String name, String displayName, int color) {
        this.name = name;
        this.displayName = displayName;
        this.color = color;
        this.items = new HashMap<>();
        this.blocks = new HashMap<>();
        this.itemIngredientFlags = new HashMap<>();
        this.blockIngredientFlags = new HashMap<>();
    }

    public void addItem(MaterialCraftingIngredients ingredient, DeferredItem<?> item) {
        this.items.put(ingredient, item);
    }

    public void addBlock(MaterialCraftingIngredients ingredient, DeferredBlock<?> block) {
        this.blocks.put(ingredient, block);
    }

    public void setItemFlags(MaterialCraftingIngredients ingredient, MaterialFlags flag) {
        this.itemIngredientFlags.put(ingredient, flag);
    }

    public void setBlockFlags(MaterialCraftingIngredients ingredient, MaterialFlags flag) {
        this.blockIngredientFlags.put(ingredient, flag);
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getColor() {
        return color;
    }

    public String[] getTextureStrings(DeferredBlock<?> block) {
        for(MaterialCraftingIngredients ingredient : blocks.keySet()) {
            if(blocks.get(ingredient).equals(block)) {
                MaterialFlags flags = blockIngredientFlags.get(ingredient);
                if(flags != null && flags.hasAlternativeTexture()) {
                    return flags.getAlternativeTextureStrings();
                }else{
                    return ingredient.getBaseTextures();
                }
            }
        }
        return null;
    }

    public String[] getTextureStrings(DeferredItem<?> item) {
        for(MaterialCraftingIngredients ingredient : items.keySet()) {
            if(items.get(ingredient).equals(item)) {
                MaterialFlags flags = itemIngredientFlags.get(ingredient);
                if(flags != null && flags.hasAlternativeTexture()) {
                    return flags.getAlternativeTextureStrings();
                }else{
                    return ingredient.getBaseTextures();
                }
            }
        }
        return null;
    }

    public HashMap<MaterialCraftingIngredients, DeferredItem<?>> getItems() {
        return items;
    }

    public HashMap<MaterialCraftingIngredients, DeferredBlock<?>> getBlocks() {
        return blocks;
    }

    public MaterialFlags getItemFlags(MaterialCraftingIngredients ingredient) {
        return itemIngredientFlags.get(ingredient);
    }

    public MaterialFlags getItemFlags(DeferredItem<?> item) {
        for(MaterialCraftingIngredients ingredient : items.keySet()) {
            if(items.get(ingredient).equals(item)) {
                return itemIngredientFlags.get(ingredient);
            }
        }
        return null;
    }

    public MaterialFlags getBlockFlags(MaterialCraftingIngredients ingredient) {
        return blockIngredientFlags.get(ingredient);
    }

    public MaterialFlags getBlockFlags(DeferredBlock<?> block) {
        for(MaterialCraftingIngredients ingredient : blocks.keySet()) {
            if(blocks.get(ingredient).equals(block)) {
                return blockIngredientFlags.get(ingredient);
            }
        }
        return null;
    }

    public Collection<DeferredBlock<?>> getAllBlocks() {
        return blocks.values();
    }

    public Collection<DeferredItem<?>> getAllItems() {
        return items.values();
    }

    public HashMap<DeferredBlock<?>, MaterialFlags> getAllBlockFlags() {
        HashMap<DeferredBlock<?>, MaterialFlags> blockFlags = new HashMap<>();
        for(MaterialCraftingIngredients ingredient : blocks.keySet()) {
            blockFlags.put(blocks.get(ingredient), blockIngredientFlags.get(ingredient));
        }
        return blockFlags;
    }

    public HashMap<DeferredItem<?>, MaterialFlags> getAllItemFlags() {
        HashMap<DeferredItem<?>, MaterialFlags> itemFlags = new HashMap<>();
        for(MaterialCraftingIngredients ingredient : items.keySet()) {
            itemFlags.put(items.get(ingredient), itemIngredientFlags.get(ingredient));
        }
        return itemFlags;
    }

    public static enum MaterialType {
        METAL,
        GEM,
        WOOD,
        LIQUID,
        GAS,;
    }
}
