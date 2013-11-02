package com.fredxcoders.dojo.mod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.fredxcoders.dojo.mod.BaseMod;

public class MyBlock extends Block {

	public MyBlock(int id, Material material) {
		super(id, material);
		// TODO Auto-generated constructor stub
	}

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(BaseMod.MODID+":test");
    }

    /**
     * This method determines what is dropped when the block is broken
     */
    @Override
    public int idDropped(int par1, Random random, int zero) {
    	if(random.nextBoolean()){	//get a random boolean (flip a coin)
    		return Item.appleRed.itemID; 
    	} else {
    		return this.blockID;
    	}
    }
    
    /**
     * This method determines how many of an item will drop when the block is broken
     */
    @Override
    public int quantityDropped(Random random)
    {
    	if(random.nextBoolean()){	//Flip a coin....
    		return 1;
    	} else {
    		return 2;
    	}
    }
    
    /**
     * This method determines what will happen if you right click the block while it's placed.
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int par6, float par7, float par8, float par9) {
    	
    	//First we check to make sure the player doesn't have any items equipped so we know they're not trying to place a block
    	if(entityplayer.getCurrentEquippedItem() == null){	
	    	if(entityplayer.isSneaking()){	//Do something different if a player is sneaking
	    		if(world.isRaining()){
	    			world.getWorldInfo().setRaining(false);
	    		} else {
	    			world.getWorldInfo().setRaining(true);
	    		}
	    	} else {	//We do this if the player isn't sneaking
	    		if(world.isDaytime()){
	    			world.getWorldInfo().setWorldTime(18000);
	    		} else {
	    			world.getWorldInfo().setWorldTime(6000);
	    		}
	    	}
	    	return true;
    	} else {
    		return false;
    	}
    }
    
}
