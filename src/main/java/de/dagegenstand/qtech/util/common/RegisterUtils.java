package de.dagegenstand.qtech.util.common;

import de.dagegenstand.qtech.common.data.materials.MaterialCraftingIngredientsMetal;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RegisterUtils {
    //Color register List
    public static HashSet<RegisterEntry> toRegisterBlocks = new HashSet<>();
    public static HashSet<RegisterEntry> toRegisterItems = new HashSet<>();

    //Creative tab register List
    public static List<DeferredItem<?>> toCreativeResourceTab = new ArrayList<>();

    //Add tags to the corresponding items and blocks


    //Methods to get entries as deferred blocks or items
    public static HashSet<DeferredItem<?>> getToRegisterItems() {
        HashSet<DeferredItem<?>> items = new HashSet<>();
        toRegisterItems.forEach(entry -> items.add((DeferredItem<?>) entry.get()));
        return items;
    }

    public static HashSet<DeferredBlock<?>> getToRegisterBlocks() {
        HashSet<DeferredBlock<?>> blocks = new HashSet<>();
        toRegisterBlocks.forEach(entry -> blocks.add((DeferredBlock<?>) entry.get()));
        return blocks;
    }

    //Helper class to store the ingredient and the entry together for easier registration
    public static class RegisterEntry {
        public final MaterialCraftingIngredientsMetal ingredient;
        public final DeferredHolder<?, ?> entry;
        public final String[] otherTextureString;

        public RegisterEntry(MaterialCraftingIngredientsMetal ingredient, DeferredHolder<?, ?> entry, @Nullable String... otherTextureString) {
            this.ingredient = ingredient;
            this.entry = entry;
            this.otherTextureString = otherTextureString;
        }

        public DeferredHolder<?, ?> get() {
            return entry;
        }

        public String[] getTextureStrings() {
            if(otherTextureString.length > 0) {
                System.out.println("Getting alt texture strings for " + entry.getId() + " with ingredient " + Arrays.toString(this.otherTextureString));
                return otherTextureString;
            } else {
                System.out.println("Getting original texture strings for " + entry.getId() + " with ingredient " + Arrays.toString(this.ingredient.getBaseTextures()));
                return ingredient.getBaseTextures();
            }
        }
    }
}
