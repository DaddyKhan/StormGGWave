package me.frost.ggwave.listeners;

import me.frost.ggwave.managers.WaveManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (!WaveManager.getInstance().hasWaveStarted()) {
            return;
        }
        if (!event.getMessage().startsWith("gg")) {
            return;
        }
        event.setMessage(WaveManager.getInstance().getRandomType());
    }
}