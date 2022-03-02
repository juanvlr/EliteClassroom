package io.github.juanvlr.eliteclassroom.api.command.condition;

import co.aikar.commands.BukkitCommandExecutionContext;
import co.aikar.commands.BukkitCommandIssuer;
import co.aikar.commands.BukkitConditionContext;
import co.aikar.commands.CommandConditions;

public abstract class IssuerRegistrableCondition extends RegistrableCondition implements CommandConditions.Condition<BukkitCommandIssuer> {

    public IssuerRegistrableCondition(String id) {
        super(id);
    }

    @Override
    public void register(CommandConditions<BukkitCommandIssuer, BukkitCommandExecutionContext, BukkitConditionContext> conditions) {
        conditions.addCondition(this.id, this);
    }
}
