package io.github.juanvlr.eliteclassroom.api.text.bundle;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.throwingproviders.ThrowingProviderBinder;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class BundleModule extends AbstractModule {

    @Override
    protected void configure() {
        ThrowingProviderBinder.create(binder())
                .bind(BundlesProvider.class, new TypeLiteral<Map<Locale, ResourceBundle>>() {})
                .to(BundlesProviderImpl.class);
    }
}
