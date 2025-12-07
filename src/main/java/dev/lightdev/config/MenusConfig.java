package dev.lightdev.config;


import dev.lightdev.config.customitem.MenuDecoration;
import dev.lightdev.config.customitem.MenuItems;
import dev.lightdev.config.customitem.MenusSetup;
import dev.lightdev.utils.ItemUtil;
import dev.lightdev.utils.string.ChatUtil;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.platform.core.annotation.Configuration;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

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
                    new MenuDecoration(4, ChatUtil.fixColor("&r"), Material.IRON_CHAIN, List.of(18, 26, 27, 35)),
                    new MenuDecoration(5, ChatUtil.fixColor("&r"), Material.SHROOMLIGHT, List.of(4))
            )
    );
    public MenuItems warpBezpieczna = new MenuItems(ItemUtil.of(Material.DIAMOND_PICKAXE)
            .setName(ChatUtil.fixColor("&#68FF48&lꜱ&#70FF4E&lᴛ&#77FF53&lʀ&#7FFF59&lᴇ&#87FF5F&lꜰ&#8EFF64&lᴀ &#9DFF6F&lʙ&#A5FF75&lᴇ&#9DFF6F&lᴢ&#96FF6A&lᴘ&#8EFF64&lɪ&#87FF5F&lᴇ&#7FFF59&lᴄ&#77FF53&lᴢ&#70FF4E&lɴ&#68FF48&lᴀ"))
            .setLore(ChatUtil.fixLore(Arrays.asList(
                    "",
                    " &8● &fKliknij, aby się &#A5FF75przeteleportować!"
            )))
            .toItemStack(),
            21,
            0
    );
    public MenuItems warpPvP = new MenuItems(ItemUtil.of(Material.NETHERITE_SWORD)
            .setName(ChatUtil.fixColor("&#FF4848&lꜱ&#FF5151&lᴛ&#FF5A5A&lʀ&#FF6363&lᴇ&#FF6C6C&lꜰ&#FF7575&lᴀ &#FF5F5F&lᴘ&#FF5353&lᴠ&#FF4848&lᴘ"))
            .setLore(ChatUtil.fixLore(Arrays.asList(
                    "",
                    " &8● &fKliknij, aby się &#FF7575przeteleportować!"
            )))
            .toItemStack(),
            22,
            0
    );
    public MenuItems warpAfk = new MenuItems(ItemUtil.of(Material.CLOCK)
            .setName(ChatUtil.fixColor("&#48FFFF&lꜱ&#59FFFD&lᴛ&#6AFFFB&lʀ&#7AFFFA&lᴇ&#8BFFF8&lꜰ&#9CFFF6&lᴀ &#72FFFB&lᴀ&#5DFFFD&lꜰ&#48FFFF&lᴋ"))
            .setLore(ChatUtil.fixLore(Arrays.asList(
                    "",
                    " &8● &fKliknij, aby się &#9CFFF6przeteleportować!"
            )))
            .toItemStack(),
            23,
            0
    );
    public MenuItems warpSkrzynki = new MenuItems(ItemUtil.of(Material.CLOCK)
            .setName(ChatUtil.fixColor("&#FF7C48&lꜱ&#FF844F&lᴛ&#FF8B55&lʀ&#FF935C&lᴇ&#FF9B63&lꜰ&#FFA36A&lᴀ &#FFB277&lꜱ&#FFAA70&lᴋ&#FFA36A&lʀ&#FF9B63&lᴢ&#FF935C&lʏ&#FF8B55&lɴ&#FF844F&lᴇ&#FF7C48&lᴋ"))
            .setLore(ChatUtil.fixLore(Arrays.asList(
                    "",
                    " &8● &fKliknij, aby się &#FFB277przeteleportować!"
            )))
            .toItemStack(),
            31,
            0
    );

}

