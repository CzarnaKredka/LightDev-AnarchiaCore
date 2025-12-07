package dev.lightdev.commands.handlers;

import dev.lightdev.utils.string.ChatUtil;
import dev.rollczi.litecommands.handler.result.ResultHandlerChain;
import dev.rollczi.litecommands.invocation.Invocation;
import dev.rollczi.litecommands.permission.MissingPermissions;
import dev.rollczi.litecommands.permission.MissingPermissionsHandler;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvalidPermissionHandler implements MissingPermissionsHandler<CommandSender> {

    @Override
    public void handle(
            Invocation<CommandSender> invocation,
            MissingPermissions missingPermissions,
            ResultHandlerChain<CommandSender> chain
    ) {
        String permissions = missingPermissions.asJoinedText();
        CommandSender sender = invocation.sender();


        if (sender instanceof Player player) {
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);

            sender.sendMessage(ChatUtil.fixColor("&#FF0000❌ &8| &cNie posiadasz uprawnień &#FF0000(&#FF0000" + permissions + ")"));
        }
    }
}