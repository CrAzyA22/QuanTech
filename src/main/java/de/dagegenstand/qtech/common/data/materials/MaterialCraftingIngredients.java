package de.dagegenstand.qtech.common.data.materials;

import java.util.List;

public enum MaterialCraftingIngredients {
    //Crafting Ingredients
    INGOT("*metal*_ingot", "*metal* Ingot", Materials.provideMaterialTypeList(Material.MaterialType.METAL), false, "base_ingot"),
    NUGGET("*metal*_nugget", "*metal* Nugget", Materials.provideMaterialTypeList(Material.MaterialType.METAL), false, "base_nugget"),
    PLATE("*metal*_plate", "*metal* Plate", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_plate"),
    ROD("*metal*_rod", "*metal* Rod", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_rod"),
    GEAR("*metal*_gear", "*metal* Gear", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_gear"),
    WIRE("*metal*_wire", "*metal* Wire", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_wire"),
    BLOCK("*metal*_block", "Block of *metal*", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), true, "block/base_metal_block"),
    SHEET("*metal*_sheet", "*metal* Sheet", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_sheet"),
    DUST("*metal*_dust", "*metal* Dust", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_dust"),
    BOLT("*metal*_bolt", "*metal* Bolt", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_bolt"),
    SCREW("*metal*_screw", "*metal* Screw", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_screw"),
    SPRING("*metal*_spring", "*metal* Spring", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_spring"),
    RING("*metal*_ring", "*metal* Ring", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_ring"),
    ROTOR("*metal*_rotor", "*metal* Rotor", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_rotor"),
    DOUBLE_PLATE("*metal*_double_plate", "*metal* Double Plate", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_double_plate"),
    FOIL("*metal*_foil", "*metal* Foil", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_foil"),
    WIRE_COIL("*metal*_wire_coil", "*metal* Wire Coil", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_wire_coil_overlay", "base_wire_coil_base"),

    //Gems
    GEM("*metal*_gem", "*metal* Gem", Materials.provideMaterialTypeList(Material.MaterialType.GEM), false, "base_gem"),

    //Ores
    ORE("*metal*_ore", "*metal* Ore", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), true, "block/base_ore_overlay_alt_one", "minecraft:block/stone"),
    DEEPSLATE_ORE("deepslate_*metal*_ore", "Deepslate *metal* Ore", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), true, "block/base_ore_overlay_alt_one", "minecraft:block/deepslate"),
    NETHER_ORE("netherrack_*metal*_ore", "Netherrack *metal* Ore", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), true, "block/base_ore_overlay_alt_one", "minecraft:block/netherrack"),
    BASALT_ORE("basalt_*metal*_ore", "Basalt *metal* Ore", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), true, "block/base_ore_overlay_alt_one", "minecraft:block/smooth_basalt"),
    BLACKSTONE_ORE("blackstone_*metal*_ore", "Blackstone *metal* Ore", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), true, "block/base_ore_overlay_alt_one", "minecraft:block/blackstone"),
    RAW_ORE("raw_*metal*_ore", "Raw *metal* Ore", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), false, "base_raw_ore"),
    RAW_ORE_BLOCK("raw_*metal*_block", "Block of Raw *metal* Ore", Materials.provideMaterialTypeList(Material.MaterialType.METAL, Material.MaterialType.GEM), true, "block/base_raw_ore_block"),
    CRUSHED("crushed_*metal*", "Crushed *metal* Ore", Materials.provideMaterialTypeList(Material.MaterialType.METAL), false, "crushed_base"),
    ;

    private final String name;
    private final String displayName;
    private final boolean isBlock;
    private final List<Material.MaterialType> materialType;

    private final String[] baseTexture;

    MaterialCraftingIngredients(String name, String displayName, List<Material.MaterialType> materialType, boolean isBlock, String... baseTextures) {
        this.name = name;
        this.displayName = displayName;
        this.isBlock = isBlock;
        this.baseTexture = baseTextures;
        this.materialType = materialType;
    }

    private String getName() {
        return name;
    }

    private String getDisplayName() {
        return displayName;
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
        return this == ORE || this == DEEPSLATE_ORE || this == NETHER_ORE || this == BASALT_ORE || this == BLACKSTONE_ORE || this == RAW_ORE;
    }
}
