package com.gmail.ibmesp1.ibcore.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/**
 * Utils class use to add static methods.
 *
 * @author Ib
 * @version 1.0
 * @since 0.0.1
 */

public class Utils {

    /**
     * Displays an urgent message to the console server
     *
     * @param name Plugin name
     * @param msg Message you want to display
     *
     * @author Ib
     * @since 0.0.1
     */
    public static void urgentConsoleWarning(String name,String msg) {
        Bukkit.getConsoleSender().sendMessage(name + " " + ChatColor.RED + msg);
    }

    /**
     * Capitalizes the first letter of a string
     *
     * @param string String you want to capitalize
     * @return String with the first letter capitalized
     *
     * @author Ib
     * @since 0.0.1
     */
    public static String capitalizeFirstLetter(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    /**
     * Capitalizes the first letter of a string
     *
     * @param languageData An object from {@link DataManager} that manages the language files
     * @param path The String path at the languageData
     * @return String with the first letter capitalized
     *
     * @author Ib
     * @since 1.1.2
     */
    public static String getLanguageString(DataManager languageData, String path) {
        return languageData.getConfig().getString(path);
    }
}
