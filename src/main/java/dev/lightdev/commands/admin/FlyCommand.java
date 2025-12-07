package dev.lightdev.commands.admin;

import dev.lightdev.config.MessageConfig;
import dev.lightdev.utils.ConsoleMessageUtil;
import dev.lightdev.utils.ConsoleUtil;
import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@RequiredArgsConstructor(onConstructor_ = @Inject)
@Command(name = "fly", aliases = "lataj")
public class FlyCommand {

    private final MessageConfig messageConfig;

    @Execute
    @Permission("meteordev.core.admin")
    public void onFlyToggle(@Context CommandSender commandSender) {
        if (commandSender instanceof Player player) {

            if (player.getAllowFlight()) {
                player.setFlying(false);
                player.setAllowFlight(false);
                this.messageConfig.offFlyToggle.send(player);
            } else {
                player.setAllowFlight(true);
                player.setFlying(true);
                this.messageConfig.onFlyToggle.send(player);
            }
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO, 1, 1);

        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }
    }

    @Execute
    @Permission("meteordev.core.admin")
    public void onFlyToggleOthers(@Context CommandSender commandSender, @Arg("player") Player target) {
        if (commandSender instanceof Player player) {

            if (target.getAllowFlight()) {
                target.setFlying(false);
                target.setAllowFlight(false);
                this.messageConfig.offFlyToggleOthers.send(player);
            } else {
                target.setAllowFlight(true);
                target.setFlying(true);
                this.messageConfig.onFlyToggleOthers.send(player);
            }
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO, 1, 1);

        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }
    }
}
