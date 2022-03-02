package io.github.juanvlr.eliteclassroom.api.plugin;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.github.juanvlr.eliteclassroom.api.plugin.boostrap.PluginBoostrapImpl;
import io.github.juanvlr.eliteclassroom.api.plugin.boostrap.PluginBootstrap;
import io.github.juanvlr.eliteclassroom.api.plugin.logger.LoggerModule;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitScheduler;

import java.io.File;

public class PluginModule extends AbstractModule {

    private final Plugin plugin;

    public PluginModule(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        install(new LoggerModule(this.plugin.getLogger()));

        bind(PluginBootstrap.class).to(PluginBoostrapImpl.class);
    }

    @Provides
    public Plugin providePlugin() {
        return this.plugin;
    }

    @Provides
    @PluginConfiguration
    public FileConfiguration providePluginConfiguration(Plugin plugin) {
        return plugin.getConfig();
    }

    @Provides
    @PluginDataFolder
    public File providePluginDataFolder(Plugin plugin) {
        return plugin.getDataFolder();
    }

    @Provides
    public BukkitScheduler provideScheduler() {
        return Bukkit.getScheduler();
    }

    @Provides
    public PluginManager providePluginManager() {
        return Bukkit.getPluginManager();
    }

    @Provides
    public BukkitAudiences provideAudiences(Plugin plugin) {
        return BukkitAudiences.create(plugin);
    }
}
