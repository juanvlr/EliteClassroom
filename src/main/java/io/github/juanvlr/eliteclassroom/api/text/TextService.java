package io.github.juanvlr.eliteclassroom.api.text;

import io.github.juanvlr.eliteclassroom.api.text.component.TranslatableComponent;
import io.github.juanvlr.eliteclassroom.api.text.title.TranslatableTitle;
import net.kyori.adventure.audience.Audience;
import org.bukkit.entity.Player;

public interface TextService {

    void sendMessage(Audience audience, TranslatableComponent message);

    void sendMessage(Player player, TranslatableComponent message);

    void sendTitle(Audience audience, TranslatableTitle title);

    void sendTitle(Player player, TranslatableTitle title);
}
