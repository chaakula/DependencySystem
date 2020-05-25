package com.ds.input.processor.impl;

import com.ds.command.processor.CommandProcessor;
import com.ds.command.request.CommandRequest;

public class ListCommandProcessor implements CommandProcessor {
	@Override
	public void processCommand(CommandRequest command) {
		System.out.println("List");

	}
}
