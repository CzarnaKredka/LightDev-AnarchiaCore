package dev.lightdev.managers;

import eu.okaeri.platform.core.annotation.Component;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Component
public class ChatManager {

    private boolean chatEnabled = true;
    private boolean autoTitlesEnabled = true;
    private boolean autoMessagesEnabled = true;
    private int cooldownMessage = 5;


    private final Map<UUID, Long> cooldowns = new HashMap<>();

    public long getRemainingCooldown(Player player) {
        Long last = cooldowns.get(player.getUniqueId());
        if (last == null) return 0;

        long elapsed = System.currentTimeMillis() - last;
        long remaining = (cooldownMessage * 1000L) - elapsed;
        return Math.max(remaining / 1000L, 0);
    }

    public boolean isOnCooldown(Player player) {
        return getRemainingCooldown(player) > 0;
    }

    public void updateCooldown(Player player) {
        cooldowns.put(player.getUniqueId(), System.currentTimeMillis());
    }
}

