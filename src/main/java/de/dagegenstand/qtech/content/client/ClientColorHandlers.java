package de.dagegenstand.qtech.content.client;

import de.dagegenstand.qtech.QuanTech;
import de.dagegenstand.qtech.util.RegisterUtils;
import de.dagegenstand.qtech.util.items.ITintable;
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
        RegisterUtils.getToRegisterBlocks().forEach(block -> event.register((state, world, pos, tintIndex) -> {
            if(tintIndex != 0) return -1;
            Block tintBlock = state.getBlock();
            return (tintBlock instanceof ITintable tbb) ? tbb.getTintColor() | 0xFF000000 : -1;
        }, block.get()));
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        //ITEMS
        RegisterUtils.getToRegisterItems().forEach(item -> event.register((stack, tintIndex) -> {
            if(tintIndex != 0) return -1;
            return (stack.getItem() instanceof ITintable tbi) ? tbi.getTintColor() | 0xFF000000 : -1;
        }, item.get()));

        //BLOCK ITEMS
        RegisterUtils.getToRegisterBlocks().forEach(item -> event.register((stack, tintIndex) -> {
            if(tintIndex != 0) return -1;
            return (stack.getItem() instanceof ITintable tbi) ? tbi.getTintColor() | 0xFF000000 : -1;
        }, item.get().asItem()));
    }
}
