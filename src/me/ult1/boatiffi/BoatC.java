package me.ult1.boatiffi;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class BoatC extends JavaPlugin {
    // I'll be referring to " boatC " as the boantiful name of this thing in code

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Readability0(), this);

        getCommand("ulti_boat_spawn").setExecutor(new Commands());
        getCommand("ulti_boat_playerspawn").setExecutor(new Commands());
        getCommand("ulti_boat_motion").setExecutor(new Commands());
        getCommand("ulti_boat_help").setExecutor(new Commands());

    }

}