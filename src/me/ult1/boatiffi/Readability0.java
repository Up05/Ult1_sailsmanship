package me.ult1.boatiffi;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Readability0 implements Listener {
    static double spawnPointX = 0.5;
    static double spawnPointY = 101;
    static double spawnPointZ = 3.5;

    static double spawnBoatX = 0.5;
    static double spawnBoatY = 100;
    static double spawnBoatZ = 1;

    static double boatMotionX = 0.0;
    static double boatMotionY = 0.0;
    static double boatMotionZ = -0.3;


    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 400000, 10));
        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 400000, 10));
    }

    @EventHandler
    public static void onPlayerQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        p.removePotionEffect(PotionEffectType.SATURATION);
        p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
    }

    @EventHandler
    public static void playerMoveEvent(PlayerMoveEvent e){

        Player p = e.getPlayer();
        Material block = p.getWorld().getBlockAt(p.getLocation().getBlockX(),p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ()).getType();


        for(Entity ent : Bukkit.getWorld("world").getEntities()){
            if(ent.equals(EntityType.BOAT)) {
                ent.setVelocity(ent.getVelocity().setX(boatMotionX).setY(boatMotionY).setZ(boatMotionZ));
            }
        }

        if(block == Material.STATIONARY_WATER){
            int yaw = 0;
            {
                       if (boatMotionX < 0) {
                    yaw = 90;
                } else if (boatMotionX > 0) {
                    yaw = -90;
                } else if (boatMotionZ < 0) {
                    yaw = 180;
                } else if (boatMotionZ > 0) {
                    yaw = -180;
                }
            } // calculates yaw, ya can close this with your editor of choice.


            for(Entity ent : Bukkit.getWorld("world").getEntities()){
                if(ent.getType().equals(EntityType.BOAT)) {
                    ent.eject();
                    ent.remove(); // I'm sure this won't cause any problems... NAH!
                }
            }
            Location loc = new Location(Bukkit.getWorld("world"), spawnPointX, spawnPointY, spawnPointZ, yaw, 0);
            p.teleport(loc);
        }
    }


    public void onBoatEnter(PlayerInteractEntityEvent e) {
        if(e.getRightClicked().getType() == EntityType.BOAT){
            e.getPlayer().eject();
        }
    }


        public static void setPlayerRespawnCoords ( double x, double y, double z){
            spawnPointX = x;
            spawnPointY = y;
            spawnPointZ = z;
        }
        public static void setBoatSpawnCoords ( double x, double y, double z){
            spawnBoatX = x;
            spawnBoatY = y;
            spawnBoatZ = z;
        }
        public static void setBoatMotion ( double x, double y, double z){
            boatMotionX = x;
            boatMotionY = y;
            boatMotionZ = z;
        }

        public double[] getPlayerRespawnCoords () {
            double[] s = new double[3];
            s[0] = spawnPointX;
            s[1] = spawnPointY;
            s[2] = spawnPointZ;
            return s;
        }
        public double[] getBoatSpawnCoords () {
            double[] s = new double[3];
            s[0] = spawnBoatX;
            s[1] = spawnBoatY;
            s[2] = spawnBoatZ;
            return s;
        }
        public double[] getBoatMotion () {
            double[] s = new double[3];
            s[0] = boatMotionX;
            s[1] = boatMotionY;
            s[2] = boatMotionZ;
            return s;
        }



    @EventHandler
    public void onStep(PlayerInteractEvent e) {
        if (e.getAction() == Action.PHYSICAL) {
            Player player = e.getPlayer();
                    {
                    // If you'd mind closing these curly braces in your preferred editor.
                // Arrays... what's that!

                Location loc0 = new Location(player.getWorld(), spawnBoatX - 2.4, spawnBoatY, spawnBoatZ);
                Location loc1 = new Location(player.getWorld(), spawnBoatX - 0.8, spawnBoatY, spawnBoatZ);
                Location loc2 = new Location(player.getWorld(), spawnBoatX + 0.8, spawnBoatY, spawnBoatZ);
                Location loc3 = new Location(player.getWorld(), spawnBoatX + 2.4, spawnBoatY, spawnBoatZ);

                Entity ent0 = Bukkit.getWorld("world").spawnEntity(loc0, EntityType.BOAT);
                ent0.setGravity(false);
                Entity ent1 = Bukkit.getWorld("world").spawnEntity(loc1, EntityType.BOAT);
                ent1.setGravity(false);
                Entity ent2 = Bukkit.getWorld("world").spawnEntity(loc2, EntityType.BOAT);
                ent2.setGravity(false);
                Entity ent3 = Bukkit.getWorld("world").spawnEntity(loc3, EntityType.BOAT);
                ent3.setGravity(false);

                // ಥ_ಥ    ಥ_ಥ    ಥ_ಥ     ಥ_ಥ     ಥ_ಥ     ಥ_ಥ     ಥ_ಥ     ಥ_ಥ !!!
                    } // this was my attempt at hiding it, hopefully it worked
            }
    }
}
