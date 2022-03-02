package io.github.juanvlr.eliteclassroom.api.scoreboard;

import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ScoreboardServiceImpl implements ScoreboardService {

    private final Map<UUID, FastBoard> scoreboards;

    public ScoreboardServiceImpl() {
        this.scoreboards = new HashMap<>();
    }

    @Override
    public void addScoreboard(Player player) {
        this.scoreboards.put(player.getUniqueId(), new FastBoard(player));
    }

    @Override
    public FastBoard getScoreboard(UUID player) {
        return this.scoreboards.get(player);
    }
}
