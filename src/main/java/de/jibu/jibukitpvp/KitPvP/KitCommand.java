package de.jibu.jibukitpvp.KitPvP;

import de.jibu.jibukitpvp.DefaultFunctions.Kits.OPPlayerKit;
import de.jibu.jibukitpvp.DefaultFunctions.Kits.PotionPlayerKit;
import de.jibu.jibukitpvp.DefaultFunctions.Kits.ShieldPlayerKit;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class KitCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 1) {
                if (p.getWorld() != Bukkit.getWorld("world")) {
                    if (!p.getScoreboardTags().contains("Combat")) {
                        if (args[0].equalsIgnoreCase("potion") || args[0].equalsIgnoreCase("potions")) {
                            PotionPlayerKit.PlayerPotionKit(p);
                            p.sendMessage("§aDu hast das §dPotion §aKit erhalten");
                        } else if (args[0].equalsIgnoreCase("op")) {
                            OPPlayerKit.GivePlayerOPKit(p);
                            p.sendMessage("§aDu hast das §6OP §aKit erhalten");
                        } else if (args[0].equalsIgnoreCase("shield")) {
                            ShieldPlayerKit.PlayerShieldKit(p);
                            p.sendMessage("§aDu hast das §6Shield §aKit erhalten");
                        }
                    } else {
                        p.sendMessage("§cDu bist grade in Combat!");
                    }
                } else {
                    p.sendMessage("§cDu kannst für diesen Command nicht in der Lobby sein");
                }

            } else {
                p.sendMessage("§cBitte nutze: /kit <potion(s)/crystal...>");
            }
        } else {
            sender.sendMessage("§cDu musst ein Spieler sein!");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if (args.length == 0) return list;
        if (args.length == 1) {
            list.add("OP");
            list.add("Potion");
            list.add("Shield");

        }

        ArrayList<String> completerList = new ArrayList<>();
        String currentarg = args[args.length - 1];
        for (String s : list) {
            String s1 = s.toLowerCase();
            if (s1.startsWith(currentarg)) {
                completerList.add(s);

            }
        }

        return completerList;
    }


}
