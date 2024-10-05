package de.jibu.jibukitpvp.LobbyMiniGames;

import de.jibu.jibukitpvp.DefaultFunctions.ItemBuilder;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class DropperFunction implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        if (p.getWorld() == Bukkit.getWorld("world")) {
            if (p.getWorld().getBlockAt(p.getLocation()).getType().equals(Material.WATER) && p.getLocation().getY() <= 33) {
                event.getPlayer().teleport(Objects.requireNonNull(Bukkit.getWorld("world")).getSpawnLocation());
                p.setLevel(p.getLevel() + 1);
                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1 , 0.5f);
                p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40 ,255, true, false, false));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 40 ,255, true, false, false));
                HoneyClickerConfig honeyClickerConfig = new HoneyClickerConfig(event.getPlayer().getUniqueId());
                honeyClickerConfig.setHoneyCount(event.getPlayer().getLevel() + honeyClickerConfig.getHoneyCount());

                StringBuilder actionBarText = new StringBuilder("§e");
                actionBarText.append("+" + event.getPlayer().getLevel() + " §6Honey §8| §7Total: §6" + honeyClickerConfig.getHoneyCount());
                event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionBarText.toString()));


                if (p.getMaxHealth() == 1) {
                    p.setMaxHealth(2);
                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1 , 2f);
                    p.getInventory().setItem(4, new ItemBuilder(Material.IRON_PICKAXE).setName("§6World Manager").setUnbreakable().getItemStack());
                    p.sendTitle("§c", "§6You can now return to the FFA Arena");
                } else if (p.getMaxHealth() <= 18) {
                    p.setMaxHealth(p.getMaxHealth() + 2);
                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1 , 0.5f);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.getEntity().setLevel(0);
        event.getEntity().setExp(0);
    }

}
