package com.fredxcoders.dojo.mod.helper;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

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
		
		String row1 = ((input[0][0] != null) ? "a" : " ") + ((input[0][1] != null) ? "b" : " ") + ((input[0][2] != null) ? "c" : " ");
		String row2 = ((input[1][0] != null) ? "d" : " ") + ((input[1][1] != null) ? "e" : " ") + ((input[1][2] != null) ? "f" : " ");
		String row3 = ((input[2][0] != null) ? "g" : " ") + ((input[2][1] != null) ? "h" : " ") + ((input[2][2] != null) ? "i" : " ");
		
		System.out.println("Null size: " + nullCount);
		int recipeSize = 3 + (2 * (9 - nullCount));
		
		System.out.println("Recipe size: " + recipeSize);
		Object[] recipe = new Object[recipeSize];
		char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
		
		System.out.println("row1: " + row1);
		System.out.println("row2: " + row2);
		System.out.println("row3: " + row3);
		
		//Does this: new Object[] { "DDD", "DDD", "DDD",
		recipe[0] = row1;
		recipe[1] = row2;
		recipe[2] = row3;
		
		int letterCount = 0;
		int itemCount = 0;
		for(int x=0; x<3; x++){
			for(int y=0; y<3; y++){
				if(input[x][y] != null){
					int loc = 2*(itemCount+1)+3;	
					System.out.println("Found an item for location: " + loc);
					//does this: 'D', Block.dirt})
					recipe[(2*itemCount)+3] = letters[letterCount];
					recipe[(2*itemCount)+4] = input[x][y];
					itemCount++;
				}
				letterCount++;
			}
		}
		GameRegistry.addRecipe(output, recipe);
	}
	
	/**
	 * Gets an empty 3x3 ItemStack array to be used for recipes
	 * @return
	 */
	public static ItemStack[][] getBlankRecipe(){
		ItemStack[][] recipe = new ItemStack[3][3];
		return recipe;
	}
	
}
