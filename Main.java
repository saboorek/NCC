package me.saboorek.dwmccore;

import java.util.List;

import org.bukkit.Bukkit;
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
		System.out.println(ANSI_CYAN + "=====[DwMC]=====" + ANSI_RESET);
		System.out.println(ANSI_GREEN + "Uruchamiono plugin" + ANSI_RESET);
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
		getCommand("spawn").setExecutor(new Cmds());
		getCommand("report").setExecutor(new Cmds());
		getCommand("gp").setExecutor(new Cmds());
		//==================//
		
		//Komendy z Configi.java//
		getCommand("config").setExecutor(new Configi());
		//=====================//
		
		//Wczytanie configu//
		saveDefaultConfig();
		msgs = getConfig().getStringList("autoMsg");
		autoMsg();
		//================//
		//komendy z Tab//
		getCommand("pogoda").setTabCompleter(new TabCompletion());
		//============//
		
		//Zapis informacji//
		
		//================//
		
	}
	@Override
	public void onDisable() {
		System.out.println(ANSI_CYAN + "=====[DwMC]=====" + ANSI_RESET);
		System.out.println(ANSI_GREEN + "Plugin poprawnie zamknięty" + ANSI_RESET);
		System.out.println(ANSI_CYAN + "===============" + ANSI_RESET);
	}
	public static Main getInst() {
		return instance;
	}
	public class Test extends JavaPlugin {

    String host, port, database, username, password;
    static Connection connection;
 
    @Override
    public void onEnable() {  
        host = "localhost";
        port = "3306";
        database = "TestDatabase";
        username = "user";
        password = "pass";    
    }
 
    @Override
    public void onDisable() {
	    statement.executeUpdate(INSERT INTO PlayerData (PLAYER, BALANCE) VALUES ('Playername', 'balance');
    }

}

