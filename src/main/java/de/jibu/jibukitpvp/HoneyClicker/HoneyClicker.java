package de.jibu.jibukitpvp.HoneyClicker;

import de.jibu.jibukitpvp.DefaultFunctions.ItemBuilder;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class HoneyClicker implements Listener {

    static Random random = new Random();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        PotionEffect effect = event.getPlayer().getPotionEffect(PotionEffectType.ABSORPTION);
        HoneyClickerConfig honeyClickerConfig = new HoneyClickerConfig(player.getUniqueId());
        if (event.getPlayer().getWorld() == Bukkit.getWorld("world")) {
            if (block.getType().equals(Material.HONEY_BLOCK)) {
                int zufall = random.nextInt(2000);
                switch (zufall) {
                    case 0:
                        if (effect == null) {
                            block.setType(Material.GOLD_BLOCK);
                        }
                        break;
                }
                StringBuilder actionBarText = new StringBuilder("§e");
                actionBarText.append("+1 §6Honey §8| §7Total: §6" + honeyClickerConfig.getHoneyCount());
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionBarText.toString()));
                event.setCancelled(true);
                honeyClickerConfig.addHoneyCount();
                if (effect != null) {
                    honeyClickerConfig.addHoneyCount();
                    honeyClickerConfig.addHoneyCount();
                    honeyClickerConfig.addHoneyCount();
                    honeyClickerConfig.addHoneyCount();
                    StringBuilder actionBarText1 = new StringBuilder("§6");
                    actionBarText1.append("+5 Honey §8| §7Total: §6" + honeyClickerConfig.getHoneyCount());
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionBarText1.toString()));
                }
            }
            if (effect != null) {
                if (block.getType().equals(Material.GOLD_BLOCK) || block.getType().equals(Material.HONEY_BLOCK)) {
                    block.setType(Material.HONEY_BLOCK);
                }
            }
        }
        if (event.getPlayer().getWorld() == Bukkit.getWorld("world")) {
            if (block.getType().equals(Material.GOLD_BLOCK)) {
                event.setCancelled(true);
                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2 * 20 * 60, 4, true));
            }
        }
    }
}
