package com.ds.input.processor.impl;

import com.ds.command.processor.CommandProcessor;
import com.ds.command.request.CommandRequest;
import com.ds.command.request.InstalledComponent;

public class ListCommandProcessor implements CommandProcessor {
	@Override
	public CommandRequest processCommand(CommandRequest commandReq) {
		System.out.println("LIST");
		for (InstalledComponent installedComponent : commandReq.getInstalledSet()) {
			System.out.println("\t" + installedComponent.getName());
		}
		return commandReq;
	}
}
