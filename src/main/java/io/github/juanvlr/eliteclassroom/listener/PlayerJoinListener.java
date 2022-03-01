package io.github.juanvlr.eliteclassroom.listener;

import io.github.juanvlr.eliteclassroom.api.text.TextKey;
import io.github.juanvlr.eliteclassroom.api.text.TextService;
import io.github.juanvlr.eliteclassroom.api.text.component.TranslatableComponent;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import javax.inject.Inject;

public class PlayerJoinListener implements Listener {

    private final BukkitAudiences audiences;
    private final TextService textService;

    @Inject
    public PlayerJoinListener(BukkitAudiences audiences, TextService textService) {
        this.audiences = audiences;
        this.textService = textService;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Audience audience = this.audiences.player(player);
        this.textService.sendMessage(audience, TranslatableComponent.from(
                TextKey.HELLO,
                Placeholder.component("name", Component.text(player.getName())))
        );
    }
}
