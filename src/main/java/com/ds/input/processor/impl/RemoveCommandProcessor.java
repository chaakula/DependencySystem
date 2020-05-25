package com.ds.input.processor.impl;

import java.util.Set;

import com.ds.command.processor.CommandProcessor;
import com.ds.command.request.CommandRequest;

public class RemoveCommandProcessor implements CommandProcessor {
	@Override
	public CommandRequest processCommand(CommandRequest req) {
		String[] words = req.getFullCommand().split(" ");
		if (req.getInstalledSet().contains(words[1])) {
			Set<String> deps = req.getRevDeps().get(words[1]);
			if (deps == null || deps.isEmpty()) {
				System.out.println("    Removing " + words[1]);
				req.getInstalledSet().remove(words[1]);
			} else {
				removeDependency(words[1], req);
			}
		}
		return req;
	}

	public static void removeDependency(String comp, CommandRequest req) {
		Set<String> deps = req.getRevDeps().get(comp);
		if (deps == null || deps.isEmpty() || deps.size() == 1) {
			System.out.println("\tRemoving " + comp);
			req.getInstalledSet().remove(comp);
		} else {

		}
	}
}
