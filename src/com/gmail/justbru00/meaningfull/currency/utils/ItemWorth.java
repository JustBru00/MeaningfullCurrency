/**
The MIT License (MIT)

Copyright (c) 2016 Justin "JustBru00" Brubaker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
**/ 
package com.gmail.justbru00.meaningfull.currency.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.gmail.justbru00.meaningfull.currency.main.Main;

public class ItemWorth {

	public static void initialize(Main main) {
		main2 = main;
		IRON_INGOT = main2.getConfig().getInt("values.iron_ingot");
		GOLD_INGOT = main2.getConfig().getInt("values.gold_ingot");
		DIAMOND = main2.getConfig().getInt("values.diamond");
		return;
	}
	
	private static Main main2;
	
	public static int IRON_INGOT;
	public static int GOLD_INGOT;
	public static int DIAMOND;	
	
	
	public static int calc(ItemStack is) {
		
		Debug.send("Starting Calulation. Item is:" + is.getType().toString());
		
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
		} else {
			
		Debug.send("Value is calculated at nothing.");
		
		return value;
		}
	}
	
}
