package com.gmail.ibmesp1.ibcore.guis;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum MenuItems {

    BACK(Material.ARROW,"gui.items.back"),
    GLASS(Material.BLACK_STAINED_GLASS_PANE," "),
    CREATE_BP(Material.CHEST,"gui.items.create"),
    DELETE_BP(Material.TNT,"gui.items.delete"),
    CONFIG_BP(Material.REDSTONE,"gui.items.config"),
    KEEP_BP(Material.TOTEM_OF_UNDYING,"gui.items.keepBackpack"),
    SIZE_BP(Material.CHEST,"gui.size."),
    SEARCH(Material.ANVIL,"gui.items.search"),
    PAGE(Material.ARROW,"gui.");

    private ItemStack item;

    MenuItems(Material material, String path){
        item = createItem(material,path);
    }

    private ItemStack createItem(Material material, String name){
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack getItem(){
        return item;
    }
}