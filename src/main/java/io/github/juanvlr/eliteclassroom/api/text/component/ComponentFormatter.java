package io.github.juanvlr.eliteclassroom.api.text.component;

import java.text.Format;
import java.text.MessageFormat;

public interface ComponentFormatter {

    MessageFormat format(Format format);

    Object getValue();
}
