package dev.lightdev.commands.user;

import dev.lightdev.utils.ConsoleMessageUtil;
import dev.lightdev.utils.ConsoleUtil;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Command(name = "crafting", aliases = {"workbench", "wb"})
public class WorkBenchCommand {

    @Execute
    @Permission("meteordev.core.user")
    public void onUseWorkBench(@Context CommandSender commandSender) {
        if (commandSender instanceof Player player) {

            player.openWorkbench(player.getLocation(), true);

            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK,1,1);

        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }
    }
}
