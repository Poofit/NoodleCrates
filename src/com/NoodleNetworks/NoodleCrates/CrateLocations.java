package com.NoodleNetworks.NoodleCrates;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CrateLocations
  extends Crate
  implements CommandExecutor
{
  String Prefix = ChatColor.WHITE + "" + ChatColor.BOLD + "[" + ChatColor.GOLD + ChatColor.BOLD + "NoodleCrates" + ChatColor.WHITE + ChatColor.BOLD + "] " + ChatColor.LIGHT_PURPLE + ChatColor.BOLD;
  String Permissions = ChatColor.RED + "" + ChatColor.BOLD + "[Permission] No Permission Granted.";
  public Crate plugin;
  
  public CrateLocations(Crate plugin)
  {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(this.Prefix + "Player only command.");
      return true;
    }
    Player player = (Player)sender;
    if (!sender.hasPermission("NoodleCrate.location")) {
      player.sendMessage(this.Permissions);
    } else if (args.length < 1) {
      player.sendMessage(this.Prefix + "Set crate command: /setcrate [common | legendary | platinum]");
    }
    if ((args.length == 1) && (args[0].equalsIgnoreCase("common")))
    {
      this.plugin.Crates.set("Crates.World", player.getWorld().getName());
      this.plugin.Crates.set("Crates.Common.X", Double.valueOf(player.getLocation().getX()));
      this.plugin.Crates.set("Crates.Common.Y", Double.valueOf(player.getLocation().getY()));
      this.plugin.Crates.set("Crates.Common.Z", Double.valueOf(player.getLocation().getZ()));
      this.plugin.saveCrates();
      player.sendMessage(this.Prefix + "Common Crate location set.");
    }
    if ((args.length == 1) && (args[0].equalsIgnoreCase("legendary")))
    {
      this.plugin.Crates.set("Crates.World", player.getWorld().getName());
      this.plugin.Crates.set("Crates.Legendary.X", Double.valueOf(player.getLocation().getX()));
      this.plugin.Crates.set("Crates.Legendary.Y", Double.valueOf(player.getLocation().getY()));
      this.plugin.Crates.set("Crates.Legendary.Z", Double.valueOf(player.getLocation().getZ()));
      this.plugin.saveCrates();
      player.sendMessage(this.Prefix + "Legendary Crate location set.");
    }
    if ((args.length == 1) && (args[0].equalsIgnoreCase("platinum")))
    {
      this.plugin.Crates.set("Crates.World", player.getWorld().getName());
      this.plugin.Crates.set("Crates.Platinum.X", Double.valueOf(player.getLocation().getX()));
      this.plugin.Crates.set("Crates.Platinum.Y", Double.valueOf(player.getLocation().getY()));
      this.plugin.Crates.set("Crates.Platinum.Z", Double.valueOf(player.getLocation().getZ()));
      this.plugin.saveCrates();
      player.sendMessage(this.Prefix + "Platinum Crate location set.");
    }
    return true;
  }
}
