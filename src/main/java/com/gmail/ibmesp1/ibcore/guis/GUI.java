package com.gmail.ibmesp1.ibcore.guis;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public abstract class GUI implements InventoryHolder {
    protected Inventory inventory;

    public GUI(int size, String title){
        this.inventory = Bukkit.createInventory(this,size,title);

        MenuItems menuItems = new MenuItems();

        for(int i = 0;i < size;i++)
            this.inventory.setItem(i,menuItems.glass());
    }

    public abstract void onOpen(InventoryOpenEvent e);
    public abstract void onClick(InventoryClickEvent e);
    public abstract void onClose(InventoryCloseEvent e);

    public abstract void contents();

    @Override
    public Inventory getInventory(){
        return inventory;
    }
}
