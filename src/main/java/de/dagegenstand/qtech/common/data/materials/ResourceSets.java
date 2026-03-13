package de.dagegenstand.qtech.common.data.materials;

import static de.dagegenstand.qtech.common.data.materials.Material.MaterialType.GEM;
import static de.dagegenstand.qtech.common.data.materials.Material.MaterialType.METAL;

public class ResourceSets {

    public static void createResourceSets() {
        //Vanilla Additions
        new ResourceSetBuilder("copper", "Copper", 0xe77c56)
                .addIngredients(MaterialCraftingIngredients.PLATE, MaterialCraftingIngredients.ROD, MaterialCraftingIngredients.GEAR, MaterialCraftingIngredients.WIRE, MaterialCraftingIngredients.SHEET, MaterialCraftingIngredients.DUST, MaterialCraftingIngredients.CRUSHED, MaterialCraftingIngredients.BOLT, MaterialCraftingIngredients.SCREW, MaterialCraftingIngredients.SPRING, MaterialCraftingIngredients.SPRING, MaterialCraftingIngredients.ROTOR)
                .build();

        new ResourceSetBuilder("iron", "iron", 0xD8D8D8)
                .addIngredients(MaterialCraftingIngredients.PLATE, MaterialCraftingIngredients.ROD, MaterialCraftingIngredients.GEAR, MaterialCraftingIngredients.WIRE, MaterialCraftingIngredients.SHEET, MaterialCraftingIngredients.DUST, MaterialCraftingIngredients.CRUSHED, MaterialCraftingIngredients.BOLT, MaterialCraftingIngredients.SCREW, MaterialCraftingIngredients.SPRING, MaterialCraftingIngredients.ROTOR)
                .build();

        new ResourceSetBuilder("gold", "Gold", 0xfdf55f)
                .addIngredients(MaterialCraftingIngredients.PLATE, MaterialCraftingIngredients.ROD, MaterialCraftingIngredients.GEAR, MaterialCraftingIngredients.WIRE, MaterialCraftingIngredients.SHEET, MaterialCraftingIngredients.DUST, MaterialCraftingIngredients.CRUSHED, MaterialCraftingIngredients.BOLT, MaterialCraftingIngredients.SCREW, MaterialCraftingIngredients.SPRING, MaterialCraftingIngredients.ROTOR)
                .build();

        new ResourceSetBuilder("lapis", "Lapis", 0x1e3c8b)
                .addIngredients(MaterialCraftingIngredients.DUST, MaterialCraftingIngredients.CRUSHED, MaterialCraftingIngredients.SHEET, MaterialCraftingIngredients.ROD)
                .build();

        new ResourceSetBuilder("emerald", "Emerald", 0x00aa2c)
                .addIngredients(MaterialCraftingIngredients.PLATE, MaterialCraftingIngredients.ROD, MaterialCraftingIngredients.GEAR, MaterialCraftingIngredients.DUST, MaterialCraftingIngredients.CRUSHED, MaterialCraftingIngredients.BOLT, MaterialCraftingIngredients.SCREW, MaterialCraftingIngredients.ROTOR)
                .build();

        new ResourceSetBuilder("diamond", "Diamond", 0x1aaaa7)
                .addIngredients(MaterialCraftingIngredients.PLATE, MaterialCraftingIngredients.ROD, MaterialCraftingIngredients.GEAR, MaterialCraftingIngredients.DUST, MaterialCraftingIngredients.CRUSHED, MaterialCraftingIngredients.BOLT, MaterialCraftingIngredients.SCREW, MaterialCraftingIngredients.ROTOR)
                .build();

        //Mod Additions - Ores
        new ResourceSetBuilder("silver", "Silver", 0xdedede)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .build();

        new ResourceSetBuilder("terranium", "Terranium", 0x7eff33)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .changeOreOverlay("block/base_ore_overlay_alt_two")
                .build();

        new ResourceSetBuilder("osmium", "Osmium", 0xb0fff6)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .changeOreOverlay("block/base_ore_overlay_alt_three")
                .build();

        new ResourceSetBuilder("lead", "Lead", 0x353236)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .build();

        new ResourceSetBuilder("platinum", "Platinum", 0xe3feff)
                .addAllIngredients(METAL, true)
                .removeOverworldOres()
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .changeOreOverlay("block/base_ore_overlay_alt_three")
                .build();

        new ResourceSetBuilder("nickel", "Nickel", 0xc4c7b7)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_two")
                .build();

        new ResourceSetBuilder("uranium", "Uranium", 0x177d00)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .removeFlexible()
                .removeConductive()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("tin", "Tin", 0xcccccc)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .build();

        new ResourceSetBuilder("azbantium", "Azbantium", 0x311236)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_three")
                .changeOreOverlay("block/base_ore_overlay")
                .build();

        new ResourceSetBuilder("rutherfordium", "Rutherfordium", 0x3e3240)
                .addAllIngredients(GEM, true)
                .removeOverworldOres()
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.GEM, "item/base_gem_alt_one")
                .changeOreOverlay("block/base_ore_overlay_alt_three")
                .build();

