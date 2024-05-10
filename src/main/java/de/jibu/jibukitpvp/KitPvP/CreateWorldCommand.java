package de.jibu.jibukitpvp.KitPvP;

import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CreateWorldCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        WorldCreator worldCreator = new WorldCreator("ffa_world");
        worldCreator.createWorld();

        commandSender.sendMessage("Welt wird erstellt");

        return false;
    }
}
