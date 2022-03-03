package io.github.juanvlr.eliteclassroom.api.text;

import co.aikar.locales.MessageKey;
import co.aikar.locales.MessageKeyProvider;
import net.kyori.adventure.translation.Translatable;
import org.jetbrains.annotations.NotNull;

public enum TextKey implements MessageKeyProvider, Translatable {

    DONATE("donate"),
    RECEIVE("receive"),
    STEAL("steal"),
    STOLEN("stolen"),
    NOT_BREAK_TIME("not-break-time"),
    SELF("self"),
    NEGATIVE_AMOUNT("negative-amount"),
    HAS_NOT_ENOUGH("has-not-enough"),
    IS_THIEF("is-thief"),
    TOO_FAR("too-far"),
    JOIN("join");

    private final String key;

    TextKey(String key) {
        this.key = key;
    }

    @Override
    public MessageKey getMessageKey() {
        return MessageKey.of(this.getKey());
    }

    @Override
    public @NotNull String translationKey() {
        return this.getKey();
    }

    private String getKey() {
        return this.key;
    }
}
