package dev.lightdev.config;

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

    @Comment("")
    @Comment("Skonfiguruj przedmiot wybierający tryb:")
    public MenuItems chooseMode = new MenuItems(ItemUtil.of(Material.BELL)
            .setName(ChatUtil.fixColor("&#FCD05C&lᴡ&#FDD56C&lʏ&#FDDA7D&lʙ&#FEDF8D&lɪ&#FEE49E&lᴇ&#FFE9AE&lʀ&#FFE5A0&lᴢ &#FEDD85&lᴛ&#FDD877&lʀ&#FDD46A&lʏ&#FCD05C&lʙ"))
            .setLore(ChatUtil.fixLore(Arrays.asList(
                    "",
                    " &8● &7Tu znajdziesz &fwszystkie &7tryby",
                    " &8● &7dostępne na serwerze.",
                    "",
                    " &8● &aKliknij &2PRAWYM&a, aby otworzyć!"
            )))
            .toItemStack(),
            4,
            1
    );

    @Comment("")
    @Comment("Skonfiguruj przedmiot profilu gracza:")
    public MenuItems playerProfile = new MenuItems(ItemUtil.of(Material.PLAYER_HEAD)
            .setName(ChatUtil.fixColor("&#FF0000&lᴛ&#FF5500&lᴡ&#FFAA00&ló&#FFFF00&lᴊ &#55FF00&lᴘ&#00AA55&lʀ&#0000FF&lᴏ&#3200AC&lꜰ&#63009D&lɪ&#9400D3&lʟ"))
            .setLore(ChatUtil.fixLore(Arrays.asList(
                    "",
                    " &8● &7Tu znajdziesz &fwszystkie &7informację",
                    " &8● &7na temat twojej osoby.",
                    "",
                    " &8● &aKliknij &2PRAWYM&a, aby otworzyć!"
            )))
            .toItemStack(),
            8,
            1
    );

    @Comment("")
    @Comment("Skonfiguruj przedmiot walki:")
    public MenuItems swordItem = new MenuItems(ItemUtil.of(Material.DIAMOND_SWORD)
            .setName(ChatUtil.fixColor("&#FC5C5C&lʀ&#FC6666&lᴏ&#FD7171&lᴢ&#FD7B7B&lᴘ&#FE8585&lᴏ&#FE8F8F&lᴄ&#FF9A9A&lᴢ&#FFA4A4&lɴ&#FF9B9B&lɪ&#FE9292&lᴊ &#FE8080&lᴡ&#FD7777&lᴀ&#FD6E6E&lʟ&#FC6565&lᴋ&#FC5C5C&lᴇ"))
            .setLore(ChatUtil.fixLore(Arrays.asList(
                    "",
                    " &8● &7Aby rozpocząć &fwalkę &7musisz",
                    " &8● &7trzymać ten miecz przez &c5 &7sekund.",
                    "",
                    " &8● &aPrzytrzymaj w &2RĘCĘ&a, aby zawalczyć!"
            )))
            .addFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS)
            .toItemStack(),
            0,
            1
    );
}
