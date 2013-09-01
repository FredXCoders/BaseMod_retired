package com.fredxcoders.dojo.mod.blocks;

import com.fredxcoders.dojo.mod.BaseMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class MyBlock extends Block {

	public MyBlock(int id, Material material) {
		super(id, material);
		// TODO Auto-generated constructor stub
	}

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(BaseMod.MODID+":test");
    }
	
}
