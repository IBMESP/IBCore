package com.gmail.ibmesp1.ibcore.commands;

import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * Abstract class to create subcommands
 *
 * @author IB
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

    /**
     * This method executes the command behaviour
     *
     * @param sender The command sender
     * @param args The command arguments
     *
     * @author IB
     * @since 0.0.1
     */
    public abstract void perform(CommandSender sender, String[] args);

    /**
     * This method is used to show the subcommands of a subcommand
     *
     * @param args The command arguments
     * @return A List of subcommands to TabComplete
     *
     * @author IB
     * @since 0.0.1
     */
    public abstract List<String> getSubCommandsArgs(String[] args);
}
