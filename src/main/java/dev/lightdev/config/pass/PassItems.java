package dev.lightdev.config.pass;

import dev.lightdev.utils.ItemUtil;
import eu.okaeri.configs.OkaeriConfig;
import lombok.*;
import org.bukkit.inventory.ItemStack;

@Getter
@Setter
@AllArgsConstructor
public class PassItems extends OkaeriConfig {

    private ItemStack itemStack;
    private int customModelData;
    private int requiredLevel;

    public ItemStack toItemStack() {
        return ItemUtil.of(this.itemStack.clone()).setCmd(this.customModelData).toItemStack();
    }
}
