package de.jibu.jibukitpvp.DefaultFunctions;

import de.jibu.jibukitpvp.Utilities.JavaScriptExecuterClass;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SummonDolyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        JavaScriptExecuterClass javaScriptExecuterClass = new JavaScriptExecuterClass();
        javaScriptExecuterClass.executeJavaScriptFile("C:/Users/Jim/Desktop/Programmieren/Minecraft/Plugins/PvPBot/index");
        sender.sendMessage("JavaScript-Datei wurde ausgeführt!");
        return true;
    }

}
