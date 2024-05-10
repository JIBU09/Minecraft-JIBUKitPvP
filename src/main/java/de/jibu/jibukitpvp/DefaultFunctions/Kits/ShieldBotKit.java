package de.jibu.jibukitpvp.DefaultFunctions.Kits;

import de.jibu.jibukitpvp.DefaultFunctions.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ShieldBotKit implements Listener {

    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        String message = event.getMessage();
        Player p = event.getPlayer();
        Inventory inventory = p.getInventory();
        if (message.equals("wefi$%&smv")) {
            inventory.clear();
            p.performCommand("sethearts " + p.getName() + " 20");
            p.getInventory().clear();
            p.getInventory().setItem(40, new ItemBuilder(Material.SHIELD).getItemStack());
            p.getInventory().setItem(39, new ItemBuilder(Material.DIAMOND_HELMET).getItemStack());
            p.getInventory().setItem(38, new ItemBuilder(Material.DIAMOND_CHESTPLATE).getItemStack());
            p.getInventory().setItem(37, new ItemBuilder(Material.DIAMOND_LEGGINGS).getItemStack());
            p.getInventory().setItem(36, new ItemBuilder(Material.DIAMOND_BOOTS).getItemStack());
            p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_SWORD).getItemStack());
            p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_AXE).getItemStack());
            event.setCancelled(true);

        } else if (message.equals("wei&sdav.90de")) {
            inventory.clear();
            p.performCommand("sethearts " + p.getName() + " 40");
            p.getInventory().clear();
            p.getInventory().setItem(40, new ItemBuilder(Material.SHIELD).addEnchant(Enchantment.DURABILITY, 3).getItemStack());
            p.getInventory().setItem(39, new ItemBuilder(Material.DIAMOND_HELMET).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).getItemStack());
            p.getInventory().setItem(38, new ItemBuilder(Material.DIAMOND_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).getItemStack());
            p.getInventory().setItem(37, new ItemBuilder(Material.DIAMOND_LEGGINGS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2).getItemStack());
            p.getInventory().setItem(36, new ItemBuilder(Material.DIAMOND_BOOTS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3).getItemStack());
            p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_AXE).addEnchant(Enchantment.DAMAGE_ALL, 2).getItemStack());
            p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 3).getItemStack());
            event.setCancelled(true);
        }
    }
}
