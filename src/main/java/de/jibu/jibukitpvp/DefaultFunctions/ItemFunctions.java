package de.jibu.jibukitpvp.DefaultFunctions;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class ItemFunctions implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        Player p = event.getPlayer();
        if (p.getItemInHand().getType() == Material.NETHER_STAR) {
            if (Objects.requireNonNull(event.getPlayer().getInventory()
                    .getItemInMainHand().getItemMeta()).getDisplayName().equals("§cHeart")) {
                if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    if (p.getMaxHealth() <= 38) {
                        p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(p.getMaxHealth() + 2);
                        p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
                    } else p.sendMessage("§cYou can't gain more than 20 hearts");

                }
            }
        }
    }
}
