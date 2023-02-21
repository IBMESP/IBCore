package com.gmail.ibmesp1.ibcore.guis;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

/**
 * If you use {@link com.gmail.ibmesp1.ibcore.guis.GUI} make sure to register this listener
 * <p>
 * These methods call their respective methods on a {@link com.gmail.ibmesp1.ibcore.guis.GUI} class
 *
 * @author Ib
 * @since 1.1.0
 * @version 1.0
 */
public class GUIListeners implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onClick(InventoryClickEvent event) {
        if (event.getInventory().getHolder() instanceof GUI) {
            final GUI gui = (GUI) event.getInventory().getHolder();
            gui.onClick(event);
        }
    }

    @EventHandler
    private void onOpen(InventoryOpenEvent event) {
        if (event.getInventory().getHolder() instanceof GUI) {
            final GUI gui = (GUI) event.getInventory().getHolder();
            gui.onOpen(event);
        }
    }

    @EventHandler
    private void onClose(InventoryCloseEvent event) {
        if (event.getInventory().getHolder() instanceof GUI) {
            final GUI gui = (GUI) event.getInventory().getHolder();
            gui.onClose(event);
        }
    }
}
