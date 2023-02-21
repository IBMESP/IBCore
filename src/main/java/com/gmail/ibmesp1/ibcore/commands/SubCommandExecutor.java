package com.gmail.ibmesp1.ibcore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * This interface manage the subcommands
 *
 * @author Ib
 * @version 1.0
 * @since 0.0.1
 */
public interface SubCommandExecutor extends TabExecutor {

    ArrayList<SubCommand> getSubCommands();

    /**
     * Executes the {@link com.gmail.ibmesp1.ibcore.commands.SubCommand#perform(CommandSender, String[])} method
     *
     * @param sender The command sender
     * @param command The command
     * @param label The command label
     * @param args The command arguments
     *
     * @author Ib
     * @since 0.0.1
     */
    default boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        for (int i = 0; i< getSubCommands().size(); i++) {
            if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())) {
                getSubCommands().get(i).perform(sender, args);
            }
        }
        return false;
    }

    /**
     * This method is used to show the subcommands of a command
     *
     * @param sender The sender of the command
     * @param command The command name
     * @param alias The command alias
     * @param args The command arguments
     * @return A List of subcommands to TabComplete
     *
     * @author Ib
     * @since 0.0.1
     */
    @Override
    default List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1){
            ArrayList<String> subCommandsArgs = new ArrayList<>();

            for (int i = 0; i< getSubCommands().size(); i++){
                subCommandsArgs.add(getSubCommands().get(i).getName());
            }
            return subCommandsArgs;
        }else if(args.length == 2){
            for (int i = 0; i< getSubCommands().size(); i++){
                if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())){
                    return getSubCommands().get(i).getSubCommandsArgs(args);
                }
            }
        }
        return null;
    }
}
