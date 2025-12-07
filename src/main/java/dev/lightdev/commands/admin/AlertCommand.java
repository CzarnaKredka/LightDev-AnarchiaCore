package dev.lightdev.commands.admin;

import dev.lightdev.config.MessageConfig;
import dev.lightdev.utils.ConsoleMessageUtil;
import dev.lightdev.utils.ConsoleUtil;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.join.Join;
import dev.rollczi.litecommands.annotations.permission.Permission;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

@Command(name = "alert", aliases = "ogloszenie")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class AlertCommand {

    private final MessageConfig messageConfig;

    @Execute
    @Permission("meteodev.core.admin")
    public void onAlertUse(@Context CommandSender commandSender, @Join("message") String message) {
        if (commandSender instanceof Player player) {

            Map<String, Object> placeholders = Map.of("MESSAGE", message);
            this.messageConfig.onAlertSend.send(player);

            for (Player online : Bukkit.getOnlinePlayers()) {
                this.messageConfig.onAlertSendPlayers.send(online, placeholders);
                online.playSound(online.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO,1,1);
            }


        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }
    }
}
