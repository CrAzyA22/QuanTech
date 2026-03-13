package de.dagegenstand.qtech.data.datagen;

import de.dagegenstand.qtech.QuanTech;
import de.dagegenstand.qtech.common.data.materials.Material;
import de.dagegenstand.qtech.common.data.materials.MaterialFlags;
import de.dagegenstand.qtech.common.data.materials.Materials;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.HashMap;

public class ModLangProvider extends LanguageProvider {
    public static HashMap<String, String> toTranslate = new HashMap<>();

    public ModLangProvider(PackOutput output, String locale) {
        super(output, QuanTech.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("creativetab.qtech.resources", "QuanTech Resources");
        for(Material material : Materials.getAllMaterials()) {
            for(MaterialFlags flag : material.getAllItemFlags().values()) {
                if(flag.hasTranslation()) {
                    add(flag.getTranslationKey(), flag.getTranslationValue());
                }
            }

            for(MaterialFlags flag : material.getAllBlockFlags().values()) {
                if(flag.hasTranslation()) {
                    add(flag.getTranslationKey(), flag.getTranslationValue());
                }
            }
        }
    }
}
