package me.frost.ggwave.yaml;

import com.google.common.io.Files;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class FileHandler {
    private final JavaPlugin plugin;
    private FileConfiguration configuration;
    private final boolean hasDefault;
    private final File file;
    private final String fileName;

    public FileHandler(JavaPlugin plugin, String fileName, boolean hasDefault) {
        this.plugin = plugin;
        this.hasDefault = hasDefault;
        this.fileName = fileName;
        file = new File(plugin.getDataFolder() + File.separator + fileName + ".yml");
        reload();
    }

    public void reload() {
        if (!file.exists()) {
            try {
                if (hasDefault) {
                    plugin.saveResource(fileName + ".yml", false);
                } else {
                    file.createNewFile();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        loadConfig();
    }

    public void loadConfig() {
        configuration = new YamlConfiguration();
        try {
            configuration.loadFromString(Files.toString(file, StandardCharsets.UTF_8));
        } catch (IOException | InvalidConfigurationException exception) {
            exception.printStackTrace();
        }
    }

    public FileConfiguration getConfig() {
        return configuration;
    }

    public void saveConfig() {
        try {
            configuration.save(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}