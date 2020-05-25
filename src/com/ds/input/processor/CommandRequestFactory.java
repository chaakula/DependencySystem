package com.ds.input.processor;

import com.ds.command.request.CommandRequest;
import com.ds.command.request.DependedCommandRequest;
import com.ds.command.request.InstallCommandRequest;
import com.ds.command.request.ListCommandRequest;
import com.ds.command.request.RremoveCommandRequest;
import com.ds.input.validator.ValidCommands;

public class CommandRequestFactory {

	public static CommandRequest getCommandRequest(String commandCode) {
		if(ValidCommands.DEPEND.name().equals(commandCode)) {
			return new DependedCommandRequest();
		} else if(ValidCommands.INSTALL.name().equals(commandCode)) {
			return new InstallCommandRequest();
		} else if(ValidCommands.LIST.name().equals(commandCode)) {
			return new ListCommandRequest();
		} else if(ValidCommands.REMOVE.name().equals(commandCode)){
			return new RremoveCommandRequest();
		} else if(ValidCommands.END.name().equals(commandCode)) {
			return new CommandRequest();
		}
		
		return null;
	}
}
