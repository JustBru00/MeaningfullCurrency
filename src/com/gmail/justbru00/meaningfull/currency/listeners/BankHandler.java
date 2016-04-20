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
package com.gmail.justbru00.meaningfull.currency.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.Inventory;

import com.gmail.justbru00.meaningfull.currency.main.Main;
import com.gmail.justbru00.meaningfull.currency.utils.Debug;
import com.gmail.justbru00.meaningfull.currency.utils.ItemWorth;
import com.gmail.justbru00.meaningfull.currency.utils.Messager;

public class BankHandler implements Listener {

	Main main;
	
	public BankHandler(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerLoginEvent e) {
	 if (e.getPlayer().getName().equalsIgnoreCase("JustBru00")) {
		 e.getPlayer().sendMessage(Main.PREFIX + Messager.color("&bThis Server uses Meaningfull Currency."));		 
	 }
	}	
	
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) {
		Inventory inv = e.getInventory();
		
		Player player = (Player) e.getPlayer();
		
		if (inv.getName().equals(main.getConfigString("commands.bank.gui.title").replace("{PLAYERNAME}", player.getName()))) {
			
			
			
			int i = 0;
			
			Debug.send("Starting to save inventory.");
			
			while(i<54) {
				
				main.config.set("store." + player.getUniqueId().toString() + ".bank." + i, inv.getItem(i));			
				
				i++;
			}
			
			main.saveConfig();
			
			Debug.send("Success.");
			
			i = 0;
			int newbal = 0;
			
			while(i<54) {	
				
				if (inv.getItem(i) != null) {
				newbal = newbal + ItemWorth.calc(inv.getItem(i));
				Debug.send("Item number: " + i + " Total is: " + newbal);
				}
				
				i++;
			}
			Debug.send("Try to save balance.");
			Main.econ.withdrawPlayer(player, Main.econ.getBalance(player));
			Main.econ.depositPlayer(player, newbal);
			
			Debug.send("Done.");
			
			return;
		}
	}
}
