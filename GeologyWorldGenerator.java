/**
 * 
 */
package geology;

import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGravel;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.src.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

/**
 * @author patriceboivin
 * 
 */
public class GeologyWorldGenerator implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
	    IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
			case -1: generateNether(world, random, chunkX * 16, chunkZ * 16);
			case  0: generateSurface(world, random, chunkX * 16, chunkZ * 16);
			case  1: generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
    }

    /*
     * useful functions and methods from WorldGenDungeons Material material =
     * par1World.getBlockMaterial(k1, l1, i2); 
     * par1World.isAirBlock(k1, l1, i2)
     * par1World.setBlockToAir(k1, l1, i2); 
     * par1World.setBlock(k1, l1, i2, Block.cobblestoneMossy.blockID, 0, 2);
     * this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, 0, 4, 9, 4, Block.sandStone.blockID, 0, false); 
     * this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 10, 1, 3, 10, 3, Block.sandStone.blockID, Block.sandStone.blockID, false);
     * this.placeBlockAtCurrentPosition(par1World,
     * Block.stairsSandStone.blockID, i, 2, 10, 0, par3StructureBoundingBox);
     * this.fillWithMetadataBlocks(par1World, par3StructureBoundingBox, 8, 1, 8, 8, 3, 8, Block.sandStone.blockID, 2, Block.sandStone.blockID, 2, false);
     */
    private void generateSurface(World world, Random random, int BlockX,
	    int BlockZ) {
	/* System.out.println("starting GeologyWorldGenerator.java"); */

	/* place the ore blocks first */
	for (int i = 0; i < 10; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = random.nextInt(10) + 10;
	    int randPosZ = BlockZ + random.nextInt(16);
	    int subType = random.nextInt(BlockMetalOreA.maxSubType);
	    int numBlocks = random.nextInt(25);
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.stone.blockID) {
		new GeologyWorldGenMinable(geology.Geology.metalOreABlockID,
			subType, numBlocks, Block.stone.blockID).generate(
			world, random, randPosX, randPosY, randPosZ);
	    }
	}

	for (int i = 0; i < 10; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = random.nextInt(100);
	    int randPosZ = BlockZ + random.nextInt(16);
	    int subType = random.nextInt(BlockMetalOreB.maxSubType);
	    int numBlocks = random.nextInt(25);
	    new GeologyWorldGenMinable(geology.Geology.metalOreBBlockID,
		    subType, numBlocks, Block.stone.blockID).generate(world,
		    random, randPosX, randPosY, randPosZ);
	}

	for (int i = 0; i < 10; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = random.nextInt(100);
	    int randPosZ = BlockZ + random.nextInt(16);
	    int subType = random.nextInt(BlockMetalOreC.maxSubType);
	    int numBlocks = random.nextInt(25);
	    new GeologyWorldGenMinable(geology.Geology.metalOreCBlockID,
		    subType, numBlocks, Block.stone.blockID).generate(world,
		    random, randPosX, randPosY, randPosZ);
	}

	for (int i = 0; i < 10; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = random.nextInt(100);
	    int randPosZ = BlockZ + random.nextInt(16);
	    int subType = random.nextInt(BlockMetalOreD.maxSubType);
	    int numBlocks = random.nextInt(20);
	    new GeologyWorldGenMinable(geology.Geology.metalOreDBlockID,
		    subType, numBlocks, Block.stone.blockID).generate(world,
		    random, randPosX, randPosY, randPosZ);
	}

	for (int i = 0; i < 5; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = random.nextInt(100);
	    int randPosZ = BlockZ + random.nextInt(16);
	    int subType = random.nextInt(BlockMetalOreE.maxSubType);
	    int numBlocks = random.nextInt(15);
	    new GeologyWorldGenMinable(geology.Geology.metalOreEBlockID,
		    subType, numBlocks, Block.stone.blockID).generate(world,
		    random, randPosX, randPosY, randPosZ);
	}

	/* replacing coal "ore" blocks here */
	for (int i = 0; i < 50; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 10 + random.nextInt(128);
	    int randPosZ = BlockZ + random.nextInt(16);
	    int subType = random.nextInt(BlockSediCoalRock.maxSubType);
	    int numBlocks = 10;
	    new GeologyWorldGenMinable(geology.Geology.sediCoalRockBlockID,
		    subType, numBlocks, Block.oreCoal.blockID).generate(world,
		    random, randPosX, randPosY, randPosZ);
	}

	/* replacing diamond ore blocks with kimberlite */
	for (int i = 0; i < 40; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 10 + random.nextInt(128);
	    int randPosZ = BlockZ + random.nextInt(16);
	    int subType = 12; /* kimberlite */
	    int numBlocks = 10;
	    new GeologyWorldGenMinable(geology.Geology.outerMantleBRockBlockID,
		    subType, numBlocks, Block.oreDiamond.blockID).generate(
		    world, random, randPosX, randPosY, randPosZ);
	}

	/* replacing iron ore blocks with OreA blocks */
	for (int i = 0; i < 40; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 10 + random.nextInt(128);
	    int randPosZ = BlockZ + random.nextInt(16);
	    int subType = random.nextInt(BlockMetalOreA.maxSubType);
	    int numBlocks = 15;
	    new GeologyWorldGenMinable(geology.Geology.metalOreABlockID,
		    subType, numBlocks, Block.oreIron.blockID).generate(world,
		    random, randPosX, randPosY, randPosZ);
	}

	/* lowest blocks */
	for (int i = 0; i < 10; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = random.nextInt(2) + 1;
	    int randPosZ = BlockZ + random.nextInt(16);
	    int numBlocks = random.nextInt(40) + 20;
	    int subType = random.nextInt(BlockMantleRock.maxSubType);
	    /*
	     * world.setBlock(randPosX, randPosY, randPosZ,
	     * geology.Geology.sediAggregatesBlockID, subType, 2);
	     */
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.bedrock.blockID) {
		new GeologyWorldGenMinable(geology.Geology.mantleRockBlockID,
			subType, numBlocks, Block.bedrock.blockID).generate(
			world, random, randPosX, randPosY, randPosZ);
	    }
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.stone.blockID) {
		new GeologyWorldGenMinable(geology.Geology.mantleRockBlockID,
			subType, numBlocks, Block.stone.blockID).generate(
			world, random, randPosX, randPosY, randPosZ);
	    }
	}

	for (int i = 0; i < 30; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = random.nextInt(2) + 4;
	    int randPosZ = BlockZ + random.nextInt(16);
	    int numBlocks = random.nextInt(40) + 20;
	    int k = random.nextInt(2);
	    if (k == 0) {
		int subType = random.nextInt(BlockOuterMantleRock.maxSubType);
		if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.bedrock.blockID) {
		    new GeologyWorldGenMinable(
			    geology.Geology.outerMantleRockBlockID, subType,
			    numBlocks, Block.bedrock.blockID).generate(world,
			    random, randPosX, randPosY, randPosZ);
		}
		if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.stone.blockID) {
		    new GeologyWorldGenMinable(
			    geology.Geology.outerMantleRockBlockID, subType,
			    numBlocks, Block.stone.blockID).generate(world,
			    random, randPosX, randPosY, randPosZ);
		}
	    } else {
		int subType = random.nextInt(BlockOuterMantleBRock.maxSubType);
		if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.bedrock.blockID) {
		    new GeologyWorldGenMinable(
			    geology.Geology.outerMantleBRockBlockID, subType,
			    numBlocks, Block.bedrock.blockID).generate(world,
			    random, randPosX, randPosY, randPosZ);
		}
		if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.stone.blockID) {
		    new GeologyWorldGenMinable(
			    geology.Geology.outerMantleBRockBlockID, subType,
			    numBlocks, Block.stone.blockID).generate(world,
			    random, randPosX, randPosY, randPosZ);
		}
	    }
	}

	for (int i = 0; i < 30; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = random.nextInt(3) + 5;
	    int randPosZ = BlockZ + random.nextInt(16);
	    int numBlocks = random.nextInt(40) + 20;
	    int subType = random.nextInt(BlockIgneousIntrusiveRock.maxSubType);
	    /*
	     * System.out.println(
	     * "for BlockIgneousIntrusiveRock, using numBlocks = " + numBlocks);
	     */
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.bedrock.blockID) {
		new GeologyWorldGenMinable(
			geology.Geology.igneousInstrusiveRockBlockID, subType,
			numBlocks, Block.bedrock.blockID).generate(world,
			random, randPosX, randPosY, randPosZ);
	    }
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.stone.blockID) {
		new GeologyWorldGenMinable(
			geology.Geology.igneousInstrusiveRockBlockID, subType,
			numBlocks, Block.stone.blockID).generate(world, random,
			randPosX, randPosY, randPosZ);
	    }
	}

	for (int i = 0; i < 10; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 1 + random.nextInt(80);
	    int randPosZ = BlockZ + random.nextInt(16);
	    int numBlocks = random.nextInt(5) + 30;
	    int subType = random.nextInt(BlockIgneousExtrusiveRock.maxSubType);
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.stone.blockID) {
		new GeologyWorldGenMinable(
			geology.Geology.igneousExtrusiveRockBlockID, subType,
			numBlocks, Block.stone.blockID).generate(world, random,
			randPosX, randPosY, randPosZ);
	    }
	}

	/* a little higher, metamorphic blocks including marble */
	for (int k = 0; k < 15; k++) {
	    int randRockType = random.nextInt(100);
	    if (randRockType < 45) {
		for (int i = 0; i < 40; i++) {
		    int randPosX = BlockX + random.nextInt(16);
		    int randPosY = 10 + random.nextInt(100);
		    int randPosZ = BlockZ + random.nextInt(16);
		    int numBlocks = random.nextInt(40) + 15;
		    int subType = random
			    .nextInt(BlockMetamorphicRock.maxSubType);
		    new GeologyWorldGenMinable(
			    geology.Geology.metamorphicRockBlockID, subType,
			    numBlocks, Block.stone.blockID).generate(world,
			    random, randPosX, randPosY, randPosZ);
		}
	    } else if (randRockType < 50) {
		for (int i = 0; i < 30; i++) {
		    int randPosX = BlockX + random.nextInt(16);
		    int randPosY = 10 + random.nextInt(100);
		    int randPosZ = BlockZ + random.nextInt(16);
		    int numBlocks = random.nextInt(40) + 15;
		    int subType = random
			    .nextInt(BlockMetamorphicBRock.maxSubType);
		    new GeologyWorldGenMinable(
			    geology.Geology.metamorphicBRockBlockID, subType,
			    numBlocks, Block.stone.blockID).generate(world,
			    random, randPosX, randPosY, randPosZ);
		}
	    }

	    else if (randRockType < 55) {
		for (int i = 0; i < 30; i++) {
		    int randPosX = BlockX + random.nextInt(16);
		    int randPosY = 15 + random.nextInt(100);
		    int randPosZ = BlockZ + random.nextInt(16);
		    int numBlocks = random.nextInt(40) + 15;
		    int subType = random.nextInt(BlockMarbleRockA.maxSubType);
		    new GeologyWorldGenMinable(
			    geology.Geology.marbleRockABlockID, subType,
			    numBlocks, Block.stone.blockID).generate(world,
			    random, randPosX, randPosY, randPosZ);
		}
	    } else if (randRockType < 60) {
		for (int i = 0; i < 30; i++) {
		    int randPosX = BlockX + random.nextInt(16);
		    int randPosY = 15 + random.nextInt(100);
		    int randPosZ = BlockZ + random.nextInt(16);
		    int subType = random.nextInt(BlockMarbleRockB.maxSubType);
		    int numBlocks = random.nextInt(40) + 15;
		    new GeologyWorldGenMinable(
			    geology.Geology.marbleRockBBlockID, subType,
			    numBlocks, Block.stone.blockID).generate(world,
			    random, randPosX, randPosY, randPosZ);
		}
	    } else if (randRockType < 70) {
		for (int i = 0; i < 30; i++) {
		    int randPosX = BlockX + random.nextInt(16);
		    int randPosY = 15 + random.nextInt(100);
		    int randPosZ = BlockZ + random.nextInt(16);
		    int subType = random.nextInt(BlockMarbleRockC.maxSubType);
		    int numBlocks = random.nextInt(40) + 15;
		    new GeologyWorldGenMinable(
			    geology.Geology.marbleRockCBlockID, subType,
			    numBlocks, Block.stone.blockID).generate(world,
			    random, randPosX, randPosY, randPosZ);
		}
	    } else if (randRockType < 80) {
		for (int i = 0; i < 30; i++) {
		    int randPosX = BlockX + random.nextInt(16);
		    int randPosY = 15 + random.nextInt(100);
		    int randPosZ = BlockZ + random.nextInt(16);
		    int subType = random.nextInt(BlockMarbleRockD.maxSubType);
		    int numBlocks = random.nextInt(40) + 15;
		    new GeologyWorldGenMinable(
			    geology.Geology.marbleRockDBlockID, subType,
			    numBlocks, Block.stone.blockID).generate(world,
			    random, randPosX, randPosY, randPosZ);
		}
	    } else if (randRockType < 85) {
		for (int i = 0; i < 30; i++) {
		    int randPosX = BlockX + random.nextInt(16);
		    int randPosY = 15 + random.nextInt(100);
		    int randPosZ = BlockZ + random.nextInt(16);
		    int subType = random.nextInt(BlockMarbleRockE.maxSubType);
		    int numBlocks = random.nextInt(40) + 15;
		    new GeologyWorldGenMinable(
			    geology.Geology.marbleRockEBlockID, subType,
			    numBlocks, Block.stone.blockID).generate(world,
			    random, randPosX, randPosY, randPosZ);
		}
	    } else if (randRockType < 90) {
		for (int i = 0; i < 30; i++) {
		    int randPosX = BlockX + random.nextInt(16);
		    int randPosY = 15 + random.nextInt(100);
		    int randPosZ = BlockZ + random.nextInt(16);
		    int subType = random.nextInt(BlockMarbleRockF.maxSubType);
		    int numBlocks = random.nextInt(40) + 15;
		    new GeologyWorldGenMinable(
			    geology.Geology.marbleRockFBlockID, subType,
			    numBlocks, Block.stone.blockID).generate(world,
			    random, randPosX, randPosY, randPosZ);
		}
	    } else if (randRockType < 95) {
		for (int i = 0; i < 30; i++) {
		    int randPosX = BlockX + random.nextInt(16);
		    int randPosY = 15 + random.nextInt(100);
		    int randPosZ = BlockZ + random.nextInt(16);
		    int subType = random.nextInt(BlockMarbleRockG.maxSubType);
		    int numBlocks = random.nextInt(40) + 15;
		    new GeologyWorldGenMinable(
			    geology.Geology.marbleRockGBlockID, subType,
			    numBlocks, Block.stone.blockID).generate(world,
			    random, randPosX, randPosY, randPosZ);
		}
	    } else if (randRockType < 100) {
		for (int i = 0; i < 30; i++) {
		    int randPosX = BlockX + random.nextInt(16);
		    int randPosY = 15 + random.nextInt(100);
		    int randPosZ = BlockZ + random.nextInt(16);
		    int subType = random.nextInt(BlockMarbleRockH.maxSubType);
		    int numBlocks = random.nextInt(40) + 15;
		    new GeologyWorldGenMinable(
			    geology.Geology.marbleRockHBlockID, subType,
			    numBlocks, Block.stone.blockID).generate(world,
			    random, randPosX, randPosY, randPosZ);
		}
	    }
	}

	/* nearer the surface, sediments accumulated */
	for (int i = 0; i < 10; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 30 + random.nextInt(128);
	    int randPosZ = BlockZ + random.nextInt(16);
	    int subType = random.nextInt(BlockSediBedsRock.maxSubType);
	    int numBlocks = random.nextInt(60) + 15;
	    new GeologyWorldGenMinable(geology.Geology.sediBedsRockBlockID,
		    subType, numBlocks, Block.stone.blockID).generate(world,
		    random, randPosX, randPosY, randPosZ);
	}

	for (int i = 0; i < 10; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 30 + random.nextInt(128);
	    int randPosZ = BlockZ + random.nextInt(16);
	    int subType = random.nextInt(BlockSediCarbonateRock.maxSubType);
	    int numBlocks = random.nextInt(40) + 15;
	    new GeologyWorldGenMinable(
		    geology.Geology.sediCarbonateRockBlockID, subType,
		    numBlocks, Block.stone.blockID).generate(world, random,
		    randPosX, randPosY, randPosZ);
	}

	for (int i = 0; i < 20; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 30 + random.nextInt(128);
	    int randPosZ = BlockZ + random.nextInt(16);
	    int k = random.nextInt(2);
	    if (k == 0) {
		int subType = random.nextInt(BlockSediClasticRock.maxSubType);
		int numBlocks = random.nextInt(50) + 10;
		new GeologyWorldGenMinable(
			geology.Geology.sediClasticRockBlockID, subType,
			numBlocks, Block.stone.blockID).generate(world, random,
			randPosX, randPosY, randPosZ);
	    } else {
		int subType = random.nextInt(BlockSediClasticRockB.maxSubType);
		int numBlocks = random.nextInt(50) + 10;
		new GeologyWorldGenMinable(
			geology.Geology.sediClasticRockBBlockID, subType,
			numBlocks, Block.stone.blockID).generate(world, random,
			randPosX, randPosY, randPosZ);
	    }
	}

	for (int i = 0; i < 10; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 30 + random.nextInt(128);
	    int randPosZ = BlockZ + random.nextInt(16);
	    int subType = random.nextInt(BlockSediPrecipRock.maxSubType);
	    int numBlocks = random.nextInt(25) + 5;
	    new GeologyWorldGenMinable(geology.Geology.sediPrecipRockBlockID,
		    subType, numBlocks, Block.stone.blockID).generate(world,
		    random, randPosX, randPosY, randPosZ);
	}

	/* place aggregate blocks */
	/* place gravel types */
	/* System.out.println("we are at aggregates now."); */
	for (int i = 0; i < 150; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 5 + random.nextInt(123);
	    int randPosZ = BlockZ + random.nextInt(16);
	    int subType = random.nextInt(BlockSediAggregates.maxSubType);
	    int numBlocks = 50;
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.gravel.blockID) {
		new WorldGenMinable(geology.Geology.sediAggregatesBlockID,
			subType, numBlocks, Block.gravel.blockID).generate(
			world, random, randPosX, randPosY, randPosZ);
		/*
		 * world.setBlock(randPosX, randPosY, randPosZ,
		 * geology.Geology.sediAggregatesBlockID, subType, 2);
		 */
		/*
		 * if (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY, randPosZ) && randPosY >= 0) { byte var8 = 32;
		 * 
		 * if (!BlockSediAggregates.fallInstantly &&
		 * world.checkChunksExist(randPosX - var8, randPosY - var8,
		 * randPosZ - var8, randPosX + var8, randPosY + var8, randPosZ +
		 * var8)) { if (!world.isRemote) { EntityFallingMaterial var9 =
		 * new EntityFallingMaterial(world, (double)((float)randPosX +
		 * 0.5F), (double)((float)randPosY + 0.5F),
		 * (double)((float)randPosZ + 0.5F),
		 * geology.Geology.sediAggregatesBlockID,
		 * world.getBlockMetadata(randPosX, randPosY, randPosZ));
		 * /*BlockSediAggregates.onStartFalling(var9);
		 */
		/*
		 * world.spawnEntityInWorld(var9); } } else { /** Sets the block
		 * ID and metadata at a given location. Args: X, Y, Z, new block
		 * ID, new metadata, flags. Flag 1 will cause a block update.
		 * Flag 2 will send the change to clients (you almost always
		 * want this). Flag 4 prevents the block from being re-rendered,
		 * if this is a client world. Flags can be added together.
		 */
		/*
		 * world.setBlock(randPosX, randPosY, randPosZ,
		 * geology.Geology.sediAggregatesBlockID, subType, 2);
		 * 
		 * while (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY - 1, randPosZ) && randPosY > 0) { /*--par3;par1Wo
		 */
		/*
		 * }
		 * 
		 * if (randPosY > 0) { world.setBlock(randPosX, randPosY,
		 * randPosZ, geology.Geology.sediAggregatesBlockID, subType, 2);
		 * } } }
		 */
	    }
	}

	for (int i = 0; i < 70; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 5 + random.nextInt(123);
	    int randPosZ = BlockZ + random.nextInt(16);
	    int subType = random.nextInt(BlockSediAggregates.maxSubType);
	    int numBlocks = 50;
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.gravel.blockID) {
		new WorldGenMinable(geology.Geology.sediAggregatesBlockID,
			subType, numBlocks, Block.gravel.blockID).generate(
			world, random, randPosX, randPosY, randPosZ);
		/*
		 * world.setBlock(randPosX, randPosY, randPosZ,
		 * geology.Geology.sediAggregatesBlockID, subType, 2);
		 */
		/*
		 * if (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY, randPosZ) && randPosY >= 0) { byte var8 = 32;
		 * 
		 * if (!BlockSediAggregates.fallInstantly &&
		 * world.checkChunksExist(randPosX - var8, randPosY - var8,
		 * randPosZ - var8, randPosX + var8, randPosY + var8, randPosZ +
		 * var8)) { if (!world.isRemote) { EntityFallingMaterial var9 =
		 * new EntityFallingMaterial(world, (double)((float)randPosX +
		 * 0.5F), (double)((float)randPosY + 0.5F),
		 * (double)((float)randPosZ + 0.5F),
		 * geology.Geology.sediAggregatesBlockID,
		 * world.getBlockMetadata(randPosX, randPosY, randPosZ));
		 * /*BlockSediAggregates.onStartFalling(var9);
		 */
		/*
		 * world.spawnEntityInWorld(var9); } } else { /** Sets the block
		 * ID and metadata at a given location. Args: X, Y, Z, new block
		 * ID, new metadata, flags. Flag 1 will cause a block update.
		 * Flag 2 will send the change to clients (you almost always
		 * want this). Flag 4 prevents the block from being re-rendered,
		 * if this is a client world. Flags can be added together.
		 */
		/*
		 * world.setBlock(randPosX, randPosY, randPosZ,
		 * geology.Geology.sediAggregatesBlockID, subType, 2);
		 * 
		 * while (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY - 1, randPosZ) && randPosY > 0) { /*--par3;par1Wo
		 */
		/*
		 * }
		 * 
		 * if (randPosY > 0) { world.setBlock(randPosX, randPosY,
		 * randPosZ, geology.Geology.sediAggregatesBlockID, subType, 2);
		 * } } }
		 */
	    }
	}

	for (int i = 0; i < 70; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 30 + random.nextInt(98);
	    int randPosZ = BlockZ + random.nextInt(16);
	    int subType = random.nextInt(BlockSediAggregatesB.maxSubType);
	    int numBlocks = 50;
	    new WorldGenMinable(geology.Geology.sediAggregatesBBlockID,
		    subType, numBlocks, Block.gravel.blockID).generate(world,
		    random, randPosX, randPosY, randPosZ);
	    /*
	     * if (BlockSediAggregates.canFallBelow(world, randPosX, randPosY,
	     * randPosZ) && randPosY >= 0) { byte var8 = 32;
	     * 
	     * if (!BlockSediAggregates.fallInstantly &&
	     * world.checkChunksExist(randPosX - var8, randPosY - var8, randPosZ
	     * - var8, randPosX + var8, randPosY + var8, randPosZ + var8)) { if
	     * (!world.isRemote) { EntityFallingMaterial var9 = new
	     * EntityFallingMaterial(world, (double)((float)randPosX + 0.5F),
	     * (double)((float)randPosY + 0.5F), (double)((float)randPosZ +
	     * 0.5F), geology.Geology.sediAggregatesBBlockID,
	     * world.getBlockMetadata(randPosX, randPosY, randPosZ));
	     * /*BlockSediAggregates.onStartFalling(var9);
	     */
	    /*
	     * world.spawnEntityInWorld(var9); } } else { /** Sets the block ID
	     * and metadata at a given location. Args: X, Y, Z, new block ID,
	     * new metadata, flags. Flag 1 will cause a block update. Flag 2
	     * will send the change to clients (you almost always want this).
	     * Flag 4 prevents the block from being re-rendered, if this is a
	     * client world. Flags can be added together.
	     */
	    /*
	     * world.setBlock(randPosX, randPosY, randPosZ,
	     * geology.Geology.sediAggregatesBBlockID, subType, 2);
	     * 
	     * while (BlockSediAggregates.canFallBelow(world, randPosX, randPosY
	     * - 1, randPosZ) && randPosY > 0) { /*--par3;par1Wo
	     */
	    /*
	     * }
	     * 
	     * if (randPosY > 0) { world.setBlock(randPosX, randPosY, randPosZ,
	     * geology.Geology.sediAggregatesBBlockID, subType, 2); } } }
	     */

	}

	/* place soil blocks --> do it by biome */
	/* System.out.println("we are at soils now."); */
	/* below ground */
	for (int i = 0; i < 200; i++) {
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 5 + random.nextInt(62);
	    int randPosZ = BlockZ + random.nextInt(16);
	    BiomeGenBase here = world.getBiomeGenForCoords(randPosX, randPosZ);
	    String biomeName = here.biomeName;
	    int blockID = 1;
	    int subType = 3;
	    if (biomeName == "Ocean") {
		subType = 13;
		blockID = geology.Geology.soilBlockID;
	    } else {
		subType = 10;
		blockID = geology.Geology.sediAggregatesBlockID;
	    }

	    int numBlocks = 30;
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.dirt.blockID) {
		new WorldGenMinable(blockID, subType, numBlocks,
			Block.dirt.blockID).generate(world, random, randPosX,
			randPosY, randPosZ);
		/*
		 * world.setBlock(randPosX, randPosY, randPosZ,
		 * geology.Geology.sediAggregatesBlockID, subType, 2);
		 */
		/*
		 * if (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY, randPosZ) && randPosY >= 0) { byte var8 = 32;
		 * 
		 * if (!BlockSediAggregates.fallInstantly &&
		 * world.checkChunksExist(randPosX - var8, randPosY - var8,
		 * randPosZ - var8, randPosX + var8, randPosY + var8, randPosZ +
		 * var8)) { if (!world.isRemote) { EntityFallingMaterial var9 =
		 * new EntityFallingMaterial(world, (double)((float)randPosX +
		 * 0.5F), (double)((float)randPosY + 0.5F),
		 * (double)((float)randPosZ + 0.5F),
		 * geology.Geology.soilBlockID, world.getBlockMetadata(randPosX,
		 * randPosY, randPosZ));
		 * /*BlockSediAggregates.onStartFalling(var9);
		 */
		/*
		 * world.spawnEntityInWorld(var9); } } else { /** Sets the block
		 * ID and metadata at a given location. Args: X, Y, Z, new block
		 * ID, new metadata, flags. Flag 1 will cause a block update.
		 * Flag 2 will send the change to clients (you almost always
		 * want this). Flag 4 prevents the block from being re-rendered,
		 * if this is a client world. Flags can be added together.
		 */
		/*
		 * world.setBlock(randPosX, randPosY, randPosZ,
		 * geology.Geology.soilBlockID, subType, 2);
		 * 
		 * while (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY - 1, randPosZ) && randPosY > 0) { /*--par3;par1Wo
		 */
		/*
		 * }
		 * 
		 * if (randPosY > 0) { world.setBlock(randPosX, randPosY,
		 * randPosZ, geology.Geology.soilBlockID, subType, 2); } } }
		 */

	    }
	}

	/* near the surface */

	for (int i = 0; i < 150; i++) { /* up to 900 "veins" per chunk */
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 60 + random.nextInt(68);
	    int randPosZ = BlockZ + random.nextInt(16);
	    BiomeGenBase here = world.getBiomeGenForCoords(randPosX, randPosZ);
	    String biomeName = here.biomeName;
	    /* int subType = random.nextInt(BlockSediAggregatesB.maxSubType); */

	    int subType = 3;
	    if (biomeName == "Forest") {
		subType = 0;
	    } else if (biomeName == "Forest Hills") {
		subType = 0;
	    } else if (biomeName == "Desert") {
		subType = 2;
	    } else if (biomeName == "Desert Hills") {
		subType = 2;
	    } else if (biomeName == "Extreme Hills") {
		subType = 3;
	    } else if (biomeName == "Ice Plains") {
		subType = 4;
	    } else if (biomeName == "Ice Mountains") {
		subType = 4;
	    } else if (biomeName == "Swampland") {
		subType = 5;
	    } else if (biomeName == "Extreme Hills Edge") {
		subType = 6;
	    } else if (biomeName == "Plains") {
		subType = 7;
	    } else if (biomeName == "Jungle") {
		subType = 8;
	    } else if (biomeName == "JungleHills") {
		subType = 8;
	    } else if (biomeName == "Taiga") {
		subType = 9;
	    } else if (biomeName == "TaigaHills") {
		subType = 9;
	    } else if (biomeName == "Ocean") {
		subType = 10;
	    } else if (biomeName == "Frozen Ocean") {
		subType = 10;
	    } else if (biomeName == "River") {
		subType = 11;
	    } else if (biomeName == "Frozen River") {
		subType = 11;
	    } else if (biomeName == "Beach") {
		subType = 11;
	    } else {
		subType = 0;
	    }

	    int numBlocks = 70; /* number of blocks in that vein */
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.dirt.blockID) {
		new WorldGenMinable(geology.Geology.soilBlockID, subType,
			numBlocks, Block.dirt.blockID).generate(world, random,
			randPosX, randPosY, randPosZ);
		/*
		 * if (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY, randPosZ) && randPosY >= 0) { byte var8 = 32;
		 * 
		 * if (!BlockSediAggregates.fallInstantly &&
		 * world.checkChunksExist(randPosX - var8, randPosY - var8,
		 * randPosZ - var8, randPosX + var8, randPosY + var8, randPosZ +
		 * var8)) { if (!world.isRemote) { EntityFallingMaterial var9 =
		 * new EntityFallingMaterial(world, (double)((float)randPosX +
		 * 0.5F), (double)((float)randPosY + 0.5F),
		 * (double)((float)randPosZ + 0.5F),
		 * geology.Geology.soilBlockID, world.getBlockMetadata(randPosX,
		 * randPosY, randPosZ));
		 * /*BlockSediAggregates.onStartFalling(var9);
		 */
		/*
		 * world.spawnEntityInWorld(var9); } } else { /** Sets the block
		 * ID and metadata at a given location. Args: X, Y, Z, new block
		 * ID, new metadata, flags. Flag 1 will cause a block update.
		 * Flag 2 will send the change to clients (you almost always
		 * want this). Flag 4 prevents the block from being re-rendered,
		 * if this is a client world. Flags can be added together.
		 */
		/*
		 * world.setBlock(randPosX, randPosY, randPosZ,
		 * geology.Geology.soilBlockID, subType, 2);
		 * 
		 * while (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY - 1, randPosZ) && randPosY > 0) { /*--par3;par1Wo
		 */
		/*
		 * }
		 * 
		 * if (randPosY > 0) { world.setBlock(randPosX, randPosY,
		 * randPosZ, geology.Geology.soilBlockID, subType, 2); } }
		 */
	    }
	    /*
	     * world.setBlock(randPosX, randPosY, randPosZ,
	     * geology.Geology.sediAggregatesBlockID, subType, 2);
	     */
	}

	for (int i = 0; i < 150; i++) { /* up to 500 "veins" per chunk */
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 60 + random.nextInt(68);
	    int randPosZ = BlockZ + random.nextInt(16);
	    BiomeGenBase here = world.getBiomeGenForCoords(randPosX, randPosZ);
	    String biomeName = here.biomeName;
	    /* int subType = random.nextInt(BlockSediAggregatesB.maxSubType); */

	    int subType = 3;
	    if (biomeName == "Forest") {
		subType = 0;
	    } else if (biomeName == "Forest Hills") {
		subType = 0;
	    } else if (biomeName == "Desert") {
		subType = 2;
	    } else if (biomeName == "Desert Hills") {
		subType = 2;
	    } else if (biomeName == "Extreme Hills") {
		subType = 3;
	    } else if (biomeName == "Ice Plains") {
		subType = 4;
	    } else if (biomeName == "Ice Mountains") {
		subType = 4;
	    } else if (biomeName == "Swampland") {
		subType = 5;
	    } else if (biomeName == "Extreme Hills Edge") {
		subType = 6;
	    } else if (biomeName == "Plains") {
		subType = 7;
	    } else if (biomeName == "Jungle") {
		subType = 8;
	    } else if (biomeName == "JungleHills") {
		subType = 8;
	    } else if (biomeName == "Taiga") {
		subType = 9;
	    } else if (biomeName == "TaigaHills") {
		subType = 9;
	    } else if (biomeName == "Ocean") {
		subType = 10;
	    } else if (biomeName == "Frozen Ocean") {
		subType = 10;
	    } else if (biomeName == "River") {
		subType = 11;
	    } else if (biomeName == "Frozen River") {
		subType = 11;
	    } else if (biomeName == "Beach") {
		subType = 11;
	    } else {
		subType = 0;
	    }

	    int numBlocks = 70; /* number of blocks in that vein */
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.dirt.blockID) {
		new WorldGenMinable(geology.Geology.soilBlockID, subType,
			numBlocks, Block.dirt.blockID).generate(world, random,
			randPosX, randPosY, randPosZ);
		/*
		 * if (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY, randPosZ) && randPosY >= 0) { byte var8 = 32;
		 * 
		 * if (!BlockSediAggregates.fallInstantly &&
		 * world.checkChunksExist(randPosX - var8, randPosY - var8,
		 * randPosZ - var8, randPosX + var8, randPosY + var8, randPosZ +
		 * var8)) { if (!world.isRemote) { EntityFallingMaterial var9 =
		 * new EntityFallingMaterial(world, (double)((float)randPosX +
		 * 0.5F), (double)((float)randPosY + 0.5F),
		 * (double)((float)randPosZ + 0.5F),
		 * geology.Geology.soilBlockID, world.getBlockMetadata(randPosX,
		 * randPosY, randPosZ));
		 * /*BlockSediAggregates.onStartFalling(var9);
		 */
		/*
		 * world.spawnEntityInWorld(var9); } } else { /** Sets the block
		 * ID and metadata at a given location. Args: X, Y, Z, new block
		 * ID, new metadata, flags. Flag 1 will cause a block update.
		 * Flag 2 will send the change to clients (you almost always
		 * want this). Flag 4 prevents the block from being re-rendered,
		 * if this is a client world. Flags can be added together.
		 */
		/*
		 * world.setBlock(randPosX, randPosY, randPosZ,
		 * geology.Geology.soilBlockID, subType, 2);
		 * 
		 * while (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY - 1, randPosZ) && randPosY > 0) { /*--par3;par1Wo
		 */
		/*
		 * }
		 * 
		 * if (randPosY > 0) { world.setBlock(randPosX, randPosY,
		 * randPosZ, geology.Geology.soilBlockID, subType, 2); } }
		 */
	    }
	}

	for (int i = 0; i < 150; i++) { /* up to 500 "veins" per chunk */
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 60 + random.nextInt(68);
	    int randPosZ = BlockZ + random.nextInt(16);
	    BiomeGenBase here = world.getBiomeGenForCoords(randPosX, randPosZ);
	    String biomeName = here.biomeName;
	    /* int subType = random.nextInt(BlockSediAggregatesB.maxSubType); */

	    int subType = 3;
	    if (biomeName == "Forest") {
		subType = 0;
	    } else if (biomeName == "Forest Hills") {
		subType = 0;
	    } else if (biomeName == "Desert") {
		subType = 2;
	    } else if (biomeName == "Desert Hills") {
		subType = 2;
	    } else if (biomeName == "Extreme Hills") {
		subType = 3;
	    } else if (biomeName == "Ice Plains") {
		subType = 4;
	    } else if (biomeName == "Ice Mountains") {
		subType = 4;
	    } else if (biomeName == "Swampland") {
		subType = 5;
	    } else if (biomeName == "Extreme Hills Edge") {
		subType = 6;
	    } else if (biomeName == "Plains") {
		subType = 7;
	    } else if (biomeName == "Jungle") {
		subType = 8;
	    } else if (biomeName == "JungleHills") {
		subType = 8;
	    } else if (biomeName == "Taiga") {
		subType = 9;
	    } else if (biomeName == "TaigaHills") {
		subType = 9;
	    } else if (biomeName == "Ocean") {
		subType = 10;
	    } else if (biomeName == "Frozen Ocean") {
		subType = 10;
	    } else if (biomeName == "River") {
		subType = 11;
	    } else if (biomeName == "Frozen River") {
		subType = 11;
	    } else if (biomeName == "Beach") {
		subType = 11;
	    } else {
		subType = 0;
	    }

	    int numBlocks = 70; /* number of blocks in that vein */
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.dirt.blockID) {
		new WorldGenMinable(geology.Geology.soilBlockID, subType,
			numBlocks, Block.dirt.blockID).generate(world, random,
			randPosX, randPosY, randPosZ);
		/*
		 * if (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY, randPosZ) && randPosY >= 0) { byte var8 = 32;
		 * 
		 * if (!BlockSediAggregates.fallInstantly &&
		 * world.checkChunksExist(randPosX - var8, randPosY - var8,
		 * randPosZ - var8, randPosX + var8, randPosY + var8, randPosZ +
		 * var8)) { if (!world.isRemote) { EntityFallingMaterial var9 =
		 * new EntityFallingMaterial(world, (double)((float)randPosX +
		 * 0.5F), (double)((float)randPosY + 0.5F),
		 * (double)((float)randPosZ + 0.5F),
		 * geology.Geology.soilBlockID, world.getBlockMetadata(randPosX,
		 * randPosY, randPosZ));
		 * /*BlockSediAggregates.onStartFalling(var9);
		 */
		/*
		 * world.spawnEntityInWorld(var9); } } else { /** Sets the block
		 * ID and metadata at a given location. Args: X, Y, Z, new block
		 * ID, new metadata, flags. Flag 1 will cause a block update.
		 * Flag 2 will send the change to clients (you almost always
		 * want this). Flag 4 prevents the block from being re-rendered,
		 * if this is a client world. Flags can be added together.
		 */
		/*
		 * world.setBlock(randPosX, randPosY, randPosZ,
		 * geology.Geology.soilBlockID, subType, 2);
		 * 
		 * while (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY - 1, randPosZ) && randPosY > 0) { /*--par3;par1Wo
		 */
		/*
		 * }
		 * 
		 * if (randPosY > 0) { world.setBlock(randPosX, randPosY,
		 * randPosZ, geology.Geology.soilBlockID, subType, 2); } }
		 */
	    }
	}

	for (int i = 0; i < 150; i++) { /* up to 500 "veins" per chunk */
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 60 + random.nextInt(68);
	    int randPosZ = BlockZ + random.nextInt(16);
	    BiomeGenBase here = world.getBiomeGenForCoords(randPosX, randPosZ);
	    String biomeName = here.biomeName;
	    /* int subType = random.nextInt(BlockSediAggregatesB.maxSubType); */

	    int subType = 3;
	    if (biomeName == "Forest") {
		subType = 0;
	    } else if (biomeName == "Forest Hills") {
		subType = 0;
	    } else if (biomeName == "Desert") {
		subType = 2;
	    } else if (biomeName == "Desert Hills") {
		subType = 2;
	    } else if (biomeName == "Extreme Hills") {
		subType = 3;
	    } else if (biomeName == "Ice Plains") {
		subType = 4;
	    } else if (biomeName == "Ice Mountains") {
		subType = 4;
	    } else if (biomeName == "Swampland") {
		subType = 5;
	    } else if (biomeName == "Extreme Hills Edge") {
		subType = 6;
	    } else if (biomeName == "Plains") {
		subType = 7;
	    } else if (biomeName == "Jungle") {
		subType = 8;
	    } else if (biomeName == "JungleHills") {
		subType = 8;
	    } else if (biomeName == "Taiga") {
		subType = 9;
	    } else if (biomeName == "TaigaHills") {
		subType = 9;
	    } else if (biomeName == "Ocean") {
		subType = 10;
	    } else if (biomeName == "Frozen Ocean") {
		subType = 10;
	    } else if (biomeName == "River") {
		subType = 11;
	    } else if (biomeName == "Frozen River") {
		subType = 11;
	    } else if (biomeName == "Beach") {
		subType = 11;
	    } else {
		subType = 0;
	    }

	    int numBlocks = 70; /* number of blocks in that vein */
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.dirt.blockID) {
		new WorldGenMinable(geology.Geology.soilBlockID, subType,
			numBlocks, Block.dirt.blockID).generate(world, random,
			randPosX, randPosY, randPosZ);
		/*
		 * if (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY, randPosZ) && randPosY >= 0) { byte var8 = 32;
		 * 
		 * if (!BlockSediAggregates.fallInstantly &&
		 * world.checkChunksExist(randPosX - var8, randPosY - var8,
		 * randPosZ - var8, randPosX + var8, randPosY + var8, randPosZ +
		 * var8)) { if (!world.isRemote) { EntityFallingMaterial var9 =
		 * new EntityFallingMaterial(world, (double)((float)randPosX +
		 * 0.5F), (double)((float)randPosY + 0.5F),
		 * (double)((float)randPosZ + 0.5F),
		 * geology.Geology.soilBlockID, world.getBlockMetadata(randPosX,
		 * randPosY, randPosZ));
		 * /*BlockSediAggregates.onStartFalling(var9);
		 */
		/*
		 * world.spawnEntityInWorld(var9); } } else { /** Sets the block
		 * ID and metadata at a given location. Args: X, Y, Z, new block
		 * ID, new metadata, flags. Flag 1 will cause a block update.
		 * Flag 2 will send the change to clients (you almost always
		 * want this). Flag 4 prevents the block from being re-rendered,
		 * if this is a client world. Flags can be added together.
		 */
		/*
		 * world.setBlock(randPosX, randPosY, randPosZ,
		 * geology.Geology.soilBlockID, subType, 2);
		 * 
		 * while (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY - 1, randPosZ) && randPosY > 0) { /*--par3;par1Wo
		 */
		/*
		 * }
		 * 
		 * if (randPosY > 0) { world.setBlock(randPosX, randPosY,
		 * randPosZ, geology.Geology.soilBlockID, subType, 2); } }
		 */
	    }
	}

	for (int i = 0; i < 150; i++) { /* up to 500 "veins" per chunk */
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 60 + random.nextInt(68);
	    int randPosZ = BlockZ + random.nextInt(16);
	    BiomeGenBase here = world.getBiomeGenForCoords(randPosX, randPosZ);
	    String biomeName = here.biomeName;
	    /* int subType = random.nextInt(BlockSediAggregatesB.maxSubType); */

	    int subType = 3;
	    if (biomeName == "Forest") {
		subType = 0;
	    } else if (biomeName == "Forest Hills") {
		subType = 0;
	    } else if (biomeName == "Desert") {
		subType = 2;
	    } else if (biomeName == "Desert Hills") {
		subType = 2;
	    } else if (biomeName == "Extreme Hills") {
		subType = 3;
	    } else if (biomeName == "Ice Plains") {
		subType = 4;
	    } else if (biomeName == "Ice Mountains") {
		subType = 4;
	    } else if (biomeName == "Swampland") {
		subType = 5;
	    } else if (biomeName == "Extreme Hills Edge") {
		subType = 6;
	    } else if (biomeName == "Plains") {
		subType = 7;
	    } else if (biomeName == "Jungle") {
		subType = 8;
	    } else if (biomeName == "JungleHills") {
		subType = 8;
	    } else if (biomeName == "Taiga") {
		subType = 9;
	    } else if (biomeName == "TaigaHills") {
		subType = 9;
	    } else if (biomeName == "Ocean") {
		subType = 10;
	    } else if (biomeName == "Frozen Ocean") {
		subType = 10;
	    } else if (biomeName == "River") {
		subType = 11;
	    } else if (biomeName == "Frozen River") {
		subType = 11;
	    } else if (biomeName == "Beach") {
		subType = 11;
	    } else {
		subType = 0;
	    }

	    int numBlocks = 70; /* number of blocks in that vein */
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.dirt.blockID) {
		new WorldGenMinable(geology.Geology.soilBlockID, subType,
			numBlocks, Block.dirt.blockID).generate(world, random,
			randPosX, randPosY, randPosZ);
		/*
		 * if (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY, randPosZ) && randPosY >= 0) { byte var8 = 32;
		 * 
		 * if (!BlockSediAggregates.fallInstantly &&
		 * world.checkChunksExist(randPosX - var8, randPosY - var8,
		 * randPosZ - var8, randPosX + var8, randPosY + var8, randPosZ +
		 * var8)) { if (!world.isRemote) { EntityFallingMaterial var9 =
		 * new EntityFallingMaterial(world, (double)((float)randPosX +
		 * 0.5F), (double)((float)randPosY + 0.5F),
		 * (double)((float)randPosZ + 0.5F),
		 * geology.Geology.soilBlockID, world.getBlockMetadata(randPosX,
		 * randPosY, randPosZ));
		 * /*BlockSediAggregates.onStartFalling(var9);
		 */
		/*
		 * world.spawnEntityInWorld(var9); } } else { /** Sets the block
		 * ID and metadata at a given location. Args: X, Y, Z, new block
		 * ID, new metadata, flags. Flag 1 will cause a block update.
		 * Flag 2 will send the change to clients (you almost always
		 * want this). Flag 4 prevents the block from being re-rendered,
		 * if this is a client world. Flags can be added together.
		 */
		/*
		 * world.setBlock(randPosX, randPosY, randPosZ,
		 * geology.Geology.soilBlockID, subType, 2);
		 * 
		 * while (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY - 1, randPosZ) && randPosY > 0) { /*--par3;par1Wo
		 */
		/*
		 * }
		 * 
		 * if (randPosY > 0) { world.setBlock(randPosX, randPosY,
		 * randPosZ, geology.Geology.soilBlockID, subType, 2); } }
		 */
	    }
	    /*
	     * world.setBlock(randPosX, randPosY, randPosZ,
	     * geology.Geology.sediAggregatesBlockID, subType, 2);
	     */
	}

	for (int i = 0; i < 150; i++) { /* up to 500 "veins" per chunk */
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 60 + random.nextInt(68);
	    int randPosZ = BlockZ + random.nextInt(16);
	    BiomeGenBase here = world.getBiomeGenForCoords(randPosX, randPosZ);
	    String biomeName = here.biomeName;
	    /* int subType = random.nextInt(BlockSediAggregatesB.maxSubType); */

	    int subType = 3;
	    if (biomeName == "Forest") {
		subType = 0;
	    } else if (biomeName == "Forest Hills") {
		subType = 0;
	    } else if (biomeName == "Desert") {
		subType = 2;
	    } else if (biomeName == "Desert Hills") {
		subType = 2;
	    } else if (biomeName == "Extreme Hills") {
		subType = 3;
	    } else if (biomeName == "Ice Plains") {
		subType = 4;
	    } else if (biomeName == "Ice Mountains") {
		subType = 4;
	    } else if (biomeName == "Swampland") {
		subType = 5;
	    } else if (biomeName == "Extreme Hills Edge") {
		subType = 6;
	    } else if (biomeName == "Plains") {
		subType = 7;
	    } else if (biomeName == "Jungle") {
		subType = 8;
	    } else if (biomeName == "JungleHills") {
		subType = 8;
	    } else if (biomeName == "Taiga") {
		subType = 9;
	    } else if (biomeName == "TaigaHills") {
		subType = 9;
	    } else if (biomeName == "Ocean") {
		subType = 10;
	    } else if (biomeName == "Frozen Ocean") {
		subType = 10;
	    } else if (biomeName == "River") {
		subType = 11;
	    } else if (biomeName == "Frozen River") {
		subType = 11;
	    } else if (biomeName == "Beach") {
		subType = 11;
	    } else {
		subType = 0;
	    }

	    int numBlocks = 70; /* number of blocks in that vein */
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.dirt.blockID) {
		new WorldGenMinable(geology.Geology.soilBlockID, subType,
			numBlocks, Block.dirt.blockID).generate(world, random,
			randPosX, randPosY, randPosZ);
		/*
		 * if (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY, randPosZ) && randPosY >= 0) { byte var8 = 32;
		 * 
		 * if (!BlockSediAggregates.fallInstantly &&
		 * world.checkChunksExist(randPosX - var8, randPosY - var8,
		 * randPosZ - var8, randPosX + var8, randPosY + var8, randPosZ +
		 * var8)) { if (!world.isRemote) { EntityFallingMaterial var9 =
		 * new EntityFallingMaterial(world, (double)((float)randPosX +
		 * 0.5F), (double)((float)randPosY + 0.5F),
		 * (double)((float)randPosZ + 0.5F),
		 * geology.Geology.soilBlockID, world.getBlockMetadata(randPosX,
		 * randPosY, randPosZ));
		 * /*BlockSediAggregates.onStartFalling(var9);
		 */
		/*
		 * world.spawnEntityInWorld(var9); } } else { /** Sets the block
		 * ID and metadata at a given location. Args: X, Y, Z, new block
		 * ID, new metadata, flags. Flag 1 will cause a block update.
		 * Flag 2 will send the change to clients (you almost always
		 * want this). Flag 4 prevents the block from being re-rendered,
		 * if this is a client world. Flags can be added together.
		 */
		/*
		 * world.setBlock(randPosX, randPosY, randPosZ,
		 * geology.Geology.soilBlockID, subType, 2);
		 * 
		 * while (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY - 1, randPosZ) && randPosY > 0) { /*--par3;par1Wo
		 */
		/*
		 * }
		 * 
		 * if (randPosY > 0) { world.setBlock(randPosX, randPosY,
		 * randPosZ, geology.Geology.soilBlockID, subType, 2); } }
		 */
	    }
	    /*
	     * world.setBlock(randPosX, randPosY, randPosZ,
	     * geology.Geology.sediAggregatesBlockID, subType, 2);
	     */
	}

	for (int i = 0; i < 70; i++) { /* up to 500 "veins" per chunk */
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 60 + random.nextInt(68);
	    int randPosZ = BlockZ + random.nextInt(16);
	    BiomeGenBase here = world.getBiomeGenForCoords(randPosX, randPosZ);
	    String biomeName = here.biomeName;
	    /* int subType = random.nextInt(BlockSediAggregatesB.maxSubType); */

	    int subType = 3;
	    if (biomeName == "Forest") {
		subType = 0;
	    } else if (biomeName == "Forest Hills") {
		subType = 0;
	    } else if (biomeName == "Desert") {
		subType = 2;
	    } else if (biomeName == "Desert Hills") {
		subType = 2;
	    } else if (biomeName == "Extreme Hills") {
		subType = 3;
	    } else if (biomeName == "Ice Plains") {
		subType = 4;
	    } else if (biomeName == "Ice Mountains") {
		subType = 4;
	    } else if (biomeName == "Swampland") {
		subType = 5;
	    } else if (biomeName == "Extreme Hills Edge") {
		subType = 6;
	    } else if (biomeName == "Plains") {
		subType = 7;
	    } else if (biomeName == "Jungle") {
		subType = 8;
	    } else if (biomeName == "JungleHills") {
		subType = 8;
	    } else if (biomeName == "Taiga") {
		subType = 9;
	    } else if (biomeName == "TaigaHills") {
		subType = 9;
	    } else if (biomeName == "Ocean") {
		subType = 10;
	    } else if (biomeName == "Frozen Ocean") {
		subType = 10;
	    } else if (biomeName == "River") {
		subType = 11;
	    } else if (biomeName == "Frozen River") {
		subType = 11;
	    } else if (biomeName == "Beach") {
		subType = 11;
	    } else {
		subType = 0;
	    }

	    int numBlocks = 70; /* number of blocks in that vein */
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.dirt.blockID) {
		new WorldGenMinable(geology.Geology.soilBlockID, subType,
			numBlocks, Block.dirt.blockID).generate(world, random,
			randPosX, randPosY, randPosZ);
		/*
		 * if (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY, randPosZ) && randPosY >= 0) { byte var8 = 32;
		 * 
		 * if (!BlockSediAggregates.fallInstantly &&
		 * world.checkChunksExist(randPosX - var8, randPosY - var8,
		 * randPosZ - var8, randPosX + var8, randPosY + var8, randPosZ +
		 * var8)) { if (!world.isRemote) { EntityFallingMaterial var9 =
		 * new EntityFallingMaterial(world, (double)((float)randPosX +
		 * 0.5F), (double)((float)randPosY + 0.5F),
		 * (double)((float)randPosZ + 0.5F),
		 * geology.Geology.soilBlockID, world.getBlockMetadata(randPosX,
		 * randPosY, randPosZ));
		 * /*BlockSediAggregates.onStartFalling(var9);
		 */
		/*
		 * world.spawnEntityInWorld(var9); } } else { /** Sets the block
		 * ID and metadata at a given location. Args: X, Y, Z, new block
		 * ID, new metadata, flags. Flag 1 will cause a block update.
		 * Flag 2 will send the change to clients (you almost always
		 * want this). Flag 4 prevents the block from being re-rendered,
		 * if this is a client world. Flags can be added together.
		 */
		/*
		 * world.setBlock(randPosX, randPosY, randPosZ,
		 * geology.Geology.soilBlockID, subType, 2);
		 * 
		 * while (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY - 1, randPosZ) && randPosY > 0) { /*--par3;par1Wo
		 */
		/*
		 * }
		 * 
		 * if (randPosY > 0) { world.setBlock(randPosX, randPosY,
		 * randPosZ, geology.Geology.soilBlockID, subType, 2); } }
		 */
	    }
	}

	for (int i = 0; i < 70; i++) { /* up to 500 "veins" per chunk */
	    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 60 + random.nextInt(68);
	    int randPosZ = BlockZ + random.nextInt(16);
	    BiomeGenBase here = world.getBiomeGenForCoords(randPosX, randPosZ);
	    String biomeName = here.biomeName;
	    /* int subType = random.nextInt(BlockSediAggregatesB.maxSubType); */

	    int subType = 3;
	    if (biomeName == "Forest") {
		subType = 0;
	    } else if (biomeName == "Forest Hills") {
		subType = 0;
	    } else if (biomeName == "Desert") {
		subType = 2;
	    } else if (biomeName == "Desert Hills") {
		subType = 2;
	    } else if (biomeName == "Extreme Hills") {
		subType = 3;
	    } else if (biomeName == "Ice Plains") {
		subType = 4;
	    } else if (biomeName == "Ice Mountains") {
		subType = 4;
	    } else if (biomeName == "Swampland") {
		subType = 5;
	    } else if (biomeName == "Extreme Hills Edge") {
		subType = 6;
	    } else if (biomeName == "Plains") {
		subType = 7;
	    } else if (biomeName == "Jungle") {
		subType = 8;
	    } else if (biomeName == "JungleHills") {
		subType = 8;
	    } else if (biomeName == "Taiga") {
		subType = 9;
	    } else if (biomeName == "TaigaHills") {
		subType = 9;
	    } else if (biomeName == "Ocean") {
		subType = 10;
	    } else if (biomeName == "Frozen Ocean") {
		subType = 10;
	    } else if (biomeName == "River") {
		subType = 11;
	    } else if (biomeName == "Frozen River") {
		subType = 11;
	    } else if (biomeName == "Beach") {
		subType = 11;
	    } else {
		subType = 0;
	    }

	    int numBlocks = 30; /* number of blocks in that vein */
	    if (world.getBlockId(randPosX, randPosY, randPosZ) == Block.dirt.blockID) {
		new WorldGenMinable(geology.Geology.soilBlockID, subType,
			numBlocks, Block.dirt.blockID).generate(world, random,
			randPosX, randPosY, randPosZ);
		/*
		 * if (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY, randPosZ) && randPosY >= 0) { byte var8 = 32;
		 * 
		 * if (!BlockSediAggregates.fallInstantly &&
		 * world.checkChunksExist(randPosX - var8, randPosY - var8,
		 * randPosZ - var8, randPosX + var8, randPosY + var8, randPosZ +
		 * var8)) { if (!world.isRemote) { EntityFallingMaterial var9 =
		 * new EntityFallingMaterial(world, (double)((float)randPosX +
		 * 0.5F), (double)((float)randPosY + 0.5F),
		 * (double)((float)randPosZ + 0.5F),
		 * geology.Geology.soilBlockID, world.getBlockMetadata(randPosX,
		 * randPosY, randPosZ));
		 * /*BlockSediAggregates.onStartFalling(var9);
		 */
		/*
		 * world.spawnEntityInWorld(var9); } } else { /** Sets the block
		 * ID and metadata at a given location. Args: X, Y, Z, new block
		 * ID, new metadata, flags. Flag 1 will cause a block update.
		 * Flag 2 will send the change to clients (you almost always
		 * want this). Flag 4 prevents the block from being re-rendered,
		 * if this is a client world. Flags can be added together.
		 */
		/*
		 * world.setBlock(randPosX, randPosY, randPosZ,
		 * geology.Geology.soilBlockID, subType, 2);
		 * 
		 * while (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY - 1, randPosZ) && randPosY > 0) { /*--par3;par1Wo
		 */
		/*
		 * }
		 * 
		 * if (randPosY > 0) { world.setBlock(randPosX, randPosY,
		 * randPosZ, geology.Geology.soilBlockID, subType, 2); } }
		 */
	    }

	}

	/* replace top turf blocks */
