package daxz.dev.cutsiecreepers;

import daxz.dev.cutsiecreepers.Events.CreeperExplosionHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Cutsiecreepers extends JavaPlugin {

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new CreeperExplosionHandler(), this);

        saveResource("config.yml", true);
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static Cutsiecreepers getInstance() {
        return instance;
    }



}
