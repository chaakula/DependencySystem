package com.ds.input.processor.impl;

import com.ds.command.processor.CommandProcessor;
import com.ds.command.request.CommandRequest;

public class ListCommandProcessor implements CommandProcessor {
	@Override
	public CommandRequest processCommand(CommandRequest commandReq) {
		System.out.println("LIST");
		for (String installedComponent : commandReq.getInstalledSet()) {
			System.out.println("\t" + installedComponent);
		}
		return commandReq;
	}
}
