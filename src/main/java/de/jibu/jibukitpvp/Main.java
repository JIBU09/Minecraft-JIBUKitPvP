package de.jibu.jibukitpvp;

import de.jibu.jibukitpvp.DefaultFunctions.*;
import de.jibu.jibukitpvp.DefaultFunctions.Kits.OPBotKit;
import de.jibu.jibukitpvp.DefaultFunctions.Kits.PotionBotKit;
import de.jibu.jibukitpvp.DefaultFunctions.Kits.ShieldBotKit;
import de.jibu.jibukitpvp.HoneyClicker.*;
import de.jibu.jibukitpvp.KitPvP.CreateWorldCommand;
import de.jibu.jibukitpvp.KitPvP.KitCommand;
import de.jibu.jibukitpvp.Lobby.AntiBreak;
import de.jibu.jibukitpvp.Lobby.WarpSign;
import de.jibu.jibukitpvp.KitPvP.WorldReset;
import de.jibu.jibukitpvp.Lobby.DropperFunction;
import de.jibu.jibukitpvp.Lobby.WorldManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main plugin;


    @Override
    public void onLoad() {
    }

    @Override
    public void onEnable() {
        plugin = this;

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new LifeStealFunction(), this);
        pm.registerEvents(new ItemFunctions(), this);
        pm.registerEvents(new CombatLogging(), this);
        //pm.registerEvents(new AutoAnchor(), this);
        //pm.registerEvents(new AutoTotem(), this);
        pm.registerEvents(new AntiBreak(), this);
        pm.registerEvents(new WarpSign(), this);
        pm.registerEvents(new PotionBotKit(), this);
        pm.registerEvents(new OPBotKit(), this);
        pm.registerEvents(new ShieldBotKit(), this);
        pm.registerEvents(new DropperFunction(), this);
        pm.registerEvents(new WorldManager(), this);
        pm.registerEvents(new HoneyClicker(), this);
        pm.registerEvents(new HoneyAreaResistance(), this);
        this.getCommand("sethearts").setExecutor(new SetHealthCommand());
        this.getCommand("withdraw").setExecutor(new WithDraw());
        this.getCommand("reset").setExecutor(new WorldReset());
        this.getCommand("heal").setExecutor(new HealCommand());
        //this.getCommand("createworld").setExecutor(new CreateWorldCommand());
        this.getCommand("kit").setExecutor(new KitCommand());
        this.getCommand("build").setExecutor(new BuildCommand());
        this.getCommand("gethoney").setExecutor(new GetHoneyCommand());
        this.getCommand("sethoney").setExecutor(new SetHoneyCommand());
        this.getCommand("addhoney").setExecutor(new AddHoneyCommand());
        this.getCommand("removehoney").setExecutor(new RemoveHoneyCommand());
        this.getCommand("doly").setExecutor(new DolyCommand());
        // TODO: Edit CrystalBotKit
        //SUS Seed: 7363601127887533281

    }

    @Override
    public void onDisable() {
        saveConfig();
        // Plugin shutdown logic
    }

    public static Main getPlugin() {
        return plugin;
    }
}
