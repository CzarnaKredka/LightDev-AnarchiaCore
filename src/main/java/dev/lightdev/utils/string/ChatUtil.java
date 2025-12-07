package dev.lightdev.utils.string;

import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class ChatUtil {
    static public final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";

    public static String fixColor(String text) {
        String[] texts = text.split(String.format(WITH_DELIMITER, "&"));
        StringBuilder finalText = new StringBuilder();
        for (int i = 0; i < texts.length; i++) {
            if (texts[i].equalsIgnoreCase("&")) {
                i++;
                if (texts[i].charAt(0) == '#') {
                    finalText.append(net.md_5.bungee.api.ChatColor.of(texts[i].substring(0, 7)) + texts[i].substring(7));
                } else {
                    finalText.append(ChatColor.translateAlternateColorCodes('&', "&" + texts[i]).replace(">>", "»"));
                }
            } else {
                finalText.append(texts[i]);
            }
        }
        return finalText.toString();
    }

    public static String fixColor(@NonNull String text, @NonNull Map<String, Object> placeholders) {
        return fixColor(text, Locale.forLanguageTag("pl"), placeholders, true);
    }

    public static String fixColor(@NonNull String text, @NonNull Map<String, Object> placeholders, boolean colorizePlaceholders) {
        return fixColor(text, Locale.forLanguageTag("pl"), placeholders, colorizePlaceholders);
    }

    public static String fixColor(@NonNull String text, @NonNull Locale locale, @NonNull Map<String, Object> placeholders) {
        return fixColor(text, locale, placeholders, true);
    }
    public static String fixColor(@NonNull String text, @NonNull Locale locale, @NonNull Map<String, Object> placeholders, boolean colorizePlaceholders) {
        if (colorizePlaceholders) {
            return fixColor(StringUtil.replace(text, locale, placeholders));
        }

        return StringUtil.replace(fixColor(text), locale, placeholders);
    }

    public static List<String> fixColor(@NonNull List<String> stringList, @NonNull Map<String, Object> placeholders) {
        return stringList.stream()
                .map(text -> fixColor(text, placeholders))
                .collect(Collectors.toList());
    }

    public static List<String> fixLore(List<String> lore) {
        ArrayList<String> fixLore = new ArrayList<String>();
        if (lore == null) {
            return fixLore;
        }
        lore.forEach(s -> fixLore.add(ChatUtil.fixColor(s)));

        return fixLore;
    }

    public static List<String> fixLore(List<String> lore, Map<String, Object> placeholders) {
        if (lore == null) return Collections.emptyList();

        return lore.stream()
                .map(line -> fixColor(line, placeholders))
                .toList();
    }

    public static List<String> lores(ItemStack st, Player p) {
        ItemMeta itemMeta = st.getItemMeta();

        List<String> lore = itemMeta.getLore();
        if (lore == null) {
            return new ArrayList<>();
        }
        return lore.stream()
                .map(ChatUtil::fixColor)
                .collect(Collectors.toList());
    }
    public static void sendActionbar(Player player, String message) {
        if (player == null || message == null) {
            return;
        }
        String nmsVersion = Bukkit.getServer().getClass().getPackage().getName();
        try {
            Class<?> craftPlayerClass = Class.forName("org.bukkit.craftbukkit." + nmsVersion + ".entity.CraftPlayer");
            Object craftPlayer = craftPlayerClass.cast(player);
            Class<?> ppoc = Class.forName("net.minecraft.server." + nmsVersion + ".PacketPlayOutChat");
            Class<?> packet = Class.forName("net.minecraft.server." + nmsVersion + ".Packet");
            Class<?> chat = Class.forName("net.minecraft.server." + nmsVersion + (nmsVersion.equalsIgnoreCase("v1_8_R1") ? ".ChatSerializer" : ".ChatComponentText"));
            Class<?> chatBaseComponent = Class.forName("net.minecraft.server." + nmsVersion + ".IChatBaseComponent");
            Method method = null;
            if (nmsVersion.equalsIgnoreCase("v1_8_R1")) {
                method = chat.getDeclaredMethod("a", String.class);
            }
            Object object = nmsVersion.equalsIgnoreCase("v1_8_R1") ? chatBaseComponent.cast(method.invoke(chat, "{'text': '" + message + "'}")) : chat.getConstructor(String.class).newInstance(message);
            Object packetPlayOutChat = ppoc.getConstructor(chatBaseComponent, Byte.TYPE).newInstance(object, (byte)2);
            Method handle = craftPlayerClass.getDeclaredMethod("getHandle", new Class[0]);
            Object iCraftPlayer = handle.invoke(craftPlayer, new Object[0]);
            Field playerConnectionField = iCraftPlayer.getClass().getDeclaredField("playerConnection");
            Object playerConnection = playerConnectionField.get(iCraftPlayer);
            Method sendPacket = playerConnection.getClass().getDeclaredMethod("sendPacket", packet);
            sendPacket.invoke(playerConnection, packetPlayOutChat);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void sendTitle(Player p, String t, String s) {
        p.sendTitle(ChatUtil.fixColor(t), ChatUtil.fixColor(s));
    }

    private ChatUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void sendMessage(CommandSender sender, String s) {

    }
}
