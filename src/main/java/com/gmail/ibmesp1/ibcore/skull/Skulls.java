package com.gmail.ibmesp1.ibcore.skull;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class Skulls {

    private String key;

    public Skulls() {
        key = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";
    }

    /**
     * Creates a skull with texture
     *
     * @param url The url from <a
     *      href="https://minecraft-heads.com/">Head Database</a>
     * @return An ItemStack skull with a texture
     *
     */
    public ItemStack getSkull(String url) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        if ((key + url).isEmpty()) {
            return head;
        }

        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", key + url));
        Field profileField;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ignored) {

        }
        head.setItemMeta(headMeta);
        return head;
    }

    /**
     * Creates a skull with a player skin
     *
     * @param player The player skin you want to use
     * @return An ItemStack skull with a player skin
     *
     */
    public ItemStack playerSkull(Player player){
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwningPlayer(player);
        skullMeta.setDisplayName(ChatColor.GOLD + player.getName());
        skull.setItemMeta(skullMeta);
        return skull;
    }
}
