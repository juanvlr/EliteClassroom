package io.github.juanvlr.eliteclassroom.api.plugin.boostrap;

import io.github.juanvlr.eliteclassroom.api.command.CommandRegisterer;
import io.github.juanvlr.eliteclassroom.api.listener.ListenerRegisterer;
import io.github.juanvlr.eliteclassroom.api.plugin.PluginDataFolder;
import org.bukkit.plugin.Plugin;

import javax.inject.Inject;
import java.io.File;

public class PluginBoostrapImpl implements PluginBootstrap {

    private final Plugin plugin;
    private final File dataFolder;
    private final CommandRegisterer commandRegisterer;
    private final ListenerRegisterer listenerRegisterer;

    @Inject
    public PluginBoostrapImpl(
            Plugin plugin,
            @PluginDataFolder File dataFolder,
            CommandRegisterer commandRegisterer,
            ListenerRegisterer listenerRegisterer
    ) {
        this.plugin = plugin;
        this.dataFolder = dataFolder;
        this.commandRegisterer = commandRegisterer;
        this.listenerRegisterer = listenerRegisterer;
    }

    @Override
    public void boostrap() throws Exception {
        if (!this.dataFolder.exists()) {
            if (!this.dataFolder.mkdir()) {
                throw new Exception("An exception occurred while attempting to create the data folder");
            }
        }

        this.plugin.saveDefaultConfig();

        this.commandRegisterer.registerCommands();
        this.listenerRegisterer.registerListeners();
    }
}
