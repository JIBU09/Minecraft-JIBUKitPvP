package de.jibu.jibukitpvp.DefaultFunctions;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class AutoTotem implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        try {
            Player player = (Player) event.getEntity();
            if (player.getHealth() >= 0) {
                player.getInventory().setItem(40, new ItemBuilder(Material.TOTEM_OF_UNDYING).getItemStack());
            }
        } catch (Exception exception) {
            return;
        }
    }
}
