package de.dagegenstand.qtech.common.data.materials;

import de.dagegenstand.qtech.common.items.ModCreativeModeTabs;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;

public class MaterialFlags {
    private boolean hasTranslation;
    private boolean hasTint;
    private boolean hasAlternativeTexture;
    private boolean hasCreativeTab;
    private boolean hasOreLootTable;
    private boolean needsToolLevel;

    private boolean blockItem;

    //Translation
    private String translationKey;
    private String translationValue;

    public MaterialFlags addTranslation(String key, String value) {
        this.hasTranslation = true;

        this.translationKey = key;
        this.translationValue = value;

        return this;
    }

    public String getTranslationKey() {
        return translationKey;
    }

    public String getTranslationValue() {
        return translationValue;
    }

    public boolean hasTranslation() {
        return hasTranslation;
    }

    //Tinting
    private int tintColor;

    public MaterialFlags addTint(int tintColor) {
        this.hasTint = true;

        this.tintColor = tintColor;

        return this;
    }

    public int getTintColor() {
        return tintColor;
    }

    public boolean hasTint() {
        return hasTint;
    }

    //Alternative Texture
    private String[] alternativeTextureStrings;

    public MaterialFlags addAlternativeTexture(String... textureString) {
        this.hasAlternativeTexture = true;

        this.alternativeTextureStrings = textureString;

        return this;
    }

    public String[] getAlternativeTextureStrings() {
        return alternativeTextureStrings;
    }

    public boolean hasAlternativeTexture() {
        return hasAlternativeTexture;
    }

    //Creative Tab
    private ModCreativeModeTabs.ModCreativeTabs creativeTab;

    public MaterialFlags addCreativeTab(ModCreativeModeTabs.ModCreativeTabs creativeTab) {
        this.hasCreativeTab = true;

        this.creativeTab = creativeTab;

        return this;
    }

    public ModCreativeModeTabs.ModCreativeTabs getCreativeTab() {
        return creativeTab;
    }

    public boolean hasCreativeTab() {
        return hasCreativeTab;
    }

    //Loot Table
    private float lootTableMinDrops;
    private float lootTableMaxDrops;

    private MaterialCraftingIngredients lootTableDroppedIngredient;

    public MaterialFlags addOreLootTable(float minDrops, float maxDrops, MaterialCraftingIngredients droppedIngredient) {
        this.hasOreLootTable = true;

        this.lootTableMinDrops = minDrops;
        this.lootTableMaxDrops = maxDrops;
        this.lootTableDroppedIngredient = droppedIngredient;

        return this;
    }

    public float getLootTableMinDrops() {
        return lootTableMinDrops;
    }

    public float getLootTableMaxDrops() {
        return lootTableMaxDrops;
    }

    public MaterialCraftingIngredients getLootTableDroppedIngredient() {
        return lootTableDroppedIngredient;
    }

    public boolean hasOreLootTable() {
        return hasOreLootTable;
    }

    //Block Item
    public MaterialFlags setBlockItem() {
        this.blockItem = true;
        return this;
    }

    public boolean isBlockItem() {
        return blockItem;
    }

    //Needs tool level
    private int requiredToolLevel;

    public MaterialFlags setNeededToolLevel(int requiredToolLevel) {
        this.needsToolLevel = true;

        this.requiredToolLevel = requiredToolLevel;

        return this;
    }

    public TagKey<Block> getRequiredToolLevelTag() {
        return switch (requiredToolLevel) {
            case 0 -> Tags.Blocks.NEEDS_WOOD_TOOL;
            case 2 -> BlockTags.NEEDS_IRON_TOOL;
            case 3 -> BlockTags.NEEDS_DIAMOND_TOOL;
            case 4 -> Tags.Blocks.NEEDS_NETHERITE_TOOL;
            default -> BlockTags.NEEDS_STONE_TOOL;
        };
    }

    public boolean needsToolLevel() {
        return needsToolLevel;
    }
}
