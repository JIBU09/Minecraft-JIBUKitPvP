package de.jibu.jibukitpvp.HoneyClicker;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetHoneyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 2) {
                Player target = Bukkit.getPlayer(args[0]);
                int honey = Integer.parseInt(args[1]);
                HoneyClickerConfig honeyClickerConfig = new HoneyClickerConfig(target.getUniqueId());
                honeyClickerConfig.setHoneyCount(honey);
                player.sendMessage("§a" + target.getDisplayName() + " now has " + honeyClickerConfig.getHoneyCount() + " honey.");
            } else {
                player.sendMessage("§cUse: /sethoney <Player>");
            }
        } else {
            sender.sendMessage("§cYou have to be a player!");
        }
        return false;
    }

}

