package com.NoodleNetworks.NoodleCrates;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class CommonCrate
  implements Listener
{
  private Inventory Common;
  private ItemStack Dark_Matter;
  private ItemStack Red_Matter;
  private ItemStack Industrial_Credit;
  private ItemStack LegendaryKey;
  private ItemStack PlaceHolder;
  
  public CommonCrate(Plugin p)
  {
    this.Common = Bukkit.getServer().createInventory(null, 27, ChatColor.DARK_RED + "Common Crate");
    
    int dark_matter = 27541;
    int red_matter = 27563;
    int industrial_credit = 30186;
    
    this.Dark_Matter = new ItemStack(dark_matter, 5);
    this.Red_Matter = new ItemStack(red_matter, 5);
    this.Industrial_Credit = new ItemStack(industrial_credit);
    this.LegendaryKey = createItem(Material.IRON_HOE, Enchantment.DURABILITY, 10);
    this.PlaceHolder = new ItemStack(Material.THIN_GLASS);
    
    this.Common.setItem(0, this.PlaceHolder);
    this.Common.setItem(1, this.PlaceHolder);
    this.Common.setItem(2, this.PlaceHolder);
    this.Common.setItem(3, this.PlaceHolder);
    this.Common.setItem(4, this.PlaceHolder);
    this.Common.setItem(5, this.PlaceHolder);
    this.Common.setItem(6, this.PlaceHolder);
    this.Common.setItem(7, this.PlaceHolder);
    this.Common.setItem(8, this.PlaceHolder);
    this.Common.setItem(9, this.PlaceHolder);
    this.Common.setItem(10, this.PlaceHolder);
    this.Common.setItem(11, this.PlaceHolder);
    this.Common.setItem(12, this.Dark_Matter);
    this.Common.setItem(13, this.Red_Matter);
    this.Common.setItem(14, this.Industrial_Credit);
    this.Common.setItem(15, this.PlaceHolder);
    this.Common.setItem(16, this.PlaceHolder);
    this.Common.setItem(17, this.PlaceHolder);
    this.Common.setItem(18, this.PlaceHolder);
    this.Common.setItem(19, this.PlaceHolder);
    this.Common.setItem(20, this.PlaceHolder);
    this.Common.setItem(21, this.PlaceHolder);
    this.Common.setItem(22, this.LegendaryKey);
    this.Common.setItem(23, this.PlaceHolder);
    this.Common.setItem(24, this.PlaceHolder);
    this.Common.setItem(25, this.PlaceHolder);
    this.Common.setItem(26, this.PlaceHolder);
    
    Bukkit.getServer().getPluginManager().registerEvents(this, p);
  }
  
  private ItemStack createItem(Material material, Enchantment enchantment, int enchantlevel)
  {
    ItemStack item = new ItemStack(material);
    item.addUnsafeEnchantment(enchantment, enchantlevel);
    return item;
  }
  
  public void show(Player p)
  {
	if(p.hasPermission("NoodleCrate.contents")) {
	    p.openInventory(this.Common);
	} else {
		p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You do not have permission for this command!");
	}
  }
  
  @EventHandler
  public void onInventoryClick(InventoryClickEvent e)
  {
    Player player = (Player)e.getWhoClicked();
    if (!e.getInventory().getName().equalsIgnoreCase(this.Common.getName())) {
      return;
    }
    if (e.getCurrentItem() == null) {
      return;
    }
    if (e.getCurrentItem().getType().getId() == 27541)
    {
      e.setCancelled(true);
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + " Common Crate Prize: " + ChatColor.GRAY + ChatColor.BOLD + "5 Dark Matter");
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.closeInventory();
    }
    if (e.getCurrentItem().getType().getId() == 27563)
    {
      e.setCancelled(true);
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + " Common Crate Prize: " + ChatColor.GRAY + ChatColor.BOLD + "5 Red Matter");
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.closeInventory();
    }
    if (e.getCurrentItem().getType().getId() == 30186)
    {
      e.setCancelled(true);
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + " Common Crate Prize: " + ChatColor.GRAY + ChatColor.BOLD + "$1000 In-Game Money");
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.closeInventory();
    }
    if (e.getCurrentItem().getType() == Material.IRON_HOE)
    {
      e.setCancelled(true);
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + " Common Crate Prize: " + ChatColor.GRAY + ChatColor.BOLD + "Legendary Key");
      player.sendMessage(ChatColor.GRAY + "----------------------------------------------------");
      player.closeInventory();
    }
    if (e.getCurrentItem().getType() == Material.THIN_GLASS) {
      e.setCancelled(true);
    }
  }
}