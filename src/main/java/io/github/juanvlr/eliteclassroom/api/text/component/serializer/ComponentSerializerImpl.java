package io.github.juanvlr.eliteclassroom.api.text.component.serializer;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

import javax.inject.Inject;

public class ComponentSerializerImpl implements ComponentSerializer {

    private final net.kyori.adventure.text.serializer.ComponentSerializer<Component, Component, String> componentSerializer;
    private final MiniMessage miniMessage;

    @Inject
    public ComponentSerializerImpl(
            MiniMessage miniMessage,
            net.kyori.adventure.text.serializer.ComponentSerializer<Component, Component, String> componentSerializer
    ) {
        this.componentSerializer = componentSerializer;
        this.miniMessage = miniMessage;
    }

    @Override
    public String serialize(Component component) {
        return this.componentSerializer.serialize(component);
    }

    @Override
    public Component deserialize(String input, TagResolver... resolvers) {
        return this.miniMessage.deserialize(input, resolvers);
    }
}
