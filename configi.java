package me.saboorek.neptunecore;



import java.util.List;
//import java.util.Set;

//import org.bukkit.Bukkit;
//import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Configi implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("config")) {
			if(sender.hasPermission("ncc.config")) {
			if(args.length != 1) {
				return true;
			}
			if(!(sender instanceof Player)) {
				return true;
			}
			Player p = (Player) sender;
			if(args[0].equalsIgnoreCase("set")) {
				String pn = p.getName().toLowerCase();
				String ip = p.getAddress().getAddress().toString().replaceAll("/", "");
				String uuid = p.getUniqueId().toString();
				Main.getInst().getConfig().set("players." + pn + ".uuid", uuid);
				Main.getInst().getConfig().set("players." + pn + ".ip", ip);
				Main.getInst().saveConfig();
				return true;
			}
			if(args[0].equalsIgnoreCase("get")) {
				String pn = p.getName().toLowerCase();
				if(Main.getInst().getConfig().get("players." + pn) != null) {
					p.sendMessage("§6§lIP address: §7§l" + Main.getInst().getConfig().getString("players." + pn + ".ip"));
					p.sendMessage("§6§lUUID: §7§l" + Main.getInst().getConfig().getString("players." + pn + ".uuid"));
					
				}
							
			}
				return true;
		}
	}
		/*if(cmd.getName().equalsIgnoreCase("spawn")) {
			if(sender.hasPermission("ncc.spawn")) {
			if(args.length != 1) {
				return true;
			}
			if(!(sender instanceof Player)) {
				return true;
			}
			Player p = (Player) sender;
			if(args[0].equalsIgnoreCase("set")) {
				Location l = p.getLocation();
				Main.getInst().getConfig().set("spawnLocX", l.getX());
				Main.getInst().getConfig().set("spawnLocY", l.getY());
				Main.getInst().getConfig().set("spawnLocZ", l.getZ());
				Main.getInst().getConfig().set("spawnLocWorld", l.getWorld().getName());
				Main.getInst().saveConfig();
				return true;
			}
			if(args[0].equalsIgnoreCase("get")) {
				double x = Main.getInst().getConfig().getDouble("spawnLocX");
				double y = Main.getInst().getConfig().getDouble("spawnLocY");
				double z = Main.getInst().getConfig().getDouble("spawnLocZ");
				String wName = Main.getInst().getConfig().getString("spawnLocWorld");
				Location  l = new Location(Bukkit.getWorld(wName), x,y,z);
				p.teleport(l);
				return true;
				}
				return false;
		
			}
			
		}*/
		/*if(cmd.getName().equalsIgnoreCase("automsg")) {
			if(sender.hasPermission("ncc.automsgs")) {
			if(args.length == 0) {
				sender.sendMessage("§dDostepne opcje:");
				sender.sendMessage("§3/automsg list, /automsg add, /automsg remove");
				return true;
			}
			if(args.length == 1) {
				if(args[0].equals("list")) {
					for(int i = 0; i<Main.getInst().msgs.size(); i++) {
						sender.sendMessage("§dID " + i + "§7:" + Main.getInst().msgs.get(i));

					}
				}
			}
			if(args.length == 2) {
				if(args[0].equals("remove")) {
					int numer = Integer.parseInt(args[1]);
					Main.getInst().msgs.remove(numer);
					Main.getInst().getConfig().set("autoMsg", Main.getInst().msgs);
					Main.getInst().saveConfig();
				}
			} else {
				if(args[0].equals("add")) {
					String msg = "";
					for(int i = 1; i<args.length; i++) {
						msg += " " + args[i];
					}
					msg.replaceFirst(" ", "");
					List<String> msgs = Main.getInst().getConfig().getStringList("autoMsg");
					msgs.add(msg);
					Main.getInst().msgs = msgs;
					Main.getInst().getConfig().set("autoMsg", msgs);
					Main.getInst().saveConfig();
					}
				}
			}
		}*/
		/*if(cmd.getName().equalsIgnoreCase("warp")) {
			if(sender.hasPermission("ncc.warp")) {
				if(args.length == 1) {
					if(args[0].equals("list")) {
						Set<String> keys = Main.getInst().getConfig().getKeys(false);
						String lista = "";
						for(String s: keys) {
							if(!s.equals("autoMsg")) {
								lista +=", " + s;
							}
						}
						sender.sendMessage("§6Warpy: " + lista);
					}
				}
				if(args.length == 2) {
					if(args[0].equals("set")) {
						if(Main.getInst().getConfig().get(args[1]) !=null) {
							return true;
						}
						Main.getInst().getConfig().set(args[1]+ ".x", 0);
						Main.getInst().getConfig().set(args[1]+ ".y", 0);
						Main.getInst().getConfig().set(args[1]+ ".z", 0);
						Main.getInst().getConfig().set(args[1]+ ".world", "NeptuneAdventure");
					}
				}
					if(args[0].equals("remove")) {
						if(Main.getInst().getConfig().get(args[1]) !=null) {
							Main.getInst().getConfig().set(args[1], null);
						}
					}
			}
		}*/
			return false;
	}
}

