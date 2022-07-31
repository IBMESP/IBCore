package com.gmail.ibmesp1.ibcore.commands;

import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class SubCommand {

    public abstract String getName();
    public abstract void perform(CommandSender sender, String[] args);

    public abstract List<String> getSubCommandsArgs(String[] args);
}
