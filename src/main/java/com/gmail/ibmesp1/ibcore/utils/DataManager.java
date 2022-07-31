package com.gmail.ibmesp1.ibcore.utils;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class DataManager {
    private JavaPlugin plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;
    private final String fileName;

    public DataManager(JavaPlugin plugin, String fileName) {
        this.plugin = plugin;
        this.fileName = fileName;
        saveDefaultConfig();
    }

    public void reloadConfig(){
        if(configFile == null)
            configFile = new File(plugin.getDataFolder(), fileName);

        dataConfig = YamlConfiguration.loadConfiguration(configFile);

        InputStream defaultStream = plugin.getResource(fileName);

        if(defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getConfig()
    {
        if(dataConfig == null)
            reloadConfig();

        return dataConfig;
    }

    public void saveConfig()
    {
        if(dataConfig == null|| configFile == null)
            return;

        try {
            getConfig().save(configFile);
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, ChatColor.RED + "Could not save config to " + configFile, e);
        }
    }

    public void  saveDefaultConfig()
    {
        if(configFile == null)
            configFile = new File(plugin.getDataFolder(), fileName);

        if(!configFile.exists())
            plugin.saveResource(fileName,false);
    }

    public boolean isEmpty(){
        if (configFile.length() == 0L){
            return true;
        }else{
            return false;
        }
    }
}
