package com.gmail.justbru00.meaningfull.currency.main;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.justbru00.meaningfull.currency.commands.Bank;
import com.gmail.justbru00.meaningfull.currency.utils.Debug;
import com.gmail.justbru00.meaningfull.currency.utils.Messager;

public class Main extends JavaPlugin {
	
	public static String PREFIX = Messager.color("&8[&bEpic&fEnchants&8] &f");
	public static ConsoleCommandSender console = Bukkit.getConsoleSender();	
	public FileConfiguration config = getConfig();
	public static boolean debugMode = false;
	public final String PLUGIN_VERSION = this.getDescription().getVersion();
	public final List<String> PLUGIN_AUTHORS = this.getDescription().getAuthors();

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
	}

	@Override
	public void onEnable() {
		
		// Save Default Config
		this.saveDefaultConfig();
		
		// Initialize Debug
		Debug.initialize(this);
				
		// Command Executors
		getCommand("bank").setExecutor(new Bank(this));
	}
	
	public String getConfigString(String path) {
		return Messager.color(config.getString(path));
	}

}
