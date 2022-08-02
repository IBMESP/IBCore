package com.gmail.ibmesp1.ibcore.commands;

import org.bukkit.command.TabExecutor;

import java.util.ArrayList;

public interface SubCommandExecutor extends TabExecutor {
    public ArrayList<SubCommand> getSubCommands();
}
