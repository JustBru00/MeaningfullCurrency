/**
 * @pluginname EpicEnchants
 * @author Justin Brubaker
 * Copyright (C) 2016 Justin Brubaker
 */
package com.gmail.justbru00.meaningfull.currency.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.justbru00.meaningfull.currency.main.Main;




public class Messager {

	public static String color(String uncolored){
		return ChatColor.translateAlternateColorCodes('&', uncolored);		
	}
	
	public static void msgConsole(String msg) {
		Main.console.sendMessage(Main.PREFIX + Messager.color(msg));		
	}
	
	public static void msgPlayer(String msg, Player player) {
		player.sendMessage(Main.PREFIX + Messager.color(msg));
	}	
	
	public static void msgSender(String msg, CommandSender sender) {
		sender.sendMessage(Main.PREFIX + Messager.color(msg));
	}	
}
