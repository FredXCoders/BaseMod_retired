package com.fredxcoders.dojo.mod;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

import com.fredxcoders.dojo.mod.blocks.MyBlock;
import com.fredxcoders.dojo.mod.helper.RecipeHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="dojo_basemod", name="Base Mod", version="0.1")
@NetworkMod(clientSideRequired=true,serverSideRequired=true)
public class BaseMod {
	
	public static final String MODID = "dojo_basemod";

	@Instance(MODID)
	public static BaseMod instance;
	
	public final static Block myBlock = new MyBlock(500, Material.ground)
				.setHardness(0.5F).setStepSound(Block.soundMetalFootstep)
			    .setUnlocalizedName("myBlock").setCreativeTab(CreativeTabs.tabBlock)
			    .setLightValue(0.0F)
			    .setLightOpacity(0);

	@EventHandler
	public void load(FMLInitializationEvent event){
		
		LanguageRegistry.addName(myBlock, "My Block");
        MinecraftForge.setBlockHarvestLevel(myBlock, "shovel", 0);
        GameRegistry.registerBlock(myBlock, "myBlock");
		
		ItemStack[][] recipe = RecipeHelper.getBlankRecipe();
		recipe[0][0] = new ItemStack(Block.dirt);
		RecipeHelper.addRecipe(new ItemStack(myBlock), recipe);	//dirt makes myBlock!
		
//		proxy.registerRenderers();	
	}
}
