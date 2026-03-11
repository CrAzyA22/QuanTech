package de.dagegenstand.qtech.common.items;

import de.dagegenstand.qtech.util.common.items.ITintable;
import net.minecraft.world.item.Item;

public class BaseTintableItem extends Item implements ITintable {
    int tintColor;

    public BaseTintableItem(int tint, Properties properties) {
        super(properties);
        this.tintColor = tint;
    }

    @Override
    public int getTintColor() {
        return this.tintColor;
    }
}
