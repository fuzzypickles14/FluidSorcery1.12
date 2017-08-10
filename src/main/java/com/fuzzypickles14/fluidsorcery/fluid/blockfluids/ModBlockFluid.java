package com.fuzzypickles14.fluidsorcery.fluid.blockfluids;

import com.fuzzypickles14.fluidsorcery.items.ModItems;
import com.fuzzypickles14.fluidsorcery.items.items.StoneGem;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;

import java.util.Random;

/**
 * Created by Andrew Toomey on 8/8/2017.
 */
public class ModBlockFluid extends BlockFluidFinite {
    public ModBlockFluid(Fluid fluid, Material material) {
        super(fluid, material);
    }


    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        if (entityIn instanceof EntityItem && ((EntityItem)entityIn).getItem().getItem() == ModItems.stoneGem)
        {
            StoneGem gem = (StoneGem) ((EntityItem)entityIn).getItem().getItem();
            if ( gem.getCookTime(((EntityItem)entityIn).getItem(), worldIn) - worldIn.getTotalWorldTime() > 0) {
                worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, entityIn.posX, entityIn.posY, entityIn.posZ, 0, 1, 0);
            }
            else
            {
                ((EntityItem) entityIn).setItem(new ItemStack(Items.DIAMOND, ((EntityItem)entityIn).getItem().getCount()));
            }
        }
    }


    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    }
}
