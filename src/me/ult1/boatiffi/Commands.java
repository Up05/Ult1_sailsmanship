package me.ult1.boatiffi;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);

        Readability0 r = new Readability0();

        if(commandSender.hasPermission("ulti_boat.staffCommands")){

// ###############################################################################################################################

            if(command.getName().equalsIgnoreCase("ulti_boat_spawn")){
                    if(strings.length >= 3) {
                        Readability0.setBoatSpawnCoords(Double.parseDouble(strings[0]),Double.parseDouble(strings[1]),Double.parseDouble(strings[2]));
                        commandSender.sendMessage("set boat spawn point");
                    } else {
                        double[] t = r.getBoatSpawnCoords();
                        commandSender.sendMessage(ChatColor.GOLD + "/ulti_boat_spawn <x> <y> <z>");
                        commandSender.sendMessage(ChatColor.ITALIC + "Current location: " + t[0] + ", " + t[1] + ", " + t[2]);
                    }
                }

// ###############################################################################################################################

            if(command.getName().equalsIgnoreCase("ulti_boat_playerspawn")){
                if(strings.length >= 3) {
                    Readability0.setPlayerRespawnCoords(Double.valueOf(strings[0]),Double.valueOf(strings[1]),Double.valueOf(strings[2]));
                    commandSender.sendMessage("set player spawn point");
                } else {
                    double[] t = r.getPlayerRespawnCoords();
                    commandSender.sendMessage(ChatColor.GOLD + "/ulti_boat_playerspawn <x> <y> <z>");
                    commandSender.sendMessage(ChatColor.ITALIC + "Current location: " + t[0] + ", " + t[1] + ", " + t[2]);
                }
            }

// ###############################################################################################################################

            if(command.getName().equalsIgnoreCase("ulti_boat_motion")){
                if(strings.length >= 3) {

                    Readability0.setBoatMotion(Double.valueOf(strings[0]),Double.valueOf(strings[1]),Double.valueOf(strings[2]));
                    commandSender.sendMessage("set boat spawn point");
                } else {
                    double[] t = r.getBoatMotion();
                    commandSender.sendMessage(ChatColor.GOLD + "/ulti_boat_motion <x> <y> <z>");
                    commandSender.sendMessage(ChatColor.ITALIC + "Current boat motion: " + t[0] + ", " + t[1] + ", " + t[2]);
                }
            }

// ###############################################################################################################################

            if(command.getName().equalsIgnoreCase("ulti_boat_help")){
                    Player player = (Player) commandSender;
                    player.sendMessage(
                             "  -------------------------------------------"         + ChatColor.ITALIC + ChatColor.YELLOW +
                                "\nI This is mostly for new custom maps and staff,"     +
                                "\nI all my commands are prefixed with: "               + ChatColor.GREEN  + "ulti_<plugin>_"+ChatColor.WHITE+
                                "\nI beaoutiful command list: "                         + ChatColor.GOLD   +
                                "\nI ulti_boat_spawn - Sets the first boat's location," +
                                "\nI ulti_boat_motion - Sets every boat's motion,"      +
                                "\nI ulti_boat_help - Gets player this message."        +
                                "\n-------------------------------------------"
                            );
                }

// ###############################################################################################################################

        } else {
        commandSender.sendMessage(ChatColor.DARK_RED + "You do not have permission!");
        }


        return true;
    }
}
