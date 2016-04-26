package com.gmail.filoghost.chestcommands.bridge;

import me.armar.plugins.autorank.Autorank;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class AutoRankBridge {

	private static Autorank autoRank;
	
	public static boolean setupPlugin() {
		 Plugin rankPlugin = Bukkit.getPluginManager().getPlugin("Autorank");
				 
		 if (rankPlugin == null || !(rankPlugin instanceof Autorank)) {
			 return false;
	     }
		 
		 autoRank = (Autorank) rankPlugin;
		 return true;
	}
	
	public static boolean hasValidPlugin() {
		return autoRank != null;
	}
	
	public static int getBungeePlayTime(Player player) {
		if (!hasValidPlugin()) throw new IllegalStateException("AutoRank plugin was not found!");
		return autoRank.getAPI().getGlobalPlayTime(player.getUniqueId());
	}
	
	public static int getServerPlayTime(Player player) {
		if (!hasValidPlugin()) throw new IllegalStateException("AutoRank plugin was not found!");
		return autoRank.getAPI().getLocalPlayTime(player.getUniqueId());
	}
	
	public static String getPermissionGroup(Player player) {
		if (!hasValidPlugin()) throw new IllegalStateException("AutoRank plugin was not found!");
		return autoRank.getAPI().getPrimaryGroup(player);
	}
}