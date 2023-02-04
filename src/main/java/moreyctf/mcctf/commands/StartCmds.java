package moreyctf.mcctf.commands;

import moreyctf.mcctf.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class StartCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if(s.equalsIgnoreCase("startg")) {
            Player player = (Player) sender;
            player.sendMessage("debug");
            if(TeamConfigCmds.purple.getEntries().contains(player.getName())) {
                if (Main.purple == null) {
                    player.sendMessage(Main.prefix + "§cLa position de la drapeau de l'équipe §5purple §cn'a pas été définie.");
                    return false;
                } else {
                    player.teleport(Main.purple);
                    player.sendMessage(Main.prefix + "§5Vous avez été téléporté au spawn de l'équipe §5purple§5.");
                }
            }
            if(TeamConfigCmds.yellow.getEntries().contains(player.getName())) {
                if (Main.yellow == null) {
                    player.sendMessage(Main.prefix + "§cLa position de la drapeau de l'équipe §eyellow §cn'a pas été définie.");
                    return false;
                } else {
                    player.teleport(Main.yellow);
                    player.sendMessage(Main.prefix + "§eVous avez été téléporté au spawn de l'équipe §eyellow§e.");
                }
            }
        }
        return false;
    }
}
