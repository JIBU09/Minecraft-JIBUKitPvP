package de.jibu.jibukitpvp.LobbyMiniGames;

import de.jibu.jibukitpvp.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Random;

public class HoneyClicker implements Listener {

    static Random random = new Random();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        PotionEffect effect = event.getPlayer().getPotionEffect(PotionEffectType.ABSORPTION);
        HoneyClickerConfig honeyClickerConfig = new HoneyClickerConfig(player.getUniqueId());

        //Honey Block
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

        //Gold Bonus
        if (event.getPlayer().getWorld() == Bukkit.getWorld("world")) {
            if (block.getType().equals(Material.GOLD_BLOCK)) {
                event.setCancelled(true);
                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2 * 20 * 60, 4, true));
            }
        }

        //Diamond Block
        if (event.getPlayer().getWorld() == Bukkit.getWorld("world")) {
            if (block.getType().equals(Material.DIAMOND_BLOCK)) {
                event.setCancelled(true);
                if (honeyClickerConfig.hasBoughtSoup()) {
                    boostPlayerToSoup(player);
                } else {
                    if (honeyClickerConfig.getHoneyCount() >= 10000) {
                        honeyClickerConfig.setHoneyCount(honeyClickerConfig.getHoneyCount() - 10000);
                        honeyClickerConfig.setBoughtSoup(true);
                        StringBuilder actionBarText = new StringBuilder("§e");
                        actionBarText.append("-10.000 §6Honey §8| §7Total: §6" + honeyClickerConfig.getHoneyCount());
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionBarText.toString()));
                        boostPlayerToSoup(player);
                    }
                }
            }
        }

    }

    public void boostPlayerToSoup(Player player) {

        removeWalls(player);

        if (player.getScoreboardTags().contains("HoneySoup")) {
            player.removeScoreboardTag("HoneySoup");
        } else {
            player.addScoreboardTag("HoneySoup");
        }


        Location currentLocation = player.getLocation();
        Location targetLocation = new Location(currentLocation.getWorld(), 0, currentLocation.getY() + 2, 0);
        Vector direction = targetLocation.toVector().subtract(currentLocation.toVector()).normalize();
        double speed = 100;
        player.setVelocity(direction.multiply(speed));

        player.setGameMode(GameMode.CREATIVE);
        Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                player.setGameMode(GameMode.SURVIVAL);
            }
        }, 5L);

    }

    public void removeWalls(Player player) {

        for (int y = 34; y <= 36; y++) {
            for (int z = 0; z <= 2; z++) {
                Location blockLocation = player.getWorld().getBlockAt(-1, y, z).getLocation();
                player.sendBlockChange(blockLocation, Material.AIR, (byte) 0);
            }
        }

        for (int z = -3; z <= 0; z++) {
            Location blockLocation = player.getWorld().getBlockAt(-6, 35, z).getLocation();
            player.sendBlockChange(blockLocation, Material.AIR, (byte) 0);
        }

        for (int x = 2; x <= 3; x++) {
            for (int z = -5; z <= -3; z++) {
                Location blockLocation = player.getWorld().getBlockAt(x, 20, z).getLocation();
                //Byte 15 to make it Black
                player.sendBlockChange(blockLocation, Material.BLACK_CONCRETE, (byte) 15);
            }
        }


    }

}

