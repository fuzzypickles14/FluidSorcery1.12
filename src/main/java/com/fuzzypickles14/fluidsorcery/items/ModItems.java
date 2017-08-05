package com.fuzzypickles14.fluidsorcery.items;

import com.fuzzypickles14.fluidsorcery.items.items.ItemManual;
import com.fuzzypickles14.fluidsorcery.lib.LibModDetails;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Created by Andrew Toomey on 7/11/2017.
 */
public class ModItems {

    @GameRegistry.ObjectHolder(LibModDetails.MODID + ":" + "itemmanual")
    public static Item itemManual =  new ItemManual("itemmanual");


    @Mod.EventBusSubscriber(modid = LibModDetails.MODID)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            final IForgeRegistry<Item> registry = event.getRegistry();
            registry.register(itemManual);
        }
    }
}
