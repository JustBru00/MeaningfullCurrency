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
