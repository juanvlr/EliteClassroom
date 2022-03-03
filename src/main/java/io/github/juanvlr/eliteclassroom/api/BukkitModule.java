package io.github.juanvlr.eliteclassroom.api;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitScheduler;

public class BukkitModule extends AbstractModule {

    @Provides
    public BukkitScheduler provideScheduler() {
        return Bukkit.getScheduler();
    }

    @Provides
    public PluginManager providePluginManager() {
        return Bukkit.getPluginManager();
    }
}
