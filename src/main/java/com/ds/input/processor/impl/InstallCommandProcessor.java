package com.ds.input.processor.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ds.command.processor.CommandProcessor;
import com.ds.command.request.CommandRequest;

public class InstallCommandProcessor implements CommandProcessor {
	@Override
	public CommandRequest processCommand(CommandRequest req) {
		// System.out.println(req.getFullCommand());
		String[] words = req.getFullCommand().split(" ");
		
		if (req.getInstalledSet().contains(words[1])) {
			System.out.println(words[1] + " is already installed.");
		} else {
			resolveDependencies(words[1], req);
		}
		return req;
	}
	
	 public static void resolveDependencies(String comp, CommandRequest req) {
	        if (!req.getInstalledSet().contains(comp)) {
	            List<String> deps = req.getMap().get(comp);
	            if (deps != null && !deps.isEmpty()) {
	                deps.forEach(depn -> {
	                    Set<String> listRev = req.getRevDeps().get(depn);
	                    if (listRev == null) {
	                        listRev = new HashSet<>();
	                        req.getRevDeps().put(depn, listRev);
	                    }
	                    listRev.add(comp);
	                    resolveDependencies(depn, req);
	                });

	            }
	            req.getInstalledSet().add(comp);
	            System.out.println("\tInstalling " + comp);
	        }
	    }
}
