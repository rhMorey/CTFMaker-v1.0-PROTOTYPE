package moreyctf.mcctf.commands;

import moreyctf.mcctf.Main;
import moreyctf.mcctf.events.EndEvents;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CtfCmds implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (s.equalsIgnoreCase("ctf")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("bo")) {
                    sender.sendMessage("test");
                }
            }
            if(args.length == 2) {
                switch(args[1]) {
                    case "3":
                        EndEvents.CustomScore = 3;
                        sender.sendMessage(Main.prefix + "§aLe CTF est maintenant paramétré sur un BO3.");
                        break;
                    case "5":
                        EndEvents.CustomScore = 5;
                        sender.sendMessage(Main.prefix + "§aLe CTF est maintenant paramétré sur un BO5.");
                        break;
                    case "7":
                        EndEvents.CustomScore = 7;
                        sender.sendMessage(Main.prefix + "§aLe CTF est maintenant paramétré sur un BO7.");
                        break;
                    case "9":
                        EndEvents.CustomScore = 9;
                        sender.sendMessage(Main.prefix + "§aLe CTF est maintenant paramétré sur un BO9.");
                        break;
                    default:
                        sender.sendMessage(Main.prefix + "§cErreur: §4" + args[1] + " §cn'est pas un nombre valide.");
                        sender.sendMessage(Main.prefix + "§cVeuillez choisir une valeur parmis celle-ci: §e3, 5, 7, 9");
                        break;
                }
            }
        }
        return false;
    }
}
