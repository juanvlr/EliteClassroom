package io.github.juanvlr.eliteclassroom.api.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.PaperCommandManager;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.multibindings.Multibinder;
import org.bukkit.plugin.Plugin;

public class CommandModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder.newSetBinder(binder(), BaseCommand.class);

        bind(CommandRegisterer.class).to(CommandRegistererImpl.class);
    }

    @Provides
    public PaperCommandManager provideCommandManager(Plugin plugin) {
        return new PaperCommandManager(plugin);
    }
}
