package io.github.juanvlr.eliteclassroom.api.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.PaperCommandManager;

import javax.inject.Inject;
import java.util.Set;

public class CommandRegistererImpl implements CommandRegisterer {

    private final PaperCommandManager commandManager;
    private final Set<BaseCommand> commands;

    @Inject
    public CommandRegistererImpl(PaperCommandManager commandManager, Set<BaseCommand> commands) {
        this.commandManager = commandManager;
        this.commands = commands;
    }

    @Override
    public void registerCommands() {
        this.commands.forEach(this.commandManager::registerCommand);
    }
}
