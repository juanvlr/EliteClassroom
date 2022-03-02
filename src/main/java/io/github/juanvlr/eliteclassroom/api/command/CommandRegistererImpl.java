package io.github.juanvlr.eliteclassroom.api.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.PaperCommandManager;
import io.github.juanvlr.eliteclassroom.api.command.condition.RegistrableCondition;

import javax.inject.Inject;
import java.util.Set;

public class CommandRegistererImpl implements CommandRegisterer {

    private final PaperCommandManager commandManager;

    private final Set<RegistrableCondition> conditions;
    private final Set<BaseCommand> commands;

    @Inject
    public CommandRegistererImpl(PaperCommandManager commandManager, Set<RegistrableCondition> conditions, Set<BaseCommand> commands) {
        this.commandManager = commandManager;
        this.conditions = conditions;
        this.commands = commands;
    }

    @Override
    public void registerCommands() {
        this.conditions.forEach(condition -> condition.register(this.commandManager.getCommandConditions()));
        this.commands.forEach(this.commandManager::registerCommand);
    }
}
