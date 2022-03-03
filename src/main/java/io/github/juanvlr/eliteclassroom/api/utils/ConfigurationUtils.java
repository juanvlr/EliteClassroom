package io.github.juanvlr.eliteclassroom.api.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigurationUtils {

    public static Location parseLocation(FileConfiguration configuration, String path) {
        ConfigurationSection locationSection = configuration.getConfigurationSection(path);

        double x = locationSection.getDouble("x");
        double y = locationSection.getDouble("y");
        double z = locationSection.getDouble("z");

        // Doesn't work
        /*
        float yaw = locationSection.getFloat("yaw");
        float pitch = locationSection.getFloat("pitch");
         */

        float yaw = (float) locationSection.getDouble("yaw");
        float pitch = (float) locationSection.getDouble("pitch");

        String worldName = locationSection.getString("world");
        World world = Bukkit.getWorld(worldName);

        return new Location(world, x, y, z, yaw, pitch);
    }
}
