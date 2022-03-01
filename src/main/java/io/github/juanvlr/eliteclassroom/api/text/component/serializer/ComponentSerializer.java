package io.github.juanvlr.eliteclassroom.api.text.component.serializer;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

public interface ComponentSerializer {

    String serialize(Component component);

    Component deserialize(String input, TagResolver... resolvers);
}
