package com.fuzzypickles14.fluidsorcery.world;

import com.fuzzypickles14.fluidsorcery.blocks.ModBlocks;
import com.fuzzypickles14.fluidsorcery.fluid.ModFluid;
import com.fuzzypickles14.fluidsorcery.fluid.ModFluids;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by Andrew Toomey on 8/17/2017.
 */
public class WorldGenFluids implements IWorldGenerator {

    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int blockX = chunkX * 16;
        int blockZ = chunkZ * 16;
        switch (world.provider.getDimension())
        {
            case -1:
                generateNether(world, rand, blockX, blockZ);
                break;
            case 0:
                generateOverworld(world, rand, blockX, blockZ);
                break;
            case 1:
                break;
        }
    }

    private void generateNether(World world, Random rand, int blockX, int blockZ)
    {

    }

    private void generateOverworld(World world, Random rand, int blockX, int blockZ)
    {
        Pool scorchPool = new Pool(ModFluids.SCORCH.getBlock(), ModFluids.AER.getBlock(), ModFluids.MIST.getBlock(), ModFluids.TERRE.getBlock());
        scorchPool.generate(world, rand, new BlockPos(blockX,findGround(world, blockX, blockZ), blockZ));
    }

    private int findGround(World world, int x, int z)
    {
        int y = 255;
        boolean isAtGround = false;
        BlockPos pos = new BlockPos(x, y, z);
        while(!isAtGround && y-- >=0)
        {
            isAtGround = !world.isAirBlock(pos) && world.isAirBlock(new BlockPos(pos.add(0,1,0)));
            pos = pos.down();
        }
        return y;
    }
}
