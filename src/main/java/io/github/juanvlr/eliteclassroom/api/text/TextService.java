package io.github.juanvlr.eliteclassroom.api.text;

import io.github.juanvlr.eliteclassroom.api.text.component.TranslatableComponent;
import io.github.juanvlr.eliteclassroom.api.text.component.TranslatableTitle;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public interface TextService {

    void sendMessage(Audience audience, TranslatableComponent message);

    void sendMessage(Player player, TranslatableComponent message);

    void sendTitle(Audience audience, TranslatableTitle title);

    void sendTitle(Player player, TranslatableTitle title);

    Component toKyoriComponent(Audience audience, TranslatableComponent component);
}
