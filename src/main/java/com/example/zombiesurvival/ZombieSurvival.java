package com.example.zombiesurvival;

import org.bukkit.plugin.java.JavaPlugin;

public class ZombieSurvival extends JavaPlugin {
    private WaveManager waveManager;
    private DayManager dayManager;

    @Override
    public void onEnable() {
        this.waveManager = new WaveManager(this);
        this.dayManager = new DayManager(this);
        getCommand("startzombie").setExecutor((sender, command, label, args) -> {
            dayManager.start();
            waveManager.start();
            sender.sendMessage("Zombie Survival Started!");
            return true;
        });
        getCommand("stopzombie").setExecutor((sender, command, label, args) -> {
            dayManager.stop();
            waveManager.stop();
            sender.sendMessage("Zombie Survival Stopped!");
            return true;
        });
    }
}
