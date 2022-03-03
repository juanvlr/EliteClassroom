package io.github.juanvlr.eliteclassroom.api.text.component;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.Style;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.util.List;

public class NumberComponent implements ComponentFormatter, TextComponent {

    private final TextComponent wrapped;
    private final int value;

    private NumberComponent(TextComponent wrapped, int value) {
        this.wrapped = wrapped;
        this.value = value;
    }

    public static NumberComponent of(int value) {
        return new NumberComponent(Component.text(value), value);
    }

    @Override
    public MessageFormat format(Format format) {
        if (format instanceof MessageFormat) {
            return (MessageFormat) format;
        }

        if (format instanceof ChoiceFormat) {
            ChoiceFormat choiceFormat = (ChoiceFormat) format;

            double[] choiceLimits = choiceFormat.getLimits();
            String[] choiceFormats = (String[]) choiceFormat.getFormats();

            int i;
            for (i = 0; i < choiceLimits.length; ++i) {
                if (!(this.value >= choiceLimits[i])) {
                    // same as number < choiceLimits, except catchs NaN
                    break;
                }
            }

            --i;

            if (i < 0) i = 0;

            return new MessageFormat(choiceFormats[i]);
        }

        throw new UnsupportedOperationException("Unsupported format");
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    @Override
    public @NotNull String content() {
        return this.wrapped.content();
    }

    @Override
    public @NotNull TextComponent content(@NotNull String content) {
        return this.wrapped.content(content);
    }

    @Override
    public @NotNull Builder toBuilder() {
        return this.wrapped.toBuilder();
    }

    @Override
    public @Unmodifiable @NotNull List<Component> children() {
        return this.wrapped.children();
    }

    @Override
    public @NotNull TextComponent children(@NotNull List<? extends ComponentLike> children) {
        return this.wrapped.children(children);
    }

    @Override
    public @NotNull Style style() {
        return this.wrapped.style();
    }

    @Override
    public @NotNull TextComponent style(@NotNull Style style) {
        return this.wrapped.style(style);
    }
}