        new ResourceSetBuilder("rhenium", "Rhenium", 0x707070)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("iridium", "Iridium", 0xfffacf)
                .addAllIngredients(GEM, true)
                .removeNetherOres()
                .setAlternativeTexture(MaterialCraftingIngredients.GEM, "item/base_gem_alt_two")
                .build();

        new ResourceSetBuilder("titanium", "Titanium", 0x9e9e9e)
                .addAllIngredients(METAL, true)
                .removeOverworldOres()
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .changeOreOverlay("block/base_ore_overlay_alt_three")
                .build();

        new ResourceSetBuilder("adamatium", "Adamantium", 0xc25a00)
                .addAllIngredients(GEM, true)
                .removeOverworldOres()
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.GEM, "item/base_gem_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("mithril", "Mithril", 0xb8fffd)
                .addAllIngredients(GEM, true)
                .removeNetherOres()
                .removeFlexible()
                .removeConductive()
                .setAlternativeTexture(MaterialCraftingIngredients.GEM, "item/base_gem_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_three")
                .changeOreOverlay("block/base_ore_overlay_alt_two")
                .build();

        new ResourceSetBuilder("lunarite", "Lunarite", 0xf9ffb8)
                .addAllIngredients(METAL, true)
                .removeNetherOres()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_two")
                .changeOreOverlay("block/base_ore_overlay_alt_three")
                .build();

        new ResourceSetBuilder("naquadah", "Naquadah", 0x291630)
                .addAllIngredients(METAL, true)
                .removeOverworldOres()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_two")
                .build();

        new ResourceSetBuilder("plutonium", "Plutonium", 0x529e86)
                .addAllIngredients(METAL, false)
                .removeConductive()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        //Mod Additions - Alloys
        new ResourceSetBuilder("steel", "Steel", 0x696969)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_one")
                .build();

        new ResourceSetBuilder("shadow_steel", "Shadow Steel", 0x242424)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_one")
                .build();

