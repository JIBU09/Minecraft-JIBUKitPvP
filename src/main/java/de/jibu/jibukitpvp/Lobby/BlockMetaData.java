package de.jibu.jibukitpvp.Lobby;

import de.jibu.jibukitpvp.Main;
import org.bukkit.Sound;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlockMetaData implements Listener {

    public static void addMetaData(BlockState state, String dataName) {
        state.setMetadata(dataName, new FixedMetadataValue(Main.getPlugin(), 1));
    }

    public static void removeMetaData(BlockState state, String dataName) {
        state.removeMetadata(dataName, Main.getPlugin());
    }

    public static void hasMetaData(BlockState state, String dataName) {
        state.hasMetadata(dataName);
    }


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getBlock().getState().hasMetadata("noDrop")) {
            event.setDropItems(false);
            event.setCancelled(true);
        } else if (event.getBlock().getState().hasMetadata("unbreakable")) {
            event.setDropItems(false);
            event.setCancelled(true);
        }


    }


    @EventHandler
    public void onBlockDropItem(BlockDropItemEvent event) {
        if (event.getBlock().getState().hasMetadata("noDrop")) {
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (event.getPlayer().getWorld().getBlockAt(event.getPlayer().getLocation()).getState().hasMetadata("blood")) {
            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20,4, true, false, false));

        }
    }
}