/*	for (int x = 0; x < 16; x++) {
	    for (int z = 0; z < 16; z++) {
		BiomeGenBase here = world.getBiomeGenForCoords(x, z);
		String biomeName = here.biomeName;
		if (biomeName == "Desert" || biomeName == "Desert Hills" || biomeName == "Beach") {
			int y = 128;
			int topY = 0;
			while (topY == 0) {
			    if (world.getBlockMaterial(x, y, z)== Material.sand)
				{ topY = y;}
			    else {y = y-1;}
				System.out.println(biomeName + " sand y = " + y);

			}
			int subType = 2;
			System.out.println(biomeName + " sand topY = " + topY);
			world.setBlock(x, topY, z, geology.Geology.soilGrassBlockID, subType, 0);
		}
		else if (biomeName != "Ocean" && biomeName != "Frozen Ocean" && biomeName != "River" && biomeName != "Frozen River") {
			int subType = 0;
			int y = 128;
			int topY = 0;
			while (topY == 0) {
			    if (world.getBlockMaterial(x, y, z)== Material.grass)
				{ topY = y;}
			    else {y = y-1;}
			}
			if (biomeName == "Forest") {subType = 0;} 
			else if (biomeName == "Forest Hills") {subType = 0;}
			else if (biomeName == "Extreme Hills") {subType = 3;} 
			else if (biomeName == "Ice Plains") {subType = 4;} 
			else if (biomeName == "Ice Mountains") {subType = 4;} 
			else if (biomeName == "Swampland") {subType = 5;} 
			else if (biomeName == "Extreme Hills Edge") {subType = 6;} 
			else if (biomeName == "Plains") {	subType = 7; } 
			else if (biomeName == "Jungle") {subType = 8;} 
			else if (biomeName == "JungleHills") {subType = 8;} 
			else if (biomeName == "Taiga") {subType = 9;} 
			else if (biomeName == "TaigaHills") {subType = 9;} 
			else {subType = 0;}
			world.setBlock(x, topY, z, geology.Geology.soilGrassBlockID, subType, 0);
			    /*int numBlocks = 30; /* number of blocks in that vein */
			    /*if (world.getBlockId(x, y, z) == Block.grass.blockID) {new WorldGenMinable(geology.Geology.soilGrassBlockID, subType,numBlocks, Block.grass.blockID).generate(world, random,x, y, z);	*/
