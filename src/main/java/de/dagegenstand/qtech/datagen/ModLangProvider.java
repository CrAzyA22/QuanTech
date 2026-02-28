package de.dagegenstand.qtech.datagen;

import de.dagegenstand.qtech.QuanTech;
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
        for(var entry : toTranslate.entrySet()) {
            add(entry.getKey(), entry.getValue());
        }
    }
}
