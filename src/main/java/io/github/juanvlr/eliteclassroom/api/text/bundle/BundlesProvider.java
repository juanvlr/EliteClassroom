package io.github.juanvlr.eliteclassroom.api.text.bundle;

import com.google.inject.throwingproviders.CheckedProvider;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

@SuppressWarnings("RedundantThrows")
public interface BundlesProvider extends CheckedProvider<Map<Locale, ResourceBundle>> {

    @Override
    Map<Locale, ResourceBundle> get() throws IOException;
}
