package de.jibu.jibukitpvp.LobbyMiniGames;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetHoneyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (player.hasPermission("kitpvp.honey")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    HoneyClickerConfig honeyClickerConfig = new HoneyClickerConfig(target.getUniqueId());
                    player.sendMessage("§a" + target.getDisplayName() + " has " + honeyClickerConfig.getHoneyCount() + " honey.");
                } else {
                    HoneyClickerConfig honeyClickerConfig = new HoneyClickerConfig(player.getUniqueId());
                    player.sendMessage("§aYou have " + honeyClickerConfig.getHoneyCount() + " honey.");
                }
            } else if (args.length == 0) {
                HoneyClickerConfig honeyClickerConfig = new HoneyClickerConfig(player.getUniqueId());
                player.sendMessage("§aYou have " + honeyClickerConfig.getHoneyCount() + " honey.");
            } else {
                player.sendMessage("§cUse: /gethoney [Player]");
            }
        } else {
            sender.sendMessage("§cYou have to be a player!");
        }
        return false;
    }

}
