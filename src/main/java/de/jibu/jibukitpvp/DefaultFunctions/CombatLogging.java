package de.jibu.jibukitpvp.DefaultFunctions;

import de.jibu.jibukitpvp.Main;
import net.minecraft.server.v1_16_R3.PacketPlayInClientCommand;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class CombatLogging implements Listener {

    private int taskID;

    private void respawn(final Player player, int time) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                if (player.isDead()) {
                    ((CraftPlayer) player).getHandle().playerConnection.a(new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN));
                }
            }
        }, time * 20);
    }


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        respawn(event.getEntity(), 15);
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        Entity damager = event.getDamager();


        if (entity instanceof Player && damager instanceof Player) {
            if (!damager.getScoreboardTags().contains("Combat") & !damager.getScoreboardTags().contains("Combat")) {
                taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
                    int timer = 15;

                    @Override
                    public void run() {
                        if (timer == 15) {
                            entity.sendMessage("§cYou're now in Combat");
                            entity.sendMessage("§cDo §lNOT Logout");
                            entity.addScoreboardTag("Combat");

                            damager.sendMessage("§cYou're now in Combat");
                            damager.sendMessage("§cDo §lNOT Logout");
                            damager.addScoreboardTag("Combat");
                        }


                        if (timer == 0) {
                            damager.removeScoreboardTag("Combat");
                            entity.removeScoreboardTag("Combat");

                            damager.sendMessage("§cYou're now out of Combat");
                            entity.sendMessage("§cYou're now out of Combat");

                            Bukkit.getScheduler().cancelTask(taskID);
                            return;
                        }

                        timer--;

                    }


                }, 0, 20);
            } else return;
        }
    }
}


