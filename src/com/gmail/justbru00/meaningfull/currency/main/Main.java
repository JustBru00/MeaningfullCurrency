package com.gmail.justbru00.meaningfull.currency.main;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.justbru00.meaningfull.currency.commands.Bank;
import com.gmail.justbru00.meaningfull.currency.listeners.BankHandler;
import com.gmail.justbru00.meaningfull.currency.utils.Debug;
import com.gmail.justbru00.meaningfull.currency.utils.ItemWorth;
import com.gmail.justbru00.meaningfull.currency.utils.Messager;

import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {
	
	public static String PREFIX = Messager.color("&8[&bEpic&fEnchants&8] &f");
	public static ConsoleCommandSender console = Bukkit.getConsoleSender();	
	public FileConfiguration config = getConfig();
	public static boolean debugMode = false;
	public final String PLUGIN_VERSION = this.getDescription().getVersion();
	public final List<String> PLUGIN_AUTHORS = this.getDescription().getAuthors();
	public static Economy econ = null;

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
	}

	@Override
	public void onEnable() {
		
		// Save Default Config
		this.saveDefaultConfig();
		
		// Check Vault
		if (!setupEconomy() ) {
            console.sendMessage(Messager.color(String.format("%s &cDisabled due to Vault NOT FOUND!", PREFIX)));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
		
		// Initialize Debug
		Debug.initialize(this);
		
		// Initialize ItemWorth
		ItemWorth.initialize(this);
				
		// Command Executors
		getCommand("bank").setExecutor(new Bank(this));
		
		// Register Listeners
		PluginManager pl = Bukkit.getServer().getPluginManager();
		pl.registerEvents(new BankHandler(this), this);
	}
	
	public String getConfigString(String path) {
		return Messager.color(config.getString(path));
	}
	
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

}
