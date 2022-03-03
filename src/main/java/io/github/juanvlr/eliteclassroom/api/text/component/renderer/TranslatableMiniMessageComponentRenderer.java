package io.github.juanvlr.eliteclassroom.api.text.component.renderer;

import io.github.juanvlr.eliteclassroom.api.text.component.serializer.ComponentSerializer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TranslatableComponent;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.kyori.adventure.text.renderer.TranslatableComponentRenderer;
import net.kyori.adventure.translation.Translator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TranslatableMiniMessageComponentRenderer extends TranslatableComponentRenderer<Locale> {

    public static final String PLACEHOLDER_TAG_NAME_FORMAT = "placeholder-%d";

    private final Translator source;
    private final ComponentSerializer serializer;
    private final TranslatableMiniMessageComponentFormatter formatter;

    @Inject
    public TranslatableMiniMessageComponentRenderer(
            Translator source,
            ComponentSerializer serializer,
            TranslatableMiniMessageComponentFormatter formatter
    ) {
        this.source = source;
        this.serializer = serializer;
        this.formatter = formatter;
    }

    @Override
    protected @Nullable MessageFormat translate(@NotNull String key, @NotNull Locale context) {
        return this.source.translate(key, context);
    }

    @Override
    protected @NotNull Component renderTranslatable(@NotNull TranslatableComponent component, @NotNull Locale context) {
        MessageFormat format = this.translate(component.key(), context);

        if (format == null) {
            TranslatableComponent.Builder builder = Component.translatable()
                    .key(component.key());

            if (!component.args().isEmpty()) {
                List<Component> args = new ArrayList<>(component.args());

                for (int i = 0, size = args.size(); i < size; i++) {
                    args.set(i, this.render(args.get(i), context));
                }

                builder.args(args);
            }

            return this.mergeStyleAndOptionallyDeepRender(component, builder, context);
        }

        List<Component> args = component.args();

        if (args.isEmpty()) {
            StringBuffer buffer = format.format(null, new StringBuffer(), null);

            return Component.textOfChildren(this.serializer.deserialize(buffer.toString()));
        }

        StringBuilder builder = new StringBuilder();
        this.formatter.format(component, format, builder);

        TagResolver[] resolvers = new TagResolver[args.size()];

        for (int i = 0; i < args.size(); i++) {
            resolvers[i] = Placeholder.component(String.format(PLACEHOLDER_TAG_NAME_FORMAT, i), args.get(i));
        }

        return this.serializer.deserialize(builder.toString(), resolvers);
    }
}
