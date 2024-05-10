package de.jibu.jibukitpvp.DefaultFunctions;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (!target.getScoreboardTags().contains("Combat")) {
                    if (!player.getScoreboardTags().contains("Combat")) {
                        double maxHealth = target.getMaxHealth();
                        target.setHealth(maxHealth);
                        target.setFoodLevel(20);
                        target.setSaturation(20);
                        player.sendMessage("§aSuccessfully healed!");
                        target.sendMessage("§aYou were healed!");
                    } else {
                        player.sendMessage("§cYou are in combat!");
                    }
                } else {
                    player.sendMessage("§cThe player is in combat!");
                }
            } else if (args.length == 0) {
                if (!player.getScoreboardTags().contains("Combat")) {
                    double maxHealth = player.getMaxHealth();
                    player.setHealth(maxHealth);
                    player.setFoodLevel(20);
                    player.setSaturation(20);
                    player.sendMessage("§aSuccessfully healed yourself!");
                } else {
                    player.sendMessage("§cYou are in combat!");
                }
            } else {
                player.sendMessage("§cUse: /heal [Player]");
            }
        } else {
            sender.sendMessage("§cYou have to be a player!");
        }
        return false;
    }
}
