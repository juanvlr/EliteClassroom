package io.github.juanvlr.eliteclassroom.api.command.condition;

import co.aikar.commands.BukkitCommandExecutionContext;
import co.aikar.commands.BukkitCommandIssuer;
import co.aikar.commands.BukkitConditionContext;
import co.aikar.commands.CommandConditions;

public abstract class ParameterRegistrableCondition<T> extends RegistrableCondition implements CommandConditions.ParameterCondition<T, BukkitCommandExecutionContext, BukkitCommandIssuer> {

    private final Class<T> type;

    public ParameterRegistrableCondition(Class<T> type, String id) {
        super(id);

        this.type = type;
    }

    @Override
    public void register(CommandConditions<BukkitCommandIssuer, BukkitCommandExecutionContext, BukkitConditionContext> conditions) {
        conditions.addCondition(this.type, this.id, this);
    }
}
