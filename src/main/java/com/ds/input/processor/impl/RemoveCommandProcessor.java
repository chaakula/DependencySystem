package com.ds.input.processor.impl;

import java.util.List;
import java.util.Set;

import com.ds.command.processor.CommandProcessor;
import com.ds.command.request.CommandRequest;

public class RemoveCommandProcessor implements CommandProcessor {
	@Override
	public CommandRequest processCommand(CommandRequest req) {
		String[] words = req.getFullCommand().split(" ");
		System.out.println(req.getFullCommand());
		if (req.getInstalledSet().contains(words[1])) {

			Set<String> deps = req.getRevDeps().get(words[1]);
			if (deps != null && deps.size() > 1) {
				System.out.println("    " + words[1] + " is still needed");
			} else {
				removeDependency(words[1], req);
			}

		} else {
			System.out.println("\t" + words[1] + " is not installed");
		}
		return req;
	}

	public static boolean removeDependency(String comp, CommandRequest req) {
		Set<String> deps = req.getRevDeps().get(comp);

		if (deps != null && !deps.isEmpty()) {
			if (deps.size() == 1) {
				System.out.println("    Removing " + comp);
				req.getInstalledSet().remove(comp);
				deps.remove(comp);
				List<String> comps = req.getMap().get(comp);
				if (comps != null) {
					comps.forEach(depn -> {
						removeDependency(depn, req);
					});
				}
			}
		} else {
			System.out.println("    Removing " + comp);
			List<String> comps = req.getMap().get(comp);
			if (comps != null) {
				comps.forEach(depn -> {
					Set<String> get = req.getRevDeps().get(depn);
					if (get != null && !get.isEmpty()) {
						get.remove(comp);
					}
					removeDependency(depn, req);
				});
			}
		}
		return false;
	}
}
