package com.gmail.ibmesp1.ibcore.skull;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

/**
 * Create player skulls or use skulls from <a href="https://minecraft-heads.com/">Head Database</a>
 *
 * @since 0.0.1
 * @author IB
 * @version 1.1
 */
public class Skulls {

    private static final String key = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";

    /**
     * Creates a skull with texture
     *
     * @param url The url from <a
     *      href="https://minecraft-heads.com/">Head Database</a>
     * @return An ItemStack skull with a texture
     *
     * @since 0.0.1
     */
    public static ItemStack getSkull(String url) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);

        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", key + url));
        Field profileField;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(headMeta, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ignored){}
        head.setItemMeta(headMeta);
        return head;
    }

    /**
     * Creates a skull with texture
     *
     * @param url The url from <a
     *      href="https://minecraft-heads.com/">Head Database</a>
     * @param name The name of the item
     * @return An ItemStack skull with a texture
     *
     * @since 1.2.2
     * @author IB
     */
    public static ItemStack getSkull(String url,String name){
        ItemStack skull = getSkull(url);
        ItemMeta meta = skull.getItemMeta();
        meta.setDisplayName(name);
        skull.setItemMeta(meta);
        return skull;
    }

    /**
     * Creates a skull with texture
     *
     * @param url The url from <a
     *      href="https://minecraft-heads.com/">Head Database</a>
     * @param name The name of the item
     * @param lore If you want to add lore to the skull
     * @return An ItemStack skull with a texture
     *
     * @since 1.2.2
     * @author IB
     */
    public static ItemStack getSkull(String url,String name,List<String> lore){
        ItemStack skull = getSkull(url,name);
        ItemMeta meta = skull.getItemMeta();
        meta.setLore(lore);
        skull.setItemMeta(meta);
        return skull;
    }

    /**
     * Creates a skull with a player skin
     *
     * @param player The player skin you want to use
     * @return An ItemStack skull with a player skin
     *
     * @author IB
     * @since 0.0.1
     */
    public static ItemStack playerSkull(Player player){
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwningPlayer(player);
        skullMeta.setDisplayName(ChatColor.GOLD + player.getName());
        skull.setItemMeta(skullMeta);
        return skull;
    }

    /**
     * Creates a skull with a player skin
     *
     * @param player The player skin you want to use
     * @param name The name of the item
     * @return An ItemStack skull with a player skin
     *
     * @author IB
     * @since 1.1.2
     */
    public static ItemStack playerSkull(Player player, String name){
        ItemStack skull = playerSkull(player);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setDisplayName(name);
        skull.setItemMeta(skullMeta);
        return skull;
    }

    /**
     * Creates a skull with a player skin
     *
     * @param player The player skin you want to use
     * @param lore If you want to add lore to the skull
     * @return An ItemStack skull with a player skin
     *
     * @author IB
     * @since 0.0.1
     */
    public static ItemStack playerSkull(Player player, List<String> lore){
        ItemStack skull = playerSkull(player);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setDisplayName(ChatColor.GOLD + player.getName());
        skullMeta.setLore(lore);
        skull.setItemMeta(skullMeta);
        return skull;
    }

    /**
     * Creates a skull with a player skin
     *
     * @param player The player skin you want to use
     * @param name The name of the item
     * @param lore If you want to add lore to the skull
     * @return An ItemStack skull with a player skin
     *
     * @author IB
     * @since 1.1.2
     */
    public static ItemStack playerSkull(Player player,String name ,List<String> lore){
        ItemStack skull = playerSkull(player);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setDisplayName(name);
        skullMeta.setLore(lore);
        skull.setItemMeta(skullMeta);
        return skull;
    }
}
