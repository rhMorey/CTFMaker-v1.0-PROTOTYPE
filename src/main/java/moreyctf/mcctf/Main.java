package moreyctf.mcctf;

import moreyctf.mcctf.commands.PurpleSetupCmds;
import moreyctf.mcctf.commands.StartCmds;
import moreyctf.mcctf.commands.TeamConfigCmds;
import moreyctf.mcctf.commands.YellowSetupCmds;
import moreyctf.mcctf.events.CaptureEvents;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Location purple;
    public static Location yellow;
    public static Main plugin;

    @Override
    public void onEnable() {

        plugin = this;
        System.out.println("CTF Maker is enabled!");
        Bukkit.getPluginManager().registerEvents(new CaptureEvents(), this);
        Bukkit.getPluginCommand("setpurpleflag").setExecutor(new PurpleSetupCmds());
        Bukkit.getPluginCommand("setyellowflag").setExecutor(new YellowSetupCmds());
        Bukkit.getPluginCommand("startg").setExecutor(new StartCmds());
        Bukkit.getPluginCommand("tcreate").setExecutor(new TeamConfigCmds());

    }

    @Override
    public void onDisable() {

        System.out.println("CTF Maker is disabled!");
    }

    public static String prefix = "§c§l(!) §r";

}
