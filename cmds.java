
package me.saboorek.neptunecore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class Cmds implements CommandExecutor{
	
	public Map<String, BukkitTask> tp = new HashMap<String, BukkitTask>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
		if(cmd.getName().equalsIgnoreCase("mspawn")) {
			if(sender.hasPermission("ncc.admin.mobspawn")) {
				
			if(args.length !=1) {
					return false;
			}
			List<String> str = new ArrayList<String>();
			for(EntityType en : EntityType.values()){
					str.add(en.name());
				
			}
			if(str.contains(args[0].toUpperCase())) {
				if(sender instanceof Player) {
					((Player)sender).getLocation().getWorld().spawnEntity(((Player)sender).getLocation(), EntityType.valueOf(args[0].toUpperCase()));
					
					}
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("ulecz")) {
			if(sender.hasPermission("ncc.admin.heal")) {
			statement.executeQuary(SELECT 'aduty' FROM 'Playerdata' WHERE 'Playerdata'. 'aduty' =1) {
					if(args.length == 0) {
					if(!(sender instanceof Player)) {
						sender.sendMessage("§cNie jestes graczem!");
						return false;
					}
					Player p = (Player) sender;
					p.setHealth(20);
					p.sendMessage("§3Uleczyles sie!");
				}
				if(args.length >= 1) {
					String pName = args[0];
					if(Bukkit.getPlayer(pName) !=null) {
						Player p = Bukkit.getPlayer(pName);
						p.setHealth(20);
						p.sendMessage("§3Zostałeś uleczony przez Administrację!");
					} else {
						sender.sendMessage("§c§1Nie ma takiego gracza na serwerze!");
					}
				}		
			}
				
			} else {
				sender.sendMessage("§Nie posiadasz uprawnien do wykonania tej komendy!");
			}
		}
		if(cmd.getName().equalsIgnoreCase("pogoda")) {
			if(sender.hasPermission("ncc.admin.weather")) {
				if(args.length == 1) {
					
					World w = ((Player)sender).getWorld();
					if(args[0].equals("slonce")) {
						w.setStorm(false);
						w.setThundering(false);
						sender.sendMessage("§6[INFO]§3Zmieniono pogode na §dSlonce");
					}
					if(args[0].equals("deszcz")) {
						w.setStorm(true);
						w.setThundering(false);
						sender.sendMessage("§6[INFO]§3Zmieniono pogode na §dDeszcz");
					}
					if(args[0].equals("burza")) {
						w.setStorm(true);
						w.setThundering(true);
						sender.sendMessage("§6[INFO]§3Zmieniono pogode na §dBurza");
					}
				} else {
					sender.sendMessage("§dDostepne opcje:");
					sender.sendMessage("§6slonce §f- SLONECZNA POGODA");
					sender.sendMessage("§1deszcz §f- DESZCZOWA POGODA");
					sender.sendMessage("§8burza §f- BURZA");
				}
			} else {
				sender.sendMessage("§6[INFO]§cNie posiadasz uprawnien do wykonania tej komendy!");
			}
		}
		if(cmd.getName().equalsIgnoreCase("czas")) {
			if(sender.hasPermission("ncc.admin.time")) {
				if(args.length == 1) {
					
					if(!(sender instanceof Player)) {
						sender.sendMessage("§6[INFO]§cTa komende moze uzyc tylko gracz!");
						return false;
					}
					
					Player p = (Player) sender;
					if(args[0].equals("dzien")) {
						p.getLocation().getWorld().setTime(3000);
						sender.sendMessage("Czas zostal zmieniony na dzien");
					}
					if(args[0].equals("noc")) {
						p.getLocation().getWorld().setTime(12000);
						sender.sendMessage("Czas zostal zmieniony na noc");
					}
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("gm")) {
			if(sender.hasPermission("ncc.admin.gamemode")) {
				if(args.length == 1) {
					
					if(!(sender instanceof Player)) {
						sender.sendMessage("§6[INFO]§cTa komende moze uzyc tylko gracz!");
						return false;
					}
					
					Player p = (Player) sender;
					if(args[0].equals("a")) {
						p.setGameMode(GameMode.ADVENTURE);
						sender.sendMessage("§6[INFO]§dUstawiono twoj gamemode na §3ADVENTURE");
					}
					if(args[0].equals("s")) {
						p.setGameMode(GameMode.SURVIVAL);
						sender.sendMessage("§6[INFO]§dUstawiono twoj gamemode na §3SURVIVAL");
					}
					if(args[0].equals("c")) {
						p.setGameMode(GameMode.CREATIVE);
						sender.sendMessage("§6[INFO]§dUstawiono twoj gamemode na §3CREATIVE");
					}
					if(args[0].equals("spec")) {
						p.setGameMode(GameMode.SPECTATOR);
						sender.sendMessage("§6[INFO]§dUstawiono twoj gamemode na §3SPECTATOR");
					}
				} else {
					sender.sendMessage("§dDostepne opcje:");
					sender.sendMessage("§ca - ADVENTURE");
					sender.sendMessage("§3s - SURVIVAL");
					sender.sendMessage("§4c - CREATIVE");
					sender.sendMessage("§8spec - SPECTATOR");
				}
			} else {
				sender.sendMessage("§6[INFO]§cNie posiadasz uprawnien do wykonania tej komendy!");
			}
		}
		if(cmd.getName().equalsIgnoreCase("spawn")) {
			if(sender.hasPermission("ncc.spawn")) {
				if(!(sender instanceof Player)) {
					sender.sendMessage("§cTylko gracz ma dostep do tej komendy!");
					return true;
				}
			
				final Player p = (Player) sender;
				if(tp.containsKey(p.getName())) {
					((BukkitTask)tp.remove(p.getName())).cancel();
				}
				p.sendMessage("§6[TP INFO] §3Teleportacja nastapi za 5 sekund");
				BukkitTask bt = Bukkit.getScheduler().runTaskLater(Main.getInst(), new Runnable() {
					public void run() {
						p.teleport(p.getWorld().getSpawnLocation());
						((BukkitTask)tp.remove(p.getName())).cancel();
						p.sendMessage("§6[TP INFO]§3Przeteleportowano na spawn");
					}
				}, 5*20);
				tp.put(p.getName(), bt);
			}
		}
		if(cmd.getName().equalsIgnoreCase("report")) {
			sender.sendMessage("§6[ALERT]§fAktualnie komenda jest w fazie tworzenia. Aby zreportowac blad lub gracza zajzyj na forum");
		}
		if(cmd.getName().equalsIgnoreCase("regulamin")){
			if(sender.hasPermission("ncc.rules")) {
				if(!(sender instanceof Player)) {
					sender.sendMessage("§cTylko gracz moze uzyc tej komendy!");
					
					return false;
				}
				sender.sendMessage("§d REGULAMIN SERWERA:");
				sender.sendMessage("1. Prosimy ograniczac wulgarny jezyk do minimum");
				sender.sendMessage("2. Na serwerze zakazuje sie trollowac i griefowac");
				sender.sendMessage("3. Na serwerze panuje zakaz uzywania cheatow (np.X-Ray)");
				sender.sendMessage("4. Swoja rozgrywke nalezy prowadzic w sposob wymieniony w regulaminie na forum");
				sender.sendMessage("5. Szanujmy siebie nawzajem, a atmosfera na pewno bedzie milsza!");
				sender.sendMessage("§cWiecej informacji znajduje sie na forum");
			}
		}
		if(cmd.getName().equalsIgnoreCase("getpos")) {
			if(sender.hasPermission("ncc.admin.getpos")) {
				if(!(sender instanceof Player)) {
					sender.sendMessage("§cTylko gracz moze uzyc tej komendy!");
				
					return false;
				}
				Player p = (Player) sender;
				int x = p.getLocation().getBlockX();
	            int y = p.getLocation().getBlockY();
	            int z = p.getLocation().getBlockZ();
	            String X = String.valueOf(x);
	            String Y = String.valueOf(y);
	            String Z = String.valueOf(z);
	            p.sendMessage("Twoje koordynaty to:");
	            p.sendMessage("X: "+X);
	            p.sendMessage("Y: "+Y);
	            p.sendMessage("Z: "+Z);
			}
		}
		if(cmd.getName().equalsIgnoreCase(""){
			if(sender.hasPermission("ncc.admin.")) {
				
			}
				
		
		}
		return false;
	}
}




