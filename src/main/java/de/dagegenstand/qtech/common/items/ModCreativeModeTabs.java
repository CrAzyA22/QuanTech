package de.dagegenstand.qtech.common.items;

import de.dagegenstand.qtech.QuanTech;
import de.dagegenstand.qtech.common.data.materials.Material;
import de.dagegenstand.qtech.common.data.materials.Materials;
import de.dagegenstand.qtech.util.common.RegisterUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, QuanTech.MODID);

    public static final Supplier<CreativeModeTab> QUANTECH_RESOURCES = CREATIVE_MODE_TAB.register("qtech_resource_tab", () -> CreativeModeTab.builder()
            .icon(() -> ModItems.BASE_INGOT.get().getDefaultInstance())
            .title(Component.translatable("creativetab.qtech.resources"))
            .displayItems(((itemDisplayParameters, output) -> {
                output.accept(ModItems.BASE_INGOT.get());

                for(Material material : Materials.getAllMaterials()) {
                    for(DeferredItem<?> item : material.getAllItems()) {
                        if(item != null &&material.getItemFlags(item) != null && material.getItemFlags(item).getCreativeTab().equals(ModCreativeTabs.RESOURCES)) {
                            output.accept(item.get());
                        }
                    }
                }
            }))
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

    public static enum ModCreativeTabs {
        RESOURCES;
    }
}
