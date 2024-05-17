package com.gmail.ibmesp1.ibcore.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.logging.Level;

/**
 * Logger class
 *
 * @author IB
 * @version 1.0
 * @since 1.3.0
 */
public class Logger {

    private static void log(Level level,String msg){
        Bukkit.getLogger().log(level,msg);
    }

    /**
     * Displays message to the console server
     *
     * @param level Message level
     * @param name Plugin name
     * @param msg Message you want to display
     *
     * @author IB
     * @since 1.3.0
     */
    public static void log(Level level,String name,String msg){
        log(level,name + " " + msg);
    }

    /**
     * Displays message to the console server
     *
     * @param level Message level
     * @param name Plugin name
     * @param msg Message you want to display
     * @param color The message color
     *
     * @author IB
     * @since 1.3.0
     */
    public static void log(Level level,String name,String msg,ChatColor color){
        log(level,name + " " + color + msg);
    }

    /**
     * Displays a warning message to the console server
     *
     * @param name Plugin name
     * @param msg Message you want to display
     *
     * @author IB
     * @since 0.0.1
     */
    public static void consoleWarning(String name,String msg) {
        log(Level.WARNING,name,msg,ChatColor.RED);
    }

    /**
     * Displays an info message to the console server
     *
     * @param name Plugin name
     * @param msg Message you want to display
     *
     * @author IB
     * @since 1.3.0
     */
    public static void consoleInfo(String name,String msg){
        log(Level.INFO,name,msg);
    }

    /**
     * Displays a severe message to the console server
     *
     * @param name Plugin name
     * @param msg Message you want to display
     *
     * @author IB
     * @since 1.3.0
     */
    public static void consoleSevere(String name,String msg){
        log(Level.SEVERE,name,msg,ChatColor.DARK_RED);
    }
}
