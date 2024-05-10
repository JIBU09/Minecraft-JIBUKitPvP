package de.jibu.jibukitpvp.HoneyClicker;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class HoneyAreaResistance implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getEntity().getWorld() == Bukkit.getWorld("world")) {
            if (event.getEntity().getLocation().getY() >= 34 && event.getEntity().getLocation().getY() <= 35) {
                event.setCancelled(true);
            }
        }
    }

}
