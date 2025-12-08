package dev.lightdev.commands.user;

import dev.lightdev.config.MessageConfig;
import dev.lightdev.utils.ConsoleMessageUtil;
import dev.lightdev.utils.ConsoleUtil;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Command(name = "strona", aliases = "store")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class StoreCommand {

    private final MessageConfig messageConfig;

    @Execute
    void Store(@Context CommandSender commandSender) {
        if (commandSender instanceof Player p) {
            this.messageConfig.storeSend.send(p);
        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");

        }
    }
}
