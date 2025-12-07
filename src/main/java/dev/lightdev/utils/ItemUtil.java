package dev.lightdev.utils;

import dev.lightdev.utils.string.ChatUtil;
import lombok.NonNull;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ItemUtil {

    private ItemStack itemStack;

    public ItemUtil(@NonNull Material material) {
        this.itemStack = new ItemStack(material);
    }

    public ItemUtil(@NonNull Material material, int amount) {
        this.itemStack = new ItemStack(material, amount);
    }

    public ItemUtil(@NonNull ItemStack itemStack, boolean clone) {
        if (clone) {
            this.itemStack = new ItemStack(itemStack);
        }
        else {
            this.itemStack = itemStack;
        }
    }

    public static ItemUtil of(@NonNull Material material) {
        return new ItemUtil(material);
    }

    public static ItemUtil of(@NonNull Material material, int amount) {
        return new ItemUtil(material, amount);
    }

    public static ItemUtil of(@NonNull ItemStack itemStack) {
        return new ItemUtil(itemStack, true);
    }

    public static ItemUtil manipulate(@NonNull ItemStack itemStack) {
        return new ItemUtil(itemStack, false);
    }

    public ItemUtil setAmount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemUtil clone() {
        return new ItemUtil(this.itemStack.getType());
    }

    public ItemUtil setType(@NonNull Material material) {
        this.itemStack.setType(material);
        return this;
    }

    public ItemUtil setType(@NonNull ItemStack itemStack) {
        return this.setType(itemStack, true);
    }

    public ItemUtil setType(@NonNull ItemStack itemStack, boolean clone) {

        final ItemStack copy;
        if (clone) {
            copy = new ItemStack(itemStack);
        }
        else {
            copy = itemStack;
        }

        copy.setAmount(this.itemStack.getAmount());

        if (this.itemStack.hasItemMeta()) {
            copy.setItemMeta(this.itemStack.getItemMeta());
        }

        this.itemStack = copy;
        return this;
    }

    public ItemUtil withDurability(int durability) {
        this.itemStack.setDurability((short) durability);
        return this;
    }

    public ItemUtil setName(@NonNull String name) {

        ItemMeta itemMeta = this.itemStack.getItemMeta();
        assert itemMeta != null;

        itemMeta.setDisplayName(ChatUtil.fixColor(name));
        this.itemStack.setItemMeta(itemMeta);

        return this;
    }

    public ItemUtil setColor(@NonNull Color color) {
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        assert itemMeta != null;

        if (itemMeta instanceof LeatherArmorMeta leatherArmorMeta) {
            leatherArmorMeta.setColor(color);
            this.itemStack.setItemMeta(leatherArmorMeta);
        }

        return this;
    }


    public ItemUtil setLore(@NonNull List<String> lore) {

        ItemMeta itemMeta = this.itemStack.getItemMeta();
        assert itemMeta != null;

        itemMeta.setLore(ChatUtil.fixLore(lore));
        this.itemStack.setItemMeta(itemMeta);

        return this;
    }

    public ItemUtil setCmd(@NonNull int cmd) {
        if (cmd != 0) {
            ItemMeta itemMeta = this.itemStack.getItemMeta();
            assert itemMeta != null;

            itemMeta.setCustomModelData(cmd);
            this.itemStack.setItemMeta(itemMeta);
        }

        return this;
    }

    public ItemUtil withKey(@NonNull NamespacedKey namespacedKey, @NonNull PersistentDataType persistentDataType, @NonNull Object object) {
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        assert itemMeta != null;

        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();

        persistentDataContainer.set(namespacedKey, persistentDataType, object);
        this.itemStack.setItemMeta(itemMeta);

        return this;
    }

    public ItemUtil setLore(@NonNull String... lore) {
        return this.setLore(ChatUtil.fixLore(Arrays.asList(lore)));
    }

    public ItemUtil addEnchant(@NonNull Enchantment enchantment, int level, boolean ignoreLevelRestriction) {

        ItemMeta itemMeta = this.itemStack.getItemMeta();
        assert itemMeta != null;

        itemMeta.addEnchant(enchantment, level, ignoreLevelRestriction);
        this.itemStack.setItemMeta(itemMeta);

        return this;
    }

    public ItemUtil addEnchant(@NonNull Enchantment enchantment, int level) {
        return this.addEnchant(enchantment, level, true);
    }

    public ItemUtil addFlags(@NonNull ItemFlag... itemFlag) {

        ItemMeta itemMeta = this.itemStack.getItemMeta();
        assert itemMeta != null;

        itemMeta.addItemFlags(itemFlag);
        this.itemStack.setItemMeta(itemMeta);

        return this;
    }

    public ItemUtil fixColors() {

        ItemMeta itemMeta = this.itemStack.getItemMeta();
        assert itemMeta != null;

        if (itemMeta.hasDisplayName()) {
            itemMeta.setDisplayName(ChatUtil.fixColor(itemMeta.getDisplayName()));
        }

        if (itemMeta.hasLore()) {
            itemMeta.setLore(Objects.requireNonNull(itemMeta.getLore())
                    .stream()
                    .map(ChatUtil::fixColor)
                    .collect(Collectors.toList()));
        }

        this.itemStack.setItemMeta(itemMeta);
        return this;
    }


    public ItemUtil setSkullOwner(String owner) {
        SkullMeta im = (SkullMeta) this.itemStack.getItemMeta();
        im.setOwner(owner);
        this.itemStack.setItemMeta(im);
        return this;
    }


    public ItemUtil withCustomMeta(@NonNull Function<ItemMeta, ItemMeta> function) {

        final ItemMeta itemMeta = this.itemStack.getItemMeta();
        this.itemStack.setItemMeta(function.apply(itemMeta));

        return this;
    }


    public ItemStack toItemStack() {
        return this.itemStack;
    }
}