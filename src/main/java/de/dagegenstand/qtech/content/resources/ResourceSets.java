package de.dagegenstand.qtech.content.resources;

public class ResourceSets {

    public static void createResourceSets() {
        //Vanilla Additions
        new ResourceSetBuilder("copper", "Copper", 0xe77c56)
                .addIngredients(MetalCraftingIngredient.PLATE, MetalCraftingIngredient.ROD, MetalCraftingIngredient.GEAR, MetalCraftingIngredient.WIRE, MetalCraftingIngredient.SHEET, MetalCraftingIngredient.DUST, MetalCraftingIngredient.CRUSHED, MetalCraftingIngredient.BOLT, MetalCraftingIngredient.SCREW, MetalCraftingIngredient.SPRING)
                .build();

        new ResourceSetBuilder("iron", "iron", 0xD8D8D8)
                .addIngredients(MetalCraftingIngredient.PLATE, MetalCraftingIngredient.ROD, MetalCraftingIngredient.GEAR, MetalCraftingIngredient.WIRE, MetalCraftingIngredient.SHEET, MetalCraftingIngredient.DUST, MetalCraftingIngredient.CRUSHED, MetalCraftingIngredient.BOLT, MetalCraftingIngredient.SCREW, MetalCraftingIngredient.SPRING)
                .build();

        new ResourceSetBuilder("gold", "Gold", 0xfdf55f)
                .addIngredients(MetalCraftingIngredient.PLATE, MetalCraftingIngredient.ROD, MetalCraftingIngredient.GEAR, MetalCraftingIngredient.WIRE, MetalCraftingIngredient.SHEET, MetalCraftingIngredient.DUST, MetalCraftingIngredient.CRUSHED, MetalCraftingIngredient.BOLT, MetalCraftingIngredient.SCREW, MetalCraftingIngredient.SPRING)
                .build();

        new ResourceSetBuilder("emerald", "Emerald", 0x00aa2c)
                .addIngredients(MetalCraftingIngredient.PLATE, MetalCraftingIngredient.ROD, MetalCraftingIngredient.GEAR, MetalCraftingIngredient.DUST, MetalCraftingIngredient.CRUSHED, MetalCraftingIngredient.BOLT, MetalCraftingIngredient.SCREW)
                .build();

        new ResourceSetBuilder("diamond", "Diamond", 0x1aaaa7)
                .addIngredients(MetalCraftingIngredient.PLATE, MetalCraftingIngredient.ROD, MetalCraftingIngredient.GEAR, MetalCraftingIngredient.DUST, MetalCraftingIngredient.CRUSHED, MetalCraftingIngredient.BOLT, MetalCraftingIngredient.SCREW)
                .build();

        //Mod Additions - Ores
        new ResourceSetBuilder("silver", "Silver", 0xc0c0c0)
                .addAllIngredients(true)
                .build();

        //Mod Additions - Alloys
        new ResourceSetBuilder("steel", "Steel", 0x696969)
                .addAllIngredients(false)
                .build();
    }

}
