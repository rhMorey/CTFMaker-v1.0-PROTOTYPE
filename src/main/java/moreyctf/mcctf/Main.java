package moreyctf.mcctf;

import moreyctf.mcctf.commands.*;
import moreyctf.mcctf.events.CaptureEvents;
import moreyctf.mcctf.events.EndEvents;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Location purpleloc;
    public static Location yellowloc;
    public static Main plugin;

    @Override
    public void onEnable() {

        plugin = this;
        System.out.println("CTF Maker is enabled!");
        Bukkit.getPluginManager().registerEvents(new CaptureEvents(), this);
        Bukkit.getPluginManager().registerEvents(new EndEvents(), this);
        Bukkit.getPluginCommand("setpurpleflag").setExecutor(new PurpleSetupCmds());
        Bukkit.getPluginCommand("setyellowflag").setExecutor(new YellowSetupCmds());
        Bukkit.getPluginCommand("startg").setExecutor(new StartCmds());
        Bukkit.getPluginCommand("tcreate").setExecutor(new TeamConfigCmds());
        Bukkit.getPluginCommand("ctf").setExecutor(new CtfCmds());

    }

    @Override
    public void onDisable() {

        System.out.println("CTF Maker is disabled!");
    }

    public static String prefix = "§c§l(!) §r";

}
