package com.fuzzypickles14.fluidsorcery.core.proxy;

import com.fuzzypickles14.fluidsorcery.items.ModItem;
import com.fuzzypickles14.fluidsorcery.items.ModItems;
import com.fuzzypickles14.fluidsorcery.lib.LibModDetails;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Andrew Toomey on 7/11/2017.
 */
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = LibModDetails.MODID)
public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        OBJLoader.INSTANCE.addDomain(LibModDetails.MODID);
        ModelResourceLocation location =  new ModelResourceLocation(ModItems.itemManual.getRegistryName() + "", "inventory");
        ModelLoader.setCustomModelResourceLocation(ModItems.itemManual, 0, location);
    }

    public void init(FMLInitializationEvent event) {
        super.init(event);

    }

    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
