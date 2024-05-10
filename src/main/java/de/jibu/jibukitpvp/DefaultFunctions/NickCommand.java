package de.jibu.jibukitpvp.DefaultFunctions;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.jibu.jibukitpvp.Main;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Field;
import java.util.Random;


public class NickCommand implements CommandExecutor, Listener {

    private Field nameField;

    @EventHandler
    public void onPluginEnable(PluginEnableEvent event) {
        nameField = getField(GameProfile.class, "name");
    }


    public static void SkinChanger(Player player) {
        GameProfile profile = ((CraftPlayer) player).getHandle().getProfile();
        PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;


        connection.sendPacket(new PacketPlayOutPlayerInfo(
                PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER,
                ((CraftPlayer) player).getHandle()));


        if (player.getName().equals("Doly")) {
            profile.getProperties().put("textures", getDolySkin());
        } else {
            profile.getProperties().removeAll("textures");
            profile.getProperties().put("textures", getSkin());
        }


        new BukkitRunnable() {
            @Override
            public void run() {

                connection.sendPacket(new PacketPlayOutPlayerInfo(
                        PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER,
                        ((CraftPlayer) player).getHandle()));

            }
        }.runTaskLater(Main.getPlugin(), 4);

    }


    public void removePlayer(CraftPlayer cp) {
        PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, cp.getHandle());
        sendPacket(packet);
    }

    public void addPlayer(CraftPlayer cp) {
        PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, cp.getHandle());
        sendPacket(packet);
    }


    private void sendPacket(Packet<?> packet) {
        for (Player all : Bukkit.getOnlinePlayers()) {
            ((CraftPlayer) all).getHandle().playerConnection.sendPacket(packet);
        }
    }

    private Field getField(Class<?> clazz, String name) {
        try {
            Field field = clazz.getDeclaredField(name);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            return null;
        }
    }


    private static Property getSkin() {
        Random r = new Random();
        int num = r.nextInt(4);
        switch (num) {
            case 0:
                return new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTYyODk0MjY1MzQyNCwKICAicHJvZmlsZUlkIiA6ICJlZDUzZGQ4MTRmOWQ0YTNjYjRlYjY1MWRjYmE3N2U2NiIsCiAgInByb2ZpbGVOYW1lIiA6ICI0MTQxNDE0MWgiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGFmMDZmNzYwZWRkMzcwMzE5YmVmZjViMzRmMjFhNmNkM2M3Y2NiZmQ2NmU3ZDk2ZjY4YjE5ZjhhODQ4NTE4MiIsCiAgICAgICJtZXRhZGF0YSIgOiB7CiAgICAgICAgIm1vZGVsIiA6ICJzbGltIgogICAgICB9CiAgICB9CiAgfQp9", "ek/l6no8rFkVhUmMkROPFWuo2tRva9XXWi8qiDzYiASO9xW467py9N+lez8uMBLIanKLI1u/6cV9Exf5LJH5+PdR821attueJNbKZ77ToiZSqbVK/r8atkjhdcgcFIqngBsR1aglCwT/IuRnodEhko+T70jmLOPUVhzBKOYy0UWT1KF2pS1FlzuxB1Qbz/9aQ1jwTC1SY+nPWpo2VkugfKJ93kbliUvgsb1Pc4riTZJnHEFEN9b9la949wox7sZM+iiozyIaALwaNInAdp6522vNsLu3wH6eB+zq7xiAkSVyrk9yelpkCAmM4MqkStbVF+I6QNy2fYM8JzKS5WBuxZUCp8HvIXRu6JFmBT280j47edoEA26GLS01dO1c2smhgQR58ma5r3gcu2LM/P0ti5pEdY+/ZKMcWvTFmaoKV7t5B9duoGYUlJD3LX1fNJ+53e/204ny+sqs1o7fAkqr2BR3KzJhRQA3mrFdBxrEeUFnw669n1FDFvYDyvBxl0rtq1BR2hCLUUYtrRDDSgM220+8GiAB6qtpGN6GHsvalr5YAZ6we5OU7VX3KIbbx/hrZ+xSss9tZTAeLtn+WBfaa5rspevKi19YeSkM6otzwwC/B5jqpVYE8+kjhgId03Q4MVNdmVZ+7LOHi0w4Ztqq+84mFCpg/sBFdgKwrIfsh20=");
            case 1:
                return new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTYzMDg4Njc0MDUwNCwKICAicHJvZmlsZUlkIiA6ICI0ZWQ4MjMzNzFhMmU0YmI3YTVlYWJmY2ZmZGE4NDk1NyIsCiAgInByb2ZpbGVOYW1lIiA6ICJGaXJlYnlyZDg4IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2JiOTM1MGI0MjY4ZThjNGRmYTg4ODIyY2VjOWEwZjRmMmU1YzUyNGViY2U1ZGE5YmMxMWJmZWU1YmRhODBjM2UiLAogICAgICAibWV0YWRhdGEiIDogewogICAgICAgICJtb2RlbCIgOiAic2xpbSIKICAgICAgfQogICAgfQogIH0KfQ==", "w6ZsgGwDD822wjwDR9KXjAVeFneRyuhJ/zhB3TlVzYQmOJZzYVSnDBnMsqFEANEJWLTq+/maxeSQ0rvoMtZQMhzFaZtxDFANVEiGVGz8Dw7VPjaDqfR+7gWpK0IplwtFrzJ6xZgvJfQZK/SyZom4zJjuSkMUHHjpuJu9Sy70oP0k3Sc4PVD5jebLlOxoRJwrh4QgHJPX4aun7/aTe3AHHUX+R0eX9iZylpPfNoIYSQKJuSDSy0qZ+cq2dW61G4C1/FZEaf1dSGZAeNZ88e2JgEt0gOiwILty6UzviG+/BJTE3l3VwyPZzxU24LHPGYjZN4mm6uhAqlKfmyeSl7OsX532UgtjKXz3zRGS60BfwCpxLsJ4Ct4/dJdn++Uf30pSrzHF97wK7LOGqSdYXSModLT7v2JZD93YGZ4JddnweuzH7ajsoy/ILB2NRjnUyClQqhvu5970+xLMNDC8LP8SDstzWld+6++kbfLwWnCOl3H6KTxQJEIsblcRkChyGYWVGB6NzWopWN4Y1xxFdYUm9ezMDAd1e41Bl/FqT+QWAjva+29JZ0aLudNTDlaNtirZ3znAIsdP8cJyvky9mPhRrC8+P/PJ0/y/YrsgefhOWv0NSS2MGpQtA1GksoSECN9NRSPiPaPgwjKqr003nQ9H8L1jES9Wh7jUcdn5e5+FtSE=");
            case 2:
                return new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTY0NzU3Mzg3NzMyNSwKICAicHJvZmlsZUlkIiA6ICIwNTVhOTk2NTk2M2E0YjRmOGMwMjRmMTJmNDFkMmNmMiIsCiAgInByb2ZpbGVOYW1lIiA6ICJUaGVWb3hlbGxlIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzdlMWI4MjE4ZGUyZDQ3MDZkODM3M2E0ODYxZGY4ZjYyYzQwOGY5ZjY5MTQwMzcyODI1YjczNDM2OTliYTFiYzciCiAgICB9CiAgfQp9", "Rl5R7fyNrclVSpSgQEY68q4U9UXKuTTz3UTwwNnx2E4cSUSKlKGLZ6M7kk9Yf1WswHi1czYn46jjPhdFGEEGYuGU7IRwehuakPaD2WkVU4jYHwwJMg3gY0a9Q3bZHLIQ1gtg4XBdcT502jB9n5Dpx3CLXMgRej872CIajRnmZeTznqxvV29FSUnDiHXZjMeoSqkjzFII+hAEbcu86XV/axCCjdBpR1kaLsnSzxHf800ok4jlhG2rPBzqY7hBCMGY7LOaw9E8r8jn8pzx23Lr9w1lRMtQvM6b68lbVkjJZz48To0De/gk8DBLjZSeGviPl0BZ99umpk6405XTxbQOFDsmoDuQQ3Tz9ijW1dG+vDDK+A2oDfiU2azvvu+sNDLOttZz1wFr7BM2JqB7ioQpBzjwLf58p/Pb4P5XS75Fd2ASSl9GI6deCwQDGdbzrLxvzyDMBDquv9yEnEm/ZqWTel1xdaDCSctDh31BtLKPFeoRI1jnbwyRtlDnvrfhSs8YfErt8hWpn+sb1YWJI51eX0dLjZugJXdlkbK7F9A9QKLuVjWahtDVJWv9jcMjWgkwKmmaVf6zHU5NQVF0pa0xQWmHNis/Xapec+I1Zrt7E2GKMEqt7McQPoL0TzJQuVWP1jtPSCauCO3C/XYwfVLTQRURh9l8BqmFNPLwB+6BcTM=");
            case 3:
                return new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTY0ODc0Mjc1MDI1NiwKICAicHJvZmlsZUlkIiA6ICIxNzU1N2FjNTEzMWE0YTUzODAwODg3Y2E4ZTQ4YWQyNSIsCiAgInByb2ZpbGVOYW1lIiA6ICJQZW50YXRpbCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9iYjRhM2FjMmFjYmY1ZjJjZjhlMjllZGI4ZjM1OGY5NzViYTRlYmZmNThkMzRjNWNmODVmY2Y1MzVmOGM3ZGI5IgogICAgfQogIH0KfQ==", "qkjpGTvHpNqeCXbwXWGIViEmeCK8DYWE4O4DzEhyOELx4xAL6XjxIis0Ha6zAzgnCOaW7/13QYG8vFTTX4l8nAJojaup3OirgPNQIawsm6i4wYog/gP3DXVjmsGxRvCukfbqWVFDOjerCMG40s6b7VSvFR6sHfNlQHkkDbAhhk1jW0EFedAIaUgzqdiNRoABUFbY6fskV8S+mj8OCbgqQ76ZgtJhO/4zGBzsV6kEEtSbG/Ecq8xqK81R5dCDZAwRBfcSH5Ox1nyYLHnspDOBzNFCFNWvSkwtGoI81cL6zzxsLUVwyhuBd50gwDWfvLRTdNYSkZqk5RfNDm6hFjXbDQB0HOSrsYpK+hwa6KugB5BNTgPieHoSYimhPAnoXi9hMFYXLDr+rSa0GwlG3/nzxiGmzGZp5kBsgtY6q8I3xElYghbViON0wWC6ZxH1SCiG9WQZ1KTP0CzLaxeIZxfGZqF4NgcBfzIua0yAPA+yxaZt14FRWE8KmrhTPU5zw19FAYY/jIJ6JvGhHOAcJMLj+qYD3pA7lRnUeS97fsnv5eReoX0e4VU+CMJvZmuAcPBnXRU+DLc2l18gc3K2eNI1OkkasBaqwhEJYMdLDTvD7L/S84eLNo/bnDB1XkQGmV9u0MvaJ/hM2Xd8XPaCZOl8+CFJxafI6Yg5bSFWQd5p1B8=");
            case 4:
                return new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTYyODk0MjY1MzQyNCwKICAicHJvZmlsZUlkIiA6ICJlZDUzZGQ4MTRmOWQ0YTNjYjRlYjY1MWRjYmE3N2U2NiIsCiAgInByb2ZpbGVOYW1lIiA6ICI0MTQxNDE0MWgiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGFmMDZmNzYwZWRkMzcwMzE5YmVmZjViMzRmMjFhNmNkM2M3Y2NiZmQ2NmU3ZDk2ZjY4YjE5ZjhhODQ4NTE4MiIsCiAgICAgICJtZXRhZGF0YSIgOiB7CiAgICAgICAgIm1vZGVsIiA6ICJzbGltIgogICAgICB9CiAgICB9CiAgfQp9", "ek/l6no8rFkVhUmMkROPFWuo2tRva9XXWi8qiDzYiASO9xW467py9N+lez8uMBLIanKLI1u/6cV9Exf5LJH5+PdR821attueJNbKZ77ToiZSqbVK/r8atkjhdcgcFIqngBsR1aglCwT/IuRnodEhko+T70jmLOPUVhzBKOYy0UWT1KF2pS1FlzuxB1Qbz/9aQ1jwTC1SY+nPWpo2VkugfKJ93kbliUvgsb1Pc4riTZJnHEFEN9b9la949wox7sZM+iiozyIaALwaNInAdp6522vNsLu3wH6eB+zq7xiAkSVyrk9yelpkCAmM4MqkStbVF+I6QNy2fYM8JzKS5WBuxZUCp8HvIXRu6JFmBT280j47edoEA26GLS01dO1c2smhgQR58ma5r3gcu2LM/P0ti5pEdY+/ZKMcWvTFmaoKV7t5B9duoGYUlJD3LX1fNJ+53e/204ny+sqs1o7fAkqr2BR3KzJhRQA3mrFdBxrEeUFnw669n1FDFvYDyvBxl0rtq1BR2hCLUUYtrRDDSgM220+8GiAB6qtpGN6GHsvalr5YAZ6we5OU7VX3KIbbx/hrZ+xSss9tZTAeLtn+WBfaa5rspevKi19YeSkM6otzwwC/B5jqpVYE8+kjhgId03Q4MVNdmVZ+7LOHi0w4Ztqq+84mFCpg/sBFdgKwrIfsh20=");
        }
        return null;
    }

    private static Property getDolySkin() {
        Random r = new Random();
        int num = r.nextInt(4);
        switch (num) {
            case 0:
                return new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTY0ODc0Mjc1MDI1NiwKICAicHJvZmlsZUlkIiA6ICIxNzU1N2FjNTEzMWE0YTUzODAwODg3Y2E4ZTQ4YWQyNSIsCiAgInByb2ZpbGVOYW1lIiA6ICJQZW50YXRpbCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9iYjRhM2FjMmFjYmY1ZjJjZjhlMjllZGI4ZjM1OGY5NzViYTRlYmZmNThkMzRjNWNmODVmY2Y1MzVmOGM3ZGI5IgogICAgfQogIH0KfQ==", "qkjpGTvHpNqeCXbwXWGIViEmeCK8DYWE4O4DzEhyOELx4xAL6XjxIis0Ha6zAzgnCOaW7/13QYG8vFTTX4l8nAJojaup3OirgPNQIawsm6i4wYog/gP3DXVjmsGxRvCukfbqWVFDOjerCMG40s6b7VSvFR6sHfNlQHkkDbAhhk1jW0EFedAIaUgzqdiNRoABUFbY6fskV8S+mj8OCbgqQ76ZgtJhO/4zGBzsV6kEEtSbG/Ecq8xqK81R5dCDZAwRBfcSH5Ox1nyYLHnspDOBzNFCFNWvSkwtGoI81cL6zzxsLUVwyhuBd50gwDWfvLRTdNYSkZqk5RfNDm6hFjXbDQB0HOSrsYpK+hwa6KugB5BNTgPieHoSYimhPAnoXi9hMFYXLDr+rSa0GwlG3/nzxiGmzGZp5kBsgtY6q8I3xElYghbViON0wWC6ZxH1SCiG9WQZ1KTP0CzLaxeIZxfGZqF4NgcBfzIua0yAPA+yxaZt14FRWE8KmrhTPU5zw19FAYY/jIJ6JvGhHOAcJMLj+qYD3pA7lRnUeS97fsnv5eReoX0e4VU+CMJvZmuAcPBnXRU+DLc2l18gc3K2eNI1OkkasBaqwhEJYMdLDTvD7L/S84eLNo/bnDB1XkQGmV9u0MvaJ/hM2Xd8XPaCZOl8+CFJxafI6Yg5bSFWQd5p1B8=");
            case 1:
                return new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTY0ODc0Mjc1MDI1NiwKICAicHJvZmlsZUlkIiA6ICIxNzU1N2FjNTEzMWE0YTUzODAwODg3Y2E4ZTQ4YWQyNSIsCiAgInByb2ZpbGVOYW1lIiA6ICJQZW50YXRpbCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9iYjRhM2FjMmFjYmY1ZjJjZjhlMjllZGI4ZjM1OGY5NzViYTRlYmZmNThkMzRjNWNmODVmY2Y1MzVmOGM3ZGI5IgogICAgfQogIH0KfQ==", "qkjpGTvHpNqeCXbwXWGIViEmeCK8DYWE4O4DzEhyOELx4xAL6XjxIis0Ha6zAzgnCOaW7/13QYG8vFTTX4l8nAJojaup3OirgPNQIawsm6i4wYog/gP3DXVjmsGxRvCukfbqWVFDOjerCMG40s6b7VSvFR6sHfNlQHkkDbAhhk1jW0EFedAIaUgzqdiNRoABUFbY6fskV8S+mj8OCbgqQ76ZgtJhO/4zGBzsV6kEEtSbG/Ecq8xqK81R5dCDZAwRBfcSH5Ox1nyYLHnspDOBzNFCFNWvSkwtGoI81cL6zzxsLUVwyhuBd50gwDWfvLRTdNYSkZqk5RfNDm6hFjXbDQB0HOSrsYpK+hwa6KugB5BNTgPieHoSYimhPAnoXi9hMFYXLDr+rSa0GwlG3/nzxiGmzGZp5kBsgtY6q8I3xElYghbViON0wWC6ZxH1SCiG9WQZ1KTP0CzLaxeIZxfGZqF4NgcBfzIua0yAPA+yxaZt14FRWE8KmrhTPU5zw19FAYY/jIJ6JvGhHOAcJMLj+qYD3pA7lRnUeS97fsnv5eReoX0e4VU+CMJvZmuAcPBnXRU+DLc2l18gc3K2eNI1OkkasBaqwhEJYMdLDTvD7L/S84eLNo/bnDB1XkQGmV9u0MvaJ/hM2Xd8XPaCZOl8+CFJxafI6Yg5bSFWQd5p1B8=");
            case 2:
                return new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTY0ODc0Mjc1MDI1NiwKICAicHJvZmlsZUlkIiA6ICIxNzU1N2FjNTEzMWE0YTUzODAwODg3Y2E4ZTQ4YWQyNSIsCiAgInByb2ZpbGVOYW1lIiA6ICJQZW50YXRpbCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9iYjRhM2FjMmFjYmY1ZjJjZjhlMjllZGI4ZjM1OGY5NzViYTRlYmZmNThkMzRjNWNmODVmY2Y1MzVmOGM3ZGI5IgogICAgfQogIH0KfQ==", "qkjpGTvHpNqeCXbwXWGIViEmeCK8DYWE4O4DzEhyOELx4xAL6XjxIis0Ha6zAzgnCOaW7/13QYG8vFTTX4l8nAJojaup3OirgPNQIawsm6i4wYog/gP3DXVjmsGxRvCukfbqWVFDOjerCMG40s6b7VSvFR6sHfNlQHkkDbAhhk1jW0EFedAIaUgzqdiNRoABUFbY6fskV8S+mj8OCbgqQ76ZgtJhO/4zGBzsV6kEEtSbG/Ecq8xqK81R5dCDZAwRBfcSH5Ox1nyYLHnspDOBzNFCFNWvSkwtGoI81cL6zzxsLUVwyhuBd50gwDWfvLRTdNYSkZqk5RfNDm6hFjXbDQB0HOSrsYpK+hwa6KugB5BNTgPieHoSYimhPAnoXi9hMFYXLDr+rSa0GwlG3/nzxiGmzGZp5kBsgtY6q8I3xElYghbViON0wWC6ZxH1SCiG9WQZ1KTP0CzLaxeIZxfGZqF4NgcBfzIua0yAPA+yxaZt14FRWE8KmrhTPU5zw19FAYY/jIJ6JvGhHOAcJMLj+qYD3pA7lRnUeS97fsnv5eReoX0e4VU+CMJvZmuAcPBnXRU+DLc2l18gc3K2eNI1OkkasBaqwhEJYMdLDTvD7L/S84eLNo/bnDB1XkQGmV9u0MvaJ/hM2Xd8XPaCZOl8+CFJxafI6Yg5bSFWQd5p1B8=");
            case 3:
                return new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTY0ODc0Mjc1MDI1NiwKICAicHJvZmlsZUlkIiA6ICIxNzU1N2FjNTEzMWE0YTUzODAwODg3Y2E4ZTQ4YWQyNSIsCiAgInByb2ZpbGVOYW1lIiA6ICJQZW50YXRpbCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9iYjRhM2FjMmFjYmY1ZjJjZjhlMjllZGI4ZjM1OGY5NzViYTRlYmZmNThkMzRjNWNmODVmY2Y1MzVmOGM3ZGI5IgogICAgfQogIH0KfQ==", "qkjpGTvHpNqeCXbwXWGIViEmeCK8DYWE4O4DzEhyOELx4xAL6XjxIis0Ha6zAzgnCOaW7/13QYG8vFTTX4l8nAJojaup3OirgPNQIawsm6i4wYog/gP3DXVjmsGxRvCukfbqWVFDOjerCMG40s6b7VSvFR6sHfNlQHkkDbAhhk1jW0EFedAIaUgzqdiNRoABUFbY6fskV8S+mj8OCbgqQ76ZgtJhO/4zGBzsV6kEEtSbG/Ecq8xqK81R5dCDZAwRBfcSH5Ox1nyYLHnspDOBzNFCFNWvSkwtGoI81cL6zzxsLUVwyhuBd50gwDWfvLRTdNYSkZqk5RfNDm6hFjXbDQB0HOSrsYpK+hwa6KugB5BNTgPieHoSYimhPAnoXi9hMFYXLDr+rSa0GwlG3/nzxiGmzGZp5kBsgtY6q8I3xElYghbViON0wWC6ZxH1SCiG9WQZ1KTP0CzLaxeIZxfGZqF4NgcBfzIua0yAPA+yxaZt14FRWE8KmrhTPU5zw19FAYY/jIJ6JvGhHOAcJMLj+qYD3pA7lRnUeS97fsnv5eReoX0e4VU+CMJvZmuAcPBnXRU+DLc2l18gc3K2eNI1OkkasBaqwhEJYMdLDTvD7L/S84eLNo/bnDB1XkQGmV9u0MvaJ/hM2Xd8XPaCZOl8+CFJxafI6Yg5bSFWQd5p1B8=");
        }
        return null;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            SkinChanger(((Player) sender).getPlayer());

            String name = args[0];

            CraftPlayer cp = (CraftPlayer) sender;

            try {
                nameField.set(cp.getProfile(), name);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            PacketPlayOutEntityDestroy destroy = new PacketPlayOutEntityDestroy(cp.getEntityId());
            sendPacket(destroy);
            removePlayer(cp);

            new BukkitRunnable() {
                @Override
                public void run() {
                    addPlayer(cp);
                    PacketPlayOutNamedEntitySpawn spawn = new PacketPlayOutNamedEntitySpawn(cp.getHandle());

                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (!all.equals(sender))
                            ((CraftPlayer) all).getHandle().playerConnection.sendPacket(spawn);
                    }
                }
            }.runTaskLater(Main.getPlugin(), 4);

            sender.sendMessage("§cDu bist nun neu genickt");
        } else {
            sender.sendMessage("§cBe a player");
        }

        return false;
    }


}
