package io.github.juanvlr.eliteclassroom.api.command.condition;

import co.aikar.commands.BukkitCommandExecutionContext;
import co.aikar.commands.BukkitCommandIssuer;
import co.aikar.commands.BukkitConditionContext;
import co.aikar.commands.CommandConditions;

public abstract class RegistrableCondition {

    protected final String id;

    public RegistrableCondition(String id) {
        this.id = id;
    }

    public abstract void register(CommandConditions<BukkitCommandIssuer, BukkitCommandExecutionContext, BukkitConditionContext> conditions);
}
