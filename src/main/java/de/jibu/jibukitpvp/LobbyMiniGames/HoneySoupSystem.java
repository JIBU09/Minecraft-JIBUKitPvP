package de.jibu.jibukitpvp.LobbyMiniGames;

import de.jibu.jibukitpvp.DefaultFunctions.ItemBuilder;
import de.jibu.jibukitpvp.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;

public class HoneySoupSystem implements Listener {

    private final Main plugin;

    /*
    Hard Difficulty:
    Amount of dropped items makes the % damage (34 Dropped Mushrooms = 34% of HP)
    Sword is always 50. Sword will be regained. Also you have 2 Swords.
     */


    //Easy
    private final int x1 = -5, y1 = 29, z1 = 7;
    private final int x2 = -2, y2 = 28, z2 = 3;

    private final int ff_x1 = -5, ff_y1 = 33, ff_z1 = 6;
    private final int ff_x2 = -2, ff_y2 = 30, ff_z2 = 3;

    //Middle
    private final int mf_x1 = -6, mf_y1 = 32, mf_z1 = 0;
    private final int mf_x2 = -6, mf_y2 = 31, mf_z2 = -3;

    private final int m_x1 = -6, m_y1 = 29, m_z1 = -3;
    private final int m_x2 = -1, m_y2 = 28, m_z2 = 0;

    //Hard
    private final int hf_x1 = 3, hf_y1 = 28, hf_z1 = -3;
    private final int hf_x2 = 2, hf_y2 = 22, hf_z2 = -5;

    private final int h_x1 = 10, h_y1 = 19, h_z1 = -15;
    private final int h_x2 = -12, h_y2 = 0, h_z2 = 7;


