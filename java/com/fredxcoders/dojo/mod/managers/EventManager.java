package com.fredxcoders.dojo.mod.managers;

import java.util.Random;

import com.fredxcoders.dojo.mod.BaseMod;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class EventManager implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		//world.provider.dimensionId -1 is nether, 0 is overworld, 1 is end
		if(world.provider.dimensionId == 0){
			generateOverworld(world, random,chunkX*16, chunkZ*16);
		}
		
	}

	private void generateOverworld(World world, Random random, int x, int z) {
		int maxX = 16; //minX is one, so setting this to 16 says all of the x ranges can be used 
		int maxZ = 16; //minY is one, so setting this to 16 says all of the y ranges can be used
		int maxVeinSize = 2 + random.nextInt(5); 	//this means each patch of our blocks will be between 4 and 8 large 
		int chancesToSpawn = 2;	//How many times our ore can spawn in one chunk 
		int minY = 15; //how low the ore can spawn
		int maxY = 160;	//how high the ore can spawn
		this.addOreSpawn(BaseMod.MY_BLOCK, world, random, x, z, maxX, maxZ, maxVeinSize, chancesToSpawn, minY, maxY);
		this.addOreSpawn(BaseMod.YOUR_BLOCK, world, random, x, z, maxX, maxZ, maxVeinSize, chancesToSpawn, minY, maxY);
		this.addOreSpawn(BaseMod.ANOTHER_BLOCK, world, random, x, z, maxX, maxZ, maxVeinSize, chancesToSpawn, minY, maxY);	
	}


	/**
	 * Adds an Ore Spawn to Minecraft. Simply register all Ores to spawn with this method in your Generation method in your IWorldGeneration extending Class
	 *
	 * @param The Block to spawn
	 * @param The World to spawn in
	 * @param A Random object for retrieving random positions within the world to spawn the Block
	 * @param An int for passing the X-Coordinate for the Generation method
	 * @param An int for passing the Z-Coordinate for the Generation method
	 * @param An int for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
	 * @param An int for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
	 * @param An int for setting the maximum size of a vein
	 * @param An int for the Number of chances available for the Block to spawn per-chunk
	 * @param An int for the minimum Y-Coordinate height at which this block may spawn
	 * @param An int for the maximum Y-Coordinate height at which this block may spawn
	 **/
	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
	       int maxPossY = minY + (maxY - 1);
	       assert maxY > minY: "The maximum Y must be greater than the Minimum Y";
	       assert maxX > 0 && maxX <= 16: "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
	       assert minY > 0: "addOreSpawn: The Minimum Y must be greater than 0";
	       assert maxY < 256 && maxY > 0: "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
	       assert maxZ > 0 && maxZ <= 16: "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
	      
	       int diffBtwnMinMaxY = maxY - minY;
	       for(int x = 0; x < chancesToSpawn; x++)
	       {
	             int posX = blockXPos + random.nextInt(maxX);
	             int posY = minY + random.nextInt(diffBtwnMinMaxY);
	             int posZ = blockZPos + random.nextInt(maxZ);
	             (new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
	             System.out.println("We just spawned a MY_BLOCK! Group [" + x + "]");
	       }
	}
}
