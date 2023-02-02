package moreyctf.mcctf.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class MainEvents implements Listener {

    @EventHandler
    public void onCapture(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && player.getTargetBlock(null, 5).getType().equals(Material.WHITE_BANNER)) {
            player.sendMessage("You captured the flag!");
        }
    }
}
