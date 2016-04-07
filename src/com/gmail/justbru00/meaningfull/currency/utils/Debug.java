package com.gmail.justbru00.meaningfull.currency.utils;

import org.bukkit.entity.Player;

import com.gmail.justbru00.meaningfull.currency.main.Main;

public class Debug {
	private static Main main2;

	public static void send(String msg, Player player) {
		if (main2.config.getBoolean("debug")) {
		Messager.msgConsole("&8[&cError&8] &c" + msg);	
		}
	}
	
	public static void initialize(Main main) {
		main2 = main;
		return;
	}
}
