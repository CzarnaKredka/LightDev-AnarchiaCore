package dev.lightdev.commands.admin;

import dev.lightdev.config.MessageConfig;
import dev.lightdev.managers.ChatManager;
import dev.lightdev.utils.ConsoleMessageUtil;
import dev.lightdev.utils.ConsoleUtil;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

@Command(name = "chat")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class ChatCommand {

    private final MessageConfig messageConfig;
    private final ChatManager chatManager;

    @Execute(name = "on")
    @Permission("meteodev.core.admin")
    public void onEnableChat(@Context CommandSender commandSender) {
        if (commandSender instanceof Player player) {

            final Map<String, Object> placeholders = Map.of("PLAYER", player.getName());

            for (Player online : Bukkit.getOnlinePlayers()) {
                this.messageConfig.onEnableChat.send(online, placeholders);

                online.playSound(online.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1,1);
            }

            this.chatManager.setChatEnabled(true);


        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda jest do użycia tylko dla gracza!");
        }
    }

    @Execute(name = "off")
    @Permission("meteodev.core.admin")
    public void onDisableChat(@Context CommandSender commandSender) {
        if (commandSender instanceof Player player) {

            final Map<String, Object> placeholders = Map.of("PLAYER", player.getName());

            for (Player online : Bukkit.getOnlinePlayers()) {
                this.messageConfig.onDisableChat.send(online, placeholders);

                online.playSound(online.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1,1);
            }

            this.chatManager.setChatEnabled(false);


        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda jest do użycia tylko dla gracza!");
        }
    }

    @Execute(name = "clear")
    @Permission("meteodev.core.admin")
    public void onClearChat(@Context CommandSender commandSender) {
        if (commandSender instanceof Player player) {

            final Map<String, Object> placeholders = Map.of("PLAYER", player.getName());

            for (int i = 0; i < 100; i++) {
                Bukkit.broadcastMessage("");
            }

            for (Player online : Bukkit.getOnlinePlayers()) {
                this.messageConfig.onClearChat.send(online, placeholders);

                online.playSound(online.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1,1);
            }


        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda jest do użycia tylko dla gracza!");
        }
    }
}
