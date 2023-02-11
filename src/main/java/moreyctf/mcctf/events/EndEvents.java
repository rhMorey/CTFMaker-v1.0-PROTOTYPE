package moreyctf.mcctf.events;

import moreyctf.mcctf.Main;
import moreyctf.mcctf.commands.TeamConfigCmds;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EndEvents implements Listener {

    public static int CustomScore = 5;

    @EventHandler
    public void onPoints(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if(CaptureEvents.pScore == CustomScore) {
            if(TeamConfigCmds.purple.getEntries().contains(player.getName())) {
                Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + player.getName() + " §6a amené le dernier drapeau et a fait gagner son équipe !");
                Bukkit.broadcastMessage("§7*-----------------------------*");
                Bukkit.broadcastMessage("§5§ki §6L'équipe §5§lPurple §6a gagné ! §5§ki");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage("§aScore d'équipe§7: §5" + CaptureEvents.pScore + " §7/ §e" + CaptureEvents.yScore);
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage("§7*-----------------------------*");
                Bukkit.getScheduler().cancelTasks(Main.plugin);
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.setGameMode(GameMode.SPECTATOR);
                    players.sendTitle("§5Purple §6a gagné !", "§aFélicitation à l'équipe §5Purple §a!", 20, 60, 20);
                    players.playSound(players.getLocation(), Sound.ITEM_TOTEM_USE, 1, 1);
                    players.setBedSpawnLocation(new Location(players.getWorld(), 220.5, 24, 94.5));
                }
                CustomScore = 0;
            }
        }
        if(CaptureEvents.yScore == CustomScore) {
            if(TeamConfigCmds.yellow.getEntries().contains(player.getName())) {
                Bukkit.broadcastMessage(ChatColor.YELLOW + player.getName() + " §6a amené le dernier drapeau et a fait gagner son équipe !");
                Bukkit.broadcastMessage("§7*-----------------------------*");
                Bukkit.broadcastMessage("§e§ki §6L'équipe §e§lYellow §6a gagné ! §e§ki");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage("§aScore d'équipe§7: §5" + CaptureEvents.pScore + " §7/ §e" + CaptureEvents.yScore);
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage("§7*-----------------------------*");
                Bukkit.getScheduler().cancelTasks(Main.plugin);
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.setGameMode(GameMode.SPECTATOR);
                    players.sendTitle("§eYellow §6a gagné !", "§aFélicitation à l'équipe §eYellow §a!", 20, 60, 20);
                    players.playSound(players.getLocation(), Sound.ITEM_TOTEM_USE, 1, 1);
                    players.setBedSpawnLocation(new Location(players.getWorld(), 220.5, 24, 94.5));
                }
                CustomScore = 0;
            }
        }
    }
}
