package moreyctf.mcctf.events;

import moreyctf.mcctf.Main;
import moreyctf.mcctf.commands.TeamConfigCmds;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.awt.*;

public class CaptureEvents implements Listener {

    private boolean flagCaptured = false;
    public static ItemStack pflag = new ItemStack(Material.PURPLE_BANNER);
    public static ItemStack yflag = new ItemStack(Material.YELLOW_BANNER);
    public static int yScore = 0;
    public static int pScore = 0;

    @EventHandler
    public void onCapture(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        Location playerloc = player.getLocation();
        if (playerloc.getBlock().getType() == Material.PURPLE_BANNER && TeamConfigCmds.yellow.getEntries().contains(player.getName())) {
            if (flagCaptured) {
                player.sendTitle(" ", "§cVotre drapeau est déjà capturé.", 0, 20, 30);
                return;
            }
            playerloc.getBlock().setType(Material.AIR);
            player.sendTitle(" ", "§7Vous avez le drapeau.", 0, 50, 30);
            ArmorStand stand = player.getWorld().spawn(player.getLocation(), ArmorStand.class);
            stand.setSmall(true);
            stand.setInvisible(true);
            stand.setInvulnerable(true);
            stand.setGravity(false);
            stand.setHelmet(pflag);
            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100000, 1));
            flagCaptured = true;
            Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, () -> {
                stand.teleport(player.getLocation().add(0, 1.5, 0));
                if (!flagCaptured) {
                    stand.remove();
                    player.removePotionEffect(PotionEffectType.GLOWING);
                    //Bukkit.getScheduler().cancelTasks(Main.plugin);
                }
            }, 0, 1);
        }
        if (playerloc.getBlock().getType() == Material.YELLOW_BANNER && TeamConfigCmds.purple.getEntries().contains(player.getName())) {
            if (flagCaptured) {
                player.sendTitle(" ", "§cVotre drapeau est déjà capturé.", 0, 20, 30);
                return;
            }
            playerloc.getBlock().setType(Material.AIR);
            player.sendTitle(" ", "§7Vous avez le drapeau.", 0, 50, 30);
            ArmorStand stand = player.getWorld().spawn(player.getLocation(), ArmorStand.class);
            stand.setSmall(true);
            stand.setInvisible(true);
            stand.setInvulnerable(true);
            stand.setGravity(false);
            stand.setHelmet(yflag);
            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100000, 1));
            flagCaptured = true;
            Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, () -> {
                stand.teleport(player.getLocation().add(0, 1.5, 0));
                if (!flagCaptured) {
                    stand.remove();
                    player.removePotionEffect(PotionEffectType.GLOWING);
                    //Bukkit.getScheduler().cancelTasks(Main.plugin);
                }
            }, 0, 1);
        }
    }

    @EventHandler
    public void PlayerWalkOnPurpleWool(PlayerMoveEvent event) {
        Location playerloc = event.getPlayer().getLocation();
        if (playerloc.add(0, -1, 0).getBlock().getType().equals(Material.PURPLE_CONCRETE) && TeamConfigCmds.purple.getEntries().contains(event.getPlayer().getName()) && flagCaptured) {
            Player player = event.getPlayer();
            if (player.hasPotionEffect(PotionEffectType.GLOWING)) {
                Bukkit.broadcastMessage("§7*------------------------*");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage("§5" + player.getName() + " §6a capturé le drapeau !");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage("§7*------------------------*");
                pScore++;
                for (Player onlinep : Bukkit.getOnlinePlayers()) {
                    onlinep.sendTitle("§e" + yScore + " §7| §5" + pScore, "§e" + player.getName() + " §7a marqué un point", 0, 100, 30);
                    onlinep.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1));
                    onlinep.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 100));
                }
                for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
                    if (TeamConfigCmds.yellow.getEntries().contains(onlinePlayer.getName())) {
                        Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
                            onlinePlayer.teleport(Main.yellowloc);
                        }, 100L);
                    }
                    if (TeamConfigCmds.purple.getEntries().contains(onlinePlayer.getName())) {
                        Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
                            onlinePlayer.teleport(Main.purpleloc);
                        }, 100L);
                    }
                }
                    player.sendMessage("§5Vous avez amené le drapeau à votre base !");
                    player.removePotionEffect(PotionEffectType.GLOWING);
                    flagCaptured = false;
                }
            }
        }

    @EventHandler
    public void PlayerWalkOnYellowWool(PlayerMoveEvent event) {
        Location playerloc = event.getPlayer().getLocation();
        if (playerloc.add(0, -1, 0).getBlock().getType().equals(Material.YELLOW_CONCRETE) && TeamConfigCmds.yellow.getEntries().contains(event.getPlayer().getName()) && flagCaptured) {
            Player player = event.getPlayer();
            if (player.hasPotionEffect(PotionEffectType.GLOWING)) {
                Bukkit.broadcastMessage("§7*------------------------*");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage("§e" + player.getName() + " §6a capturé le drapeau !");
                Bukkit.broadcastMessage(" ");
                Bukkit.broadcastMessage("§7*------------------------*");
                yScore++;
                for (Player onlinep : Bukkit.getOnlinePlayers()) {
                    onlinep.sendTitle("§e" + yScore + " §7| §5" + pScore, "§e" + player.getName() + " §7a marqué un point", 0, 100, 30);
                    onlinep.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 1));
                    onlinep.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 100));
                }
                for (Player onlinePlayer : Bukkit.getServer().getOnlinePlayers()) {
                    if (TeamConfigCmds.yellow.getEntries().contains(onlinePlayer.getName())) {
                        Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
                            onlinePlayer.teleport(Main.yellowloc);
                        }, 100L);
                    }
                    if (TeamConfigCmds.purple.getEntries().contains(onlinePlayer.getName())) {
                        Bukkit.getScheduler().runTaskLater(Main.plugin, () -> {
                            onlinePlayer.teleport(Main.purpleloc);
                        }, 100L);
                    }
                }
                    player.sendMessage("§eVous avez amené le drapeau à votre base !");
                //remettre le drapeau à sa place ducoup
                    player.removePotionEffect(PotionEffectType.GLOWING);
                    flagCaptured = false;
                }
        }
    }
}