package io.github.juanvlr.eliteclassroom.api.text.bundle;

import com.google.inject.AbstractModule;
import com.google.inject.throwingproviders.CheckedProvides;
import com.google.inject.throwingproviders.ThrowingProviderBinder;
import io.github.juanvlr.eliteclassroom.api.i18n.SupportedLocales;
import io.github.juanvlr.eliteclassroom.api.plugin.PluginDataFolder;
import net.kyori.adventure.util.UTF8ResourceBundleControl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.*;

public class BundleModule extends AbstractModule {

    private static final String MESSAGES_DIRECTORY = "messages";

    private static final String BUNDLE_NAME = "EliteClassroom";

    @Override
    protected void configure() {
        install(ThrowingProviderBinder.forModule(this));
    }

    @CheckedProvides(BundlesProvider.class)
    public Map<Locale, ResourceBundle> provideBundles(
            @PluginDataFolder File dataFolder,
            @SupportedLocales Locale[] supportedLocales
    ) throws IOException {
        Path messageDirectory = dataFolder.toPath().resolve(MESSAGES_DIRECTORY);

        URL[] urls = {messageDirectory.toFile().toURI().toURL()};

        ClassLoader classLoader = new URLClassLoader(urls);

        Map<Locale, ResourceBundle> bundles = new HashMap<>();

        for (Locale locale : supportedLocales) {
            try {
                ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale, classLoader, UTF8ResourceBundleControl.get());
                bundles.put(locale, bundle);
            } catch (MissingResourceException e) {
                // Missing file for the current locale but that's not a problem, we warn the user though
                // TODO Warn
                System.out.println("PROBLEM");
            }
        }

        return bundles;
    }
}
