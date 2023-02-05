package moreyctf.mcctf.commands;

import moreyctf.mcctf.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class YellowSetupCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if(s.equalsIgnoreCase("setyellowflag")) {
            Player player = (Player) sender;
            player.sendMessage(Main.prefix + "§aLa position de la drapeau de l'équipe §eyellow §aa été définie.");
            Location playerloc = player.getLocation();
            playerloc.getBlock().setType(Material.YELLOW_BANNER);
            playerloc.add(0, -1, 0).getBlock().setType(Material.YELLOW_CONCRETE);
            Main.yellowloc = player.getLocation();
        }
        return false;
    }
}
