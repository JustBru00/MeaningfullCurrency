package com.gmail.justbru00.meaningfull.currency.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.gmail.justbru00.meaningfull.currency.main.Main;

public class ItemWorth {

	public static void initialize(Main main) {
		main2 = main;
		return;
	}
	
	private static Main main2;
	
	public static final int IRON_INGOT = main2.config.getInt("values.iron_ingot");
	public static final int GOLD_INGOT = main2.config.getInt("values.gold_ingot");
	public static final int DIAMOND = main2.config.getInt("values.diamond");	
	
	
	public static int calc(ItemStack is) {
		
		Material temp = is.getType();
		int value = 0;
		int i = 1;
		
		if (temp == Material.AIR) return value; // If AIR no value
		
		if (temp == Material.IRON_INGOT) {
			while(is.getAmount() >= i) {
				value = value + ItemWorth.IRON_INGOT;
				i++;
			} 
			return value;
		} else if (temp == Material.GOLD_INGOT) {
			while(is.getAmount() >= i) {
				value = value + ItemWorth.GOLD_INGOT;
				i++;
			}
			return value;
		} else if (temp == Material.DIAMOND) {
			while(is.getAmount() >= i) {
				value = value + ItemWorth.DIAMOND;
				i++;
			}
			return value;
		} else if (temp == Material.IRON_BLOCK) {
			while(is.getAmount() >= i) {
				value = value + (ItemWorth.IRON_INGOT * 9);
				i++;
			}
			return value;
		} else if (temp == Material.GOLD_BLOCK) {
			while(is.getAmount() >= i) {
				value = value + (ItemWorth.GOLD_INGOT * 9);
				i++;
			}
			return value;
		} else if (temp == Material.DIAMOND_BLOCK) {
			while(is.getAmount() >= i) {
				value = value + (ItemWorth.DIAMOND * 9);
				i++;
			}
			return value;
		}
		
		return value;
	}
	
}
