package de.dagegenstand.qtech.content.items;

import de.dagegenstand.qtech.QuanTech;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(QuanTech.MODID);

    public static final DeferredItem<Item> BASE_INGOT = ITEMS.register("base_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<BaseTintableItem> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new BaseTintableItem(0x696969, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
