package io.github.juanvlr.eliteclassroom.api.text.component;

import io.github.juanvlr.eliteclassroom.api.text.TextKey;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

public class TranslatableComponent {

    private final TextKey key;
    private final TagResolver[] resolvers;

    public TranslatableComponent(TextKey key, TagResolver[] resolvers) {
        this.key = key;
        this.resolvers = resolvers;
    }

    public static TranslatableComponent from(TextKey key, TagResolver... resolvers) {
        return new TranslatableComponent(key, resolvers);
    }

    public TextKey getKey() {
        return this.key;
    }

    public TagResolver[] getResolvers() {
        return this.resolvers;
    }
}
