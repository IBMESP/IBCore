package com.gmail.ibmesp1.ibcore.commands;

import org.bukkit.entity.Player;

import java.util.List;

public abstract class SubCommand {

    public abstract String getName();
    public abstract void perform(Player player, String[] args);

    public abstract List<String> getSubCommandsArgs(String[] args);
}
