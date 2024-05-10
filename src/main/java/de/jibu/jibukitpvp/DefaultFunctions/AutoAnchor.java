package de.jibu.jibukitpvp.DefaultFunctions;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class AutoAnchor implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Block block = event.getBlockPlaced();

        if (block.getType() == Material.RESPAWN_ANCHOR) {
            block.setType(Material.AIR);
            block.getWorld().playSound(event.getBlockPlaced().getLocation(), Sound.BLOCK_RESPAWN_ANCHOR_CHARGE, 1 ,1);
            TNTPrimed anchor = (TNTPrimed) block.getWorld().spawnEntity(event.getBlockPlaced().getLocation(), EntityType.PRIMED_TNT);
            anchor.setFuseTicks(0);
            anchor.setInvulnerable(true);
            anchor.setYield(5);
            anchor.setIsIncendiary(true);
        }
    }
}
