package io.github.juanvlr.eliteclassroom.api.i18n;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.util.Locale;

public class InternalizationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(InternalizationService.class).to(InternalizationServiceImpl.class);
    }

    @Provides
    @SupportedLocales
    public Locale[] provideSupportedLocales() {
        return new Locale[]{Locale.FRENCH};
    }
}
