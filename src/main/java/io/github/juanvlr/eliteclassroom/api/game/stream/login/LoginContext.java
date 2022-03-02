package io.github.juanvlr.eliteclassroom.api.game.stream.login;

import org.bukkit.entity.Player;

public interface LoginContext {

    Player getPlayer();

    boolean isNewPlayer();
}
