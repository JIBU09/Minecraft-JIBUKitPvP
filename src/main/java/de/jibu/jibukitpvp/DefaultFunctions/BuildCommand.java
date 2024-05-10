package de.jibu.jibukitpvp.DefaultFunctions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.getScoreboardTags().contains("Builder")) {
                player.addScoreboardTag("Builder");
                player.sendMessage("§aSuccessfully set you in build mode!");
            } else {
                player.removeScoreboardTag("Builder");
                player.sendMessage("§cSuccessfully remove the building mode!");
            }
        } else {
            sender.sendMessage("§cYou have to be a player!");
        }
        return false;
    }
}
