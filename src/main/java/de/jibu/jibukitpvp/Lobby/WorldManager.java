package de.jibu.jibukitpvp.Lobby;

import de.jibu.jibukitpvp.DefaultFunctions.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;

import java.util.Objects;


public class WorldManager implements Listener {

    public static boolean hasReset = false;

    public static boolean getReset() {
        return hasReset;
    }


    public static void WorldManager(HumanEntity p) {
        if (!hasReset) {
            Inventory managerReset = Bukkit.createInventory(null, 9, "§6World Manager");
            managerReset.setItem(0, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").getItemStack());
            managerReset.setItem(1, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").getItemStack());
            managerReset.setItem(2, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").getItemStack());
            managerReset.setItem(3, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").getItemStack());
            managerReset.setItem(4, new ItemBuilder(Material.BARRIER).setName("§cReset FFA World").getItemStack());
            managerReset.setItem(5, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").getItemStack());
            managerReset.setItem(6, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").getItemStack());
            managerReset.setItem(7, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").getItemStack());
            managerReset.setItem(8, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").getItemStack());
            p.openInventory(managerReset);

        } else {
            Inventory manager = Bukkit.createInventory(null, 9, "§6World Manager");
            manager.setItem(0, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").getItemStack());
            manager.setItem(1, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").getItemStack());
            manager.setItem(2, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").getItemStack());
            manager.setItem(3, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").getItemStack());
            manager.setItem(4, new ItemBuilder(Material.PLAYER_HEAD).setName("§aTeleport to FFA World").setSkullBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzY5MTk2YjMzMGM2Yjg5NjJmMjNhZDU2MjdmYjZlY2NlNDcyZWFmNWM5ZDQ0Zjc5MWY2NzA5YzdkMGY0ZGVjZSJ9fX0=").setName("§c").getItemStack());
            manager.setItem(5, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").getItemStack());
            manager.setItem(6, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").getItemStack());
            manager.setItem(7, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").getItemStack());
            manager.setItem(8, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName("§c").getItemStack());
            p.openInventory(manager);
        }

    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if (p.getMaxHealth() == 1) {
            p.getInventory().clear();
            p.sendTitle("§c", "§cGain one heart to continue playing");
        } else {
            p.getInventory().clear();
            p.getInventory().setItem(4, new ItemBuilder(Material.IRON_PICKAXE).setName("§6World Manager").setUnbreakable().getItemStack());
            p.setGameMode(GameMode.SURVIVAL);
        }

        if (event.getPlayer().getDisplayName().equalsIgnoreCase("Doly")) {
            event.getPlayer().setAllowFlight(true);
            event.getPlayer().setFlying(true);
        }

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        try {
            if (Objects.requireNonNull(event.getWhoClicked().getItemInHand().getItemMeta()).getDisplayName().equals("§6World Manager") && event.getCurrentItem().getType() == Material.IRON_PICKAXE & !
                    event.getWhoClicked().hasCooldown(Material.IRON_PICKAXE) && event.getWhoClicked().getWorld() == Bukkit.getWorld("world") && event.getAction().equals(Action.RIGHT_CLICK_AIR) ||
                    event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                WorldManager(event.getWhoClicked());
                event.getWhoClicked().getCooldown(Material.IRON_PICKAXE);
                event.setCancelled(true);
            }
        } catch (Exception e) {
            return;
        }

        if (event.getView().getTitle().equalsIgnoreCase("§6World Manager")) {
            if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                event.getWhoClicked().teleport(Objects.requireNonNull(Bukkit.getWorld("ffa_world")).getSpawnLocation());
                event.getWhoClicked().setGameMode(GameMode.SURVIVAL);
                event.getWhoClicked().getInventory().clear();
            } else if (event.getCurrentItem().getType() == Material.BARRIER) {
                Player player = (Player) event.getWhoClicked();
                player.performCommand("reset");
                player.getInventory().setItem(4, new ItemBuilder(Material.IRON_PICKAXE).setName("§6World Manager").setUnbreakable().getItemStack());
                Bukkit.getOnlinePlayers().forEach(players -> players.getInventory().setItem(4, new ItemBuilder(Material.IRON_PICKAXE).setName("§6World Manager").setUnbreakable().getItemStack()));
                hasReset = true;

            }
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getPlayer().getWorld() == Bukkit.getWorld("world")) {
            if (!event.getPlayer().getScoreboardTags().contains("Builder")) {
            event.getPlayer().setGameMode(GameMode.SURVIVAL);
            }
        }
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        if (event.getPlayer().getWorld() == Bukkit.getWorld("world")) {
            if (!event.getPlayer().getScoreboardTags().contains("Builder")) {
                event.getPlayer().setGameMode(GameMode.SPECTATOR);
                event.getPlayer().teleport(event.getPlayer().getLocation().add(0, 0.05, 0));
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        try {
            if (Objects.requireNonNull(event.getPlayer().getItemInHand().getItemMeta()).getDisplayName().equals("§6World Manager") && event.getItem().getType() == Material.IRON_PICKAXE & !
                    event.getPlayer().hasCooldown(Material.IRON_PICKAXE) && event.getPlayer().getWorld() == Bukkit.getWorld("world") && event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                WorldManager(event.getPlayer());
                event.getPlayer().setCooldown(Material.IRON_PICKAXE, 20);
                event.setCancelled(true);
            } else return;
        } catch (Exception e) {
            return;
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        event.getPlayer().setGameMode(GameMode.SURVIVAL);
        Player p = event.getPlayer();
        if (p.getMaxHealth() == 1) {
            p.getInventory().clear();
            p.sendTitle("§c", "§cGain one heart to continue playing");
        } else {
            p.getInventory().clear();
            p.getInventory().setItem(4, new ItemBuilder(Material.IRON_PICKAXE).setName("§6World Manager").setUnbreakable().getItemStack());
        }
    }
}

