package com.NoodleNetworks.NoodleCrates;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CrateKeys
  implements CommandExecutor
{
  String Prefix = ChatColor.WHITE + "" + ChatColor.BOLD + "[" + ChatColor.GOLD + ChatColor.BOLD + "NoodleCrates" + ChatColor.WHITE + ChatColor.BOLD + "] " + ChatColor.LIGHT_PURPLE + ChatColor.BOLD;
  String Permissions = ChatColor.RED + "" + ChatColor.BOLD + "[Permission] No Permission Granted.";
  public Crate plugin;
  
  public CrateKeys(Crate plugin)
  {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!sender.hasPermission("NoodleCrate.key"))
    {
      sender.sendMessage(this.Permissions);
    }
    else
    {
      if (args.length < 2) {
        sender.sendMessage(this.Prefix + "Give Key Command: /key [common | legendary | platinum] [player]");
      }
      if ((args.length == 2) && (args[0].equalsIgnoreCase("common")))
      {
        Player target = Bukkit.getPlayer(args[1]);
        
        ItemStack Key = new ItemStack(Material.WOOD_HOE);
        Key.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        
        target.getInventory().addItem(new ItemStack[] { Key });
        target.sendMessage(this.Prefix + "You received one common crate key.");
      }
      if ((args.length == 2) && (args[0].equalsIgnoreCase("legendary")))
      {
        Player target = Bukkit.getPlayer(args[1]);
        
        ItemStack Key = new ItemStack(Material.IRON_HOE);
        Key.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        
        target.getInventory().addItem(new ItemStack[] { Key });
        target.sendMessage(this.Prefix + "You received one legendary crate key.");
      }
      if ((args.length == 2) && (args[0].equalsIgnoreCase("platinum")))
      {
        Player target = Bukkit.getPlayer(args[1]);
        
        ItemStack Key = new ItemStack(Material.DIAMOND_HOE);
        Key.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        
        target.getInventory().addItem(new ItemStack[] { Key });
        target.sendMessage(this.Prefix + "You received one platinum crate key.");
      }
    }
    return true;
  }
}
