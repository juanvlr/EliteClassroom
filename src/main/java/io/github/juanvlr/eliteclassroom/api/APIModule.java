package io.github.juanvlr.eliteclassroom.api;

import com.google.inject.AbstractModule;
import io.github.juanvlr.eliteclassroom.api.command.CommandModule;
import io.github.juanvlr.eliteclassroom.api.i18n.InternalizationModule;
import io.github.juanvlr.eliteclassroom.api.listener.ListenerModule;
import io.github.juanvlr.eliteclassroom.api.scoreboard.ScoreboardModule;
import io.github.juanvlr.eliteclassroom.api.text.TextModule;

public class APIModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new CommandModule());
        install(new InternalizationModule());
        install(new ListenerModule());
        install(new ScoreboardModule());
        install(new TextModule());
    }
}
