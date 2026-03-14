package de.dagegenstand.qtech.common.data.materials;

import java.util.List;

import static de.dagegenstand.qtech.common.data.materials.Materials.provideMaterialTypes;
import static de.dagegenstand.qtech.common.data.materials.Materials.providerMaterialTags;

public enum MaterialCraftingIngredients {
    //Crafting Ingredients
    INGOT("*metal*_ingot", "*metal* Ingot", providerMaterialTags(Material.MaterialIngredientBaseTags.INGOT), provideMaterialTypes(Material.MaterialType.METAL), false, "base_ingot"),
    NUGGET("*metal*_nugget", "*metal* Nugget", providerMaterialTags(Material.MaterialIngredientBaseTags.NUGGET), provideMaterialTypes(Material.MaterialType.METAL), false, "base_nugget"),
    PLATE("*metal*_plate", "*metal* Plate", providerMaterialTags(Material.MaterialIngredientBaseTags.PLATE), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_plate"),
    ROD("*metal*_rod", "*metal* Rod", providerMaterialTags(Material.MaterialIngredientBaseTags.ROD), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_rod"),
    GEAR("*metal*_gear", "*metal* Gear", providerMaterialTags(Material.MaterialIngredientBaseTags.GEAR), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_gear"),
    WIRE("*metal*_wire", "*metal* Wire", providerMaterialTags(Material.MaterialIngredientBaseTags.WIRE), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_wire"),
    BLOCK("*metal*_block", "Block of *metal*", providerMaterialTags(Material.MaterialIngredientBaseTags.METAL_BLOCK), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), true, "block/base_metal_block"),
    SHEET("*metal*_sheet", "*metal* Sheet", providerMaterialTags(Material.MaterialIngredientBaseTags.SHEET), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_sheet"),
    DUST("*metal*_dust", "*metal* Dust", providerMaterialTags(Material.MaterialIngredientBaseTags.DUST), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_dust"),
    BOLT("*metal*_bolt", "*metal* Bolt", providerMaterialTags(Material.MaterialIngredientBaseTags.BOLT), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_bolt"),
    SCREW("*metal*_screw", "*metal* Screw", providerMaterialTags(Material.MaterialIngredientBaseTags.SCREW), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_screw"),
    SPRING("*metal*_spring", "*metal* Spring", providerMaterialTags(Material.MaterialIngredientBaseTags.SPRING), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_spring"),
    RING("*metal*_ring", "*metal* Ring", providerMaterialTags(Material.MaterialIngredientBaseTags.RING), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_ring"),
    ROTOR("*metal*_rotor", "*metal* Rotor", providerMaterialTags(Material.MaterialIngredientBaseTags.ROTOR), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_rotor"),
    DOUBLE_PLATE("*metal*_double_plate", "*metal* Double Plate", providerMaterialTags(Material.MaterialIngredientBaseTags.DOUBLE_PLATE), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_double_plate"),
    FOIL("*metal*_foil", "*metal* Foil", providerMaterialTags(Material.MaterialIngredientBaseTags.FOIL), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_foil"),
    WIRE_COIL("*metal*_wire_coil", "*metal* Wire Coil", providerMaterialTags(Material.MaterialIngredientBaseTags.WIRE_COIL), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_wire_coil_overlay", "base_wire_coil_base"),

    //Gems
    GEM("*metal*_gem", "*metal* Gem", providerMaterialTags(Material.MaterialIngredientBaseTags.GEM), provideMaterialTypes(Material.MaterialType.GEM), false, "base_gem"),

    //Ores
    ORE("*metal*_ore", "*metal* Ore", providerMaterialTags(Material.MaterialIngredientBaseTags.ORE, Material.MaterialIngredientBaseTags.STONE_ORE), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), true, "block/base_ore_overlay_alt_one", "minecraft:block/stone"),
    DEEPSLATE_ORE("deepslate_*metal*_ore", "Deepslate *metal* Ore", providerMaterialTags(Material.MaterialIngredientBaseTags.ORE, Material.MaterialIngredientBaseTags.DEEPSLATE_ORE), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), true, "block/base_ore_overlay_alt_one", "minecraft:block/deepslate"),
    NETHER_ORE("netherrack_*metal*_ore", "Netherrack *metal* Ore", providerMaterialTags(Material.MaterialIngredientBaseTags.ORE, Material.MaterialIngredientBaseTags.NETHER_ORE), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), true, "block/base_ore_overlay_alt_one", "minecraft:block/netherrack"),
    BASALT_ORE("basalt_*metal*_ore", "Basalt *metal* Ore", providerMaterialTags(Material.MaterialIngredientBaseTags.ORE, Material.MaterialIngredientBaseTags.BASALT_ORE), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), true, "block/base_ore_overlay_alt_one", "minecraft:block/smooth_basalt"),
    BLACKSTONE_ORE("blackstone_*metal*_ore", "Blackstone *metal* Ore", providerMaterialTags(Material.MaterialIngredientBaseTags.ORE, Material.MaterialIngredientBaseTags.BLACKSTONE_ORE), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), true, "block/base_ore_overlay_alt_one", "minecraft:block/blackstone"),
    ENDSTONE_ORE("endstone_*metal*_ore", "Endstone *metal* Ore", providerMaterialTags(Material.MaterialIngredientBaseTags.ORE, Material.MaterialIngredientBaseTags.END_ORE), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), true, "block/base_ore_overlay_alt_one", "minecraft:block/end_stone"),
    RAW_ORE("raw_*metal*_ore", "Raw *metal* Ore", providerMaterialTags(Material.MaterialIngredientBaseTags.RAW_MATERIAL), provideMaterialTypes(Material.MaterialType.METAL), false, "base_raw_ore"),
    RAW_ORE_BLOCK("raw_*metal*_block", "Block of Raw *metal* Ore", providerMaterialTags(Material.MaterialIngredientBaseTags.RAW_MATERIAL_BLOCK), provideMaterialTypes(Material.MaterialType.METAL, Material.MaterialType.GEM), true, "block/base_raw_ore_block"),
    CRUSHED("crushed_*metal*", "Crushed *metal* Ore", providerMaterialTags(Material.MaterialIngredientBaseTags.CRUSHED), provideMaterialTypes(Material.MaterialType.METAL), false, "crushed_base"),
    ;

    private final String name;
    private final String displayName;
    private final boolean isBlock;
    private final List<Material.MaterialType> materialType;
    private final List<Material.MaterialIngredientBaseTags> materialTags;

    private final String[] baseTexture;

    MaterialCraftingIngredients(String name, String displayName, List<Material.MaterialIngredientBaseTags> materialTags, List<Material.MaterialType> materialType, boolean isBlock, String... baseTextures) {
        this.name = name;
        this.displayName = displayName;
        this.isBlock = isBlock;
        this.baseTexture = baseTextures;
        this.materialType = materialType;
        this.materialTags = materialTags;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<Material.MaterialIngredientBaseTags> getMaterialTags() {
        return materialTags;
    }

    public Material.MaterialIngredientBaseTags getPrimaryMaterialTag() {
        return materialTags.getFirst();
    }

    public List<Material.MaterialType> getMaterialType() {
        return materialType;
    }

    public boolean isMaterialType(Material.MaterialType type) {
        return materialType.contains(type);
    }

    public boolean isBlock() {
        return isBlock;
    }

    public String[] getBaseTextures() {
        return baseTexture;
    }

    public static String getDisplayName(MaterialCraftingIngredients currentIngredient, String metalDisplayName) {
        return currentIngredient.getDisplayName().replace("*metal*", metalDisplayName);
    }

    public static String getItemName(MaterialCraftingIngredients currentIngredient, String metalName) {
        return currentIngredient.getName().replace("*metal*", metalName);
    }

    public boolean isOre() {
        return this == ORE || this == DEEPSLATE_ORE || this == NETHER_ORE || this == BASALT_ORE || this == BLACKSTONE_ORE || this == ENDSTONE_ORE;
    }
}
