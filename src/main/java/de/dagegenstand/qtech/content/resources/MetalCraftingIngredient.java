package de.dagegenstand.qtech.content.resources;

public enum MetalCraftingIngredient {
    //Crafting Ingredients
    INGOT("*metal*_ingot", "*metal* Ingot", false, "base_ingot"),
    NUGGET("*metal*_nugget", "*metal* Nugget", false, "base_nugget"),
    PLATE("*metal*_plate", "*metal* Plate", false, "base_plate"),
    ROD("*metal*_rod", "*metal* Rod", false, "base_rod"),
    GEAR("*metal*_gear", "*metal* Gear", false, "base_gear"),
    WIRE("*metal*_wire", "*metal* Wire", false, "base_wire"),
    BLOCK("*metal*_block", "Block of *metal*", true, "base_metal_block"),
    SHEET("*metal*_sheet", "*metal* Sheet", false, "base_sheet"),
    DUST("*metal*_dust", "*metal* Dust", false, "base_dust"),
    CRUSHED("crushed_*metal*", "Crushed *metal* Ore", false, "crushed_base"),
    BOLT("*metal*_bolt", "*metal* Bolt", false, "base_bolt"),
    SCREW("*metal*_screw", "*metal* Screw", false, "base_screw"),
    SPRING("*metal*_spring", "*metal* Spring", false, "base_spring"),
    RING("*metal*_ring", "*metal* Ring", false, "base_ring"),
    ROTOR("*metal*_rotor", "*metal* Rotor", false, "base_rotor"),
    //LAYERs FIXEN: WIRE_COIL("*metal*_wire_coil", "*metal* Wire Coil", false, "base_wire_coil"),

    //Gems
    //GEM("*metal*_gem", "*metal* Gem", false, "base_gem"),

    //Ores
    ORE("*metal*_ore", "*metal* Ore", true, "minecraft:block/stone"),
    DEEPSLATE_ORE("deepslate_*metal*_ore", "Deepslate *metal* Ore", true, "minecraft:block/deepslate"),
    NETHER_ORE("netherrack_*metal*_ore", "Netherrack *metal* Ore", true, "minecraft:block/netherrack"),
    BASALT_ORE("basalt_*metal*_ore", "Basalt *metal* Ore", true, "minecraft:block/smooth_basalt"),
    BLACKSTONE_ORE("blackstone_*metal*_ore", "Blackstone *metal* Ore", true, "minecraft:block/blackstone"),
    RAW_ORE("raw_*metal*_ore", "Raw *metal* Ore", false, "base_raw_ore"),
    ;

    private final String name;
    private final String displayName;
    private final boolean isBlock;

    private final String baseTexture;

    MetalCraftingIngredient(String name, String displayName, boolean isBlock, String baseTexture) {
        this.name = name;
        this.displayName = displayName;
        this.isBlock = isBlock;
        this.baseTexture = baseTexture;
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

    public String getBaseTexture() {
        return baseTexture;
    }

    public static String getDisplayName(MetalCraftingIngredient currentIngredient, String metalDisplayName) {
        return currentIngredient.getDisplayName().replace("*metal*", metalDisplayName);
    }

    public static String getItemName(MetalCraftingIngredient currentIngredient, String metalName) {
        return currentIngredient.getName().replace("*metal*", metalName);
    }

    public boolean isOre() {
        return this == ORE || this == DEEPSLATE_ORE || this == NETHER_ORE || this == BASALT_ORE || this == BLACKSTONE_ORE || this == RAW_ORE;
    }
}
