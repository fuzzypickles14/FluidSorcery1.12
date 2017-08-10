package com.fuzzypickles14.fluidsorcery.items.items;

import com.fuzzypickles14.fluidsorcery.items.ModItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Created by Andrew Toomey on 8/9/2017.
 */
public class StoneGem extends ModItem {

    public StoneGem(String unlocalizedName) {
        super(unlocalizedName);
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
    {
        resetCookTime(item, player.getEntityWorld());
        return true;
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    public long getCookTime(ItemStack item, World world)
    {
        if (item.getTagCompound() == null)
        {
            item.setTagCompound(new NBTTagCompound());
            item.getTagCompound().setLong("cooktime", world.getTotalWorldTime() + 100);
            item.getTagCompound().setLong("cookTimeRemaining", 100);
        }
        else
        {
            item.getTagCompound().setLong("cookTimeRemaining", item.getTagCompound().getLong("cooktime") - world.getTotalWorldTime());
        }
        return item.getTagCompound().getLong("cooktime");
    }

    private void resetCookTime(ItemStack item, World world)
    {
        if (item.getTagCompound() == null)
        {
            item.setTagCompound(new NBTTagCompound());
        }
        item.getTagCompound().setLong("cooktime", world.getTotalWorldTime() + 100);
    }

    public long getCookTimeRemaining(ItemStack item)
    {
        return item.getTagCompound().getLong("cookTimeRemaining");
    }
}
