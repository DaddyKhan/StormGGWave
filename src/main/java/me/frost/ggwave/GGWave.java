package me.frost.ggwave;

import me.frost.ggwave.commands.BaseCommand;
import me.frost.ggwave.commands.execute.GGWaveCommand;
import me.frost.ggwave.listeners.PlayerChatListener;
import me.frost.ggwave.yaml.FileHandler;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class GGWave extends JavaPlugin {
    private FileHandler config;

    @Override
    public void onEnable() {
        System.out.println("[]==========[StormGGWave]==========[]");
        Bukkit.getLogger().info("Loading config...");
        config = new FileHandler(this, "config", true);
        Bukkit.getLogger().info("Registering listeners...");
        Bukkit.getPluginManager().registerEvents(new PlayerChatListener(), this);
        Bukkit.getLogger().info("Registering commands...");
        registerCommands(new GGWaveCommand());
        System.out.println("[]==========[StormGGWave]==========[]");
    }

    @Override
    public FileConfiguration getConfig() {
        return config.getConfig();
    }

    @Override
    public void reloadConfig() {
        config.reload();
    }

    public void registerCommands(BaseCommand... commands) {
        for (BaseCommand command : commands) {
            command.register(this);
        }
    }
}