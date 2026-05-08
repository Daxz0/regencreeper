package daxz.dev.cutsiecreepers;

import daxz.dev.cutsiecreepers.Events.CreeperExplosionHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Cutsiecreepers extends JavaPlugin {
    private static Cutsiecreepers instance;

    @Override
    public void onEnable() {
        instance = this;

        //listener regis
        getServer().getPluginManager().registerEvents(new CreeperExplosionHandler(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static Cutsiecreepers getInstance() {
        return instance;
    }



}
