package moreyctf.mcctf;

import moreyctf.mcctf.events.MainEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main plugin;

    @Override
    public void onEnable() {

        plugin = this;
        System.out.println("CTF Maker is enabled!");
        Bukkit.getPluginManager().registerEvents(new MainEvents(), this);

    }

    @Override
    public void onDisable() {

        System.out.println("CTF Maker is disabled!");
    }
}
