package io.github.juanvlr.eliteclassroom.api;

import com.google.inject.AbstractModule;
import io.github.juanvlr.eliteclassroom.api.listener.ListenerModule;

public class APIModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ListenerModule());
    }
}
