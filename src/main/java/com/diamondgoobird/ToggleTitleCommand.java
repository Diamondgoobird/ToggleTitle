package com.diamondgoobird;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class ToggleTitleCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "toggletitle";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "toggles titles on and off";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        ToggleTitleMod.toggleTitles();
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }
}
