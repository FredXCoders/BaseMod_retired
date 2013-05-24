package com.fredxcoders.dojo.mod;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.fredxcoders.dojo.mod.helper.RecipeHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="dojo_BaseMod", name="Base Mod", version="0.1")
@NetworkMod(clientSideRequired=true,serverSideRequired=true)
public class BaseMod {

	@Instance("dojo_BaseMod")
	public static BaseMod instance;

	@Init
	public void load(FMLInitializationEvent event){
		ItemStack[][] recipe = RecipeHelper.getBlankRecipe();
		recipe[0][0] = new ItemStack(Block.dirt);
		RecipeHelper.addRecipe(new ItemStack(Block.dirt), recipe);	//dirt makes dirt!
	}
}
