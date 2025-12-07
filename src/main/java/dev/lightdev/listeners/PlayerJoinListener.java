package dev.lightdev.listeners;

import dev.lightdev.config.MessageConfig;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Map;

@RequiredArgsConstructor
public class PlayerJoinListener implements Listener {
    
    private final MessageConfig messageConfig;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        final Map<String, Object> placeholders = Map.of("TARGET", player.getName());
        
        // Communicate when player joins to server.

        for (Player online : Bukkit.getOnlinePlayers()) {
            if (!player.hasPlayedBefore()) {
                this.messageConfig.onJoinNewPlayer.send(online, placeholders);
            } else {
                this.messageConfig.onJoinPlayer.send(online, placeholders);
            }
        }

        player.setMaxHealth(60);
        player.setHealth(60);

        e.setJoinMessage(null);
    }
}
