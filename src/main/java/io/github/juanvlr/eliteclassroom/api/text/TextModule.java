package io.github.juanvlr.eliteclassroom.api.text;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.github.juanvlr.eliteclassroom.api.text.component.ComponentModule;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class TextModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ComponentModule());
    }

    @Provides
    public MiniMessage provideMiniMessage() {
        return MiniMessage.builder()
                /*.postProcessor(component -> {
                    //System.out.println(component.children());
                    return component;
                })*/
                .build();
    }
}
