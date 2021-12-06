package me.frost.ggwave.managers;

import me.frost.ggwave.GGWave;
import me.frost.ggwave.utils.ColorUtil;
import me.frost.ggwave.utils.MessageUtils;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WaveManager {
    private static WaveManager instance = null;
    private final GGWave plugin = GGWave.getPlugin(GGWave.class);
    private boolean waveStarted = false;

    public static WaveManager getInstance() {
        return (instance == null ? instance = new WaveManager() : instance);
    }

    public void startWave(long seconds) {
        if (waveStarted) {
            return;
        }
        waveStarted = true;
        MessageUtils.getInstance().broadcastMessageList(plugin.getConfig().getStringList("messages.WAVE-START"));
        Bukkit.getScheduler().runTaskLater(plugin, this::stopWave, 20 * seconds);
    }

    public void stopWave() {
        if (!waveStarted) {
            return;
        }
        waveStarted = false;
        MessageUtils.getInstance().broadcastMessageList(plugin.getConfig().getStringList("messages.WAVE-END"));
    }

    public boolean hasWaveStarted() {
        return waveStarted;
    }

    public String getRandomType() {
        List<String> types = new ArrayList<>(plugin.getConfig().getStringList("ggwave-messages"));
        return ColorUtil.colorString(types.get(ThreadLocalRandom.current().nextInt(types.size())));
    }
}