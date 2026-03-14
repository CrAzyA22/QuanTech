package de.dagegenstand.qtech.common.data.materials;

import de.dagegenstand.qtech.common.data.tiers.EnergyTier;

import static de.dagegenstand.qtech.common.data.materials.Material.MaterialType.GEM;
import static de.dagegenstand.qtech.common.data.materials.Material.MaterialType.METAL;
import static de.dagegenstand.qtech.common.data.tiers.EnergyTier.*;

public class ResourceSets {

    public static void createResourceSets() {
        //Vanilla Additions
        new ResourceSetBuilder("copper", "Copper", EnergyTier.ULV, 0xe77c56, 0, 0)
                .addIngredients(MaterialCraftingIngredients.PLATE, MaterialCraftingIngredients.ROD, MaterialCraftingIngredients.GEAR, MaterialCraftingIngredients.WIRE, MaterialCraftingIngredients.SHEET, MaterialCraftingIngredients.DUST, MaterialCraftingIngredients.CRUSHED, MaterialCraftingIngredients.BOLT, MaterialCraftingIngredients.SCREW, MaterialCraftingIngredients.SPRING, MaterialCraftingIngredients.SPRING, MaterialCraftingIngredients.ROTOR)
                .build();

        new ResourceSetBuilder("iron", "Iron", EnergyTier.ULV, 0xD8D8D8, 0, 0)
                .addIngredients(MaterialCraftingIngredients.PLATE, MaterialCraftingIngredients.ROD, MaterialCraftingIngredients.GEAR, MaterialCraftingIngredients.WIRE, MaterialCraftingIngredients.SHEET, MaterialCraftingIngredients.DUST, MaterialCraftingIngredients.CRUSHED, MaterialCraftingIngredients.BOLT, MaterialCraftingIngredients.SCREW, MaterialCraftingIngredients.SPRING, MaterialCraftingIngredients.ROTOR)
                .build();

        new ResourceSetBuilder("gold", "Gold", LV, 0xfdf55f, 0, 0)
                .addIngredients(MaterialCraftingIngredients.PLATE, MaterialCraftingIngredients.ROD, MaterialCraftingIngredients.GEAR, MaterialCraftingIngredients.WIRE, MaterialCraftingIngredients.SHEET, MaterialCraftingIngredients.DUST, MaterialCraftingIngredients.CRUSHED, MaterialCraftingIngredients.BOLT, MaterialCraftingIngredients.SCREW, MaterialCraftingIngredients.SPRING, MaterialCraftingIngredients.ROTOR)
                .build();

        new ResourceSetBuilder("lapis", "Lapis", EnergyTier.ULV, 0x1e3c8b, 0, 0)
                .addIngredients(MaterialCraftingIngredients.DUST, MaterialCraftingIngredients.CRUSHED, MaterialCraftingIngredients.SHEET, MaterialCraftingIngredients.ROD)
                .build();

        new ResourceSetBuilder("emerald", "Emerald", LV, 0x00aa2c, 0, 0)
                .addIngredients(MaterialCraftingIngredients.PLATE, MaterialCraftingIngredients.ROD, MaterialCraftingIngredients.GEAR, MaterialCraftingIngredients.DUST, MaterialCraftingIngredients.CRUSHED, MaterialCraftingIngredients.BOLT, MaterialCraftingIngredients.SCREW, MaterialCraftingIngredients.ROTOR)
                .build();

        new ResourceSetBuilder("diamond", "Diamond", LV, 0x1aaaa7, 0,0)
                .addIngredients(MaterialCraftingIngredients.PLATE, MaterialCraftingIngredients.ROD, MaterialCraftingIngredients.GEAR, MaterialCraftingIngredients.DUST, MaterialCraftingIngredients.CRUSHED, MaterialCraftingIngredients.BOLT, MaterialCraftingIngredients.SCREW, MaterialCraftingIngredients.ROTOR)
                .build();

        new ResourceSetBuilder("coal", "Carbon", ULV, 0x3b3b3b, 0,0)
                .addIngredients(MaterialCraftingIngredients.DUST, MaterialCraftingIngredients.CRUSHED, MaterialCraftingIngredients.ROD)
                .build();

        new ResourceSetBuilder("quartz", "Quartz", LV, 0xffffff, 0, 0)
                .addIngredients(MaterialCraftingIngredients.DUST, MaterialCraftingIngredients.CRUSHED, MaterialCraftingIngredients.SHEET, MaterialCraftingIngredients.ROD, MaterialCraftingIngredients.PLATE, MaterialCraftingIngredients.DOUBLE_PLATE)
                .build();

        //Mod Additions - Ores
        new ResourceSetBuilder("silver", "Silver", LV, 0xdedede, 3, 2)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .removeEndOres()
                .addOreLootTable(MaterialCraftingIngredients.RAW_ORE, 2, 5)
                .build();

        new ResourceSetBuilder("terranium", "Terranium", CV, 0x7eff33, 8, 4)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .removeEndOres()
                .removeFlexible()
                .addOreLootTable(MaterialCraftingIngredients.RAW_ORE, 1, 2)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .changeOreOverlay("block/base_ore_overlay_alt_two")
                .build();

        new ResourceSetBuilder("osmium", "Osmium", EHV, 0xb0fff6, 5, 3)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .removeEndOres()
                .removeFlexible()
                .addOreLootTable(MaterialCraftingIngredients.RAW_ORE, 1, 2)
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .changeOreOverlay("block/base_ore_overlay_alt_three")
                .build();

        new ResourceSetBuilder("lead", "Lead", MV, 0x353236, 4, 1)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .removeEndOres()
                .removeFlexible()
                .addOreLootTable(MaterialCraftingIngredients.RAW_ORE, 2, 4)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .build();

        new ResourceSetBuilder("platinum", "Platinum", VHV, 0xe3feff, 6, 3)
                .addAllIngredients(METAL, true)
                .removeOverworldOres()
                .removeNetherOres()
                .removeFlexible()
                .addOreLootTable(MaterialCraftingIngredients.RAW_ORE, 1, 1)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .changeOreOverlay("block/base_ore_overlay_alt_three")
                .build();

        new ResourceSetBuilder("nickel", "Nickel", MV, 0xc4c7b7, 4, 2)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .removeEndOres()
                .addOreLootTable(MaterialCraftingIngredients.RAW_ORE, 2, 5)
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_two")
                .build();

        new ResourceSetBuilder("uranium", "Uranium", KHV, 0x177d00, 5, 2)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .removeEndOres()
                .removeFlexible()
                .removeConductive()
                .addOreLootTable(MaterialCraftingIngredients.RAW_ORE, 1, 3)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("tin", "Tin", MV, 0xcccccc, 3, 2)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .removeEndOres()
                .addOreLootTable(MaterialCraftingIngredients.RAW_ORE, 3, 5)
                .build();

        new ResourceSetBuilder("azbantium", "Azbantium", KCV, 0x311236, 7, 4)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .removeOverworldOres()
                .addOreLootTable(MaterialCraftingIngredients.RAW_ORE, 0, 1)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_three")
                .changeOreOverlay("block/base_ore_overlay")
                .build();

        new ResourceSetBuilder("rutherfordium", "Rutherfordium", CV, 0x3e3240, 6, 3)
                .addAllIngredients(GEM, true)
                .removeOverworldOres()
                .removeNetherOres()
                .removeFlexible()
                .addOreLootTable(MaterialCraftingIngredients.GEM, 0, 1)
                .setAlternativeTexture(MaterialCraftingIngredients.GEM, "item/base_gem_alt_one")
                .changeOreOverlay("block/base_ore_overlay_alt_three")
                .build();

        new ResourceSetBuilder("rhenium", "Rhenium", UV, 0x707070, 5, 3)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .removeEndOres()
                .addOreLootTable(MaterialCraftingIngredients.RAW_ORE, 0, 1)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("iridium", "Iridium", UV, 0xfffacf, 5, 3)
                .addAllIngredients(GEM, true)
                .removeNetherOres()
                .removeEndOres()
                .addOreLootTable(MaterialCraftingIngredients.GEM, 1, 3)
                .setAlternativeTexture(MaterialCraftingIngredients.GEM, "item/base_gem_alt_two")
                .build();

        new ResourceSetBuilder("titanium", "Titanium", VHV, 0x9e9e9e, 8, 4)
                .addAllIngredients(METAL, true)
                .removeOverworldOres()
                .removeEndOres()
                .removeFlexible()
                .addOreLootTable(MaterialCraftingIngredients.RAW_ORE, 1, 1)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .changeOreOverlay("block/base_ore_overlay_alt_three")
                .build();

        new ResourceSetBuilder("adamatium", "Adamantium", VUV, 0xc25a00, 7, 4)
                .addAllIngredients(GEM, true)
                .removeOverworldOres()
                .removeNetherOres()
                .removeFlexible()
                .addOreLootTable(MaterialCraftingIngredients.GEM, 2, 5)
                .setAlternativeTexture(MaterialCraftingIngredients.GEM, "item/base_gem_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("mithril", "Mithril", EXV, 0xb8fffd, 8, 4)
                .addAllIngredients(GEM, true)
                .removeNetherOres()
                .removeOverworldOres()
                .removeFlexible()
                .removeConductive()
                .addOreLootTable(MaterialCraftingIngredients.GEM, 0, 1)
                .setAlternativeTexture(MaterialCraftingIngredients.GEM, "item/base_gem_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_three")
                .changeOreOverlay("block/base_ore_overlay_alt_two")
                .build();

        new ResourceSetBuilder("lunarite", "Lunarite", RMV, 0xf9ffb8, 7, 4)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .removeOverworldOres()
                .addOreLootTable(MaterialCraftingIngredients.RAW_ORE, 2, 4)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_two")
                .changeOreOverlay("block/base_ore_overlay_alt_three")
                .build();

        new ResourceSetBuilder("naquadah", "Naquadah", RMV, 0x291630, 16, 4)
                .addAllIngredients(METAL, true)
                .removeOverworldOres()
                .addOreLootTable(MaterialCraftingIngredients.RAW_ORE, 0, 1)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_two")
                .build();

        new ResourceSetBuilder("plutonium", "Plutonium", UHV, 0x529e86, 5, 2)
                .addAllIngredients(METAL, false)
                .removeConductive()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        //Mod Additions - Alloys
        new ResourceSetBuilder("steel", "Steel", MV, 0x696969, 4, 2)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_one")
                .build();

        new ResourceSetBuilder("shadow_steel", "Shadow Steel", EHV, 0x242424, 7, 3)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_one")
                .build();

        new ResourceSetBuilder("rose_gold", "Rose Gold", AHV, 0xe8acac, 2, 1)
                .addAllIngredients(GEM, false)
                .removeConductive()
                .setAlternativeTexture(MaterialCraftingIngredients.GEM, "item/base_gem_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("invar", "Invar", LV, 0x9c9b91, 2, 1)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .build();

        new ResourceSetBuilder("electrum", "Electrum", MV, 0xffd621, 2, 2)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_one")
                .build();

        new ResourceSetBuilder("brass", "Brass", MV, 0xb58500, 2, 1)
                .addAllIngredients(METAL, false)
                .removeConductive()
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("bronze", "Bronze", MV, 0xd19200, 6, 3)
                .addAllIngredients(METAL, false)
                .removeConductive()
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("energetic_alloy", "Energetic Alloy", LV, 0xff7230, 5, 3)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("vibrant_alloy", "Vibrant Alloy", KHV, 0x1ce669, 9, 4)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("aluminum", "Aluminum", HV, 0x8f8f8f, 2, 1)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_two")
                .build();

        new ResourceSetBuilder("signalum", "Signalum", VHV, 0xf56522, 5, 3)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("enderium", "Enderium", KCV, 0x004d37, 7, 4)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("redstone_alloy", "Redstone Alloy", AHV, 0xa60000, 4, 2)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .build();

        new ResourceSetBuilder("lumium", "Lumium", RMV, 0xffec5e, 20, 4)
                .addAllIngredients(GEM, false)
                .setAlternativeTexture(MaterialCraftingIngredients.GEM, "item/base_gem_alt_three")
                .build();

        new ResourceSetBuilder("azbantium_enderium_alloy", "Azbantium-Enderium Alloy", EHV, 0x138542, 10, 4)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("rhenium_platinum_alloy", "Rhenium-Platinum Alloy", UV, 0x1b6585, 8, 4)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_three")
                .build();

        new ResourceSetBuilder("tunneled_signalum", "Tunneled Signalum", VUV, 0xdb7037, 12, 4)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("tunneled_azbantium_enderium_alloy", "Tunneled Azbantium-Enderium Alloy", EMV, 0x87b33b, 20, 4)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("tungsten", "Tungsten", EHV, 0x7e8276, 5, 3)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .build();

        new ResourceSetBuilder("tungsten_steel", "Tungsten Steel", KCV, 0x555751, 8, 4)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_three")
                .build();

        new ResourceSetBuilder("tungsten_adamantium_alloy", "Tungsten-Adamantium Alloy", EXV, 0x54646e, 10, 4)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .build();

        new ResourceSetBuilder("tungsten_mithril_alloy", "Tungsten-Mithril Alloy", RMV, 0x80a5bd, 32, 4)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_three")
                .build();

        new ResourceSetBuilder("mithril_lunarite_alloy", "Mithril-Lunarite Alloy", RMV, 0xa2c6de, 16, 4)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("naquadah_netherite_alloy", "Naquadah-Netherite Alloy", CV, 0x3b343d, 8, 4)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("quantium", "Quantium", EXV, 0x9822ba, 16, 4)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("quintium", "Quintium", EMV, 0x3e164a, 32, 4)
                .addAllIngredients(GEM, false)
                .setAlternativeTexture(MaterialCraftingIngredients.GEM, "item/base_gem_alt_one")
                .build();

        new ResourceSetBuilder("quantum_steel", "Quantum Steel", RMV, 0x361f3d, 20, 4)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_two")
                .build();

        new ResourceSetBuilder("quantic_quintium_steel", "Quantic Quintium Steel", EUHV, 0x5b1d6e, 32, 4)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("naquadah_quantum_steel", "Naquadah Quantum Steel", VMV, 0x2c0e36, 64, 4)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("prometheum", "Prometheum", EMV, 0x5e0000, 20, 3)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_one")
                .build();

        new ResourceSetBuilder("tiberium", "Tiberium", EMV, 0x1bde4b, 20, 4)
                .addAllIngredients(GEM, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.GEM, "item/base_gem_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_two")
                .build();

        new ResourceSetBuilder("tritanium", "Tritanium", RMV, 0x575757, 8, 4)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .build();

        new ResourceSetBuilder("tiberium_tritanium_alloy", "Tiberium-Tritanium Alloy", EMV, 0x568c66, 16, 4)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_two")
                .build();

        new ResourceSetBuilder("herculite", "Herculite", UHV, 0x0e206e, 18, 3)
                .addAllIngredients(GEM, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_three")
                .build();

        new ResourceSetBuilder("herculite_rutherfordium_alloy", "Herculite-Rutherfordium Alloy", EUHV, 0x2f214a, 96, 4)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_three")
                .build();

        new ResourceSetBuilder("insanite", "Insanite", IUHV, 0x49ff40, 128, 4)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("abyssalite", "Abyssalite", IUHV, 0x1e1a91, 128, 4)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("infinity", "Infinity", IUHV, 0xf7f7f7, 256, 4)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("quantic_insanity_infinity_alloy", "Quantic Insanity-Infinity Alloy", IUHV, 0x7e7e7e, 512, 4)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("tunneled_transdimensional_submolecular_quantum_entangeled_abyssal_quantic_insanity_infinity_alloy", "Tunneled Transdimensional Submolecular Quantum Entangeled Abyssal Quantic Insanity-Infinity Alloy", IUHV, 0x000000, 1024, 4)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();
    }
}
