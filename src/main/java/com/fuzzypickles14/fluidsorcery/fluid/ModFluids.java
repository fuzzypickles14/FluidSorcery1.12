package com.fuzzypickles14.fluidsorcery.fluid;

import com.fuzzypickles14.fluidsorcery.blocks.ModBlock;
import com.fuzzypickles14.fluidsorcery.core.FluidSorceryCreativeTab;
import com.fuzzypickles14.fluidsorcery.core.proxy.ClientProxy;
import com.fuzzypickles14.fluidsorcery.fluid.blockfluids.ModBlockFluid;
import com.fuzzypickles14.fluidsorcery.items.ModItems;
import com.fuzzypickles14.fluidsorcery.lib.LibModDetails;
import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by Andrew Toomey on 7/11/2017.
 */
public class ModFluids {


    private static final Set<ModFluid> FLUIDS = new HashSet<>();
    public static final Set<IFluidBlock> MOD_FLUID_BLOCKS = new HashSet<>();
    static final String texturePrefix = LibModDetails.MODID + ":blocks/";

    public static final ModFluid SCORCH = new ModFluid("scorch", new ResourceLocation(texturePrefix + "scorch" + "Still"), new ResourceLocation(texturePrefix + "scorch" + "Still"));
    public static final ModFluid AER = new ModFluid("aer", new ResourceLocation(texturePrefix + "aer" + "Still"), new ResourceLocation(texturePrefix + "aer" + "Still"));
    public static final ModFluid MIST = new ModFluid("mist", new ResourceLocation(texturePrefix + "mist" + "Still"), new ResourceLocation(texturePrefix + "mist" + "Still"));
    public static final ModFluid TERRE = new ModFluid("terre", new ResourceLocation(texturePrefix + "terre" + "Still"), new ResourceLocation(texturePrefix + "terre" + "Still"));

    public static void init() {
        registerFluidBlock(SCORCH, new ModBlockFluid(SCORCH, new MaterialLiquid(MapColor.RED), ModItems.fireGem), "scorch");
        registerFluidBlock(AER, new ModBlockFluid(AER, new MaterialLiquid(MapColor.YELLOW), ModItems.airGem), "aer");
        registerFluidBlock(MIST, new ModBlockFluid(MIST, new MaterialLiquid(MapColor.LIGHT_BLUE), ModItems.waterGem), "mist");
        registerFluidBlock(TERRE, new ModBlockFluid(TERRE, new MaterialLiquid(MapColor.GREEN), ModItems.earthGem), "terre");
    }


    public static Block registerFluidBlock(Fluid fluid, Block fluidBlock, String name)
    {
        fluidBlock.setRegistryName(new ResourceLocation(LibModDetails.MODID, name));
        ForgeRegistries.BLOCKS.register(fluidBlock);
        fluid.setBlock(fluidBlock);
        registerBucket(fluid);
        MOD_FLUID_BLOCKS.add((IFluidBlock) fluidBlock);
        return fluidBlock;
    }


    /**
     * Register this mod's tanks and buckets.
     */
    private static void registerFluidContainers() {
//        registerTank(FluidRegistry.WATER);
//        registerTank(FluidRegistry.LAVA);

        for (final Fluid fluid : FLUIDS) {
            registerBucket(fluid);
            //registerTank(fluid);
        }
    }

    private static void registerBucket(final Fluid fluid) {
        FluidRegistry.addBucketForFluid(fluid);
    }

//    private static void registerTank(final Fluid fluid) {
//        final FluidStack fluidStack = new FluidStack(fluid, TileEntityFluidTank.CAPACITY);
//
//        final Item item = Item.getItemFromBlock(ModBlocks.FLUID_TANK);
//        assert item instanceof ItemFluidTank;
//
//        ((ItemFluidTank) item).addFluid(fluidStack);
//    }
}
