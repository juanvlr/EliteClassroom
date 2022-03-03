package io.github.juanvlr.eliteclassroom.api.i18n;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.github.juanvlr.eliteclassroom.api.i18n.bundle.BundleModule;

import java.util.Locale;

public class InternalizationModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new BundleModule());
    }

    @Provides
    @SupportedLocales
    public Locale[] provideSupportedLocales() {
        return new Locale[]{Locale.FRENCH};
    }

    @Provides
    @DefaultLocale
    public Locale provideDefaultLocale() {
        return Locale.FRENCH;
    }
}
