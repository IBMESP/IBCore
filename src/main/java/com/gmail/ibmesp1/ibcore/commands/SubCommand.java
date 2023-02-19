package com.gmail.ibmesp1.ibcore.commands;

import org.bukkit.command.CommandSender;

import java.util.List;

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
