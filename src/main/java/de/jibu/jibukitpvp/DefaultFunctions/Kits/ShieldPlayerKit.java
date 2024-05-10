package de.jibu.jibukitpvp.DefaultFunctions.Kits;

import de.jibu.jibukitpvp.DefaultFunctions.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ShieldPlayerKit {

    public static void PlayerShieldKit(Player p) {
        p.getInventory().clear();
        p.getInventory().setItem(40, new ItemBuilder(Material.SHIELD).getItemStack());
        p.getInventory().setItem(39, new ItemBuilder(Material.DIAMOND_HELMET).getItemStack());
        p.getInventory().setItem(38, new ItemBuilder(Material.DIAMOND_CHESTPLATE).getItemStack());
        p.getInventory().setItem(37, new ItemBuilder(Material.DIAMOND_LEGGINGS).getItemStack());
        p.getInventory().setItem(36, new ItemBuilder(Material.DIAMOND_BOOTS).getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_SWORD).getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.CROSSBOW).getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_AXE).getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.BOW).getItemStack());
        p.getInventory().addItem(new ItemBuilder(Material.ARROW, 5).getItemStack());

    }

}
