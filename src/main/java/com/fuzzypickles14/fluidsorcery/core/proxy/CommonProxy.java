package com.fuzzypickles14.fluidsorcery.core.proxy;

import com.fuzzypickles14.fluidsorcery.FluidSorcery;
import com.fuzzypickles14.fluidsorcery.handler.GuiHandler;
import com.fuzzypickles14.fluidsorcery.world.WorldGenFluids;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew Toomey on 7/11/2017.
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
//        ModItems.initItems();
//        ModFluids.Init();
//        ModBlocks.initBlocks();
//        CraftingRecipes.initRecipes();
    }

    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(FluidSorcery.instance, new GuiHandler());
        GameRegistry.registerWorldGenerator(new WorldGenFluids(), 8);
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
