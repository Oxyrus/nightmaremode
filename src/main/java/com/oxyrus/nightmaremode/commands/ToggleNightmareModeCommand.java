package com.oxyrus.nightmaremode.commands;

import com.oxyrus.nightmaremode.managers.GameManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ToggleNightmareModeCommand implements CommandExecutor {
    private final GameManager gameManager;

    public ToggleNightmareModeCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // We need an enable/disable arg (/nightmare enable)
        if (args.length == 0) {
            return false;
        }

        if (args[0].equalsIgnoreCase("enable")) {
            this.gameManager.setEnableNightmareMode(true);
            sender.sendMessage(ChatColor.GREEN + "Nightmare mode has been enabled, be careful");
            return true;
        }

        if (args[0].equalsIgnoreCase("false")) {
            this.gameManager.setEnableNightmareMode(false);
            sender.sendMessage(ChatColor.RED + "Nightmare mode has been disabled, you can breath now");
            return true;
        }

        return false;
    }
}
