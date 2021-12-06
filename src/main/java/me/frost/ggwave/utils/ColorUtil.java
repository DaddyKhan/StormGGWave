package me.frost.ggwave.utils;

import org.bukkit.ChatColor;

public class ColorUtil {
    public static String colorString(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
