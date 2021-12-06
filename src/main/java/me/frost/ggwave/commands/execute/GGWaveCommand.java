package me.frost.ggwave.commands.execute;

import me.frost.ggwave.GGWave;
import me.frost.ggwave.commands.BaseCommand;
import me.frost.ggwave.commands.execute.sub.ReloadCommand;
import me.frost.ggwave.commands.execute.sub.StartCommand;
import me.frost.ggwave.commands.execute.sub.StopCommand;
import me.frost.ggwave.utils.MessageUtils;
import org.bukkit.command.CommandSender;

public class GGWaveCommand extends BaseCommand {

    public GGWaveCommand() {
        super("ggwave", GGWave.getPlugin(GGWave.class).getConfig().getString("settings.permission"), "&e&l(!) &e/ggwave");
        getSubCommands().add(new StartCommand());
        getSubCommands().add(new StopCommand());
        getSubCommands().add(new ReloadCommand());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        MessageUtils.getInstance().sendMessage("&e&lStormGGWave 1.0 &7(by frost#0723)", sender);
        getSubCommands().forEach(subCommand -> MessageUtils.getInstance().sendMessage(subCommand.getUsage(), sender));
    }
}