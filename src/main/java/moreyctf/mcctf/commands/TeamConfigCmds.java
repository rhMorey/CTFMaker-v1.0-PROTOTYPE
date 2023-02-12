package moreyctf.mcctf.commands;

import moreyctf.mcctf.Main;
import org.bukkit.command.Command;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TeamConfigCmds implements CommandExecutor {

    public static Team purple = Objects.requireNonNull(Bukkit.getServer().getScoreboardManager()).getMainScoreboard().getTeam("purple");

    public static Team yellow = Bukkit.getServer().getScoreboardManager().getMainScoreboard().getTeam("yellow");
    public static Team admin = Bukkit.getServer().getScoreboardManager().getMainScoreboard().getTeam("admin");

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (s.equalsIgnoreCase("tcreate")) {
            TeamConfigCmds.yellow = Objects.requireNonNull(sender.getServer().getScoreboardManager()).getMainScoreboard().getTeam("yellow");
            TeamConfigCmds.purple = sender.getServer().getScoreboardManager().getMainScoreboard().getTeam("purple");
            TeamConfigCmds.admin = sender.getServer().getScoreboardManager().getMainScoreboard().getTeam("admin");
            if(purple == null) {
                purple = Objects.requireNonNull(sender.getServer().getScoreboardManager()).getMainScoreboard().registerNewTeam("purple");
                sender.sendMessage(Main.prefix + "§cL'équipe purple n'existait pas, elle a été créée.");
            }
            if(yellow == null) {
                yellow = Objects.requireNonNull(sender.getServer().getScoreboardManager()).getMainScoreboard().registerNewTeam("yellow");
                sender.sendMessage(Main.prefix + "§cL'équipe yellow n'existait pas, elle a été créée.");
            }
            if(admin == null) {
                admin = Objects.requireNonNull(sender.getServer().getScoreboardManager()).getMainScoreboard().registerNewTeam("admin");
                sender.sendMessage(Main.prefix + "§cL'équipe admin n'existait pas, elle a été créée.");
            }
            purple.setPrefix(ChatColor.DARK_PURPLE + "Purple ");
            assert yellow != null;
            yellow.setPrefix(ChatColor.YELLOW + "Yellow ");
            purple.setColor(ChatColor.DARK_PURPLE);
            yellow.setColor(ChatColor.YELLOW);
            yellow.setDisplayName(ChatColor.YELLOW + "Yellow ");
            purple.setDisplayName(ChatColor.DARK_PURPLE + "Purple ");
            admin.setPrefix(ChatColor.RED + "Admin ");
            admin.setColor(ChatColor.RED);
            admin.setDisplayName(ChatColor.RED + "Admin ");
            sender.sendMessage(Main.prefix + "§aÉquipes configurées.");
        }
        return false;
    }
}
