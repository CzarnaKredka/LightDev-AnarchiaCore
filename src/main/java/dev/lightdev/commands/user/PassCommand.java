package dev.lightdev.commands.user;

import dev.lightdev.config.MenusConfig;
import dev.lightdev.utils.ConsoleMessageUtil;
import dev.lightdev.utils.ConsoleUtil;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@RequiredArgsConstructor(onConstructor_ = @Inject)
@Command(name = "karnet", aliases = "pass")
public class PassCommand {

    private final MenusConfig menusConfig;

    @Execute
    public void onOpen(@Context CommandSender commandSender) {
        if (commandSender instanceof Player player) {

            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1,1);

        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }
    }
}
