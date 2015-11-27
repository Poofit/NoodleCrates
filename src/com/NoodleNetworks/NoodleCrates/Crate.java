package com.NoodleNetworks.NoodleCrates;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;


public class Crate extends JavaPlugin implements Listener {

	  public Crate plugin;
	  public CommonCrate CommonGUI;
	  public LegendaryCrate LegendaryGUI;
	  String Crate = ChatColor.WHITE + "" + ChatColor.BOLD + "[" + ChatColor.GOLD + ChatColor.BOLD + "NoodleCrates" + ChatColor.WHITE + ChatColor.BOLD + "] " + ChatColor.LIGHT_PURPLE + ChatColor.BOLD;
	  public File CratesFile = new File("plugins/NoodleCrates/crates.yml");
	  public FileConfiguration Crates = YamlConfiguration.loadConfiguration(this.CratesFile);
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		this.CommonGUI = new CommonCrate(this);
		this.LegendaryGUI = new LegendaryCrate(this);
	    getCommand("setcrate").setExecutor(new CrateLocations(this));
	    getCommand("givekey").setExecutor(new CrateKeys(this));
	}
	
	public void onDisable() {
		
	}
	   
	  public void loadCrates()
	  {
	    try
	    {
	      this.Crates.save(this.CratesFile);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	  }
	  
	  public void saveCrates()
	  {
	    try
	    {
	      this.Crates.save(this.CratesFile);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	  }
	  
	  @EventHandler
	  public void LegendaryCrateSign(SignChangeEvent e)
	  {
		  Player player = e.getPlayer();
		  if(player.hasPermission("NoodleCrates.create")) {
	    if (e.getLine(0).equalsIgnoreCase("[Legendary]"))
	    {
	      e.setLine(0, "---------------");
	      e.setLine(1, "§5 [Legendary]");
	      e.setLine(2, "§f Click Here!");
	      e.setLine(3, "---------------");
	    }
	 } else {
		 player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You do not have permission for this command!");
	 }
	}
	  
	  @EventHandler
	  public void CommonCrateSign(SignChangeEvent e)
	  {
		  Player player = e.getPlayer();
		  if(player.hasPermission("NoodleCrates.create")) {
	    if (e.getLine(0).equalsIgnoreCase("[Common]"))
	    {
	      e.setLine(0, "---------------");
	      e.setLine(1, "§6 [Common]");
	      e.setLine(2, "§f Click Here!");
	      e.setLine(3, "---------------");
	    }
		  } else {
			  player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You do not have permission for this command!");
		  }
	  }
	  
	  @EventHandler
	  public void PlatinumCrateSign(SignChangeEvent e)
	  {
		  Player player = e.getPlayer();
		  if(player.hasPermission("NoodleCrates.create")) {
	    if (e.getLine(0).equalsIgnoreCase("[Platinum]"))
	    {
	      e.setLine(0, "---------------");
	      e.setLine(1, "§b [Platinum]");
	      e.setLine(2, "§f Click Here!");
	      e.setLine(3, "---------------");
	    }
		  } else {
			  player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You do not have permission for this command!");
		  }
	  }
	  
	  @EventHandler
	  public void CommonKey(PlayerInteractEvent event)
	  {
		    Player player = event.getPlayer();
		    if (((event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) || (event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.LEFT_CLICK_AIR)) || (event.getAction().equals(Action.LEFT_CLICK_BLOCK))) && 
		      (player.getItemInHand().getType() == Material.WOOD_HOE) && (player.getItemInHand().containsEnchantment(Enchantment.DURABILITY)) && (player.getItemInHand().getEnchantmentLevel(Enchantment.DURABILITY) == 10)) {
		      if (event.getClickedBlock().getType() != Material.SIGN)
		      {
		        event.setCancelled(true);
		        player.sendMessage(this.Crate + "Keys can only be used on Crate Signs");
		      }
		      else {}
		    }
		  }
	  
	  @EventHandler
	  public void LegendaryKey(PlayerInteractEvent event)
	  {
	    Player player = event.getPlayer();
	    if (((event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) || (event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.LEFT_CLICK_AIR)) || (event.getAction().equals(Action.LEFT_CLICK_BLOCK))) && 
	      (player.getItemInHand().getType() == Material.IRON_HOE) && (player.getItemInHand().containsEnchantment(Enchantment.DURABILITY)) && (player.getItemInHand().getEnchantmentLevel(Enchantment.DURABILITY) == 10)) {
	      if (event.getClickedBlock().getType() != Material.SIGN)
	      {
	        event.setCancelled(true);
	        player.sendMessage(this.Crate + "Keys can only be used on Crate Signs");
	      }
	      else {}
	    }
	  }
	  
	  @EventHandler
	  public void PlatinumKey(PlayerInteractEvent event)
	  {
	    Player player = event.getPlayer();
	    if (((event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) || (event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.LEFT_CLICK_AIR)) || (event.getAction().equals(Action.LEFT_CLICK_BLOCK))) && 
	      (player.getItemInHand().getType() == Material.DIAMOND_HOE) && (player.getItemInHand().containsEnchantment(Enchantment.DURABILITY)) && (player.getItemInHand().getEnchantmentLevel(Enchantment.DURABILITY) == 10)) {
	      if (event.getClickedBlock().getType() != Material.SIGN)
	      {
	        event.setCancelled(true);
	        player.sendMessage(this.Crate + "Keys can only be used on Crate Signs");
	      }
	      else {}
	    }
	  }
	  
	  @SuppressWarnings("deprecation")
	@EventHandler
	  public void CommonCrateEvent(PlayerInteractEvent e)
	  {
	    Player player = e.getPlayer();
	    if ((e.getAction() == Action.LEFT_CLICK_BLOCK) && 
	      ((e.getClickedBlock().getState() instanceof Sign)))
	    {
	      Sign s = (Sign)e.getClickedBlock().getState();
	      if (s.getLine(1).equalsIgnoreCase("§6 [Common]")) {
	        this.CommonGUI.show(player);
	      }
	    }
	    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && 
	      ((e.getClickedBlock().getState() instanceof Sign)))
	    {
	      Sign s = (Sign)e.getClickedBlock().getState();
	      if (s.getLine(1).equalsIgnoreCase("§6 [Common]")) {
	        if ((player.getItemInHand().getType() == Material.WOOD_HOE) && (player.getItemInHand().containsEnchantment(Enchantment.DURABILITY)) && (player.getItemInHand().getEnchantmentLevel(Enchantment.DURABILITY) == 10))
	        {
	          ItemStack CommonKey = new ItemStack(Material.WOOD_HOE);
	          CommonKey.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
	          
	          player.getInventory().removeItem(new ItemStack[] { CommonKey });
	          player.updateInventory();
	          
	          World world = Bukkit.getWorld(this.Crates.getString("Crates.World"));
	          Location BottomFlame = new Location(world, this.Crates.getInt("Crates.Common.X"), this.Crates.getInt("Crates.Common.Y") - 1, this.Crates.getInt("Crates.Common.Z"));
	          Location MiddleFlame = new Location(world, this.Crates.getInt("Crates.Common.X"), this.Crates.getInt("Crates.Common.Y"), this.Crates.getInt("Crates.Common.Z"));
	          Location TopFlame = new Location(world, this.Crates.getInt("Crates.Common.X"), this.Crates.getInt("Crates.Common.Y") + 1, this.Crates.getInt("Crates.Common.Z"));
	          Location Ender = new Location(world, this.Crates.getInt("Crates.Common.X"), this.Crates.getInt("Crates.Common.Y") + 2, this.Crates.getInt("Crates.Common.Z"));
	          
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(BottomFlame, Effect.MOBSPAWNER_FLAMES, 10);
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(MiddleFlame, Effect.MOBSPAWNER_FLAMES, 10);
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(TopFlame, Effect.MOBSPAWNER_FLAMES, 10);
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(Ender, Effect.ENDER_SIGNAL, 10);
	          
	          player.sendMessage(this.Crate + "You opened a Common Crate!");
	          Bukkit.broadcastMessage(this.Crate + player.getName() + " opened a Common Crate!");
	          
	          Random KeyRandom = new Random();
	          int KeyChance = KeyRandom.nextInt(100);
	          if (KeyChance == 49)
	          {
	            ItemStack LegendaryKey = new ItemStack(Material.IRON_HOE);
	            LegendaryKey.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
	            player.getInventory().addItem(new ItemStack[] { LegendaryKey });
	            player.updateInventory();
	            player.sendMessage(this.Crate + "You received one Legendary Key!");
	          }
	          Random ItemRandom = new Random();
	          int ItemChance = ItemRandom.nextInt(5);
	          if (ItemChance == 0)
	          {
	            int dark_matter = 27541;
	            player.getInventory().addItem(new ItemStack[] { new ItemStack(dark_matter, 5) });
	            player.updateInventory();
	            player.sendMessage(this.Crate + "You received 5 Dark Matter!");
	          }
	          if (ItemChance == 1)
	          {
	            int red_matter = 27563;
	            player.getInventory().addItem(new ItemStack[] { new ItemStack(red_matter, 5) });
	            player.updateInventory();
	            player.sendMessage(this.Crate + "You received 5 Red Matter!");
	          }
	          if (ItemChance == 2)
	          {
	            player.sendMessage(this.Crate + "You received $1000 In-Game Money!");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 1000");
	          }
	          if (ItemChance > 2) {
	            player.sendMessage(this.Crate + "Whoops! You received nothing! Try again next time!");
	          }
	        }
	        else
	        {
	          World world = Bukkit.getWorld(this.Crates.getString("Crates.World"));
	          Location BottomFlame = new Location(world, this.Crates.getInt("Crates.Common.X"), this.Crates.getInt("Crates.Common.Y"), this.Crates.getInt("Crates.Common.Z"));
	          Location TopFlame = new Location(world, this.Crates.getInt("Crates.Common.X"), this.Crates.getInt("Crates.Common.Y") + 1, this.Crates.getInt("Crates.Common.Z"));
	          
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(BottomFlame, Effect.MOBSPAWNER_FLAMES, 10);
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(TopFlame, Effect.MOBSPAWNER_FLAMES, 10);
	          
	          Vector v = player.getLocation().getDirection().multiply(-2.0D);
	          player.setVelocity(v);
	          
	          player.sendMessage(this.Crate + "You will need a key to open this crate!");
	        }
	      }
	    }
	  }
	  
	  @SuppressWarnings("deprecation")
	@EventHandler
	  public void LegendaryCrateEvent(PlayerInteractEvent e)
	  {
	    Player player = e.getPlayer();
	    if ((e.getAction() == Action.LEFT_CLICK_BLOCK) && 
	      ((e.getClickedBlock().getState() instanceof Sign)))
	    {
	      Sign s = (Sign)e.getClickedBlock().getState();
	      if (s.getLine(1).equalsIgnoreCase("§5 [Legendary]")) {
	        this.LegendaryGUI.show(player);
	      }
	    }
	    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && 
	      ((e.getClickedBlock().getState() instanceof Sign)))
	    {
	      Sign s = (Sign)e.getClickedBlock().getState();
	      if (s.getLine(1).equalsIgnoreCase("§5 [Legendary]")) {
	        if ((player.getItemInHand().getType() == Material.IRON_HOE) && (player.getItemInHand().containsEnchantment(Enchantment.DURABILITY)) && (player.getItemInHand().getEnchantmentLevel(Enchantment.DURABILITY) == 10))
	        {
	          ItemStack LegendaryKey = new ItemStack(Material.IRON_HOE);
	          LegendaryKey.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
	          
	          player.getInventory().removeItem(new ItemStack[] { LegendaryKey });
	          player.updateInventory();
	          
	          World world = Bukkit.getWorld(this.Crates.getString("Crates.World"));
	          Location BottomFlame = new Location(world, this.Crates.getInt("Crates.Legendary.X"), this.Crates.getInt("Crates.Legendary.Y") - 1, this.Crates.getInt("Crates.Legendary.Z"));
	          Location MiddleFlame = new Location(world, this.Crates.getInt("Crates.Legendary.X"), this.Crates.getInt("Crates.Legendary.Y"), this.Crates.getInt("Crates.Legendary.Z"));
	          Location TopFlame = new Location(world, this.Crates.getInt("Crates.Legendary.X"), this.Crates.getInt("Crates.Legendary.Y") + 1, this.Crates.getInt("Crates.Legendary.Z"));
	          Location BottomEnder = new Location(world, this.Crates.getInt("Crates.Legendary.X"), this.Crates.getInt("Crates.Legendary.Y"), this.Crates.getInt("Crates.Legendary.Z"));
	          Location MiddleEnder = new Location(world, this.Crates.getInt("Crates.Legendary.X"), this.Crates.getInt("Crates.Legendary.Y") + 1, this.Crates.getInt("Crates.Legendary.Z"));
	          Location TopEnder = new Location(world, this.Crates.getInt("Crates.Legendary.X"), this.Crates.getInt("Crates.Legendary.Y") + 2, this.Crates.getInt("Crates.Legendary.Z"));
	          
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(BottomFlame, Effect.MOBSPAWNER_FLAMES, 10);
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(MiddleFlame, Effect.MOBSPAWNER_FLAMES, 10);
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(TopFlame, Effect.MOBSPAWNER_FLAMES, 10);
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(BottomEnder, Effect.ENDER_SIGNAL, 10);
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(MiddleEnder, Effect.ENDER_SIGNAL, 10);
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(TopEnder, Effect.ENDER_SIGNAL, 10);
	          
	          player.sendMessage(this.Crate + "You opened a Legendary Crate!");
	          Bukkit.broadcastMessage(this.Crate + player.getName() + " opened a Legendary Crate!");
	          
	          Random Amulet = new Random();
	          int Amulet_Chance = Amulet.nextInt(100);
	          if (Amulet_Chance == 49)
	          {
	            player.sendMessage(this.Crate + "You received access to Amulets!");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + player.getName() + " tekkitcustomizer.27530.*.*");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + player.getName() + " tekkitcustomizer.27531.*.*");
	          }
	          Random ItemRandom = new Random();
	          int ItemChance = ItemRandom.nextInt(5);
	          if (ItemChance == 0)
	          {
	            int dark_matter = 27541;
	            player.getInventory().addItem(new ItemStack[] { new ItemStack(dark_matter, 25) });
	            player.updateInventory();
	            player.sendMessage(this.Crate + "You received 25 Dark Matter!");
	          }
	          if (ItemChance == 1)
	          {
	            int red_matter = 27563;
	            player.getInventory().addItem(new ItemStack[] { new ItemStack(red_matter, 25) });
	            player.updateInventory();
	            player.sendMessage(this.Crate + "You received 25 Red Matter!");
	          }
	          if (ItemChance == 2)
	          {
	            player.sendMessage(this.Crate + "You received $5000 In-Game Money!");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 5000");
	          }
	          if (ItemChance > 2) {
	            player.sendMessage(this.Crate + "Whoops! You received nothing! Try again next time!");
	          }
	        }
	        else
	        {
	          World world = Bukkit.getWorld(this.Crates.getString("Crates.World"));
	          Location BottomFlame = new Location(world, this.Crates.getInt("Crates.Legendary.X"), this.Crates.getInt("Crates.Legendary.Y"), this.Crates.getInt("Crates.Legendary.Z"));
	          Location TopFlame = new Location(world, this.Crates.getInt("Crates.Legendary.X"), this.Crates.getInt("Crates.Legendary.Y") + 1, this.Crates.getInt("Crates.Legendary.Z"));
	          
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(BottomFlame, Effect.MOBSPAWNER_FLAMES, 10);
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(TopFlame, Effect.MOBSPAWNER_FLAMES, 10);
	          
	          Vector v = player.getLocation().getDirection().multiply(-2.0D);
	          player.setVelocity(v);
	          
	          player.sendMessage(this.Crate + "You will need a key to open this crate!");
	        }
	      }
	    }
	  }
	  
	  @SuppressWarnings("deprecation")
	@EventHandler
	  public void PlatinumCrateEvent(PlayerInteractEvent e)
	  {
	    Player player = e.getPlayer();
	    if ((e.getAction() == Action.LEFT_CLICK_BLOCK) && 
	      ((e.getClickedBlock().getState() instanceof Sign)))
	    {
	      Sign s = (Sign)e.getClickedBlock().getState();
	      if (s.getLine(1).equalsIgnoreCase("§b [Platinum]")) {
	        this.CommonGUI.show(player);
	      }
	    }
	    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && 
	      ((e.getClickedBlock().getState() instanceof Sign)))
	    {
	      Sign s = (Sign)e.getClickedBlock().getState();
	      if (s.getLine(1).equalsIgnoreCase("§b [Platinum]")) {
	        if ((player.getItemInHand().getType() == Material.DIAMOND_HOE) && (player.getItemInHand().containsEnchantment(Enchantment.DURABILITY)) && (player.getItemInHand().getEnchantmentLevel(Enchantment.DURABILITY) == 10))
	        {
	          ItemStack PlatinumKey = new ItemStack(Material.DIAMOND_HOE);
	          PlatinumKey.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
	          
	          player.getInventory().removeItem(new ItemStack[] { PlatinumKey });
	          player.updateInventory();
	          
	          World world = Bukkit.getWorld(this.Crates.getString("Crates.World"));
	          Location BottomFlame = new Location(world, this.Crates.getInt("Crates.Platinum.X"), this.Crates.getInt("Crates.Platinum.Y") - 1, this.Crates.getInt("Crates.Platinum.Z"));
	          Location MiddleFlame = new Location(world, this.Crates.getInt("Crates.Platinum.X"), this.Crates.getInt("Crates.Platinum.Y"), this.Crates.getInt("Crates.Platinum.Z"));
	          Location TopFlame = new Location(world, this.Crates.getInt("Crates.Platinum.X"), this.Crates.getInt("Crates.Platinum.Y") + 1, this.Crates.getInt("Crates.Platinum.Z"));
	          Location Ender = new Location(world, this.Crates.getInt("Crates.Platinum.X"), this.Crates.getInt("Crates.Platinum.Y") + 2, this.Crates.getInt("Crates.Platinum.Z"));
	          
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(BottomFlame, Effect.MOBSPAWNER_FLAMES, 10);
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(MiddleFlame, Effect.MOBSPAWNER_FLAMES, 10);
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(TopFlame, Effect.MOBSPAWNER_FLAMES, 10);
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(Ender, Effect.ENDER_SIGNAL, 10);
	          
	          player.sendMessage(this.Crate + "You opened a Platinum Crate!");
	          Bukkit.broadcastMessage(this.Crate + player.getName() + " opened a Platinum Crate!");
	          
	          Random KeyRandom = new Random();
	          int KeyChance = KeyRandom.nextInt(100);
	          if (KeyChance == 49)
	          {
	            ItemStack LegendaryKey = new ItemStack(Material.IRON_HOE);
	            LegendaryKey.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
	            player.getInventory().addItem(new ItemStack[] { LegendaryKey });
	            player.updateInventory();
	            player.sendMessage(this.Crate + "You received one Legendary Key!");
	          }
	          Random ItemRandom = new Random();
	          int ItemChance = ItemRandom.nextInt(5);
	          if (ItemChance == 0)
	          {
	            int dark_matter = 27541;
	            player.getInventory().addItem(new ItemStack[] { new ItemStack(dark_matter, 35) });
	            player.updateInventory();
	            player.sendMessage(this.Crate + "You received 35 Dark Matter!");
	          }
	          if (ItemChance == 1)
	          {
	            int red_matter = 27563;
	            player.getInventory().addItem(new ItemStack[] { new ItemStack(red_matter, 30) });
	            player.updateInventory();
	            player.sendMessage(this.Crate + "You received 30 Red Matter!");
	          }
	          if (ItemChance == 2)
	          {
	            player.sendMessage(this.Crate + "You received $10000 In-Game Money!");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + player.getName() + " 10000");
	          }
	          if (ItemChance > 2) {
	            player.sendMessage(this.Crate + "Whoops! You received nothing! Try again next time! :(");
	          }
	        }
	        else
	        {
	          World world = Bukkit.getWorld(this.Crates.getString("Crates.World"));
	          Location BottomFlame = new Location(world, this.Crates.getInt("Crates.Platinum.X"), this.Crates.getInt("Crates.Platinum.Y"), this.Crates.getInt("Crates.Platinum.Z"));
	          Location TopFlame = new Location(world, this.Crates.getInt("Crates.Platinum.X"), this.Crates.getInt("Crates.Platinum.Y") + 1, this.Crates.getInt("Crates.Platinum.Z"));
	          
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(BottomFlame, Effect.MOBSPAWNER_FLAMES, 10);
	          Bukkit.getWorld(this.Crates.getString("Crates.World")).playEffect(TopFlame, Effect.MOBSPAWNER_FLAMES, 10);
	          
	          Vector v = player.getLocation().getDirection().multiply(-2.0D);
	          player.setVelocity(v);
	          
	          player.sendMessage(this.Crate + "You will need a key to open this crate!");
	        }
	      }
	    }
	  }

}
