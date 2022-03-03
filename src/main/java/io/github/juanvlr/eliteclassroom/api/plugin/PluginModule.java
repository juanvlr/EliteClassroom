package io.github.juanvlr.eliteclassroom.api.plugin;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.github.juanvlr.eliteclassroom.api.logger.LoggerModule;
import io.github.juanvlr.eliteclassroom.api.plugin.boostrap.PluginBoostrapImpl;
import io.github.juanvlr.eliteclassroom.api.plugin.boostrap.PluginBootstrap;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

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
}
