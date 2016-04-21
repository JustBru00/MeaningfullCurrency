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
 package com.gmail.justbru00.meaningfull.currency.main;
 

import java.util.List;
import java.util.logging.Logger;

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
	
	public static String PREFIX = Messager.color("&8[&bMeaningfull&fCurrency&8] &f");
	public static ConsoleCommandSender console = Bukkit.getConsoleSender();	
	public static Logger log = Bukkit.getLogger();
	public FileConfiguration config = getConfig();
	public static boolean debugMode = false;
	public final String PLUGIN_VERSION = this.getDescription().getVersion();
	public final List<String> PLUGIN_AUTHORS = this.getDescription().getAuthors();
	public static Economy econ = null;

	@Override
	public void onDisable() {
		Messager.msgConsole("&cPlugin disabled.");
	}

	@Override
	public void onEnable() {
		
		Messager.msgConsole("&bThis plugin was made by Justin \"JustBru00\" Brubaker. And is Licensed as follows:");
		Messager.msgConsole("");
		Messager.msgConsole("The MIT License (MIT)");
		Messager.msgConsole("Copyright (c) 2016 Justin \"JustBru00\" Brubaker");
		Messager.msgConsole("");
		Messager.msgConsole("Permission is hereby granted, free of charge, to any person obtaining a copy");
		Messager.msgConsole("of this software and associated documentation files (the \"Software\"), to deal");
		Messager.msgConsole("in the Software without restriction, including without limitation the rights");
		Messager.msgConsole("to use, copy, modify, merge, publish, distribute, sublicense, and/or sell");
		Messager.msgConsole("copies of the Software, and to permit persons to whom the Software is");
		Messager.msgConsole("furnished to do so, subject to the following conditions:");
		Messager.msgConsole("");
		Messager.msgConsole("The above copyright notice and this permission notice shall be included in all");
		Messager.msgConsole("copies or substantial portions of the Software.");
		Messager.msgConsole("");
		Messager.msgConsole("THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR");
		Messager.msgConsole("IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,");
		Messager.msgConsole("FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE");
		Messager.msgConsole("AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER");
		Messager.msgConsole("LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,");
		Messager.msgConsole("OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE");
		Messager.msgConsole("SOFTWARE.");
		
		Messager.msgConsole("&aStart Enable! Version: " + this.getDescription().getVersion());
		// Save Default Config
		this.saveDefaultConfig();
		
		Messager.msgConsole("&bSaved/Checked for Config.");
		// Check Vault
		if (!setupEconomy() ) {
            console.sendMessage(Messager.color(String.format("%s &cDisabled due to Vault NOT FOUND!", PREFIX)));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
		
		Messager.msgConsole("&aVault is found continuing with enable.");
		// Initialize Debug
		Debug.initialize(this);		
				
		Messager.msgConsole("&aReadied Debug.class");
		// Initialize ItemWorth
		ItemWorth.initialize(this);
				
		Messager.msgConsole("&aReadied ItemWorth.class");
		// Command Executors
		getCommand("bank").setExecutor(new Bank(this));
		
		// Register Listeners
		PluginManager pl = Bukkit.getServer().getPluginManager();
		pl.registerEvents(new BankHandler(this), this);
		
		Messager.msgConsole("&aPlugin Enable Status: SUCCESS");
	} // End of enable
	
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
