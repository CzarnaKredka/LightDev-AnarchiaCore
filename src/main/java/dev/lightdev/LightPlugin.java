package dev.lightdev;

import dev.lightdev.config.MenusConfig;
import dev.lightdev.config.MessageConfig;
import dev.lightdev.config.PluginConfig;
import dev.lightdev.managers.ChatManager;
import eu.okaeri.injector.annotation.Inject;
import eu.okaeri.platform.bukkit.OkaeriBukkitPlugin;
import eu.okaeri.platform.core.annotation.Register;
import eu.okaeri.platform.core.plan.ExecutionPhase;
import eu.okaeri.platform.core.plan.Planned;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

// Configuration

@Register(MenusConfig.class)
@Register(MessageConfig.class)
@Register(PluginConfig.class)

// Managers
@Register(ChatManager.class)
public final class LightPlugin extends OkaeriBukkitPlugin {

    @Getter private static LightPlugin plugin;

    @Inject private MenusConfig menusConfig;
    @Inject private MessageConfig messageConfig;
    @Inject private PluginConfig pluginConfig;
    @Inject private ChatManager chatManager;

    @Planned(ExecutionPhase.PRE_SETUP)
    public void preSetup() {
        plugin = this;
    }


    @Planned(ExecutionPhase.STARTUP)
    public void startUp() {

        final List<String> authors = Arrays.asList("CzarnaKredka", "Katix");
        final List<String> actualAuthors = plugin.getDescription().getAuthors();

        // Checks authors main plugin [ CzarnaKredka, Katix ]

        if (!actualAuthors.containsAll(authors) || actualAuthors.size() != authors.size()) {
            getLogger().warning("");
            getLogger().warning("-----------------------");
            getLogger().warning("ZMIENIONO AUTHORÓW PLUGINU!");
            getLogger().warning("");
            getLogger().warning("WYŁĄCZAM PLUGIN (...)");
            getLogger().warning("-----------------------");
            getLogger().warning("");
            plugin.getServer().getPluginManager().disablePlugin(plugin);
        }

        // Checks actually plugin name [ LightDev-AnarchiaCore ] :

        if (!plugin.getDescription().getName().contains("LightDev-AnarchiaCore")) {
            getLogger().log(Level.WARNING, "");
            getLogger().log(Level.WARNING, "-----------------------");
            getLogger().log(Level.WARNING, "ZMIENIONO NAZWĘ PLUGINU!");
            getLogger().log(Level.WARNING, "");
            getLogger().log(Level.WARNING, "WYŁĄCZAM PLUGIN (...)");
            getLogger().log(Level.WARNING, "-----------------------");
            getLogger().log(Level.WARNING, "");
            plugin.getServer().getPluginManager().disablePlugin(plugin);
        }

        // Implementation of service managment plugin:

        new LightService(
                this.messageConfig,
                this.pluginConfig,
                this.menusConfig,
                this.chatManager
        );
    }
}
