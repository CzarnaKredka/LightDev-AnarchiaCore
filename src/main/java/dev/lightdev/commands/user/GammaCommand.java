package dev.lightdev.commands.user;

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
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;

@Command(name = "gamma")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class GammaCommand {

    private final MessageConfig messageConfig;

    @Execute
    @Permission("lightdev.core.user")
    public void onGammaUse(@Context CommandSender commandSender) {
        if (commandSender instanceof Player player) {

            if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                this.messageConfig.changeOffGamma.send(player);
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO,1,1);
            } else {
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1));
                this.messageConfig.changeOnGamma.send(player);
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO,1,1);
            }

        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }
    }

    @Execute
    @Permission("lightdev.core.user")
    public void onGammaUseOthers(@Context CommandSender commandSender, @Arg("player") Player target) {
        if (commandSender instanceof Player player) {

            Map<String, Object> placeholders = Map.of("TARGET", target.getName());

            if (target.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                target.removePotionEffect(PotionEffectType.NIGHT_VISION);
                this.messageConfig.changeOffGammaOthers.send(player, placeholders);
                this.messageConfig.changeOffGamma.send(target);
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO,1,1);
                target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO,1,1);
            } else {
                target.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 1));
                this.messageConfig.changeOnGammaOthers.send(player, placeholders);
                this.messageConfig.changeOnGamma.send(target);
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO,1,1);
                target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_BANJO,1,1);
            }

        } else {
            ConsoleMessageUtil.logMessage(ConsoleUtil.RED, "Ta komenda może być użyta tylko przez gracza!");
        }
    }
}
