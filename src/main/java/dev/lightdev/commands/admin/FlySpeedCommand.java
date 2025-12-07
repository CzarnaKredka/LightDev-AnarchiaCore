package dev.lightdev.commands.admin;

import dev.lightdev.config.MessageConfig;
import dev.lightdev.utils.ConsoleMessageUtil;
import dev.lightdev.utils.ConsoleUtil;
import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

@Command(name = "flyspeed")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class FlySpeedCommand {

    private final MessageConfig messageConfig;

    @Execute
    public void onUseFlySpeed(@Context CommandSender commandSender, @Arg("amount") int speed) {
        if (commandSender instanceof Player player) {

            Map<String, Object> placeholders = Map.of("SPEED", speed);

            player.setFlySpeed(speed / 10f);

            this.messageConfig.onFlySpeedUse.send(player, placeholders);

            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1,1);

        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }
    }

    @Execute
    public void onUseFlySpeedOthers(@Context CommandSender commandSender, @Arg("amount") int speed, @Arg("player") Player target) {
        if (commandSender instanceof Player player) {

            Map<String, Object> placeholders = Map.of("SPEED", speed, "TARGET", target.getName());

            target.setFlySpeed(speed / 10f);

            this.messageConfig.onFlySpeedUsePlayer.send(player, placeholders);

            target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1,1);

        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }
    }
}
