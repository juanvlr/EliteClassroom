package io.github.juanvlr.eliteclassroom.api.scoreboard;

import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface ScoreboardService {

    void addScoreboard(Player player);

    FastBoard getScoreboard(UUID player);
}
