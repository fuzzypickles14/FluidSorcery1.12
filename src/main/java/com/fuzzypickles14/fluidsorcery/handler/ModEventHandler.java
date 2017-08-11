package com.fuzzypickles14.fluidsorcery.handler;

import com.fuzzypickles14.fluidsorcery.items.ModItems;
import com.fuzzypickles14.fluidsorcery.lib.LibModDetails;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Andrew Toomey on 8/9/2017.
 */
@Mod.EventBusSubscriber(modid = LibModDetails.MODID)
public class ModEventHandler {


    @SubscribeEvent
    public static void harvestDrops(final BlockEvent.HarvestDropsEvent event) {
        if (isStone(event.getState().getBlock()) && event.getHarvester().isSneaking()) {
            event.getDrops().add(new ItemStack(ModItems.stoneGem, 1));
        }
    }

    private static boolean isStone(Block block) {
        return block.equals(Blocks.STONE);
    }

}
