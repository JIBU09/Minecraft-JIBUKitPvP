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

public class PotionBotKit implements Listener {

    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        String message = event.getMessage();
        Player p = event.getPlayer();
        Inventory inventory = p.getInventory();
        if (message.equals("HiA<kc8g&gL")) {
            inventory.clear();
            p.performCommand("sethearts " + p.getName() + " 600");
            inventory.setItem(40, new ItemBuilder(Material.TOTEM_OF_UNDYING).getItemStack());
            inventory.setItem(39, new ItemBuilder(Material.NETHERITE_HELMET).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.OXYGEN, 3).addEnchant(Enchantment.WATER_WORKER, 1).getItemStack());
            inventory.setItem(38, new ItemBuilder(Material.NETHERITE_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).getItemStack());
            inventory.setItem(37, new ItemBuilder(Material.NETHERITE_LEGGINGS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).getItemStack());
            inventory.setItem(36, new ItemBuilder(Material.NETHERITE_BOOTS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.DEPTH_STRIDER, 3).addEnchant(Enchantment.PROTECTION_FALL, 4).getItemStack());
            inventory.addItem(new ItemBuilder(Material.NETHERITE_SWORD, 1).addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.FIRE_ASPECT, 2).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.SWEEPING_EDGE, 3).getItemStack());
            inventory.addItem(new ItemBuilder(Material.TOTEM_OF_UNDYING, 1).getItemStack());
            inventory.addItem(new ItemBuilder(Material.TOTEM_OF_UNDYING, 1).getItemStack());
            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 25 * 20, 255, true, false, true));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 25 * 20, 255, true, false, true));
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 25 * 20, 255, true, false, true));
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 805 * 20, 1, true, false, true));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 805 * 20, 1, true, false, true));
            p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1465 * 20, 1, true, false, true));
            event.setCancelled(true);

        } else if (message.equals("5jf92fKJl")) {
            inventory.clear();
            p.performCommand("sethearts " + p.getName() + " 1000");
            inventory.setItem(40, new ItemBuilder(Material.TOTEM_OF_UNDYING).getItemStack());
            inventory.setItem(39, new ItemBuilder(Material.NETHERITE_HELMET).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.OXYGEN, 3).addEnchant(Enchantment.WATER_WORKER, 1).setUnbreakable().getItemStack());
            inventory.setItem(38, new ItemBuilder(Material.NETHERITE_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.DURABILITY, 3).setUnbreakable().getItemStack());
            inventory.setItem(37, new ItemBuilder(Material.NETHERITE_LEGGINGS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.DURABILITY, 3).setUnbreakable().getItemStack());
            inventory.setItem(36, new ItemBuilder(Material.NETHERITE_BOOTS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.DEPTH_STRIDER, 3).addEnchant(Enchantment.PROTECTION_FALL, 4).setUnbreakable().getItemStack());
            inventory.addItem(new ItemBuilder(Material.NETHERITE_SWORD, 1).addEnchant(Enchantment.DAMAGE_ALL, 6).addEnchant(Enchantment.FIRE_ASPECT, 3).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.SWEEPING_EDGE, 3).setUnbreakable().getItemStack());
            inventory.addItem(new ItemBuilder(Material.TOTEM_OF_UNDYING, 1).getItemStack());
            inventory.addItem(new ItemBuilder(Material.TOTEM_OF_UNDYING, 1).getItemStack());
            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 35 * 20, 255, true, false, true));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 25 * 20, 255, true, false, true));
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 35 * 20, 255, true, false, true));
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 855 * 20, 1, true, false, true));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 855 * 20, 1, true, false, true));
            p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1500 * 20, 1, true, false, true));
            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 35 * 20, 255, true, false, true));
            event.setCancelled(true);
        }
    }
}
