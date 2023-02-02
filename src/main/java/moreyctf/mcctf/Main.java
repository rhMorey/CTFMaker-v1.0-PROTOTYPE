package moreyctf.mcctf;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        System.out.println("CTF Maker is enabled!");
    }

    @Override
    public void onDisable() {

        System.out.println("CTF Maker is disabled!");
    }
}
