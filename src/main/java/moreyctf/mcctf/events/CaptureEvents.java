package moreyctf.mcctf.events;

import moreyctf.mcctf.Main;
import moreyctf.mcctf.commands.TeamConfigCmds;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Team;

import java.util.Objects;

public class CaptureEvents implements Listener {

    private final boolean flagCaptured = true;
    @EventHandler
    public void onCapture(PlayerInteractEvent event) {

        if (event.getClickedBlock() == null) return;
        Material clicked = Objects.requireNonNull(event.getClickedBlock()).getType();
        if (Objects.equals(event.getHand(), EquipmentSlot.OFF_HAND)) return;
        Player player = event.getPlayer();
        if (event.getClickedBlock() == null) return;
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK && clicked.equals(Material.PURPLE_BANNER) && TeamConfigCmds.purple.getEntries().contains(player.getName())) {
            player.sendMessage(Main.prefix + "§cVous ne pouvez pas capturer votre propre drapeau.");
        }
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK && clicked.equals(Material.YELLOW_BANNER) && TeamConfigCmds.yellow.getEntries().contains(player.getName())) {
            player.sendMessage(Main.prefix + "§cVous ne pouvez pas capturer votre propre drapeau.");
        }
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK && clicked.equals(Material.PURPLE_BANNER) && TeamConfigCmds.yellow.getEntries().contains(player.getName())) {
            player.getTargetBlock(null, 5).setType(Material.AIR);
            player.sendTitle(null, "§aVous avez le drapeau", 0, 50, 30);
            ItemStack flag = new ItemStack(Material.PURPLE_BANNER);
            ArmorStand stand = player.getWorld().spawn(player.getLocation(), ArmorStand.class);
            stand.setSmall(true);
            stand.setInvisible(true);
            stand.setInvulnerable(true);
            stand.setGravity(false);
            stand.setCustomName("Flag");
            stand.setCustomNameVisible(true);
            stand.setHelmet(flag);
            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100000, 1));
            Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, () -> {
                stand.teleport(player.getLocation().add(0, 1.5, 0));
                if(!flagCaptured) {
                    stand.remove();
                    player.removePotionEffect(PotionEffectType.GLOWING);
                    Bukkit.getScheduler().cancelTasks(Main.plugin);
                }
            }, 0, 1);
        }
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK && clicked.equals(Material.YELLOW_BANNER) && TeamConfigCmds.purple.getEntries().contains(player.getName())) {
            player.getTargetBlock(null, 5).setType(Material.AIR);
            player.sendTitle(null, "§aVous avez le drapeau", 0, 50, 30);
            ItemStack flag = new ItemStack(Material.YELLOW_BANNER);
            ArmorStand stand = player.getWorld().spawn(player.getLocation(), ArmorStand.class);
            stand.setSmall(true);
            stand.setInvisible(true);
            stand.setInvulnerable(true);
            stand.setGravity(false);
            stand.setCustomName("Flag");
            stand.setCustomNameVisible(true);
            stand.setHelmet(flag);
            player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100000, 1));
            Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, () -> {
                stand.teleport(player.getLocation().add(0, 1.5, 0));
                if(!flagCaptured) {
                    stand.remove();
                    player.removePotionEffect(PotionEffectType.GLOWING);
                    Bukkit.getScheduler().cancelTasks(Main.plugin);
                }
            }, 0, 1);
        }
    }
}