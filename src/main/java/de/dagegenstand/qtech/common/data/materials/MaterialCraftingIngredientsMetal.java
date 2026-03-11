package de.dagegenstand.qtech.common.data.materials;

public enum MaterialCraftingIngredientsMetal {
    //Crafting Ingredients
    INGOT("*metal*_ingot", "*metal* Ingot", false, "item/base_ingot"),
    NUGGET("*metal*_nugget", "*metal* Nugget", false, "item/base_nugget"),
    PLATE("*metal*_plate", "*metal* Plate", false, "item/base_plate"),
    ROD("*metal*_rod", "*metal* Rod", false, "item/base_rod"),
    GEAR("*metal*_gear", "*metal* Gear", false, "item/base_gear"),
    WIRE("*metal*_wire", "*metal* Wire", false, "item/base_wire"),
    BLOCK("*metal*_block", "Block of *metal*", true, "block/base_metal_block"),
    SHEET("*metal*_sheet", "*metal* Sheet", false, "item/base_sheet"),
    DUST("*metal*_dust", "*metal* Dust", false, "item/base_dust"),
    CRUSHED("crushed_*metal*", "Crushed *metal* Ore", false, "item/crushed_base"),
    BOLT("*metal*_bolt", "*metal* Bolt", false, "item/base_bolt"),
    SCREW("*metal*_screw", "*metal* Screw", false, "item/base_screw"),
    SPRING("*metal*_spring", "*metal* Spring", false, "item/base_spring"),
    RING("*metal*_ring", "*metal* Ring", false, "item/base_ring"),
    ROTOR("*metal*_rotor", "*metal* Rotor", false, "item/base_rotor"),
    DOUBLE_PLATE("*metal*_double_plate", "*metal* Double Plate", false, "item/base_double_plate"),
    FOIL("*metal*_foil", "*metal* Foil", false, "item/base_foil"),
    WIRE_COIL("*metal*_wire_coil", "*metal* Wire Coil", false, "item/base_wire_coil_overlay", "item/base_wire_coil_base"),

    //Gems
    GEM("*metal*_gem", "*metal* Gem", false, "item/base_gem"),

    //Ores
    ORE("*metal*_ore", "*metal* Ore", true, "block/base_ore_overlay_alt_one", "minecraft:block/stone"),
    DEEPSLATE_ORE("deepslate_*metal*_ore", "Deepslate *metal* Ore", true, "block/base_ore_overlay_alt_one", "minecraft:block/deepslate"),
    NETHER_ORE("netherrack_*metal*_ore", "Netherrack *metal* Ore", true, "block/base_ore_overlay_alt_one", "minecraft:block/netherrack"),
    BASALT_ORE("basalt_*metal*_ore", "Basalt *metal* Ore", true, "block/base_ore_overlay_alt_one", "minecraft:block/smooth_basalt"),
    BLACKSTONE_ORE("blackstone_*metal*_ore", "Blackstone *metal* Ore", true, "block/base_ore_overlay_alt_one", "minecraft:block/blackstone"),
    RAW_ORE("raw_*metal*_ore", "Raw *metal* Ore", false, "item/base_raw_ore"),
    RAW_ORE_BLOCK("raw_*metal*_block", "Block of Raw *metal* Ore", true, "block/base_raw_ore_block")
    ;

    private final String name;
    private final String displayName;
    private final boolean isBlock;

    private final String[] baseTexture;

    MaterialCraftingIngredientsMetal(String name, String displayName, boolean isBlock, String... baseTextures) {
        this.name = name;
        this.displayName = displayName;
        this.isBlock = isBlock;
        this.baseTexture = baseTextures;
    }

    private String getName() {
        return name;
    }

    private String getDisplayName() {
        return displayName;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public String[] getBaseTextures() {
        return baseTexture;
    }

    public static String getDisplayName(MaterialCraftingIngredientsMetal currentIngredient, String metalDisplayName) {
        return currentIngredient.getDisplayName().replace("*metal*", metalDisplayName);
    }

    public static String getItemName(MaterialCraftingIngredientsMetal currentIngredient, String metalName) {
        return currentIngredient.getName().replace("*metal*", metalName);
    }

    public boolean isOre() {
        return this == ORE || this == DEEPSLATE_ORE || this == NETHER_ORE || this == BASALT_ORE || this == BLACKSTONE_ORE || this == RAW_ORE;
    }
}
