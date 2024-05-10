package de.jibu.jibukitpvp.DefaultFunctions.Kits;

import de.jibu.jibukitpvp.DefaultFunctions.ItemBuilder;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionPlayerKit {

    public static void PlayerPotionKit(Player p) {
        p.getInventory().clear();
        p.getInventory().setItem(40, new ItemBuilder(Material.TOTEM_OF_UNDYING).getItemStack());
        p.getInventory().setItem(39, new ItemBuilder(Material.NETHERITE_HELMET).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.OXYGEN, 3).addEnchant(Enchantment.WATER_WORKER, 1).addEnchant(Enchantment.MENDING, 1).getItemStack());
        p.getInventory().setItem(38, new ItemBuilder(Material.NETHERITE_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.MENDING, 1).getItemStack());
        p.getInventory().setItem(37, new ItemBuilder(Material.NETHERITE_LEGGINGS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.MENDING, 1).getItemStack());
        p.getInventory().setItem(36, new ItemBuilder(Material.NETHERITE_BOOTS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.DEPTH_STRIDER, 3).addEnchant(Enchantment.PROTECTION_FALL, 4).addEnchant(Enchantment.MENDING, 1).getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.NETHERITE_SWORD, 1).addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.FIRE_ASPECT, 2).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.SWEEPING_EDGE, 3).addEnchant(Enchantment.MENDING, 1).addEnchant(Enchantment.SOUL_SPEED, 3).getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.TOTEM_OF_UNDYING).getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_APPLE, 64).getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.ENDER_PEARL, 16).getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 90*20, 1)).setPotionColor(Color.MAROON).setName("§fSplash Potion of Strength").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 90*20, 1)).setPotionColor(Color.GRAY).setName("§fSplash Potion of Swiftness").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 480*20, 0)).setPotionColor(Color.ORANGE).setName("§fSplash Potion of Fire Resistance").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.EXPERIENCE_BOTTLE, 64).getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.EXPERIENCE_BOTTLE, 64).getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.ENDER_PEARL, 16).getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.TOTEM_OF_UNDYING, 1).getItemStack());

        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 90*20, 1)).setPotionColor(Color.MAROON).setName("§fSplash Potion of Strength").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 90*20, 1)).setPotionColor(Color.MAROON).setName("§fSplash Potion of Strength").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 90*20, 1)).setPotionColor(Color.MAROON).setName("§fSplash Potion of Strength").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 90*20, 1)).setPotionColor(Color.MAROON).setName("§fSplash Potion of Strength").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 90*20, 1)).setPotionColor(Color.MAROON).setName("§fSplash Potion of Strength").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 90*20, 1)).setPotionColor(Color.MAROON).setName("§fSplash Potion of Strength").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 90*20, 1)).setPotionColor(Color.MAROON).setName("§fSplash Potion of Strength").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.ENDER_PEARL, 16).getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.ENDER_PEARL, 16).getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 90*20, 1)).setPotionColor(Color.GRAY).setName("§fSplash Potion of Swiftness").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 90*20, 1)).setPotionColor(Color.GRAY).setName("§fSplash Potion of Swiftness").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 90*20, 1)).setPotionColor(Color.GRAY).setName("§fSplash Potion of Swiftness").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 90*20, 1)).setPotionColor(Color.GRAY).setName("§fSplash Potion of Swiftness").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 90*20, 1)).setPotionColor(Color.GRAY).setName("§fSplash Potion of Swiftness").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 90*20, 1)).setPotionColor(Color.GRAY).setName("§fSplash Potion of Swiftness").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 90*20, 1)).setPotionColor(Color.GRAY).setName("§fSplash Potion of Swiftness").getItemStack());

        p.getInventory().addItem(new ItemBuilder(Material.ENDER_PEARL, 16).getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 480*20, 0)).setPotionColor(Color.ORANGE).setName("§fSplash Potion of Fire Resistance").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 480*20, 0)).setPotionColor(Color.ORANGE).setName("§fSplash Potion of Fire Resistance").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 480*20, 0)).setPotionColor(Color.ORANGE).setName("§fSplash Potion of Fire Resistance").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 90*20, 1)).setPotionColor(Color.MAROON).setName("§fSplash Potion of Strength").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 90*20, 1)).setPotionColor(Color.GRAY).setName("§fSplash Potion of Swiftness").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 90*20, 1)).setPotionColor(Color.MAROON).setName("§fSplash Potion of Strength").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.SPLASH_POTION).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 90*20, 1)).setPotionColor(Color.GRAY).setName("§fSplash Potion of Swiftness").getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_APPLE, 64).getItemStack());
    }

}
