package com.fuzzypickles14.fluidsorcery.core.proxy;

import com.fuzzypickles14.fluidsorcery.fluid.ModFluids;
import com.fuzzypickles14.fluidsorcery.items.ModItem;
import com.fuzzypickles14.fluidsorcery.items.ModItems;
import com.fuzzypickles14.fluidsorcery.lib.LibModDetails;
import com.fuzzypickles14.fluidsorcery.lib.MeshDefinitionFix;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrew Toomey on 7/11/2017.
 */
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = LibModDetails.MODID)
public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        OBJLoader.INSTANCE.addDomain(LibModDetails.MODID);
        ModFluids.init();
        registerFluidModels();
    }

    public void init(FMLInitializationEvent event) {
        super.init(event);

    }

    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }


    private void registerFluidModels() {
        ModFluids.MOD_FLUID_BLOCKS.forEach(this::registerFluidModel);
    }

    private final Set<Item> itemsRegistered = new HashSet<>();

    private void registerFluidModel(IFluidBlock fluidBlock) {

        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(LibModDetails.FLUID_MODEL_PATH, fluidBlock.getFluid().getName());

        ModelLoader.setCustomStateMapper((Block) fluidBlock, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return modelResourceLocation;
            }
        });
    }

}
