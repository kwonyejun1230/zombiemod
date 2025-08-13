package com.example.zombiesurvival;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.boss.BossBar;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;

public class DayManager {
    private JavaPlugin plugin;
    private BukkitRunnable task;
    private BossBar bossBar;

    public DayManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.bossBar = Bukkit.createBossBar("Day 0 / 100", BarColor.GREEN, BarStyle.SOLID);
    }

    public void start() {
        task = new BukkitRunnable() {
            @Override
            public void run() {
                long day = Bukkit.getWorlds().get(0).getFullTime() / 24000;
                bossBar.setTitle("Day " + day + " / 100");
                if(day >= 100) {
                    Bukkit.broadcastMessage("\u2728 100 Days Survived! You Win! \u2728");
                    stop();
                }
            }
        };
        task.runTaskTimer(plugin, 0, 20);
    }

    public void stop() {
        if(task != null) task.cancel();
        bossBar.removeAll();
    }
}
