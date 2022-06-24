package com.oxyrus.nightmaremode;

import com.oxyrus.nightmaremode.commands.ToggleNightmareModeCommand;
import com.oxyrus.nightmaremode.listeners.CreatureSpawnListener;
import com.oxyrus.nightmaremode.managers.GameManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class NightmareModePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        var gameManager = new GameManager(false);

        getCommand("nightmare").setExecutor(new ToggleNightmareModeCommand(gameManager));
        getServer().getPluginManager().registerEvents(new CreatureSpawnListener(gameManager), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
