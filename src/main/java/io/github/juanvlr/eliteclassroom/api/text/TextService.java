package io.github.juanvlr.eliteclassroom.api.text;

import io.github.juanvlr.eliteclassroom.api.text.component.TranslatableComponent;
import io.github.juanvlr.eliteclassroom.api.text.title.TranslatableTitle;
import net.kyori.adventure.audience.Audience;

public interface TextService {

    void sendMessage(Audience audience, TranslatableComponent message);

    void sendTitle(Audience audience, TranslatableTitle title);
}
