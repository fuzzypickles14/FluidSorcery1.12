package com.fuzzypickles14.fluidsorcery.items;

import com.fuzzypickles14.fluidsorcery.core.FluidSorceryCreativeTab;
import net.minecraft.item.Item;

/**
 * Created by Andrew Toomey on 7/11/2017.
 */
public class ModItem extends Item {

    public ModItem(String unlocalizedName) {
        super();
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(FluidSorceryCreativeTab.instance);
        this.setRegistryName(unlocalizedName);
    }
}