    public HoneySoupSystem(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item != null && item.getType() == Material.MUSHROOM_STEW && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasDisplayName() && meta.getDisplayName().equals("§6Honey Soup")) {
                if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    if (player.getWorld().getName().equals("world")) {
                        useSoup(player);
                        event.setCancelled(true);
                    }

                }
            }
        }
    }

    private void useSoup(Player player) {
        double maxHealth = player.getMaxHealth();
        double healAmount = maxHealth * 0.30;
        if (player.getHealth() + healAmount >= maxHealth) {
            player.setHealth(maxHealth);
        } else {
            player.setHealth(player.getHealth() + healAmount);
        }
        player.setItemInHand(new ItemBuilder(Material.BOWL).setName("§fEmpty Bowl").getItemStack());

    }


    @EventHandler(ignoreCancelled = true)
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItemDrop().getItemStack();

        // Honey Soup
        if (item != null && item.getType() == Material.MUSHROOM_STEW && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasDisplayName() && meta.getDisplayName().equals("§6Honey Soup")) {
                event.getItemDrop().remove();
            }
        }

        // Empty Bowl
        if (item != null && item.getType() == Material.BOWL && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasDisplayName() && meta.getDisplayName().equals("§fEmpty Bowl")) {
                event.getItemDrop().remove();
            }
        }


        //Middle Zone//

        //Red Mushroom in Middle Zone
        if (item != null && item.getType() == Material.RED_MUSHROOM && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasDisplayName() && meta.getDisplayName().equals("§cRed Mushroom")) {
                if (isInMiddleZone(player) || isInMiddleZoneFall(player)) {
                    event.setCancelled(true);
                }
            }
        }

        //Brown Mushroom in Middle Zone
        if (item != null && item.getType() == Material.BROWN_MUSHROOM && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasDisplayName() && meta.getDisplayName().equals("§6Brown Mushroom")) {
                if (isInMiddleZone(player) || isInMiddleZoneFall(player)) {
                    event.setCancelled(true);
                }
            }
        }

        //Stone Sword in Middle Zone
        if (item != null && item.getType() == Material.STONE_SWORD && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasDisplayName() && meta.getDisplayName().equals("§fStone Sword")) {
                if (isInMiddleZone(player) || isInMiddleZoneFall(player)) {
                    event.setCancelled(true);
                }
            }
        }

        //Hard Zone//

        //Red Mushroom in Hard Zone
        if (item != null && item.getType() == Material.RED_MUSHROOM && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasDisplayName() && meta.getDisplayName().equals("§cRed Mushroom")) {
                if (isInHardZone(player) || isInHardZoneFall(player)) {

                    double maxHealth = player.getMaxHealth();
                    double damageAmount = maxHealth * ((double) event.getItemDrop().getItemStack().getAmount() / 100);
                    player.damage(damageAmount);
                    player.playSound(event.getPlayer().getLocation(), Sound.ENTITY_CAT_HISS, 1, 1);

                    event.setCancelled(true);
                }
            }
        }

        //Brown Mushroom in Hard Zone
        if (item != null && item.getType() == Material.BROWN_MUSHROOM && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasDisplayName() && meta.getDisplayName().equals("§6Brown Mushroom")) {
                if (isInHardZone(player) || isInHardZoneFall(player)) {

                    double maxHealth = player.getMaxHealth();
                    double damageAmount = maxHealth * ((double) event.getItemDrop().getItemStack().getAmount() / 100);
                    player.damage(damageAmount);
                    player.playSound(event.getPlayer().getLocation(), Sound.ENTITY_CAT_HISS, 1, 1);

                    event.setCancelled(true);
                }
            }
        }

        //Stone Sword in Hard Zone
        if (item != null && item.getType() == Material.STONE_SWORD && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasDisplayName() && meta.getDisplayName().equals("§fStone Sword")) {
                if (isInHardZone(player) || isInHardZoneFall(player)) {

                    double maxHealth = player.getMaxHealth();
                    if (player.getLevel() < 100) {
                        double damageAmount = maxHealth * 0.50;
                        player.damage(damageAmount);
                    } else {
                        double damageAmount = maxHealth * 0.75;
                        player.damage(damageAmount);
                    }
                    player.playSound(event.getPlayer().getLocation(), Sound.ENTITY_CAT_HISS, 1, 1);
                    event.setCancelled(true);
                }
            }
        }

    }


    //Craft Honey Soup in respective areas
    @EventHandler
    public void onPrepareItemCraft(PrepareItemCraftEvent event) {
        ItemStack result = event.getInventory().getResult();

        if (event.getViewers().get(0) instanceof Player) {
            Player player = ((Player) event.getViewers().get(0)).getPlayer();
            if (isInMiddleZone(player) || isInMiddleZoneFall(player) || isInHardZone(player) || isInHardZoneFall(player)) {
                if (result != null && result.getType() == Material.MUSHROOM_STEW) {
                    ItemStack honeySoup = new ItemBuilder(Material.MUSHROOM_STEW)
                            .setName("§6Honey Soup")
                            .setLore("§c", "§7So tasty, it even heals you.")
                            .getItemStack();

                    event.getInventory().setResult(honeySoup);
                }
            }
        }

    }


    //Make the player respawn in Soup Area
    @EventHandler(ignoreCancelled = true)
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if (event.getPlayer().getScoreboardTags().contains("HoneySoup")) {
            if (event.getPlayer().getWorld().getName().equals("world")) {
                HoneyClicker honeyClicker = new HoneyClicker();
                Location respawnLocation = new Location(player.getWorld(), -2, 34, -1);
                event.setRespawnLocation(respawnLocation);
                Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                    honeyClicker.removeWalls(event.getPlayer());
                }, 1L);
            }
        }
    }


    //Remove "Honey Soup" Tag when Quitting
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (event.getPlayer().getScoreboardTags().contains("HoneySoup")) {
            event.getPlayer().removeScoreboardTag("HoneySoup");
        }
    }


    public void start() {
        //Damager
        new BukkitRunnable() {
            @Override
            public void run() {
                World world = Bukkit.getWorld("world"); // Assuming default world
                for (Player player : world.getPlayers()) {


                    if (isInEasyZone(player)) {
                        if (!player.getScoreboardTags().contains("Builder")) {
                            if (!player.getInventory().isEmpty()) {
                                HoneyClickerConfig honeyClickerConfig = new HoneyClickerConfig(player.getUniqueId());
                                double maxHealth = player.getMaxHealth();
                                if (player.getLevel() < 100) {
                                    double damageAmount = maxHealth * 0.25;
                                    player.damage(damageAmount);
                                } else {
                                    double damageAmount = maxHealth * 0.35;
                                    player.damage(damageAmount);
                                }

                                if (!player.isDead()) {
                                    player.setLevel(player.getLevel() + 1);
                                    honeyClickerConfig.setHoneyCount(player.getLevel() + honeyClickerConfig.getHoneyCount());

                                    StringBuilder actionBarText = new StringBuilder("§e");
                                    actionBarText.append("+" + player.getLevel() + " §6Honey §8| §7Total: §6" + honeyClickerConfig.getHoneyCount());
                                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionBarText.toString()));
                                }
                            }

                        }
                    }


                    if (isInMiddleZone(player)) {
                        if (!player.getScoreboardTags().contains("Builder")) {
                            if (!player.getInventory().isEmpty()) {
                                HoneyClickerConfig honeyClickerConfig = new HoneyClickerConfig(player.getUniqueId());
                                double maxHealth = player.getMaxHealth();
                                if (player.getLevel() < 100) {
                                    double damageAmount = maxHealth * 0.35;
                                    player.damage(damageAmount);
                                } else {
                                    double damageAmount = maxHealth * 0.45;
                                    player.damage(damageAmount);
                                }

                                if (!player.isDead()) {
                                    player.setLevel(player.getLevel() + 1);
                                    honeyClickerConfig.setHoneyCount(player.getLevel() * 2 + honeyClickerConfig.getHoneyCount());

                                    StringBuilder actionBarText = new StringBuilder("§e");
                                    actionBarText.append("+" + player.getLevel() * 2 + " §6Honey §8| §7Total: §6" + honeyClickerConfig.getHoneyCount());
                                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionBarText.toString()));
                                }
                            }

                        }
                    }


                    if (isInHardZone(player)) {
                        if (!player.getScoreboardTags().contains("Builder")) {
                            if (!player.getInventory().isEmpty()) {
                                HoneyClickerConfig honeyClickerConfig = new HoneyClickerConfig(player.getUniqueId());
                                double maxHealth = player.getMaxHealth();
                                if (player.getLevel() < 100) {
                                    double damageAmount = maxHealth * 0.50;
                                    player.damage(damageAmount);
                                } else {
                                    double damageAmount = maxHealth * 0.60;
                                    player.damage(damageAmount);
                                }

                                if (!player.isDead()) {
                                    player.setLevel(player.getLevel() + 1);
                                    honeyClickerConfig.setHoneyCount(player.getLevel() * 4 + honeyClickerConfig.getHoneyCount());

                                    StringBuilder actionBarText = new StringBuilder("§e");
                                    actionBarText.append("+" + player.getLevel() * 4 + " §6Honey §8| §7Total: §6" + honeyClickerConfig.getHoneyCount());
                                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionBarText.toString()));
                                }
                            }

                        }
                    }

                }
            }
        }.runTaskTimer(plugin, 0L, 20L);


        //Manager
        new BukkitRunnable() {
            @Override
            public void run() {
                World world = Bukkit.getWorld("world");
                for (Player player : world.getPlayers()) {
                    if (!player.getScoreboardTags().contains("Builder")) {


                        //Easy Zone Checks
                        if (isInEasyZoneFall(player)) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 2 * 20, 1, true, false, false));


                            player.getInventory().clear();
                            if (player.getInventory().isEmpty()) {
                                giveEasyZoneItems(player);
                            }

                            Random random = new Random();
                            double randomX = (random.nextDouble() * 2 - 1); // Random value between -1 and 1
                            double randomZ = (random.nextDouble() * 2 - 1); // Random value between -1 and 1
                            double speed = 1.0;
                            Vector velocity = new Vector(randomX, -2, randomZ).normalize().multiply(speed);
                            player.setVelocity(velocity);
                        }

                        if (isInEasyZone(player)) {
                            if (player.getInventory().isEmpty()) {
                                Location currentLocation = player.getLocation();
                                Location targetLocation = new Location(currentLocation.getWorld(), -3, currentLocation.getY() + 1, 5);
                                Vector direction = targetLocation.toVector().subtract(currentLocation.toVector()).normalize();
                                double speed = 1.5;
                                player.setVelocity(direction.multiply(speed));
                            }
                        }


                        //Middle Zone Checks
                        if (isInMiddleZoneFall(player)) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 2 * 20, 1, true, false, false));


                            player.getInventory().clear();
                            if (player.getInventory().isEmpty()) {
                                giveMiddleZoneItems(player);
                            }

                            Random random = new Random();
                            double randomX = (random.nextDouble() * 2 - 1); // Random value between -1 and 1
                            double randomZ = (random.nextDouble() * 2 - 1); // Random value between -1 and 1
                            double speed = 1.0;
                            Vector velocity = new Vector(randomX, -2, randomZ).normalize().multiply(speed);
                            player.setVelocity(velocity);
                        }

                        if (isInMiddleZone(player)) {
                            if (hasOnlyStoneSword(player) || player.getInventory().isEmpty()) {
                                Location currentLocation = player.getLocation();
                                Location targetLocation = new Location(currentLocation.getWorld(), -6, currentLocation.getY() + 1, -1);
                                Vector direction = targetLocation.toVector().subtract(currentLocation.toVector()).normalize();
                                double speed = 1;
                                player.setVelocity(direction.multiply(speed));
                            }
                        }


                        //Hard Zone Checks
                        if (isInHardZoneFall(player)) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 2 * 20, 1, true, false, false));

                            for (int x = 2; x <= 3; x++) {
                                for (int z = -5; z <= -3; z++) {
                                    Location blockLocation = player.getWorld().getBlockAt(x, 20, z).getLocation();
                                    player.sendBlockChange(blockLocation, Material.AIR, (byte) 0);
                                }
                            }


                            player.getInventory().clear();
                            if (player.getInventory().isEmpty()) {
                                giveHardZoneItems(player);
                            }

                            Random random = new Random();
                            double randomX = (random.nextDouble() * 2 - 1); // Random value between -1 and 1
                            double randomZ = (random.nextDouble() * 2 - 1); // Random value between -1 and 1
                            double speed = 1.0;
                            Vector velocity = new Vector(randomX, -2, randomZ).normalize().multiply(speed);
                            player.setVelocity(velocity);
                        }

                        if (isInHardZone(player)) {
                            if (hasOnlyStoneSword(player) || player.getInventory().isEmpty()) {

                                Random random = new Random();
                                Location target1 = new Location(player.getWorld(), 2, 24, -5);
                                Location target2 = new Location(player.getWorld(), 3, 24, -3);
                                Location target = random.nextBoolean() ? target1 : target2;
                                Location playerLocation = player.getLocation();
                                Vector direction = target.toVector().subtract(playerLocation.toVector()).normalize();
                                double speed = 1.5;
                                Vector velocity = direction.multiply(speed);
                                player.setVelocity(velocity);

                            }
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, 7L);
    }


    public boolean hasOnlyStoneSword(Player player) {
        ItemStack[] inventoryContents = player.getInventory().getContents();

        for (ItemStack item : inventoryContents) {
            if (item != null && item.getType() != Material.AIR) {
                // If the item is not a stone sword, return false
                if (item.getType() != Material.STONE_SWORD) {
                    return false;
                }
            }
        }

        // If all non-null items are stone swords, return true
        return true;
    }


    //Give Easy Items
    public void giveEasyZoneItems(Player player) {
        for (int i = 0; i < player.getInventory().getSize(); i++) {
            player.getInventory().addItem(new ItemBuilder(Material.MUSHROOM_STEW).setName("§6Honey Soup").setLore("§c", "§7So tasty, it even heals you.").getItemStack());
        }
    }

    //Give Middle Items
    public void giveMiddleZoneItems(Player player) {
        for (int i = 0; i < player.getInventory().getSize(); i++) {
            player.getInventory().addItem(new ItemBuilder(Material.MUSHROOM_STEW).setName("§6Honey Soup").setLore("§c", "§7So tasty, it even heals you.").getItemStack());
        }
        player.getInventory().setItem(0, new ItemBuilder(Material.STONE_SWORD).setName("§fStone Sword").getItemStack());
        player.getInventory().setItem(14, new ItemBuilder(Material.RED_MUSHROOM, 64).setName("§cRed Mushroom").getItemStack());
        player.getInventory().setItem(15, new ItemBuilder(Material.BROWN_MUSHROOM, 64).setName("§6Brown Mushroom").getItemStack());
        player.getInventory().setItem(16, new ItemBuilder(Material.BOWL, 64).setName("§fEmpty Bowl").getItemStack());

    }

    //Give Hard Items
    public void giveHardZoneItems(Player player) {
        for (int i = 0; i < player.getInventory().getSize(); i++) {
            player.getInventory().addItem(new ItemBuilder(Material.MUSHROOM_STEW).setName("§6Honey Soup").setLore("§c", "§7So tasty, it even heals you.").getItemStack());
        }
        player.getInventory().setItem(0, new ItemBuilder(Material.STONE_SWORD).setName("§fStone Sword").getItemStack());
        player.getInventory().setItem(27, new ItemBuilder(Material.STONE_SWORD).setName("§fStone Sword").getItemStack());
        player.getInventory().setItem(14, new ItemBuilder(Material.RED_MUSHROOM, 64).setName("§cRed Mushroom").getItemStack());
        player.getInventory().setItem(15, new ItemBuilder(Material.BROWN_MUSHROOM, 64).setName("§6Brown Mushroom").getItemStack());
        player.getInventory().setItem(16, new ItemBuilder(Material.BOWL, 64).setName("§fEmpty Bowl").getItemStack());

    }


    //Easy Zone Checks
    private boolean isInEasyZone(Player player) {
        Location loc = player.getLocation();
        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockZ();

        // Check if the player is within the bounded area
        return (x >= Math.min(x1, x2) && x <= Math.max(x1, x2)) &&
                (y >= Math.min(y1, y2) && y <= Math.max(y1, y2)) &&
                (z >= Math.min(z1, z2) && z <= Math.max(z1, z2));
    }

    private boolean isInEasyZoneFall(Player player) {
        Location loc = player.getLocation();
        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockZ();

        // Check if the player is within the bounded feather falling area
        return (x >= Math.min(ff_x1, ff_x2) && x <= Math.max(ff_x1, ff_x2)) &&
                (y >= Math.min(ff_y1, ff_y2) && y <= Math.max(ff_y1, ff_y2)) &&
                (z >= Math.min(ff_z1, ff_z2) && z <= Math.max(ff_z1, ff_z2));
    }


    //Middle Zone Checks
    private boolean isInMiddleZoneFall(Player player) {
        Location loc = player.getLocation();
        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockZ();

        return (x >= Math.min(mf_x1, mf_x2) && x <= Math.max(mf_x1, mf_x2)) &&
                (y >= Math.min(mf_y1, mf_y2) && y <= Math.max(mf_y1, mf_y2)) &&
                (z >= Math.min(mf_z1, mf_z2) && z <= Math.max(mf_z1, mf_z2));
    }

    private boolean isInMiddleZone(Player player) {
        Location loc = player.getLocation();
        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockZ();

        return (x >= Math.min(m_x1, mf_x2) && x <= Math.max(m_x1, m_x2)) &&
                (y >= Math.min(m_y1, m_y2) && y <= Math.max(m_y1, m_y2)) &&
                (z >= Math.min(m_z1, m_z2) && z <= Math.max(m_z1, m_z2));
    }


    //Hard Zone Checks
    private boolean isInHardZoneFall(Player player) {
        Location loc = player.getLocation();
        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockZ();

        return (x >= Math.min(hf_x1, hf_x2) && x <= Math.max(hf_x1, hf_x2)) &&
                (y >= Math.min(hf_y1, hf_y2) && y <= Math.max(hf_y1, hf_y2)) &&
                (z >= Math.min(hf_z1, hf_z2) && z <= Math.max(hf_z1, hf_z2));
    }

    private boolean isInHardZone(Player player) {
        Location loc = player.getLocation();
        int x = loc.getBlockX();
        int y = loc.getBlockY();
        int z = loc.getBlockZ();

        return (x >= Math.min(h_x1, h_x2) && x <= Math.max(h_x1, h_x2)) &&
                (y >= Math.min(h_y1, h_y2) && y <= Math.max(h_y1, h_y2)) &&
                (z >= Math.min(h_z1, h_z2) && z <= Math.max(h_z1, h_z2));
    }


}
