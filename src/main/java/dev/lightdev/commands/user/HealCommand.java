package dev.lightdev.commands.user;

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

import java.util.Map;

@Command(name = "heal", aliases = "ulecz")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class HealCommand {

    private final MessageConfig messageConfig;

    @Execute
    @Permission("meteordev.core.user")
    public void onHealOwn(@Context CommandSender commandSender) {
        if (commandSender instanceof Player player) {

            player.setHealth(player.getMaxHealth());
            player.setFoodLevel(20);

            this.messageConfig.onHealOwn.send(player);

            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO,1,1);

        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }
    }

    @Execute
    @Permission("meteordev.core.user")
    public void onHealOthers(@Context CommandSender commandSender, @Arg("player") Player target) {
        if (commandSender instanceof Player player) {

            Map<String, Object> placeholders = Map.of("TARGET", target.getName());

            target.setHealth(target.getMaxHealth());
            target.setFoodLevel(20);

            this.messageConfig.onHealOthers.send(player, placeholders);

            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO,1,1);

        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }
    }
}
