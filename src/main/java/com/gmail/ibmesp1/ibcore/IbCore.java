package com.gmail.ibmesp1.ibcore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class IbCore extends JavaPlugin {

    @Override
    public void onLoad() {
        Bukkit.getConsoleSender().sendMessage("IbCore working");
    }

}
