package dev.lightdev.commands.user;


import dev.lightdev.config.MessageConfig;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.context.Context;
import dev.rollczi.litecommands.annotations.execute.Execute;
import dev.rollczi.litecommands.annotations.permission.Permission;
import eu.okaeri.injector.annotation.Inject;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

@Command(name = "repair")
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class RepairCommand {

    private final MessageConfig messageConfig;

    @Execute
    @Permission("lightdev.core.user")
    void Repair(@Context CommandSender commandSender) {
        if (commandSender instanceof Player p) {
            if (p.getInventory().getItemInMainHand() == null || p.getInventory().getItemInMainHand().getType().isAir()) {
                this.messageConfig.repairNoItem.send(p);
                return;
            }

            short durability = p.getInventory().getItemInMainHand().getDurability();
            if (durability == 0) {
                this.messageConfig.repairItemNotRepair.send(p);
                return;
            }

            p.getInventory().getItemInMainHand().setDurability((short) 0);
            this.messageConfig.repairItem.send(p);
        }
    }

    @Execute(name = "all")
    @Permission("lightdev.core.user")
    void repairAll(@Context CommandSender commandSender) {
        if (commandSender instanceof Player p) {
            int repaired = 0;

            for (ItemStack item : p.getInventory().getContents()) {
                if (item != null && item.getType().getMaxDurability() > 0) {
                    if (item.getDurability() > 0) {
                        item.setDurability((short) 0);
                        repaired++;
                    }
                }
            }
            for (ItemStack armor : p.getInventory().getArmorContents()) {
                if (armor != null && armor.getType().getMaxDurability() > 0) {
                    if (armor.getDurability() > 0) {
                        armor.setDurability((short) 0);
                        repaired++;
                    }

                    if (repaired == 0) {
                        this.messageConfig.repairAllNoItemRepair.send(p);
                    } else {
                        Map<String, Object> placeholders = Map.of("COUNT", repaired);
                        this.messageConfig.repairAllSucces.send(p, placeholders);
                    }
                }
            }
        }
    }
}