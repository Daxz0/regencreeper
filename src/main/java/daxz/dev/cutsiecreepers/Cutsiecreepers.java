package daxz.dev.cutsiecreepers;

import org.bukkit.plugin.java.JavaPlugin;

public final class Cutsiecreepers extends JavaPlugin {

    @Override
    public void onEnable() {

        saveResource("config.yml", true);
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
