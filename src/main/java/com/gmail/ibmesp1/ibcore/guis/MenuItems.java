package com.gmail.ibmesp1.ibcore.guis;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class MenuItems {

    public ItemStack glass(){
        ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta meta = glass.getItemMeta();
        meta.setDisplayName(" ");
        glass.setItemMeta(meta);
        return glass;
    }

    public ItemStack back(String name){
        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta meta = back.getItemMeta();
        meta.setDisplayName(name);
        back.setItemMeta(meta);
        return back;
    }

    public ItemStack search(String name){
        ItemStack search = new ItemStack(Material.ANVIL);
        ItemMeta meta = search.getItemMeta();
        meta.setDisplayName(name);
        search.setItemMeta(meta);
        return search;
    }

    public ItemStack createItem(Material material, String name, List<String> lore){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);

        if(lore != null)
            meta.setLore(lore);

        item.setItemMeta(meta);
        return item;
    }
}