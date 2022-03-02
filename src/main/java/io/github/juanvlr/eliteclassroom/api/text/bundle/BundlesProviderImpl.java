package io.github.juanvlr.eliteclassroom.api.text.bundle;

import io.github.juanvlr.eliteclassroom.api.i18n.SupportedLocales;
import io.github.juanvlr.eliteclassroom.api.plugin.logger.InjectPluginLogger;
import io.github.juanvlr.eliteclassroom.api.plugin.PluginDataFolder;
import net.kyori.adventure.util.UTF8ResourceBundleControl;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Logger;

public class BundlesProviderImpl implements BundlesProvider {

    private static final String MESSAGES_DIRECTORY = "messages";

    private static final String BUNDLE_NAME = "EliteClassroom";

    @SuppressWarnings("unused")
    @InjectPluginLogger
    private Logger logger;

    private final File dataFolder;
    private final Locale[] supportedLocales;

    @Inject
    public BundlesProviderImpl(
            @PluginDataFolder File dataFolder,
            @SupportedLocales Locale[] supportedLocales
    ) {
        this.dataFolder = dataFolder;
        this.supportedLocales = supportedLocales;
    }

    @Override
    public Map<Locale, ResourceBundle> get() throws IOException {
        Path messageDirectory = dataFolder.toPath().resolve(MESSAGES_DIRECTORY);

        URL[] urls = {messageDirectory.toFile().toURI().toURL()};

        ClassLoader classLoader = new URLClassLoader(urls);

        Map<Locale, ResourceBundle> bundles = new HashMap<>();

        for (Locale locale : supportedLocales) {
            try {
                ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale, classLoader, UTF8ResourceBundleControl.get());
                bundles.put(locale, bundle);
            } catch (MissingResourceException e) {
                // Missing resource for the current locale but that's not a problem, we warn the user though
                this.logger.warning(String.format("No resource has been found for supported locale '%s'", locale));
            }
        }

        return bundles;
    }
}
