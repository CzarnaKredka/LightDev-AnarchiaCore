package dev.lightdev.commands.handlers;

import dev.lightdev.utils.TimeUtil;
import dev.lightdev.utils.string.ChatUtil;
import dev.rollczi.litecommands.cooldown.CooldownState;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.time.Duration;

public class InvalidCooldownHandler {

    public static String handleCooldown(CommandSender sender, CooldownState cooldownState) {
        Duration remainingDuration = cooldownState.getRemainingDuration();
        String formattedTime = TimeUtil.convertTime(remainingDuration.toMillis());

        if (sender instanceof Player player) {
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
        }

        return ChatUtil.fixColor("&#FF0000❌ &8| &cNastępny raz tą komendę będziesz mógł użyć za &#FF0000" + formattedTime + ChatUtil.fixColor(""));
    }
}
