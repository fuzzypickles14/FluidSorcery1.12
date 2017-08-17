package com.fuzzypickles14.fluidsorcery.items;

import com.fuzzypickles14.fluidsorcery.items.items.Gems.*;
import com.fuzzypickles14.fluidsorcery.items.items.ItemManual;
import com.fuzzypickles14.fluidsorcery.lib.LibModDetails;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
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
    public static Item fireGem = new FireGem("firegem");
    public static Item waterGem = new WaterGem("watergem");
    public static Item earthGem = new EarthGem("earthgem");
    public static Item airGem = new AirGem("airgem");



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
            registerAndAdd(fireGem);
            registerAndAdd(waterGem);
            registerAndAdd(earthGem);
            registerAndAdd(airGem);
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
