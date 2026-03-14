package de.dagegenstand.qtech.client;

import de.dagegenstand.qtech.QuanTech;
import de.dagegenstand.qtech.common.data.materials.Materials;
import de.dagegenstand.qtech.util.common.items.ITintable;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = QuanTech.MODID, value = Dist.CLIENT)
public class ClientColorHandlers {

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        //BLOCKS
        Materials.getAllMaterials().forEach(material -> material.getAllBlockFlags().forEach((block, flags) -> {
            if(flags != null && flags.hasTint()) {
                event.register((state, world, pos, tintIndex) -> {
                    if(tintIndex != 0) return -1;
                    Block tintBlock = state.getBlock();
                    return (tintBlock instanceof ITintable tbb) ? tbb.getTintColor() | 0xFF000000 : -1;
                }, block.get());
            }
        }));
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        //ITEMS
        Materials.getAllMaterials().forEach(material -> material.getAllItemFlags().forEach((item, flags) -> {
            if(flags != null && flags.hasTint()) {
                event.register((stack, tintIndex) -> {
                    if(tintIndex != 0) return -1;
                    return (stack.getItem() instanceof ITintable tbi) ? tbi.getTintColor() | 0xFF000000 : -1;
                }, item.get());
            }
        }));

        //BLOCK ITEMS
        Materials.getAllMaterials().forEach(material -> material.getAllBlockFlags().forEach((block, flags) -> {
            if(flags != null && flags.hasTint()) {
                event.register((stack, tintIndex) -> {
                    if (tintIndex != 0) return -1;
                    return (stack.getItem() instanceof ITintable tbi) ? tbi.getTintColor() | 0xFF000000 : -1;
                }, block.get().asItem());
            }
        }));
    }
}
