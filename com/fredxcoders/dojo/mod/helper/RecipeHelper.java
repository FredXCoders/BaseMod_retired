package com.fredxcoders.dojo.mod.helper;

import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;

/**
 * A class to help create recipes easily
 * @author elliott
 *
 */
public class RecipeHelper {

	/**
	 * Method to add a recipe in a less abstract way
	 * @param output the itemstack to output
	 * @param input a 3x3 itemstack array
	 */
	public static void addRecipe(ItemStack output, ItemStack[][] input){
		//recipes can be done like this:
		//ModLoader.addRecipe(new ItemStack(Item.diamond, 2), new Object[] { "DDD", "DDD", "DDD", 'D', Block.dirt});
		int nullCount = 0;
		
		for(int x=0; x<3; x++){
			for(int y=0; y<3; y++){
				if(input[x][y] == null){
					nullCount++;
				}
			}
		}
		
		String row1 = ((input[0][0] != null) ? "a" : " ") + ((input[0][1] != null) ? "a" : " ") + ((input[0][2] != null) ? "c" : " ");
		String row2 = ((input[1][0] != null) ? "d" : " ") + ((input[1][1] != null) ? "e" : " ") + ((input[1][2] != null) ? "f" : " ");
		String row3 = ((input[2][0] != null) ? "g" : " ") + ((input[2][1] != null) ? "h" : " ") + ((input[2][2] != null) ? "i" : " ");
		
		Object[] out = new Object[2 + 18 - (2 * nullCount)];
		char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
		
		//Does this: new Object[] { "DDD", "DDD", "DDD",
		out[0] = row1;
		out[1] = row2;
		out[2] = row3;
		
		int letterCount = 0;
		for(int x=0; x<3; x++){
			for(int y=0; y<3; y++){
				if(input[x][y] == null){
					//does this: 'D', Block.dirt})
					out[2*letterCount +3] = letters[letterCount];
					out[2*letterCount+4] = input[x][y];
				}
				letterCount++;
			}
		}
		ModLoader.addRecipe(output, out);
	}
	
}
