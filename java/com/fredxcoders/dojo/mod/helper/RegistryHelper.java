package com.fredxcoders.dojo.mod.helper;

import net.minecraft.block.Block;

import com.fredxcoders.dojo.mod.BaseMod;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Helper class for registering entities to the game
 * @author elliott
 *
 */
public class RegistryHelper {

	/**
	 * Registers a block in minecraft
	 * @param block
	 */
	public static void registerBlock(Block block){
		GameRegistry.registerBlock(block, BaseMod.MODID + "_" + block.getUnlocalizedName().substring(5));
	}
}
