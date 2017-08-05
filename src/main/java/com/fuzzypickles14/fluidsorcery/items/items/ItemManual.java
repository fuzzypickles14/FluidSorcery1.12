package com.fuzzypickles14.fluidsorcery.items.items;

import com.fuzzypickles14.fluidsorcery.FluidSorcery;
import com.fuzzypickles14.fluidsorcery.items.ModItem;
import com.fuzzypickles14.fluidsorcery.lib.LibGui;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Andrew Toomey on 8/2/2017.
 */
public class ItemManual extends ModItem {
    public ItemManual(String unlocalizedName) {
        super(unlocalizedName);
        this.setMaxStackSize(1);
    }

    private static void OpenManual(EntityPlayer player, World world)
    {
        player.openGui(FluidSorcery.instance, LibGui.MANUAL_GUI, world, 0 ,0, 0);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        OpenManual(playerIn, worldIn);
        return new ActionResult<ItemStack>(EnumActionResult.PASS, new ItemStack(this));
    }

}