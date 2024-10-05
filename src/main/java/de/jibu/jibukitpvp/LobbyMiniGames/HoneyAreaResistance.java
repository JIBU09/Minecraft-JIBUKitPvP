package de.jibu.jibukitpvp.LobbyMiniGames;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HoneyAreaResistance implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        if (event.getEntity().getWorld() == Bukkit.getWorld("world")) {
            if (entity.getLocation().getY() >= 34 && entity.getLocation().getY() <= 37 ||
                    entity.getLocation().getY() >= 28 & entity.getLocation().getY() <= 31) {
                event.setCancelled(true);
            }
        }
    }

}
