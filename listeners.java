package me.saboorek.neptunecore;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
//import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
//import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitTask;

public class Listeners implements Listener{

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Location to = e.getTo();
		Location from = e.getFrom();
		if(from.getBlockX() != to.getBlockX() || (from.getBlockY() != to.getBlockY() || (from.getBlockZ() != to.getBlockZ()))) {
			if(new Cmds().tp.containsKey(e.getPlayer().getName())) {
				((BukkitTask)new Cmds().tp.remove(e.getPlayer().getName())).cancel();
				e.getPlayer().sendMessage("§6[TP INFO] §3Teleportacja anulowana");
			}
		}
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		Bukkit.getScheduler().runTaskLater(Main.getInst(), new Runnable() {
			public void run() {
				p.sendMessage("§6§lWitamy na serwerze §3NeptuneCraft!");
			}
			
		}, 2*20);		
	}
}

