package de.jibu.jibukitpvp.KitPvP;

import de.jibu.jibukitpvp.Lobby.WorldManager;
import de.jibu.jibukitpvp.Main;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.org.apache.commons.io.FileUtils;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class WorldReset implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        //Bukkit.getOnlinePlayers().forEach(player -> player.kickPlayer("§9FFA World Reset"));
        Bukkit.broadcastMessage("§9Die FFA World wird resetet");
        Bukkit.getOnlinePlayers().forEach(player -> player.getInventory().clear());
        Bukkit.getOnlinePlayers().forEach(player -> player.setGameMode(GameMode.ADVENTURE));
        Bukkit.getOnlinePlayers().forEach(player -> player.teleport(Objects.requireNonNull(Bukkit.getWorld("world")).getSpawnLocation()));
        WorldManager.hasReset = true;
        //Main.getPlugin().getConfig().set("isReset", true);
        try {
            File ffa = new File(Bukkit.getWorldContainer(), "ffa_world");
            FileUtils.deleteDirectory(ffa);

            ffa.mkdirs();

            new File(ffa, "data").mkdirs();
            new File(ffa, "datapacks").mkdirs();
            new File(ffa, "playerdata").mkdirs();
            new File(ffa, "poi").mkdirs();
            new File(ffa, "region").mkdirs();


        } catch (IOException e) {
            e.printStackTrace();
        }


        WorldCreator worldCreator = new WorldCreator("ffa_world");
        worldCreator.createWorld();
        Bukkit.getWorld("ffa_world").setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        Bukkit.getWorld("ffa_world").setGameRule(GameRule.DO_TRADER_SPAWNING, false);
        Bukkit.getWorld("ffa_world").setGameRule(GameRule.DO_PATROL_SPAWNING, false);
        Bukkit.getWorld("ffa_world").setGameRule(GameRule.DO_MOB_SPAWNING, false);
        Bukkit.getWorld("ffa_world").setGameRule(GameRule.KEEP_INVENTORY, true);
        Objects.requireNonNull(Bukkit.getWorld("ffa_world")).setBiome(0, 0, Biome.DESERT);

        Main.getPlugin().saveConfig();
        //Bukkit.spigot().restart();

        return false;
    }
}
