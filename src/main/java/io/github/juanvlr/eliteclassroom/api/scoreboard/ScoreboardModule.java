package io.github.juanvlr.eliteclassroom.api.scoreboard;

import com.google.inject.AbstractModule;

public class ScoreboardModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ScoreboardService.class).to(ScoreboardServiceImpl.class);
    }
}
