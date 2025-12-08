package dev.lightdev;

import dev.lightdev.commands.admin.*;
import dev.lightdev.commands.handlers.InvalidCooldownHandler;
import dev.lightdev.commands.handlers.InvalidPermissionHandler;
import dev.lightdev.commands.handlers.InvalidUsageCmdHandler;
import dev.lightdev.commands.user.*;
import dev.lightdev.config.MenusConfig;
import dev.lightdev.config.MessageConfig;
import dev.lightdev.config.PluginConfig;
import dev.lightdev.listeners.PlayerInteractListener;
import dev.lightdev.listeners.PlayerJoinListener;
import dev.lightdev.listeners.PlayerKillListener;
import dev.lightdev.listeners.PlayerQuitListener;
import dev.lightdev.managers.ChatManager;
import dev.lightdev.utils.string.ChatUtil;
import dev.rollczi.litecommands.bukkit.LiteBukkitFactory;
import dev.rollczi.litecommands.bukkit.LiteBukkitMessages;
import dev.rollczi.litecommands.message.LiteMessages;

public class LightService {

    private final MessageConfig messageConfig;
    private final PluginConfig pluginConfig;
    private final MenusConfig menusConfig;
    private final ChatManager chatManager;

    public LightService(MessageConfig messageConfig, PluginConfig pluginConfig, MenusConfig menusConfig, ChatManager chatManager) {
        this.messageConfig = messageConfig;
        this.pluginConfig = pluginConfig;
        this.menusConfig = menusConfig;
        this.chatManager = chatManager;

        // Implementation of core events:

        LightPlugin.getPlugin().getServer().getPluginManager().registerEvents(
                new PlayerInteractListener(),
                LightPlugin.getPlugin()
        );
        LightPlugin.getPlugin().getServer().getPluginManager().registerEvents(
                new PlayerJoinListener(this.messageConfig),
                LightPlugin.getPlugin()
        );
        LightPlugin.getPlugin().getServer().getPluginManager().registerEvents(
                new PlayerQuitListener(this.messageConfig),
                LightPlugin.getPlugin()
        );
        LightPlugin.getPlugin().getServer().getPluginManager().registerEvents(
                new PlayerKillListener(this.messageConfig, this.pluginConfig),
                LightPlugin.getPlugin()
        );



        // Implementation of core commands:

        LiteBukkitFactory.builder("lightdev")
                .commands(
                        new AdminChatCommand(this.messageConfig),
                        new AlertCommand(this.messageConfig),
                        new ChatCommand(this.messageConfig, this.chatManager),
                        new ClearCommand(this.messageConfig),
                        new FlyCommand(this.messageConfig),
                        new FlySpeedCommand(this.messageConfig),
                        new GamemodeCommand(this.messageConfig),
                        new SpeedCommand(this.messageConfig),
                        new SummonCommand(this.messageConfig),
                        new FeedCommand(this.messageConfig),
                        new GammaCommand(this.messageConfig),
                        new HealCommand(this.messageConfig),
                        new WorkBenchCommand(),
                        new HelpopCommand(messageConfig),
                        new DiscordCommand(messageConfig),
                        new StoreCommand(messageConfig),
                        new RepairCommand(messageConfig)
                )
                .missingPermission(new InvalidPermissionHandler())
                .invalidUsage(new InvalidUsageCmdHandler())
                .message(LiteMessages.COMMAND_COOLDOWN, (invocation, cooldownState) ->
                        InvalidCooldownHandler.handleCooldown(invocation.sender(), cooldownState))
                .message(LiteBukkitMessages.PLAYER_NOT_FOUND, player ->
                        ChatUtil.fixColor("&#FF0000❌ &8| &cGracz &#FF0000" + player + " &cnie został odnaleziony!"))
                .build();
    }
}
