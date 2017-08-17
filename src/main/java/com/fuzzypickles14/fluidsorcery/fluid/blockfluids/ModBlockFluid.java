package com.fuzzypickles14.fluidsorcery.fluid.blockfluids;

import com.fuzzypickles14.fluidsorcery.items.ModItems;
import com.fuzzypickles14.fluidsorcery.items.items.Gems.StoneGem;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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
    private Item cookingResultItem;

    public ModBlockFluid(Fluid fluid, Material material) {
        super(fluid, material);
        cookingResultItem = Item.getItemFromBlock(Blocks.COBBLESTONE);
    }

    public ModBlockFluid(Fluid fluid, Material material, Item item) {
        super(fluid, material);
        cookingResultItem = item;
        setDefaultState(blockState.getBaseState().withProperty(LEVEL, 7));
    }


    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        if (entityIn instanceof EntityItem && ((EntityItem)entityIn).getItem().getItem() == ModItems.stoneGem)
        {
            StoneGem gem = (StoneGem) ((EntityItem)entityIn).getItem().getItem();
            if ( gem.getCookTime(((EntityItem)entityIn).getItem(), worldIn) - worldIn.getTotalWorldTime() > 0) {
                worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, entityIn.posX, pos.getY() + 1, entityIn.posZ, 0, 1, 0);
            }
            else
            {
                ((EntityItem) entityIn).setItem(new ItemStack(cookingResultItem, ((EntityItem)entityIn).getItem().getCount()));
            }
        }
    }


    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        boolean changed = false;
        int quantaRemaining = state.getValue(LEVEL) + 1;
        final int prevRemaining = quantaRemaining;
        quantaRemaining = tryToFlowVerticallyInto(world, pos, quantaRemaining);

        if (quantaRemaining < 1) {
            return;
        } else if (quantaRemaining != prevRemaining) {
            changed = true;
            if (quantaRemaining == 1) {
                world.setBlockState(pos, state.withProperty(LEVEL, quantaRemaining - 1), 2);
                return;
            }
        } else if (quantaRemaining == 1) {
            return;
        }

        if (changed) {
            world.setBlockState(pos, state.withProperty(LEVEL, quantaRemaining - 1), 2);
        }


    }
}
