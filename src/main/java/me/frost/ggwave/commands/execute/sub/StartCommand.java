package me.frost.ggwave.commands.execute.sub;

import me.frost.ggwave.GGWave;
import me.frost.ggwave.commands.SubCommand;
import me.frost.ggwave.managers.WaveManager;
import me.frost.ggwave.utils.MessageUtils;
import org.bukkit.command.CommandSender;

public class StartCommand extends SubCommand {
    public StartCommand() {
        super("start", GGWave.getPlugin(GGWave.class).getConfig().getString("settings.permission"), "&e&l(!) &e/ggwave start (duration)", "Starts a GGWave");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (WaveManager.getInstance().hasWaveStarted()) {
            MessageUtils.getInstance().sendMessage(getConfig().getString("messages.WAVE-ONGOING"), sender);
            return;
        }

        if (args.length < 2 || !isInteger(args[1])) {
            MessageUtils.getInstance().sendMessage(getConfig().getString("messages.INVALID-DURATION"), sender);
            return;
        }

        WaveManager.getInstance().startWave(Integer.parseInt(args[1]));
    }

    private boolean isInteger(String integer) {
        try {
            Integer.parseInt(integer);
        } catch (NumberFormatException exception) {
            System.out.println("Not an integer");
            return false;
        }
        return true;
    }
}