package com.fuzzpickles14.fluidsorcery.core.proxy;

import com.fuzzpickles14.fluidsorcery.FluidSorcery;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Andrew Toomey on 7/11/2017.
 */
public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

    }

    public void init(FMLInitializationEvent event) {
        super.init(event);
//        ModBlocks.renderBlocks();
//        ItemRender.registerItemRender();

    }

    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
