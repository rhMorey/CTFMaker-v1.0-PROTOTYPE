package moreyctf.mcctf.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Objects;

public class MainEvents implements Listener {

    @EventHandler
    public void onCapture(PlayerInteractEvent event) {

        Material clicked = Objects.requireNonNull(event.getClickedBlock()).getType();
        if (Objects.equals(event.getHand(), EquipmentSlot.OFF_HAND)) return;
        Player player = event.getPlayer();
        if (event.getClickedBlock() == null) return;
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK && clicked.equals(Material.WHITE_BANNER)) {
            player.sendMessage("You captured the flag!");
        }
    }
}