        new ResourceSetBuilder("rose_gold", "Rose Gold", 0xe8acac)
                .addAllIngredients(GEM, false)
                .removeConductive()
                .setAlternativeTexture(MaterialCraftingIngredients.GEM, "item/base_gem_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("invar", "Invar", 0x9c9b91)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .build();

        new ResourceSetBuilder("electrum", "Electrum", 0xffd621)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_one")
                .build();

        new ResourceSetBuilder("brass", "Brass", 0xb58500)
                .addAllIngredients(METAL, false)
                .removeConductive()
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("bronze", "Bronze", 0xd19200)
                .addAllIngredients(METAL, false)
                .removeConductive()
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("energetic_alloy", "Energetic Alloy", 0xff7230)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("vibrant_alloy", "Vibrant Alloy", 0x1ce669)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("aluminum", "Aluminum", 0x8f8f8f)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_two")
                .build();

        new ResourceSetBuilder("signalum", "Signalum", 0xf56522)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("enderium", "Enderium", 0x004d37)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("redstone_alloy", "Redstone Alloy", 0xa60000)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .build();

        new ResourceSetBuilder("lumium", "Lumium", 0xffec5e)
                .addAllIngredients(GEM, false)
                .setAlternativeTexture(MaterialCraftingIngredients.GEM, "item/base_gem_alt_three")
                .build();

        new ResourceSetBuilder("azbantium_enderium_alloy", "Azbantium-Enderium Alloy", 0x138542)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("rhenium_platinum_alloy", "Rhenium-Platinum Alloy", 0x1b6585)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_three")
                .build();

        new ResourceSetBuilder("tunneled_signalum", "Tunneled Signalum", 0xdb7037)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("tunneled_azbantium_enderium_alloy", "Tunneled Azbantium-Enderium Alloy", 0x87b33b)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("tungsten", "Tungsten", 0x7e8276)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .build();

        new ResourceSetBuilder("tungsten_steel", "Tungsten Steel", 0x555751)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_three")
                .build();

        new ResourceSetBuilder("tungsten_adamantium_alloy", "Tungsten-Adamantium Alloy", 0x54646e)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .build();

        new ResourceSetBuilder("tungsten_mithril_alloy", "Tungsten-Mithril Alloy", 0x80a5bd)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_three")
                .build();

        new ResourceSetBuilder("mithril_lunarite_alloy", "Mithril-Lunarite Alloy", 0xa2c6de)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("naquadah_netherite_alloy", "Naquadah-Netherite Alloy", 0x3b343d)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("quantium", "Quantium", 0x9822ba)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("quintium", "Quintium", 0x3e164a)
                .addAllIngredients(GEM, false)
                .setAlternativeTexture(MaterialCraftingIngredients.GEM, "item/base_gem_alt_one")
                .build();

        new ResourceSetBuilder("quantum_steel", "Quantum Steel", 0x361f3d)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_two")
                .build();

        new ResourceSetBuilder("quantic_quintium_steel", "Quantic Quintium Steel", 0x5b1d6e)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("naquadah_quantum_steel", "Naquadah Quantum Steel", 0x2c0e36)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();

        new ResourceSetBuilder("tiberium", "Tiberium", 0x1bde4b)
                .addAllIngredients(GEM, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.GEM, "item/base_gem_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_two")
                .build();

        new ResourceSetBuilder("tritanium", "Tritanium", 0x575757)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_one")
                .build();

        new ResourceSetBuilder("tiberium_tritanium_alloy", "Tiberium-Tritanium Alloy", 0x568c66)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_two")
                .build();

        new ResourceSetBuilder("herculite", "Herculite", 0x0e206e)
                .addAllIngredients(GEM, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_three")
                .build();

        new ResourceSetBuilder("herculite_rutherfordium_alloy", "Herculite-Rutherfordium Alloy", 0x2f214a)
                .addAllIngredients(METAL, false)
                .removeFlexible()
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_three")
                .build();

        new ResourceSetBuilder("insanite", "Insanite", 0x49ff40)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("abyssalite", "Abyssalite", 0x1e1a91)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_two")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_five")
                .build();

        new ResourceSetBuilder("infinity", "Infinity", 0xf7f7f7)
                .addAllIngredients(METAL, false)
                .setAlternativeTexture(MaterialCraftingIngredients.INGOT, "item/base_ingot_alt_three")
                .setAlternativeTexture(MaterialCraftingIngredients.NUGGET, "item/base_nugget_alt_one")
                .setAlternativeTexture(MaterialCraftingIngredients.BLOCK, "block/base_metal_block_alt_four")
                .build();
    }
}
