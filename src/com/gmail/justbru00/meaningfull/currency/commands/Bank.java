package com.gmail.justbru00.meaningfull.currency.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import com.gmail.justbru00.meaningfull.currency.main.Main;
import com.gmail.justbru00.meaningfull.currency.utils.Messager;

public class Bank implements CommandExecutor {

	Main main;
	
	public Bank(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	
		if (command.getName().equalsIgnoreCase("bank")) {
			if (!(sender instanceof Player)) {
				Messager.msgSender(main.getConfigString("commands.bank.wrong sender"), sender);
				return true;
			}
			
			Player player = (Player) sender;
			
			Inventory temp = Bukkit.createInventory(null, 54, main.getConfigString("commands.bank.gui.title").replace("{PLAYERNAME}", player.getName()));			
						
			int i = 0;
			
			while (i<54) {
				if (main.config.getItemStack("store." + player.getUniqueId().toString() + ".bank." + i) != null) {
					temp.setItem(i, main.config.getItemStack("store." + player.getUniqueId().toString() + ".bank." + i));
				}
				i++;
			}
			
			player.openInventory(temp);
			
			return true;
		}
		
		return false;
	}

}
