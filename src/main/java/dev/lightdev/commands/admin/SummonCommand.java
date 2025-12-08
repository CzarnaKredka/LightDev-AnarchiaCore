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

@Command(name = "tphere", aliases = {"summon", "przywolaj", "s"})
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class SummonCommand {

    private final MessageConfig messageConfig;

    @Execute
    @Permission("lightdev.core.admin")
    public void onUseSummon(@Context CommandSender commandSender, @Arg("player") Player target) {
        if (commandSender instanceof Player player) {

            target.teleport(player);

            this.messageConfig.onTpherePlayer.send(player);

            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,1,1);
        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda jest do użycia tylko dla gracza!");
        }
    }
}
