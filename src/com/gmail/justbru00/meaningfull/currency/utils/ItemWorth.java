package com.gmail.justbru00.meaningfull.currency.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.gmail.justbru00.meaningfull.currency.main.Main;

public class ItemWorth {

	public static void initialize(Main main) {
		main2 = main;
		return;
	}
	
	@SuppressWarnings("unused")
	private static Main main2;
	
	public static int IRON_INGOT = 100;
	public static int GOLD_INGOT = 1000;
	public static int DIAMOND = 10000;	
	
	
	public static int calc(ItemStack is) {
		
		
		int value = 0;
		int i = 1;
		
		if (is.getType() == Material.AIR) return value; // If AIR no value
		
		if (is.getType() == Material.IRON_INGOT) {
			while(is.getAmount() >= i) {
				value = value + ItemWorth.IRON_INGOT;
				i++;
			} 
			return value;
		} else if (is.getType() == Material.GOLD_INGOT) {
			while(is.getAmount() >= i) {
				value = value + ItemWorth.GOLD_INGOT;
				i++;
			}
			return value;
		} else if (is.getType() == Material.DIAMOND) {
			while(is.getAmount() >= i) {
				value = value + ItemWorth.DIAMOND;
				i++;
			}
			return value;
		} else if (is.getType() == Material.IRON_BLOCK) {
			while(is.getAmount() >= i) {
				value = value + (ItemWorth.IRON_INGOT * 9);
				i++;
			}
			return value;
		} else if (is.getType() == Material.GOLD_BLOCK) {
			while(is.getAmount() >= i) {
				value = value + (ItemWorth.GOLD_INGOT * 9);
				i++;
			}
			return value;
		} else if (is.getType() == Material.DIAMOND_BLOCK) {
			while(is.getAmount() >= i) {
				value = value + (ItemWorth.DIAMOND * 9);
				i++;
			}
			return value;
		}
		
		return value;
	}
	
}
