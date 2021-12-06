package me.frost.ggwave.commands;

import me.frost.ggwave.GGWave;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public abstract class SubCommand {
    private final String name;
    private final String permission;
    private final String usage;
    private final String description;
    private final GGWave plugin = GGWave.getPlugin(GGWave.class);

    protected boolean playerOnly = false;

    public SubCommand(String name, String permission, String usage, String description) {
        this.name = name;
        this.permission = permission;
        this.usage = usage;
        this.description = description;
    }

    public abstract void execute(CommandSender sender, String[] args);

    public void sendUsage(CommandSender sender) {
        sender.sendMessage(usage);
    }

    public String getName() {
        return name;
    }

    public String getPermission() {
        return permission;
    }
    public String getUsage() {
        return usage;
    }

    public String getDescription() {
        return description;
    }

    public FileConfiguration getConfig() {
        return plugin.getConfig();
    }
}