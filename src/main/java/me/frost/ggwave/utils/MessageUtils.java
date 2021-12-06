package me.frost.ggwave.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.util.List;

public class MessageUtils {
    private static MessageUtils instance = null;

    public static MessageUtils getInstance() {
        return (instance == null ? instance = new MessageUtils() : instance);
    }

    public void sendMessage(String message, CommandSender sender) {
        sender.sendMessage(ColorUtil.colorString(message));
    }

    public void sendMessageList(List<String> message, CommandSender sender) {
        message.forEach(m -> sender.sendMessage(ColorUtil.colorString(m)));
    }

    public void broadcastMessage(String message) {
        Bukkit.broadcastMessage(ColorUtil.colorString(message));
    }

    public void broadcastMessageList(List<String> message) {
        message.forEach(m -> Bukkit.broadcastMessage(ColorUtil.colorString(m)));
    }
}