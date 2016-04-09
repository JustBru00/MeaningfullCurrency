package com.gmail.justbru00.meaningfull.currency.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import com.gmail.justbru00.meaningfull.currency.main.Main;
import com.gmail.justbru00.meaningfull.currency.utils.Debug;
import com.gmail.justbru00.meaningfull.currency.utils.ItemWorth;

public class BankHandler implements Listener {

	Main main;
	
	public BankHandler(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) {
		Inventory inv = e.getInventory();
		
		Player player = (Player) e.getPlayer();
		
		if (inv.getName().equals(main.getConfigString("commands.bank.gui.title").replace("{PLAYERNAME}", player.getName()))) {
			
			
			
			int i = 0;
			
			Debug.send("Starting to save inventory.", player);
			
			while(i<53) {
				
				main.config.set("store." + player.getUniqueId().toString() + ".bank." + i, inv.getItem(i));			
				
				i++;
			}
			
			main.saveConfig();
			
			Debug.send("Success.", player);
			
			i = 0;
			int newbal = 0;
			
			while(i<53) {						
				newbal = newbal + ItemWorth.calc(inv.getItem(i));
				i++;
			}
			
			Main.econ.bankWithdraw(player.getName(), Main.econ.getBalance(player));	
			Main.econ.bankDeposit(player.getName(), newbal);
			
			return;
		}
	}
}
