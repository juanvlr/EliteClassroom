package io.github.juanvlr.eliteclassroom.api.text.component.renderer;

import io.github.juanvlr.eliteclassroom.api.text.component.ComponentFormatter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TranslatableComponent;

import java.text.AttributedCharacterIterator;
import java.text.Format;
import java.text.MessageFormat;
import java.util.List;

public class TranslatableMiniMessageComponentFormatter {

    public void format(TranslatableComponent component, MessageFormat format, StringBuilder builder) {
        List<Component> args = component.args();

        Object[] nulls = new Object[args.size()];
        String buffer = format.format(nulls);
        AttributedCharacterIterator characterIterator = format.formatToCharacterIterator(nulls);

        Format[] formats = format.getFormats();

        int formatIndex = 0;

        while (characterIterator.getIndex() < characterIterator.getEndIndex()) {
            int end = characterIterator.getRunLimit();

            Integer attributeIndex = (Integer) characterIterator.getAttribute(MessageFormat.Field.ARGUMENT);

            if (attributeIndex != null) {
                Component arg = args.get(attributeIndex);

                Format currentFormat = formats[formatIndex];

                if (currentFormat == null) {
                    // Simple format, juste replace it
                    builder.append(String.format(TranslatableMiniMessageComponentRenderer.PLACEHOLDER_FORMAT, attributeIndex));
                } else {
                    // Complex format
                    // TODO And in case of error ? (arg not instanceof ComponentFormatter)
                    if (arg instanceof ComponentFormatter) {
                        ComponentFormatter arfFormatter = (ComponentFormatter) arg;
                        MessageFormat chosenFormat = arfFormatter.format(formats[formatIndex]);

                        this.format(component, chosenFormat, builder);
                    }
                }

                formatIndex++;
            } else {
                builder.append(buffer, characterIterator.getIndex(), end);
            }

            characterIterator.setIndex(end);
        }
    }
}
