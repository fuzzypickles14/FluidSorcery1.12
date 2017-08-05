package com.fuzzypickles14.fluidsorcery.items.items;

import com.fuzzypickles14.fluidsorcery.items.ModItem;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Andrew Toomey on 8/2/2017.
 */
public class ItemManual extends ModItem{
    public ItemManual(String unlocalizedName) {
        super(unlocalizedName);
    }

    public static void OpenManual(EntityPlayer player, ItemStack itemStack, World world)
    {
        //player.openGui(FluidSorcery.instance, LibGui.MANUAL_GUI, world, 0 ,0, 0);
    }



}