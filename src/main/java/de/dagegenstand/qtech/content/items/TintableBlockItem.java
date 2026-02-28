package de.dagegenstand.qtech.content.items;

import de.dagegenstand.qtech.util.items.ITintable;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class TintableBlockItem extends BlockItem implements ITintable {
    private final int tintColor;

    public TintableBlockItem(Block block, Properties properties, int tintColor) {
        super(block, properties);
        this.tintColor = tintColor;
    }

    @Override
    public int getTintColor() {
        return tintColor;
    }
}

