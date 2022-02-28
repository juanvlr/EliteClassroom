package io.github.juanvlr.eliteclassroom;

import com.google.inject.AbstractModule;
import io.github.juanvlr.eliteclassroom.listener.ListenerModule;

public class CoreModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ListenerModule());
    }
}
