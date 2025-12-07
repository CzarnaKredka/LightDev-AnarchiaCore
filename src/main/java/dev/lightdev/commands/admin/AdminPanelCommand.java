package dev.lightdev.commands.admin;

import dev.lightdev.config.MenusConfig;
import dev.lightdev.config.MessageConfig;
import dev.lightdev.utils.ConsoleMessageUtil;
import dev.lightdev.utils.ConsoleUtil;
import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.optional.OptionalArg;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@RequiredArgsConstructor(onConstructor_ = @Inject)
@Command(name = "adminpanel")
public class AdminPanelCommand {

    private final MenusConfig menusConfig;
    private final MessageConfig messageConfig;

    @Execute
    public void onOpen(@Context CommandSender commandSender) {
        if (commandSender instanceof Player player) {

            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1,1);

        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }
    }

    @Execute(name = "give shard")
    public void onGiveShard(@Context CommandSender commandSender, @Arg("nick") Player target, @OptionalArg("ilość") int amount) {
        if (commandSender instanceof Player player) {

            target.getInventory().addItem();

        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }
    }
}
