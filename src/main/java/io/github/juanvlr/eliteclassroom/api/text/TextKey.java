package io.github.juanvlr.eliteclassroom.api.text;

import co.aikar.locales.MessageKeyProvider;

public enum TextKey implements MessageKeyProvider {
    HELLO("hello");

    private final String key;

    TextKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public co.aikar.locales.MessageKey getMessageKey() {
        return co.aikar.locales.MessageKey.of(this.getKey());
    }
}
