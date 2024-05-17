package com.gmail.ibmesp1.ibcore.guis;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

/**
 * GUI abstract class to create GUIs on an easier way
 *
 * @author IB
 * @version 1.1
 * @since 1.1.0
 */
public abstract class GUI implements InventoryHolder {
    protected Inventory inventory;

    /**
     * Creates a GUI with the title and size passed by the child constructor
     * <p>
     * Also, it fills the inventory with glass items
     *
     * @param size The size of the new GUI
     * @param title The title of the new GUI
     *
     * @author IB
     * @since 1.1.0
     */
    public GUI(int size, String title){
        this.inventory = Bukkit.createInventory(this,size,title);

        for(int i = 0;i < size;i++)
            this.inventory.setItem(i,MenuItems.glass());
    }

    /**
     * The behaviour of the GUI when you open it
     * <p>
     * This event is managed by {@link com.gmail.ibmesp1.ibcore.guis.GUIListeners}
     *
     * @param event The InventoryOpenEvent its triggered by {@link com.gmail.ibmesp1.ibcore.guis.GUIListeners}
     *
     * @author IB
     * @since 1.1.0
     */
    public abstract void onOpen(InventoryOpenEvent event);

    /**
     * The behaviour of the GUI when you click it
     * <p>
     * This event is managed by {@link com.gmail.ibmesp1.ibcore.guis.GUIListeners}
     *
     * @param event The InventoryClickEvent its triggered by {@link com.gmail.ibmesp1.ibcore.guis.GUIListeners}
     *
     * @author IB
     * @since 1.1.0
     */
    public abstract void onClick(InventoryClickEvent event);

    /**
     * The behaviour of the GUI when you close it
     * <p>
     * This event is managed by {@link com.gmail.ibmesp1.ibcore.guis.GUIListeners}
     *
     * @param event The InventoryCloseEvent its triggered by {@link com.gmail.ibmesp1.ibcore.guis.GUIListeners}
     * @author IB
     * @since 1.1.0
     */
    public abstract void onClose(InventoryCloseEvent event);

    /**
     * A void method to fill up the GUI
     * @author IB
     * @since 1.1.0
     */
    public abstract void contents();

    @Override
    public Inventory getInventory(){
        return inventory;
    }
}
