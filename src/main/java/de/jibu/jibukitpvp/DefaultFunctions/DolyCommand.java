package de.jibu.jibukitpvp.DefaultFunctions;

import de.jibu.jibukitpvp.Utilities.DolyConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DolyCommand implements CommandExecutor, TabCompleter {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("guard")) {
                    player.chat("guard");
                } else if (args[0].equalsIgnoreCase("tp")) {
                    player.chat("tp to me");
                } else if (args[0].equalsIgnoreCase("fightme")) {
                    player.chat("fight me");
                } else if (args[0].equalsIgnoreCase("honeyclicker")) {
                    player.chat("honey clicker");
                } else if (args[0].equalsIgnoreCase("stop")) {
                    player.chat("stop");
                } else if (args[0].equalsIgnoreCase("install") && player.isOp()) {
                    DolyConfig dolyConfig = new DolyConfig();
                    if (!dolyConfig.isInstalled()) {
                        player.sendMessage("§cPlease type: /doly install confirm");
                    } else {
                        player.sendMessage("§cDoly is already installed.");
                    }
                } else if (args[0].equalsIgnoreCase("uninstall") && player.isOp()) {
                    DolyConfig dolyConfig = new DolyConfig();
                    if (dolyConfig.isInstalled()) {
                        player.sendMessage("§cPlease type: /doly uninstall confirm");
                    } else {
                        player.sendMessage("§cDoly is not installed.");
                    }
                } else if (args[0].equalsIgnoreCase("join") && player.isOp()) {
                    try {
                        dolyJoin();
                        player.sendMessage("§aLetting Doly join");
                        player.sendMessage("§eOnly the server host can execute that command.");
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("fight")) {
                    if (args[1].equalsIgnoreCase("shield")) {
                        if (args[2].equalsIgnoreCase("1")) {
                            player.chat("Doly fight: shield 1");
                        } else if (args[2].equalsIgnoreCase("2")) {
                            player.chat("Doly fight: shield 2");
                        }
                    } else if (args[1].equalsIgnoreCase("potion")) {
                        if (args[2].equalsIgnoreCase("1")) {
                            player.chat("Doly fight: potion 1");
                        } else if (args[2].equalsIgnoreCase("2")) {
                            player.chat("Doly fight: potion 2");
                        }
                    }
                }
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("install") && player.isOp()) {
                    if (args[1].equalsIgnoreCase("confirm")) {
                        DolyConfig dolyConfig = new DolyConfig();
                        if (!dolyConfig.isInstalled()) {
                            player.sendMessage("§aInstalling Doly Bot.");
                            player.sendMessage("§eThis may take some time!");
                            dolyConfig.isInstalled(true);
                            downloadFromGitHub();
                        } else {
                            player.sendMessage("§cDoly is already installed.");
                        }
                    }
                } else if (args[0].equalsIgnoreCase("uninstall") && player.isOp()) {
                    if (args[1].equalsIgnoreCase("confirm")) {
                        DolyConfig dolyConfig = new DolyConfig();
                        if (dolyConfig.isInstalled()) {
                            player.sendMessage("§aUninstalling Doly Bot.");
                            dolyUnsinstall();
                        } else {
                            player.sendMessage("§cDoly is not installed.");
                        }
                    }
                }
            }
        } else {
            sender.sendMessage("§cDu musst ein Spieler sein!");
        }
        return false;
    }


    public static void downloadFromGitHub() {
        String URL = "https://github.com/JIBU09/Minecraft-PVP-Bot/archive/refs/heads/main.zip";
        String batchFileName = "plugins//JIBUKitPvP//Doly//DolyInstaller.bat";

        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URI(URL));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        //Minecraft Plugin I made to learn pvp and play with friends. It has a build in PVP Bot which can be installed ingame. Although it isn't finished.
        try {
            FileWriter writer = new FileWriter(batchFileName);
            writer.write("@echo off\n" +
                    "setlocal\n" +
                    "\n" +
                    "\n" +
                    "echo -----Waiting 30 seconds till the download is complete-----\n" +
                    "timeout /t 30 /nobreak >nul\n" +
                    "\n" +
                    ":startUnzipping\n" +
                    "if not exist \"%userprofile%\\Downloads\\Minecraft-PVP-Bot-main.zip\" (\n" +
                    "    echo !!---Error: File not found---!! \n" +
                    "    echo -----Trying again in 30 seconds-----\n" +
                    "    timeout /t 30 /nobreak >nul\n" +
                    "    goto startUnzipping\n" +
                    ")\n" +
                    "\n" +
                    "\n" +
                    "Call :UnZipFile \"%~dp0\" \"%userprofile%\\Downloads\\Minecraft-PVP-Bot-main.zip\"\n" +
                    "exit /b\n" +
                    "\n" +
                    ":UnZipFile <ExtractTo> <newzipfile>\n" +
                    "set vbs=\"%temp%\\_.vbs\"\n" +
                    "if exist %vbs% del /f /q %vbs%\n" +
                    "echo Set fso = CreateObject(\"Scripting.FileSystemObject\") >>%vbs%\n" +
                    "echo If NOT fso.FolderExists(%1) Then >>%vbs%\n" +
                    "echo     fso.CreateFolder(%1) >>%vbs%\n" +
                    "echo End If >>%vbs%\n" +
                    "echo set objShell = CreateObject(\"Shell.Application\") >>%vbs%\n" +
                    "echo set FilesInZip=objShell.NameSpace(%2).items >>%vbs%\n" +
                    "echo objShell.NameSpace(%1).CopyHere(FilesInZip) >>%vbs%\n" +
                    "echo Set fso = Nothing >>%vbs%\n" +
                    "echo Set objShell = Nothing\n" +
                    "cscript //nologo %vbs%\n" +
                    "if exist %vbs% del /f /q %vbs%");
            writer.close();
            System.out.println("Batch File Created: " + batchFileName);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(batchFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void dolyUnsinstall() {
        try {
            List<String> commands = new ArrayList<>();
            commands.add("powershell.exe");  // Startet PowerShell
            commands.add("-Command");  // Gibt an, dass es sich um PowerShell-Befehle handelt
            // Der gewünschte PowerShell-Befehl
            commands.add("Remove-Item 'plugins//JIBUKitPvP//Doly' -Recurse -Force");

            ProcessBuilder processBuilder = new ProcessBuilder(commands);
            processBuilder.redirectErrorStream(true);  // Leitet die Fehlerausgabe zum gleichen Stream wie die Standardausgabe um

            Process process = processBuilder.start();  // Startet den Prozess
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));  // Liest die Ausgabe
            String line;
            while ((line = reader.readLine()) != null) {  // Gibt die Ausgabe in der Konsole aus
                System.out.println(line);
            }

            int exitCode = process.waitFor();  // Wartet auf das Ende des Prozesses
            System.out.println("Exit Code: " + exitCode);  // Zeigt den Exit-Code an

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();  // Handhabt Ausnahmen
        }
    }

    public static void dolyJoin() throws IOException, InterruptedException {
        String batchFileName = "plugins//JIBUKitPvP//Doly//Minecraft-PVP-Bot-main//dolyLauncher.bat";
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(batchFileName));

    }


    public static void quickUnzipper() throws IOException {
        String batchFileName = "plugins//JIBUKitPvP//Doly//Minecraft-PVP-Bot-main//DolyQuickUnzipper.bat";
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(batchFileName));
    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if (args.length == 0) return list;
        if (args.length == 1) {
            list.add("guard");
            list.add("tp");
            list.add("fightme");
            list.add("honeyclicker");
            list.add("stop");
            list.add("fight");
            if (sender.isOp()) {
                list.add("install");
                list.add("uninstall");
                list.add("join");
            }

        }

        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("fight")) {
                list.add("shield");
                list.add("potion");
            } else return list;
        }

        if (args.length == 3) {
            if (args[0].equalsIgnoreCase("fight")) {
                list.add("1");
                list.add("2");
            } else return list;

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
