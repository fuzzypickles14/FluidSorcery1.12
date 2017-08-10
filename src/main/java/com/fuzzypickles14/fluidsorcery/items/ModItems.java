package com.fuzzypickles14.fluidsorcery.items;

import com.fuzzypickles14.fluidsorcery.items.items.ItemManual;
import com.fuzzypickles14.fluidsorcery.items.items.StoneGem;
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

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrew Toomey on 7/11/2017.
 */
public class ModItems {

    private static Set<Item> items = new HashSet<>();
    static Item itemManual =  new ItemManual("itemmanual");
    public static Item stoneGem = new StoneGem("stonegem");
    private static IForgeRegistry<Item> itemIForgeRegistry;


    @Mod.EventBusSubscriber(modid = LibModDetails.MODID)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event)
        {
            itemIForgeRegistry = event.getRegistry();
            registerAndAdd(itemManual);
            registerAndAdd(stoneGem);
            registerRenders();
        }
    }

    private static void registerAndAdd(Item item)
    {
        itemIForgeRegistry.register(item);
        items.add(item);
    }

    public static void registerRenders() {
        for (Item item : items) {
            ModelLoader.setCustomModelResourceLocation(item, 0,
                    createResourceLocation(item));
        }
    }

    private static ModelResourceLocation createResourceLocation(Item item) {
        return new ModelResourceLocation(item.getRegistryName() + "", "inventory");
    }

}
