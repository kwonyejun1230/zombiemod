package com.example.zombiesurvival;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Zombie;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class WaveManager {
    private JavaPlugin plugin;
    private BukkitRunnable task;

    public WaveManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void start() {
        task = new BukkitRunnable() {
            @Override
            public void run() {
                World world = Bukkit.getWorlds().get(0);
                long time = world.getTime();
                if(time >= 13000 && time <= 23000) { // 밤
                    Zombie z = world.spawn(world.getSpawnLocation(), Zombie.class);
                    z.setCustomName("Night Zombie");
                }
            }
        };
        task.runTaskTimer(plugin, 0, 200);
    }

    public void stop() {
        if(task != null) task.cancel();
    }
}
