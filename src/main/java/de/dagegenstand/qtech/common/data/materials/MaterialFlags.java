package de.dagegenstand.qtech.common.data.materials;

import de.dagegenstand.qtech.common.items.ModCreativeModeTabs;

public class MaterialFlags {
    private boolean hasTranslation;
    private boolean hasTint;
    private boolean hasAlternativeTexture;
    private boolean hasCreativeTab;
    private boolean hasLootTable;

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
    private String tempLootTableString;

    public MaterialFlags addLootTable() {
        this.hasLootTable = true;

        return this;
    }

    public boolean hasLootTable() {
        return hasLootTable;
    }

    //Block Item
    public MaterialFlags setBlockItem() {
        this.blockItem = true;
        return this;
    }

    public boolean isBlockItem() {
        return blockItem;
    }
}
