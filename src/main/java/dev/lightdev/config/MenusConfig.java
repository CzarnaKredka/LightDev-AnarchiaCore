package dev.lightdev.config;


import dev.lightdev.config.customitem.MenuDecoration;
import dev.lightdev.config.customitem.MenuItems;
import dev.lightdev.config.customitem.MenusSetup;
import dev.lightdev.config.pass.PassItems;
import dev.lightdev.utils.ItemUtil;
import dev.lightdev.utils.string.ChatUtil;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.platform.core.annotation.Configuration;
import org.bukkit.Material;
import org.bukkit.entity.Item;

import javax.swing.plaf.MenuItemUI;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration(path = "menus.yml")
public class MenusConfig extends OkaeriConfig {

    @Comment
    @Comment("Skonfiguruj menu profilu:")
    public MenusSetup playerProfileMenu = new MenusSetup(
            "&8Dostępne warpy",
            6,
            List.of(
                    new MenuDecoration(1, ChatUtil.fixColor("&r"), Material.RED_STAINED_GLASS_PANE, List.of(0, 8, 45, 53)),
                    new MenuDecoration(2, ChatUtil.fixColor("&r"), Material.GRAY_STAINED_GLASS_PANE, List.of(1, 7, 9, 17, 36, 44, 46, 52)),
                    new MenuDecoration(3, ChatUtil.fixColor("&r"), Material.WHITE_STAINED_GLASS_PANE, List.of(2, 3, 5, 6, 47, 48, 50, 51)),
                    new MenuDecoration(4, ChatUtil.fixColor("&r"), Material.CHAIN, List.of(18, 26, 27, 35)),
                    new MenuDecoration(5, ChatUtil.fixColor("&r"), Material.SHROOMLIGHT, List.of(4))
            )
    );
    public Map<String, List<PassItems>> guiItemsPass = new LinkedHashMap<>() {{
        put("item1", List.of(
                new PassItems(ItemUtil.of(Material.ENCHANTED_GOLDEN_APPLE)
                        .toItemStack(),
                        1,
                        1)
        ));
        put("item2", List.of(
                new PassItems(ItemUtil.of(Material.GOLDEN_APPLE)
                        .toItemStack(),
                        1,
                        2)
        ));
    }};
    }

