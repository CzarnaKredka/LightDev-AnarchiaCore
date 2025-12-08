package dev.lightdev.commands.admin;

import dev.lightdev.config.MessageConfig;
import dev.lightdev.utils.ConsoleMessageUtil;
import dev.lightdev.utils.ConsoleUtil;
import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

@RequiredArgsConstructor(onConstructor_ = @Inject)
@Command(name = "gamemode", aliases = "gm")
public class GamemodeCommand {

    private final MessageConfig messageConfig;

    @Execute
    @Permission("lightdev.core.admin.gamemode.all")
    public void onGamemodeOwn(@Context CommandSender commandSender, @Arg("gamemode") GameMode gameMode) {
            this.playerRunnable(commandSender, () -> this.changeGamemodeMethod((Player) commandSender, gameMode));
    }

    @Execute(name = "survival", aliases = "0")
    @Permission("lightdev.core.admin.gamemode.survival")
    public void changeGamemodeToSurvival(@Context CommandSender commandSender) {
        this.playerRunnable(commandSender, () -> this.changeGamemodeMethod((Player) commandSender, GameMode.SURVIVAL));
    }

    @Execute(name = "creative", aliases = "1")
    @Permission("lightdev.core.admin.gamemode.creative")
    public void changeGamemodeToCreative(@Context CommandSender commandSender) {
        this.playerRunnable(commandSender, () -> this.changeGamemodeMethod((Player) commandSender, GameMode.CREATIVE));
    }

    @Execute(name = "adventure", aliases = "2")
    @Permission("lightdev.core.admin.gamemode.adventure")
    public void changeGamemodeToAdventure(@Context CommandSender commandSender) {
        this.playerRunnable(commandSender, () -> this.changeGamemodeMethod((Player) commandSender, GameMode.ADVENTURE));
    }

    @Execute(name = "spectator", aliases = "3")
    @Permission("lightdev.core.admin.gamemode.spectator")
    public void changeGamemodeToSpectator(@Context CommandSender commandSender) {
        this.playerRunnable(commandSender, () -> this.changeGamemodeMethod((Player) commandSender, GameMode.SPECTATOR));
    }

    @Execute
    public void changeGamemodeOthers(@Context CommandSender commandSender, @Arg("player") Player target, @Arg("gamemode") GameMode gameMode) {
        if (commandSender instanceof Player player) {

            Map<String, Object> placeholders = Map.of("GAMEMODE", gameMode, "TARGET", target.getName());

            target.setGameMode(gameMode);
            target.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO, 1, 1);

            this.messageConfig.changeGamemodeOthers.send(player, placeholders);

        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }
    }

    private void changeGamemodeMethod(CommandSender commandSender, GameMode gameMode) {
        if (commandSender instanceof Player player) {
            Map<String, Object> placeholders = Map.of("GAMEMODE", gameMode);

            player.setGameMode(gameMode);
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO, 1, 1);
            this.messageConfig.changeGamemode.send(player, placeholders);

        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }
    }

    private void playerRunnable(CommandSender commandSender, Runnable runnable) {
        if (commandSender instanceof Player player) {
            runnable.run();
        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }
    }
}
