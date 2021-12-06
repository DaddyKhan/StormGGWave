package me.frost.ggwave.commands.execute.sub;

import me.frost.ggwave.GGWave;
import me.frost.ggwave.commands.SubCommand;
import me.frost.ggwave.managers.WaveManager;
import me.frost.ggwave.utils.MessageUtils;
import org.bukkit.command.CommandSender;

public class StopCommand extends SubCommand {
    public StopCommand() {
        super("stop", GGWave.getPlugin(GGWave.class).getConfig().getString("settings.permission"), "&e&l(!) &e/ggwave stop", "Stops a GGWave");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!WaveManager.getInstance().hasWaveStarted()) {
            MessageUtils.getInstance().sendMessage(getConfig().getString("messages.WAVE-NOT-ONGOING"), sender);
            return;
        }

        WaveManager.getInstance().stopWave();
    }
}