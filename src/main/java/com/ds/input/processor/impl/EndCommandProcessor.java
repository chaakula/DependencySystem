package com.ds.input.processor.impl;

import com.ds.command.processor.CommandProcessor;
import com.ds.command.request.CommandRequest;

public class EndCommandProcessor implements CommandProcessor {
	@Override
	public CommandRequest processCommand(CommandRequest command) {
		System.out.println(command.getCommandCode());
		return command;
	}
}
