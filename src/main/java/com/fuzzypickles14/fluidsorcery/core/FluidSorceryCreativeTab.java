package com.fuzzypickles14.fluidsorcery.core;

import com.fuzzypickles14.fluidsorcery.lib.LibModDetails;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by Andrew Toomey on 8/2/2017.
 */
public class FluidSorceryCreativeTab extends CreativeTabs {

    public static FluidSorceryCreativeTab instance = new FluidSorceryCreativeTab(LibModDetails.MODID);

    public FluidSorceryCreativeTab(String label) {
        super(label);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.APPLE);
    }
}