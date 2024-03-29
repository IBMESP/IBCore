package com.gmail.ibmesp1.ibcore.guis;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Items to use on a GUI such as {@link MenuItems#glass()}
 *
 * @author IB
 * @version 1.2
 * @since 0.0.3
 */
public class MenuItems {

    /**
     * Pre-fabricated item to fill blank spaces on my GUIs
     *
     * @return Black stained-glass pane without name
     *
     * @author IB
     * @since 0.0.3
     */
    public static ItemStack glass(){
        return createItem(Material.BLACK_STAINED_GLASS_PANE," ");
    }

    /**
     * Pre-fabricated item to go back on my GUIs
     *
     * @param name Name of the back item (Multi-Languages)
     * @return An arrow
     *
     * @author IB
     * @since 0.0.3
     */
    public static ItemStack back(String name){
        return createItem(Material.ARROW,name);
    }

    /**
     * Pre-fabricated item to search something on my GUIs
     *
     * @param name Name of the search item (Multi-Languages)
     * @return An anvil
     *
     * @author IB
     * @since 0.0.3
     */
    public static ItemStack search(String name){
        return createItem(Material.ANVIL,name);
    }

    /**
     * Create an item with a display name and lore
     *
     * @param material Choose the material to use
     * @param name Choose the name of the item
     *
     * @return The item with name and lore
     *
     * @author IB
     * @since 0.0.3
     */
    public static ItemStack createItem(Material material, String name){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);

        item.setItemMeta(meta);
        return item;
    }

    /**
     * Create an item with a display name and lore
     *
     * @param material Choose the material to use
     * @param name Choose the name of the item
     * @param lore Choose the lore of the item
     * @return The item with name and lore
     *
     * @author IB
     * @since 0.0.3
     */
    public static ItemStack createItem(Material material, String name, List<String> lore){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);

        if(lore != null)
            meta.setLore(lore);

        item.setItemMeta(meta);
        return item;
    }
}