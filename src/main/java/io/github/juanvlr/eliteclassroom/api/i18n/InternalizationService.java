package io.github.juanvlr.eliteclassroom.api.i18n;

import net.kyori.adventure.audience.Audience;

import java.util.Locale;

public interface InternalizationService {

    Locale getLocale(Audience audience);
}
