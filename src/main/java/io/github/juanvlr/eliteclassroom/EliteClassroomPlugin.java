package io.github.juanvlr.eliteclassroom;

import org.bukkit.plugin.java.JavaPlugin;

public class EliteClassroomPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin enabled successfully");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled successfully");
    }
}
