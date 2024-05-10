package de.jibu.jibukitpvp.Lobby;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class WarpSign implements Listener {

    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        String s = event.getLine(0);
        if (s.equalsIgnoreCase("[ffawarp]")) {
            event.setLine(0, "");
            event.setLine(1, "§7[§9Warp§7]");
            event.setLine(2, "§9FFA Arena Warp");
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() == null) return;

        if (event.getClickedBlock().getState() instanceof Sign) {
            String warp = ((Sign) event.getClickedBlock().getState()).getLine(2);

            if (warp.equalsIgnoreCase("§9FFA Arena Warp")){
                event.getPlayer().teleport(Objects.requireNonNull(Bukkit.getWorld("ffa_world")).getSpawnLocation());
                event.getPlayer().setGameMode(GameMode.SURVIVAL);
                event.getPlayer().getInventory().clear();
            }
        }
    }
}
