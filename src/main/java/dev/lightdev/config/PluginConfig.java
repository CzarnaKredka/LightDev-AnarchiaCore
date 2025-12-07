package dev.lightdev.config;

import dev.lightdev.config.customitem.CustomItem;
import dev.lightdev.config.customitem.MenuItems;
import dev.lightdev.utils.ItemUtil;
import dev.lightdev.utils.string.ChatUtil;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.platform.core.annotation.Configuration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;

import java.util.Arrays;

@Configuration(path = "config.yml")
public class PluginConfig extends OkaeriConfig {

    @Comment()
    @Comment("Odłamek po zabiciu z gracza:")
    public CustomItem shard = new CustomItem(ItemUtil.of(
            Material.SKELETON_SKULL)
            .setName(ChatUtil.fixColor("&6Czaszka jełopka"))
            .setLore(ChatUtil.fixLore(Arrays.asList(
                    "",
                    "&8x &7Wykorzystuj na &fnagrody&7!"
            )))
            .toItemStack(),
            1);
}
