package io.github.juanvlr.eliteclassroom.api.i18n.bundle;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.throwingproviders.ThrowingProviderBinder;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.translation.GlobalTranslator;
import net.kyori.adventure.translation.TranslationRegistry;
import net.kyori.adventure.translation.Translator;

import java.io.IOException;
import java.util.Collection;
import java.util.ResourceBundle;

public class BundleModule extends AbstractModule {

    @Override
    protected void configure() {
        ThrowingProviderBinder.create(binder())
                .bind(BundlesProvider.class, new TypeLiteral<Collection<ResourceBundle>>() {})
                .to(BundlesProviderImpl.class);
    }

    @Provides
    public Translator provideSource(BundlesProvider bundlesProvider) {
        TranslationRegistry translationRegistry = TranslationRegistry.create(Key.key("registry"));

        Collection<ResourceBundle> bundles;

        try {
            bundles = bundlesProvider.get();
        } catch (IOException e) {
            e.printStackTrace();

            bundles = UnavailableBundles.getDefaultBundles();
        }

        for (ResourceBundle bundle : bundles) {
            translationRegistry.registerAll(bundle.getLocale(), bundle, false);
        }

        return translationRegistry;
    }

    @Provides
    public GlobalTranslator provideGlobalTranslator(Translator source) {
        GlobalTranslator translator = GlobalTranslator.translator();
        translator.addSource(source);

        return translator;
    }
}
