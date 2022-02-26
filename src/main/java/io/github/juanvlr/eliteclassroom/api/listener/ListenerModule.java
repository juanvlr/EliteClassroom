package io.github.juanvlr.eliteclassroom.api.listener;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import org.bukkit.event.Listener;

public class ListenerModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder.newSetBinder(binder(), Listener.class); // Empty binder

        bind(ListenerRegisterer.class).to(ListenerRegistererImpl.class);
    }
}
