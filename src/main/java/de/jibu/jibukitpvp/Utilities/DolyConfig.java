package de.jibu.jibukitpvp.Utilities;

import java.util.UUID;

public class DolyConfig {

    private FileWriter fileWriter;
    private UUID uuid;

    public DolyConfig() {
        fileWriter = new FileWriter("plugins//JIBUKitPvP//Doly", "dolyInstalled.yml");
        fileWriter.save();
    }


    public void isInstalled(boolean installed) {
        fileWriter.setValue("installed", installed);
        fileWriter.save();
    }


    public boolean isInstalled() {
        return fileWriter.getBoolean("installed");
    }

}
