package io.github.juanvlr.eliteclassroom.api.i18n.bundle;

import com.google.inject.throwingproviders.CheckedProvider;

import java.io.IOException;
import java.util.Collection;
import java.util.ResourceBundle;

@SuppressWarnings("RedundantThrows")
public interface BundlesProvider extends CheckedProvider<Collection<ResourceBundle>> {

    @Override
    Collection<ResourceBundle> get() throws IOException;
}
