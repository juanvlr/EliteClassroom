package io.github.juanvlr.eliteclassroom.api.audience;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.github.juanvlr.eliteclassroom.api.i18n.DefaultLocale;
import net.kyori.adventure.identity.Identity;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.renderer.ComponentRenderer;
import org.bukkit.plugin.Plugin;

import java.util.Locale;

public class AudienceModule extends AbstractModule {

    @Provides
    public BukkitAudiences provideAudiences(Plugin plugin, @DefaultLocale Locale defaultLocale, ComponentRenderer<Locale> renderer) {
        return BukkitAudiences.builder(plugin)
                .componentRenderer(ptr -> ptr.getOrDefault(Identity.LOCALE, defaultLocale), renderer)
                .build();
    }
}
