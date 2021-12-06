package me.frost.ggwave.commands.execute.sub;

import me.frost.ggwave.GGWave;
import me.frost.ggwave.commands.SubCommand;
import me.frost.ggwave.utils.MessageUtils;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends SubCommand {
    public ReloadCommand() {
        super("reload", GGWave.getPlugin(GGWave.class).getConfig().getString("settings.permission"), "&e&l(!) &e/ggwave reload", "Reloads the configuration");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        GGWave.getPlugin(GGWave.class).reloadConfig();
        MessageUtils.getInstance().sendMessage("&a&l(!) &aSuccessfully reloaded the configuration!", sender);
    }
}