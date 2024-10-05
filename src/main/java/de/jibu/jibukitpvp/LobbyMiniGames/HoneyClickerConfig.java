package de.jibu.jibukitpvp.LobbyMiniGames;

import de.jibu.jibukitpvp.Utilities.FileWriter;

import java.util.UUID;

public class HoneyClickerConfig {

    private FileWriter fileWriter;
    private UUID uuid;

    public HoneyClickerConfig(UUID uuid) {
        fileWriter = new FileWriter("plugins//JIBUKitPvP//HoneyClicker", uuid.toString() + ".yml");
        fileWriter.save();
    }

    public void setHoneyCount(int count) {
        fileWriter.setValue("Amount", count);
        fileWriter.save();
    }

    public void addHoneyCount() {
        fileWriter.setValue("Amount", getHoneyCount() + 1);
        fileWriter.save();
    }

    public void removeHoneyCount() {
        fileWriter.setValue("Amount", getHoneyCount() - 1);
        fileWriter.save();
    }

    public void setBoughtSoup(boolean hasBoughtSoup) {
        fileWriter.setValue("hasBoughtSoup", hasBoughtSoup);
        fileWriter.save();
    }

    public boolean hasBoughtSoup() {
        return fileWriter.getBoolean("hasBoughtSoup");
    }


    public int getHoneyCount() {
        return fileWriter.getInt("Amount");
    }
}