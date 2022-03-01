package io.github.juanvlr.eliteclassroom.api.i18n;

import net.kyori.adventure.audience.Audience;

import java.util.Locale;

public class InternalizationServiceImpl implements InternalizationService {

    @Override
    public Locale getLocale(Audience audience) {
        return Locale.FRENCH;
    }
}
