package dev.lightdev.commands.user;


import dev.lightdev.config.MessageConfig;
import dev.lightdev.utils.ConsoleMessageUtil;
import dev.lightdev.utils.ConsoleUtil;
import dev.lightdev.utils.string.ChatUtil;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.cooldown.Cooldown;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.join.Join;
import dev.rollczi.litecommands.annotations.permission.Permission;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.time.temporal.ChronoUnit;
import java.util.Map;

@Command(name = "helpop")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class HelpopCommand {


    private final MessageConfig messageConfig;

    @Execute
    @Permission("lightdev.core.user")
    @Cooldown(key = "helpop<UUID>", count = 10, unit = ChronoUnit.SECONDS)
    void Helpop(@Context CommandSender commandSender, @Join("message") String message) {
        if (commandSender instanceof Player p) {

            Map<String, Object> placeholders = Map.of("MESSAGE", message, "PLAYER", p.getName());

            this.messageConfig.helpopUserMessage.send(p, placeholders);

            for (Player online : Bukkit.getOnlinePlayers()) {
                if (online.hasPermission("lightdev.admin.helpop")) {
                    this.messageConfig.helpopAdminMessage.send(online, placeholders);
                } else {
                    ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
                }
            }
        }
    }
}