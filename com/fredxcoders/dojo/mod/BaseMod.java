package com.fredxcoders.dojo.mod;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="dojo_BaseMod", name="Base Mod", version="0.1")
@NetworkMod(clientSideRequired=true,serverSideRequired=true)

public class BaseMod {

	@Instance("dojo_OfficeMod")
	public static BaseMod instance;

	@Init
	public void load(FMLInitializationEvent event){

	}
}
