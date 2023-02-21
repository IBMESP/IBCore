package com.gmail.ibmesp1.ibcore.commands;

import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * Abstract class to create subcommands
 *
 * @author Ib
 * @version 1.0
 * @since 1.0.0
 */
public abstract class SubCommand{
    private final String name;

    public SubCommand(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract void perform(CommandSender sender, String[] args);
    public abstract List<String> getSubCommandsArgs(String[] args);
}
