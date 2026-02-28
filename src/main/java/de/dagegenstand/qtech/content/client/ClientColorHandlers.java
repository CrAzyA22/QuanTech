package de.dagegenstand.qtech.content.client;

import de.dagegenstand.qtech.QuanTech;
import de.dagegenstand.qtech.content.blocks.ModBlocks;
import de.dagegenstand.qtech.content.items.ModItems;
import de.dagegenstand.qtech.util.items.ITintable;
import net.minecraft.util.FastColor;
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
        event.register((state, world, pos, tintIndex) -> {
            if(tintIndex != 0) return -1;
            Block tintBlock = state.getBlock();
            return (tintBlock instanceof ITintable tb) ? tb.getTintColor() | 0xFF000000 : -1;
        });

        ModBlocks.toRegisterBlocks.forEach(ro -> event.register((state, world, pos, tintIndex) -> {
            if(tintIndex != 0) return -1;
            Block tintBlock = state.getBlock();
            return (tintBlock instanceof ITintable tb) ? tb.getTintColor() | 0xFF000000 : -1;
        }, ro.get().get()));
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        //ITEMS
        event.register((stack, tintIndex) -> {
            if (tintIndex != 0) return -1;
            if (stack.getItem() instanceof ITintable ti) {
                return FastColor.ARGB32.opaque(ti.getTintColor());
            }
            return -1;
        });

        ModItems.toRegisterItems.forEach(entry -> event.register((stack, tintIndex) -> {
            if(tintIndex != 0) return -1;
            return (stack.getItem() instanceof ITintable tbi) ? tbi.getTintColor() | 0xFF000000 : -1;
        }, entry.item.get()));

        //BLOCK ITEMS
        event.register((stack, tintIndex) -> {
            if(tintIndex != 0) return -1;
            return (stack.getItem() instanceof ITintable tbi) ? tbi.getTintColor() | 0xFF000000 : -1;
        });

        ModBlocks.toRegisterBlocks.forEach(ro -> event.register((stack, tintIndex) -> {
            if(tintIndex != 0) return -1;
            return (stack.getItem() instanceof ITintable tbi) ? tbi.getTintColor() | 0xFF000000 : -1;
        }, ro.get().get().asItem()));
    }
}
