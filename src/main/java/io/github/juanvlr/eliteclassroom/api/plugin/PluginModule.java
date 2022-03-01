package io.github.juanvlr.eliteclassroom.api.plugin;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.github.juanvlr.eliteclassroom.api.plugin.boostrap.PluginBoostrapImpl;
import io.github.juanvlr.eliteclassroom.api.plugin.boostrap.PluginBootstrap;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.io.File;

public class PluginModule extends AbstractModule {

    private final Plugin plugin;

    public PluginModule(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        bind(PluginBootstrap.class).to(PluginBoostrapImpl.class);
    }

    @Provides
    public Plugin providePlugin() {
        return this.plugin;
    }

    @Provides
    @PluginDataFolder
    public File providePluginDataFolder(Plugin plugin) {
        return plugin.getDataFolder();
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
