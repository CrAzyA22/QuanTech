package de.dagegenstand.qtech.content.blocks;

import de.dagegenstand.qtech.util.items.ITintable;
import net.minecraft.world.level.block.Block;

public class BaseTintableBlock extends Block implements ITintable {
    int tintColor;

    public BaseTintableBlock(int tint, Properties properties) {
        super(properties);
        this.tintColor = tint;
    }

    @Override
    public int getTintColor() {
        return this.tintColor;
    }
}
