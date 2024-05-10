package de.jibu.jibukitpvp.DefaultFunctions;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class WithDraw implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (args.length == 1) {
            int amount = Integer.parseInt(args[0]);
            if (p.getMaxHealth() >= amount * 2) {
                if (p.getWorld() != Bukkit.getWorld("world")) {
                if (args[0].equalsIgnoreCase("1")) {
                        p.setMaxHealth(p.getMaxHealth() - 2);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("2")) {
                        p.setMaxHealth(p.getMaxHealth() - 4);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("3")) {
                        p.setMaxHealth(p.getMaxHealth() - 6);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("4")) {
                        p.setMaxHealth(p.getMaxHealth() - 8);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("5")) {
                        p.setMaxHealth(p.getMaxHealth() - 10);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("6")) {
                        p.setMaxHealth(p.getMaxHealth() - 12);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("7")) {
                        p.setMaxHealth(p.getMaxHealth() - 14);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("8")) {
                        p.setMaxHealth(p.getMaxHealth() - 16);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("9")) {
                        p.setMaxHealth(p.getMaxHealth() - 18);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("10")) {
                        p.setMaxHealth(p.getMaxHealth() - 20);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("11")) {
                        p.setMaxHealth(p.getMaxHealth() - 22);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("12")) {
                        p.setMaxHealth(p.getMaxHealth() - 24);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("13")) {
                        p.setMaxHealth(p.getMaxHealth() - 26);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("14")) {
                        p.setMaxHealth(p.getMaxHealth() - 28);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("15")) {
                        p.setMaxHealth(p.getMaxHealth() - 30);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("16")) {
                        p.setMaxHealth(p.getMaxHealth() - 32);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("17")) {
                        p.setMaxHealth(p.getMaxHealth() - 34);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("18")) {
                        p.setMaxHealth(p.getMaxHealth() - 36);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);
                    } else if (args[0].equalsIgnoreCase("19")) {
                        p.setMaxHealth(p.getMaxHealth() - 38);
                        ItemStack warp = new ItemStack(Material.NETHER_STAR, amount);
                        ItemMeta warp_meta = warp.getItemMeta();
                        warp_meta.setDisplayName("§cHeart");
                        ArrayList<String> aotelore = new ArrayList<>();
                        aotelore.add("§dUse 4 of these to craft the Beacon Of Life");
                        warp_meta.setLore(aotelore);
                        warp_meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        warp.setItemMeta(warp_meta);
                        p.getInventory().addItem(warp);

                    } else {
                        p.sendMessage("§cUse: /withdraw <1-19>");
                    }
                } else {
                    p.sendMessage("§cDu kannst in hier diesen Command nicht nutzen");
                }
            } else {
                p.sendMessage("§cDu hast nicht genug Herzen für diesen Withdraw");
            }
        }

        return false;
    }
}
