package dev.lightdev.menus;

import dev.lightdev.config.MenusConfig;
import dev.lightdev.utils.string.ChatUtil;
import dev.triumphteam.gui.guis.Gui;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
public class PassMenu {

    private final MenusConfig menusConfig;
    private final Map<UUID, Integer> clickMap = new ConcurrentHashMap<>();


    public void openMainMenu(Player player) {
        Gui gui = Gui.gui()
                .title(Component.text(ChatUtil.fixColor("")))
                .rows(6)
                .create();




        gui.setDefaultClickAction(e -> {
            e.setCancelled(true);
            UUID uuid = player.getUniqueId();
            int clicks = this.clickMap.getOrDefault(uuid, 0) + 1;
            if (clicks >= 4) {
                player.sendActionBar(ChatUtil.fixColor("&cGdzie ci się tak &4śpieszy?"));
                this.clickMap.put(uuid, 0);
            } else {
                this.clickMap.put(uuid, clicks);
            }
        });

        gui.open(player);
    }
}
