package de.jibu.jibukitpvp.DefaultFunctions;

import de.jibu.jibukitpvp.Lobby.BlockMetaData;
import de.jibu.jibukitpvp.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class DeathTrapCommand implements CommandExecutor {

    private final Map<Location, Material> originalBlocks = new HashMap<>();
    public final Map<ArmorStand, Integer> deathStandCooldown = new HashMap<>();

    private static final int DEATHSTAND_COOLDOWN = 10 * 20;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player p = (Player) sender;

        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                Location playerLocation = target.getLocation();
                ArmorStand deathstand = (ArmorStand) target.getWorld().spawnEntity(target.getLocation(), EntityType.ARMOR_STAND);
                deathstand.setInvisible(true);
                deathstand.setInvulnerable(true);
                deathstand.setSmall(true);
                target.setPassenger(deathstand);
                target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10 * 20, 250, true, false, false));
                Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                    deathStandCooldown.remove(deathstand);
                    deathstand.remove();
                }, DEATHSTAND_COOLDOWN);
                for (int x = -2; x <= 2; x++) {
                    for (int y = 0; y <= 2; y++) {
                        for (int z = -2; z <= 2; z++) {
                            // Berechne die Entfernung zum Mittelpunkt der Sphäre
                            double distance = Math.sqrt(x * x + y * y + z * z);

                            // Wenn die Entfernung kleiner oder gleich 2 und größer als 1 ist, setze den Block zu Glas
                            // Wenn die Entfernung kleiner oder gleich 1 ist, setze den Block zu Luft
                            Location blockLocation = playerLocation.clone().add(x, y, z);
                            Block block = blockLocation.getBlock();

                            if (distance <= 2 && distance > 1) {
                                originalBlocks.put(blockLocation, block.getType());
                                // Setze die Härte und Widerstandskraft des Blocks
                                target.sendBlockChange(blockLocation, Material.BEDROCK, (byte) 0);
                                block.getState().setBlockData(Bukkit.createBlockData(Material.BEDROCK));
                            } else if (distance <= 1) {
                                originalBlocks.put(blockLocation, block.getType());
                                // Setze die Härte und Widerstandskraft des Blocks
                                block.setType(Material.AIR);
                                block.getState().setBlockData(Bukkit.createBlockData(Material.AIR));
                                BlockMetaData.addMetaData(block.getState(), "unbreakable");
                            }
                        }
                    }
                }

                Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                    // Ersetze die Sphäre mit den ursprünglichen Blöcken
                    for (Location blockLocation : originalBlocks.keySet()) {
                        Block block = blockLocation.getBlock();
                        block.setType(originalBlocks.get(blockLocation));
                        target.sendBlockChange(blockLocation, block.getType(), (byte) 0);
                    }

                    // Entferne die gespeicherten ursprünglichen Blöcke
                    originalBlocks.clear();

                    // Teleportiere den Spieler zur ursprünglichen Position
                }, DEATHSTAND_COOLDOWN); // 10 Sekunden Verzögerung (1 Sekunde = 20 Ticks)
            }
        }
        return false;
    }
}



