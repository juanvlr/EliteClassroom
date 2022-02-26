package io.github.juanvlr.eliteclassroom.api.plugin.boostrap;

import io.github.juanvlr.eliteclassroom.api.listener.ListenerRegisterer;

import javax.inject.Inject;

public class PluginBoostrapImpl implements PluginBootstrap {

    private final ListenerRegisterer listenerRegisterer;

    @Inject
    public PluginBoostrapImpl(ListenerRegisterer listenerRegisterer) {
        this.listenerRegisterer = listenerRegisterer;
    }

    @Override
    public void boostrap() {
        this.listenerRegisterer.registerListeners();
    }
}
