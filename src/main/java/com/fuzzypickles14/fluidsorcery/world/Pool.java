package com.fuzzypickles14.fluidsorcery.world;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Andrew Toomey on 8/17/2017.
 */
public class Pool {
    private Block[] block;

    public Pool(Block... blockIn) {
        this.block = blockIn;
    }

    public boolean generate(World world, Random rand, BlockPos position) {
        if (rand.nextInt(100) > 2) {
            return false;
        }
        if (world.getBlockState(position) == Blocks.AIR.getDefaultState()) {
            return false;
        }
        if (checkAreaForLake(world, position))
        {
            int poolType = rand.nextInt(block.length);
            world.setBlockState(position.add(0, 1, 0), block[poolType].getDefaultState(), 2);
            return true;
        }
        else {
            return false;
        }
    }

    private boolean checkAreaForLake(World world, BlockPos position)
    {
        for (int xPos = -1; xPos < 4; xPos++)
        {
            for (int zPos = -1; zPos < 4; zPos++)
            {
                if (!world.getBlockState(position.add(xPos, 1, zPos)).getMaterial().isSolid()) {
                    return false;
                }
            }
        }
        return true;
    }
}
