package me.frost.ggwave.commands;

import me.frost.ggwave.GGWave;
import me.frost.ggwave.utils.MessageUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseCommand implements CommandExecutor {
    private final String name;
    private final String permission;
    private final String usage;
    private final Set<SubCommand> subCommands = new HashSet<>();
    private final GGWave plugin = GGWave.getPlugin(GGWave.class);

    protected boolean playerOnly = false;
    protected boolean withoutSubCommand = false;

    public BaseCommand(String name, String permission, String usage) {
        this.name = name;
        this.permission = permission;
        this.usage = usage;
    }

    public abstract void execute(CommandSender sender, String[] args);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (playerOnly && !(sender instanceof Player)) {
            sender.sendMessage("Only players can execute that command!");
            return true;
        }

        if (permission != null && !sender.hasPermission(permission)) {
            MessageUtils.getInstance().sendMessage(getPlugin().getConfig().getString("messages.NO-PERMISSION"), sender);
            return true;
        }

        if (args == null || args.length == 0) {
            execute(sender, args);
            return true;
        }

        if (withoutSubCommand) {
            getSubCommands().forEach(commandSub -> commandSub.execute(sender, args));
        }

        String subCommandName = args[0];
        SubCommand subCommand = getSubCommand(subCommandName);

        if (subCommand == null) {
            getSubCommands().forEach(commandSub -> commandSub.execute(sender, args));
            return true;
        }

        if (subCommand.getPermission() != null && !sender.hasPermission(subCommand.getPermission())) {
            MessageUtils.getInstance().sendMessage(getPlugin().getConfig().getString("messages.NO_PERMISSION"), sender);
            return true;
        }

        subCommand.execute(sender, args);

        return true;
    }

    public SubCommand getSubCommand(String name) {
        return subCommands.stream().filter(command -> command.getName().equals(name)).findAny().orElse(null);
    }

    public void sendUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.RED + usage);
    }

    public void register(JavaPlugin javaPlugin) {
        javaPlugin.getCommand(getName()).setExecutor(this);
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

    public Set<SubCommand> getSubCommands() {
        return subCommands;
    }

    public GGWave getPlugin() {
        return plugin;
    }
}