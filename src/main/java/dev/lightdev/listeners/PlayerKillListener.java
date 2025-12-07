package dev.lightdev.listeners;

import dev.lightdev.config.MessageConfig;
import dev.lightdev.config.PluginConfig;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Map;

@RequiredArgsConstructor
public class PlayerKillListener implements Listener {

    private final MessageConfig messageConfig;
    private final PluginConfig pluginConfig;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onKill(PlayerDeathEvent e) {
        Player player = e.getPlayer();
        Player target = e.getPlayer().getKiller();

        final Map<String, Object> placeholders = Map.of("PLAYER", player.getName());

        target.getInventory().addItem(this.pluginConfig.shard.toItemStack());
        this.messageConfig.onKillPlayer.send(target, placeholders);
    }
}
