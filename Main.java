package me.saboorek.neptunecore;

import java.util.List;

import org.bukkit.Bukkit;
//import org.bukkit.Material;
//import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin { 
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	private static Main instance;
	public List<String> msgs;
	int i;
	
	
	@Override
	public void onEnable(){
		instance = this;
		//Wczytywanie systemu//
		System.out.println(ANSI_CYAN + "=====[NCC]=====" + ANSI_RESET);
		System.out.println(ANSI_GREEN + "Uruchamiam plugin..." + ANSI_RESET);
		System.out.println(ANSI_GREEN + "Wczytano wszystkie systemy..." + ANSI_RESET);
		System.out.println(ANSI_GREEN + "Wczytano plik konfiguracyjny..." + ANSI_RESET);
		System.out.println(ANSI_GREEN + "Wczytana liczba komend: 10" + ANSI_RESET);
		//System.out.println(ANSI_GREEN + "Wczytano silnik roleplay RPEngine..." + ANSI_RESET);
		System.out.println(ANSI_GREEN + "Uruchomiono plugin w wersji Beta 1.0" + ANSI_RESET);
		System.out.println(ANSI_GREEN + "Wersja uzywanego spigota: 1.14.3" + ANSI_RESET);
		System.out.println(ANSI_CYAN + "===============" + ANSI_RESET);
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
		//==================//
		
		//komendy z Cmds.java//
		getCommand("mspawn").setExecutor(new Cmds());
		getCommand("ulecz").setExecutor(new Cmds());
		getCommand("pogoda").setExecutor(new Cmds());
		getCommand("gm").setExecutor(new Cmds());
		getCommand("aduty").setExecutor(new Cmds());
		getCommand("spawn").setExecutor(new Cmds());
		getCommand("report").setExecutor(new Cmds());
		getCommand("gp").setExecutor(new Cmds());
		getCommand("ck").setExecutor(new Cmds());
		//==================//
		
		//Komendy z Configi.java//
		//getCommand("spawn").setExecutor(new Configi());
		getCommand("config").setExecutor(new Configi());
		//getCommand("automsg").setExecutor(new Configi());
		//getCommand("warp").setExecutor(new Configi());
		//=====================//
		
		//Wczytanie configu//
		saveDefaultConfig();
		msgs = getConfig().getStringList("autoMsg");
		autoMsg();
		//================//
		//komendy z Tab//
		getCommand("aduty").setTabCompleter(new TabCompletion());
		getCommand("pogoda").setTabCompleter(new TabCompletion());
		//============//
		
		//Zapis informacji//
		
		//================//
		
	}
	@Override
	public void onDisable() {
		System.out.println(ANSI_CYAN + "=====[NCC]=====" + ANSI_RESET);
		System.out.println(ANSI_RED + "Zapisuje plik konfiguracyjny..." + ANSI_RESET);
		System.out.println(ANSI_RED + "Zamknieto wszystkie systemy..." + ANSI_RESET);
		System.out.println(ANSI_RED + "Zapisuje i zamykam plugin..." + ANSI_RESET);
		System.out.println(ANSI_CYAN + "===============" + ANSI_RESET);
	}
	public static Main getInst() {
		return instance;
	}
	private void autoMsg() {
		i = 0;
		Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
			public void run() {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msgs.get(i)));
				i++;
				if(i == msgs.size()) {
					i = 0;
				}
			}
		}, 0, 1200);
	}
}

