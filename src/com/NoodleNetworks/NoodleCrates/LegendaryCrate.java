package com.NoodleNetworks.NoodleCrates;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class LegendaryCrate
  implements Listener
{
  private Inventory Legendary;
  private ItemStack Dark_Matter;
  private ItemStack Red_Matter;
  private ItemStack Industrial_Credit;
  private ItemStack Volcanite_Amulet;
  private ItemStack Evertide_Amulet;
  private ItemStack Place_Holder;
  
  public LegendaryCrate(Plugin p)
  {
    this.Legendary = Bukkit.getServer().createInventory(null, 27, ChatColor.DARK_RED + "Legendary Crate");
    
    int dark_matter = 27541;
    int red_matter = 27563;
    int industrial_credit = 30186;
    int evertide_amulet = 27530;
    int volcanite_amulet = 27531;
    
    this.Dark_Matter = new ItemStack(dark_matter, 25);
    this.Red_Matter = new ItemStack(red_matter, 25);
    this.Industrial_Credit = new ItemStack(industrial_credit);
    this.Evertide_Amulet = new ItemStack(evertide_amulet);
    this.Volcanite_Amulet = new ItemStack(volcanite_amulet);
    this.Place_Holder = new ItemStack(Material.THIN_GLASS);
    
    this.Legendary.setItem(0, this.Place_Holder);
    this.Legendary.setItem(1, this.Place_Holder);
    this.Legendary.setItem(2, this.Place_Holder);
    this.Legendary.setItem(3, this.Place_Holder);
    this.Legendary.setItem(4, this.Place_Holder);
    this.Legendary.setItem(5, this.Place_Holder);
    this.Legendary.setItem(6, this.Place_Holder);
    this.Legendary.setItem(7, this.Place_Holder);
    this.Legendary.setItem(8, this.Place_Holder);
    this.Legendary.setItem(9, this.Place_Holder);
    this.Legendary.setItem(10, this.Place_Holder);
    this.Legendary.setItem(11, this.Place_Holder);
    this.Legendary.setItem(12, this.Dark_Matter);
    this.Legendary.setItem(13, this.Red_Matter);
    this.Legendary.setItem(14, this.Industrial_Credit);
    this.Legendary.setItem(15, this.Place_Holder);
    this.Legendary.setItem(16, this.Place_Holder);
    this.Legendary.setItem(17, this.Place_Holder);
    this.Legendary.setItem(18, this.Place_Holder);
    this.Legendary.setItem(19, this.Place_Holder);
    this.Legendary.setItem(20, this.Place_Holder);
    this.Legendary.setItem(21, this.Place_Holder);
    
    Random amulet_random = new Random();
    int amulet_change = amulet_random.nextInt(2);
    if (amulet_change == 0) {
      this.Legendary.setItem(22, this.Evertide_Amulet);
    }
    if (amulet_change == 1) {
      this.Legendary.setItem(22, this.Volcanite_Amulet);
    }
    this.Legendary.setItem(23, this.Place_Holder);
    this.Legendary.setItem(24, this.Place_Holder);
    this.Legendary.setItem(25, this.Place_Holder);
    this.Legendary.setItem(26, this.Place_Holder);
    
    Bukkit.getServer().getPluginManager().registerEvents(this, p);
  }
  
  public void show(Player p) {
  if(p.hasPermission("NoodleCrate.contents")) {
	    p.openInventory(this.Legendary);
	} else {
		p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You do not have permission for this command!");
	}
  }
  
  @EventHandler
  public void onInventoryClick(InventoryClickEvent e)
  {
    Player player = (Player)e.getWhoClicked();
    if (!e.getInventory().getName().equalsIgnoreCase(this.Legendary.getName())) {
      return;
    }
    if (e.getCurrentItem() == null) {
      return;
    }
    if (e.getCurrentItem().getType().getId() == 27541)
    {
      e.setCancelled(true);
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + " Legendary Crate Prize: " + ChatColor.GRAY + ChatColor.BOLD + "25 Dark Matter");
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.closeInventory();
    }
    if (e.getCurrentItem().getType().getId() == 27563)
    {
      e.setCancelled(true);
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + " Legendary Crate Prize: " + ChatColor.GRAY + ChatColor.BOLD + "25 Red Matter");
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.closeInventory();
    }
    if (e.getCurrentItem().getType().getId() == 30186)
    {
      e.setCancelled(true);
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + " Legendary Crate Prize: " + ChatColor.GRAY + ChatColor.BOLD + "$5000 In-Game Money");
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.closeInventory();
    }
    if (e.getCurrentItem().getType().getId() == 27530)
    {
      e.setCancelled(true);
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + " Legendary Crate Prize: " + ChatColor.GRAY + ChatColor.BOLD + "Access To Evertide + Volcanite Amulets ");
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.closeInventory();
    }
    if (e.getCurrentItem().getType().getId() == 27531)
    {
      e.setCancelled(true);
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + " Legendary Crate Prize: " + ChatColor.GRAY + ChatColor.BOLD + "Access To Evertide + Volcanite Amulets ");
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.closeInventory();
    }
    if (e.getCurrentItem().getType() == Material.THIN_GLASS) {
      e.setCancelled(true);
    }
  }
}
