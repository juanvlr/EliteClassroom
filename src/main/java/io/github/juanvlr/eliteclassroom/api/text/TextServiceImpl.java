package io.github.juanvlr.eliteclassroom.api.text;

import io.github.juanvlr.eliteclassroom.api.i18n.InternalizationService;
import io.github.juanvlr.eliteclassroom.api.text.bundle.BundlesProvider;
import io.github.juanvlr.eliteclassroom.api.text.bundle.UnavailableBundles;
import io.github.juanvlr.eliteclassroom.api.text.component.TranslatableComponent;
import io.github.juanvlr.eliteclassroom.api.text.component.serializer.ComponentSerializer;
import io.github.juanvlr.eliteclassroom.api.text.title.TranslatableTitle;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.kyori.adventure.title.Title;
import org.bukkit.entity.Player;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class TextServiceImpl implements TextService {

    private final BukkitAudiences audiences;
    private final InternalizationService internalizationService;
    private final ComponentSerializer componentSerializer;
    private final Map<Locale, ResourceBundle> bundles;

    @Inject
    public TextServiceImpl(
            InternalizationService internalizationService,
            ComponentSerializer componentSerializer,
            BundlesProvider bundlesProvider,
            BukkitAudiences audiences
    ) {
        this.internalizationService = internalizationService;
        this.componentSerializer = componentSerializer;
        this.audiences = audiences;

        Map<Locale, ResourceBundle> bundles;

        try {
            bundles = bundlesProvider.get();
        } catch (IOException e) {
            e.printStackTrace();

            bundles = UnavailableBundles.getDefaultBundles();
        }

        this.bundles = bundles;
    }

    @Override
    public void sendMessage(Audience audience, TranslatableComponent message) {
        audience.forEachAudience(childAudience -> childAudience.sendMessage(this.toKyoriComponent(childAudience, message)));
    }

    @Override
    public void sendMessage(Player player, TranslatableComponent message) {
        Audience audience = this.audiences.player(player);
        this.sendMessage(audience, message);
    }

    @Override
    public void sendTitle(Audience audience, TranslatableTitle title) {
        audience.forEachAudience(childAudience -> {
            Title kyoriTitle = Title.title(
                    this.toKyoriComponent(childAudience, title.getTitle()),
                    this.toKyoriComponent(childAudience, title.getSubTitle()),
                    title.getTimes()
            );

            childAudience.showTitle(kyoriTitle);
        });
    }

    @Override
    public void sendTitle(Player player, TranslatableTitle title) {
        Audience audience = this.audiences.player(player);
        this.sendTitle(audience, title);
    }

    private Component toKyoriComponent(Audience audience, TranslatableComponent component) {
        Locale locale = this.internalizationService.getLocale(audience);
        ResourceBundle bundle = this.bundles.get(locale);

        TextKey key = component.getKey();
        TagResolver[] resolvers = component.getResolvers();

        String input = bundle.getString(key.getKey());

        return this.componentSerializer.deserialize(input, resolvers);
    }
}
