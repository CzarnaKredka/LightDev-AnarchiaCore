package dev.lightdev.commands.handlers;

import dev.lightdev.utils.ConsoleMessageUtil;
import dev.lightdev.utils.ConsoleUtil;
import dev.lightdev.utils.string.ChatUtil;
import dev.rollczi.litecommands.handler.result.ResultHandlerChain;
import dev.rollczi.litecommands.invalidusage.InvalidUsage;
import dev.rollczi.litecommands.invalidusage.InvalidUsageHandler;
import dev.rollczi.litecommands.invocation.Invocation;
import dev.rollczi.litecommands.schematic.Schematic;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvalidUsageCmdHandler implements InvalidUsageHandler<CommandSender> {
    @Override
    public void handle(
            Invocation<CommandSender> invocation,
            InvalidUsage<CommandSender> result,
            ResultHandlerChain<CommandSender> chain
    ) {
        CommandSender sender = invocation.sender();
        Schematic schematic = result.getSchematic();

        if (sender instanceof Player player) {
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }

        if (schematic.isOnlyFirst()) {
            sender.sendMessage(ChatUtil.fixColor("&#FF0000❌ &8| &cPoprawne użycie &#FF0000" + schematic.first()));
            return;
        }

        sender.sendMessage(ChatUtil.fixColor("&#FF0000❌ &8| &cPoprawne użycie"));
        for (String scheme : schematic.all()) {
            sender.sendMessage(ChatUtil.fixColor("&8 - &#FF0000" + scheme));
        }
    }
}
