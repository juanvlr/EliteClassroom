package io.github.juanvlr.eliteclassroom.api.text;

import io.github.juanvlr.eliteclassroom.api.text.component.TranslatableComponent;
import io.github.juanvlr.eliteclassroom.api.text.component.TranslatableTitleComponent;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public interface TextService {

    void sendMessage(Audience audience, TranslatableComponent message);

    void sendMessage(Player player, TranslatableComponent message);

    void sendTitle(Audience audience, TranslatableTitleComponent title);

    void sendTitle(Player player, TranslatableTitleComponent title);

    Component toKyoriComponent(Audience audience, TranslatableComponent component);
}
