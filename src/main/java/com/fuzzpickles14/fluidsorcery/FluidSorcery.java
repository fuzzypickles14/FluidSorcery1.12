package com.fuzzpickles14.fluidsorcery;

import com.fuzzpickles14.fluidsorcery.core.proxy.CommonProxy;
import com.fuzzpickles14.fluidsorcery.lib.LibModDetails;
import net.minecraft.init.Blocks;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = LibModDetails.MODID, version = LibModDetails.VERSION)
public class FluidSorcery
{
    @Mod.Instance(LibModDetails.MODID)
    public static FluidSorcery instance;

    @SidedProxy(clientSide = LibModDetails.CLIENT_PROXY, serverSide = LibModDetails.COMMON_PROXY)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);

    }

    static
    {
        FluidRegistry.enableUniversalBucket();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
