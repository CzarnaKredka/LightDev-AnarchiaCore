package dev.lightdev.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.bukkit.Bukkit;

import java.util.logging.Logger;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConsoleMessageUtil {


    // logger
    private static final Logger LOG = Bukkit.getLogger();

    /**
     * Logs a colored message to the console.
     *
     * @param consoleColor The color code for the console message.
     * @param message      The message to be logged.
     */
    public static void logMessage(String consoleColor, String message) {
        LOG.info(consoleColor + message + ConsoleUtil.RESET);
    }
}