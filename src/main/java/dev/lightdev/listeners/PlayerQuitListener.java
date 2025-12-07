package dev.lightdev.listeners;

import dev.lightdev.config.MessageConfig;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Map;

@RequiredArgsConstructor
public class PlayerQuitListener implements Listener {

    private final MessageConfig messageConfig;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        final Map<String, Object> placeholders = Map.of("TARGET", player.getName());

        for (Player online : Bukkit.getOnlinePlayers()) {
            this.messageConfig.onQuitPlayer.send(online, placeholders);
        }
    }
}
