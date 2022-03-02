package io.github.juanvlr.eliteclassroom.api.i18n;

import net.kyori.adventure.audience.Audience;

import javax.inject.Inject;
import java.util.Locale;

public class InternalizationServiceImpl implements InternalizationService {

    private final Locale defaultLocale;

    @Inject
    public InternalizationServiceImpl(@DefaultLocale Locale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    @Override
    public Locale getLocale(Audience audience) {
        return this.defaultLocale;
    }
}
