package de.dagegenstand.qtech.content.items;

import de.dagegenstand.qtech.QuanTech;
import de.dagegenstand.qtech.content.resources.MetalCraftingIngredient;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(QuanTech.MODID);

    public static List<ItemEntry> toRegisterItems = new ArrayList<>();

    public static List<DeferredItem<?>> registeredResourceItems = new ArrayList<>();

    public static class ItemEntry {
        public final MetalCraftingIngredient ingredient;
        public final DeferredItem<?> item;

        public ItemEntry(MetalCraftingIngredient ingredient, DeferredItem<?> item) {
            this.ingredient = ingredient;
            this.item = item;
        }
    }

    public static final DeferredItem<Item> BASE_INGOT = ITEMS.register("base_ingot", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
