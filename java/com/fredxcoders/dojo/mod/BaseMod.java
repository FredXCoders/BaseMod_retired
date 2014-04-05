package com.fredxcoders.dojo.mod;


import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.fredxcoders.dojo.mod.blocks.AnotherBlock;
import com.fredxcoders.dojo.mod.blocks.MyBlock;
import com.fredxcoders.dojo.mod.blocks.YourBlock;
import com.fredxcoders.dojo.mod.helper.RecipeHelper;
import com.fredxcoders.dojo.mod.helper.RegistryHelper;
import com.fredxcoders.dojo.mod.managers.EventManager;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * This is the class to use to define everything about our mod
 * @author elliott
 *
 */
@Mod(modid="dojo_basemod", name="Base Mod", version="0.1")
public class BaseMod {
	
	public static final String MODID = "dojo_basemod";
	
	EventManager eventManager = new EventManager();

	@Instance(MODID)
	public static BaseMod instance;
	
	public final static Block MY_BLOCK = new MyBlock();
	public final static Block YOUR_BLOCK = new YourBlock();
	public final static Block ANOTHER_BLOCK = new AnotherBlock();

	@EventHandler
	public void load(FMLInitializationEvent event){
		
		RegistryHelper.registerBlock(MY_BLOCK);
		RegistryHelper.registerBlock(YOUR_BLOCK);
		RegistryHelper.registerBlock(ANOTHER_BLOCK);
        		
		ItemStack[][] recipe = RecipeHelper.getBlankRecipe();
		recipe[0][0] = new ItemStack(Blocks.dirt);
		RecipeHelper.addRecipe(new ItemStack(MY_BLOCK,10), recipe);	//dirt makes myBlock!
		
		ItemStack[][] recipe2 = RecipeHelper.getBlankRecipe();
		recipe2[0][0] = new ItemStack(Blocks.dirt);
		recipe2[0][1] = new ItemStack(Blocks.dirt);
		RecipeHelper.addRecipe(new ItemStack(YOUR_BLOCK), recipe2);	//dirt makes myBlock!
		
		ItemStack[][] recipe3 = RecipeHelper.getBlankRecipe();
		recipe3[0][0] = new ItemStack(Blocks.dirt);
		recipe3[1][0] = new ItemStack(Blocks.dirt);
		RecipeHelper.addRecipe(new ItemStack(ANOTHER_BLOCK), recipe3);	//dirt makes myBlock!
		
		GameRegistry.registerWorldGenerator(eventManager, 0);
	}
}
