package com.fuzzypickles14.fluidsorcery.core.proxy;

import com.fuzzypickles14.fluidsorcery.FluidSorcery;
import com.fuzzypickles14.fluidsorcery.handler.GuiHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

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
//        GameRegistry.registerWorldGenerator(new ModWorldGenerator(), 10);
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
