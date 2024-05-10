package de.jibu.jibukitpvp.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class AntiBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player p = event.getPlayer();
        if (event.getPlayer().getWorld() == Bukkit.getWorld("world")) {
            if (!p.getScoreboardTags().contains("Builder") & p.getGameMode() == GameMode.SURVIVAL) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player p = event.getPlayer();
        if (event.getPlayer().getWorld() == Bukkit.getWorld("world")) {
            if (!p.getScoreboardTags().contains("Builder") & p.getGameMode() == GameMode.SURVIVAL) {
                event.setCancelled(true);
            }
        }
    }

}

