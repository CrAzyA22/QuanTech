package de.dagegenstand.qtech.util;

import de.dagegenstand.qtech.content.resources.MetalCraftingIngredient;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RegisterUtils {
    //Color register List
    public static HashSet<RegisterEntry> toRegisterBlocks = new HashSet<>();
    public static HashSet<RegisterEntry> toRegisterItems = new HashSet<>();

    //Creative tab register List
    public static List<DeferredItem<?>> toCreativeResourceTab = new ArrayList<>();

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
        public final MetalCraftingIngredient ingredient;
        public final DeferredHolder<?, ?> entry;

        public RegisterEntry(MetalCraftingIngredient ingredient, DeferredItem<?> entry) {
            this.ingredient = ingredient;
            this.entry = entry;
        }

        public RegisterEntry(MetalCraftingIngredient ingredient, DeferredBlock<?> entry) {
            this.ingredient = ingredient;
            this.entry = entry;
        }

        public DeferredHolder<?, ?> get() {
            return entry;
        }
    }
}
