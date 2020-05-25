package com.ds.input.processor.impl;

import java.util.ArrayList;
import java.util.List;

import com.ds.command.processor.CommandProcessor;
import com.ds.command.request.CommandRequest;

public class DependCommandProcessor implements CommandProcessor {
	@Override
	public CommandRequest processCommand(CommandRequest command) {
		System.out.println(command.getFullCommand());
		String[] words = command.getFullCommand().split(" ");
		List<String> set = new ArrayList<>();
		for (int i = 2; i < words.length; i++) {
			set.add(words[i]);
		}
		command.getDepMap().put(words[1], set);
		return command;
	}
}
