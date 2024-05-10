package de.jibu.jibukitpvp.DefaultFunctions;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class LifeStealFunction implements Listener {

    public LifeStealFunction() {

    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player p = event.getEntity();
        Player killer = event.getEntity().getKiller();


        p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(p.getMaxHealth() - 2);
        if (killer != null && killer.getMaxHealth() <= 38) {
            killer.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(killer.getMaxHealth() + 2);
        }
        if (p.getMaxHealth() == 1 || p.getMaxHealth() == 0) {
            p.setMaxHealth(1);
            p.teleport(Objects.requireNonNull(Bukkit.getWorld("world")).getSpawnLocation());
            p.playSound(p.getLocation(), Sound.ENTITY_WITHER_DEATH, 1, 1);
        }
        if (p.getMaxHealth() == 1) {
            event.setDeathMessage(null);
            if (killer != null) {
                Bukkit.broadcastMessage("§6" + p.getDisplayName() + " §cdied because of §6" + killer.getDisplayName());
                p.playSound(p.getLocation(), Sound.ENTITY_WITHER_DEATH, 1, 1);
            }
        }
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        NickCommand.SkinChanger(event.getPlayer());
        event.getPlayer().setGameMode(GameMode.ADVENTURE);
        event.getPlayer().teleport(Objects.requireNonNull(Bukkit.getWorld("world")).getSpawnLocation());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (event.getPlayer().getScoreboardTags().contains("Combat")) {
            event.getPlayer().setHealth(0);
            event.getPlayer().removeScoreboardTag("Combat");
        }
        event.getPlayer().teleport(Objects.requireNonNull(Bukkit.getWorld("world")).getSpawnLocation());
    }
}