/*		    } /*  if biome is not ocean etc. */

	/*    }  /* z */
/*	}  /* x */

	
	/*for (int i = 0; i < 100; i++) { /* up to 500 "veins" per chunk */
	/*    int randPosX = BlockX + random.nextInt(16);
	    int randPosY = 50 + random.nextInt(70);
	    int randPosZ = BlockZ + random.nextInt(16);
	    
		/*
		 * if (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY, randPosZ) && randPosY >= 0) { byte var8 = 32;
		 * 
		 * if (!BlockSediAggregates.fallInstantly &&
		 * world.checkChunksExist(randPosX - var8, randPosY - var8,
		 * randPosZ - var8, randPosX + var8, randPosY + var8, randPosZ +
		 * var8)) { if (!world.isRemote) { EntityFallingMaterial var9 =
		 * new EntityFallingMaterial(world, (double)((float)randPosX +
		 * 0.5F), (double)((float)randPosY + 0.5F),
		 * (double)((float)randPosZ + 0.5F),
		 * geology.Geology.soilBlockID, world.getBlockMetadata(randPosX,
		 * randPosY, randPosZ));
		 * /*BlockSediAggregates.onStartFalling(var9);
		 */
		/*
		 * world.spawnEntityInWorld(var9); } } else { /** Sets the block
		 * ID and metadata at a given location. Args: X, Y, Z, new block
		 * ID, new metadata, flags. Flag 1 will cause a block update.
		 * Flag 2 will send the change to clients (you almost always
		 * want this). Flag 4 prevents the block from being re-rendered,
		 * if this is a client world. Flags can be added together.
		 */
		/*
		 * world.setBlock(randPosX, randPosY, randPosZ,
		 * geology.Geology.soilBlockID, subType, 2);
		 * 
		 * while (BlockSediAggregates.canFallBelow(world, randPosX,
		 * randPosY - 1, randPosZ) && randPosY > 0) { /*--par3;par1Wo
		 */
		/*
		 * }
		 * 
		 * if (randPosY > 0) { world.setBlock(randPosX, randPosY,
		 * randPosZ, geology.Geology.soilBlockID, subType, 2); } }
		 */
	/*    } */

    }

    private void generateNether(World world, Random random, int BlockX,
	    int BlockZ) {
	/*
	 * int Xcoord = BlockX + random.nextInt(16); int Zcoord = BlockZ +
	 * random.nextInt(16); int Ycoord = 10 + random.nextInt(16);
	 * 
	 * (new WorldGenMinable(geology.aluminium.blockId, 10)) .generate(world,
	 * random, Xcoord, Ycoord, Zcoord);
	 */
    }

    private void generateEnd(World world, Random random, int i, int j) {
    }

}
