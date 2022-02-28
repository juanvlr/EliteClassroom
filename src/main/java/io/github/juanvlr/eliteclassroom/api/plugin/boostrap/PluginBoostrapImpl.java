package io.github.juanvlr.eliteclassroom.api.plugin.boostrap;

import io.github.juanvlr.eliteclassroom.api.command.CommandRegisterer;
import io.github.juanvlr.eliteclassroom.api.listener.ListenerRegisterer;

import javax.inject.Inject;

public class PluginBoostrapImpl implements PluginBootstrap {

    private final CommandRegisterer commandRegisterer;
    private final ListenerRegisterer listenerRegisterer;

    @Inject
    public PluginBoostrapImpl(CommandRegisterer commandRegisterer, ListenerRegisterer listenerRegisterer) {
        this.commandRegisterer = commandRegisterer;
        this.listenerRegisterer = listenerRegisterer;
    }

    @Override
    public void boostrap() {
        this.commandRegisterer.registerCommands();
        this.listenerRegisterer.registerListeners();
    }
}
