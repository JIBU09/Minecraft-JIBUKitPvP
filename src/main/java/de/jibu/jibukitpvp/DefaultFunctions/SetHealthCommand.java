package de.jibu.jibukitpvp.DefaultFunctions;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHealthCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (args.length == 2) {
            Player t = Bukkit.getPlayer(args[0]);
            Double health = Double.valueOf(args[1]);
            t.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(health);
            p.sendMessage("§aDer Spieler hat nun " + health + " HP");
        } else {
            p.sendMessage("§cBitte nutze /sethearts <Player> <Health[Double]>");
        }
        return false;
    }
}
