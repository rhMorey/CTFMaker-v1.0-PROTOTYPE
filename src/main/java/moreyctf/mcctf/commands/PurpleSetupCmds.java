package moreyctf.mcctf.commands;

import moreyctf.mcctf.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PurpleSetupCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if(s.equalsIgnoreCase("setpurpleflag")) {
            Player player = (Player) sender;
            player.sendMessage(Main.prefix + "§aLa position de la drapeau de l'équipe §5purple §aa été définie.");
            Main.purple = player.getLocation();
        }
        return false;
    }
}
