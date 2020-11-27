package me.saboorek.neptunecore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class TabCompletion implements TabCompleter{
	

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("aduty")) {
			List<String> tab = new ArrayList<String>();
			if(args.length == 1) {
				String a = args[0].toLowerCase();
				if(a.startsWith("z")) {
					tab.add("zaloguj");
					return tab;
				}
				if(a.startsWith("w")) {
					tab.add("wyloguj");
					return tab;
				}
				if(a.equalsIgnoreCase("")) {
					tab.add("zaloguj");
					tab.add("wyloguj");
					Collections.sort(tab);
					return tab;
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("pogoda")) {
			List<String> tab = new ArrayList<String>();
			if(args.length == 1) {
				String a = args[0].toLowerCase();
				if(a.startsWith("s")) {
					tab.add("slonce");
					return tab;
				}
				if(a.startsWith("d")) {
					tab.add("deszcz");
					return tab;
				}
				if(a.startsWith("b")) {
					tab.add("burza");
					return tab;
				}
			}
		}
		return null;
	}
}


