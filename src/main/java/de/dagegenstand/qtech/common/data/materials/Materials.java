package de.dagegenstand.qtech.common.data.materials;

import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Materials {
    private static HashMap<String, Material> MATERIALS = new HashMap<>();

    public static void registerMaterial(Material material) {
        MATERIALS.put(material.getName(), material);
    }

    public static Collection<String> getAllMaterialNames() {
        return MATERIALS.keySet();
    }

    public static Collection<Material> getAllMaterials() {
        return MATERIALS.values();
    }

    public static Material getMaterial(String name) {
        return MATERIALS.get(name);
    }

    public static List<DeferredItem<?>> getAllItemsOfMaterial(Material material) {
        return material.getItems().values().stream().toList();
    }

    public static List<DeferredBlock<?>> getAllBlocksOfMaterial(Material material) {
        return material.getBlocks().values().stream().toList();
    }

    public static List<Material.MaterialType> provideMaterialTypeList(Material.MaterialType... materialTypes) {
        return Arrays.stream(materialTypes).toList();
    }
}
