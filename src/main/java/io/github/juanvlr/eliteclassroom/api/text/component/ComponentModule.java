package io.github.juanvlr.eliteclassroom.api.text.component;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.github.juanvlr.eliteclassroom.api.text.component.serializer.ComponentSerializer;
import io.github.juanvlr.eliteclassroom.api.text.component.serializer.ComponentSerializerImpl;
import net.kyori.adventure.platform.bukkit.BukkitComponentSerializer;
import net.kyori.adventure.text.Component;

public class ComponentModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ComponentSerializer.class).to(ComponentSerializerImpl.class);
    }

    @Provides
    public net.kyori.adventure.text.serializer.ComponentSerializer<Component, Component, String> provideKyoriComponentSerializer() {
        return BukkitComponentSerializer.gson();
    }
}
