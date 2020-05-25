package com.ds.input.processor;

import com.ds.command.processor.CommandProcessor;
import com.ds.input.processor.impl.DependCommandProcessor;
import com.ds.input.processor.impl.EndCommandProcessor;
import com.ds.input.processor.impl.InstallCommandProcessor;
import com.ds.input.processor.impl.ListCommandProcessor;
import com.ds.input.processor.impl.RemoveCommandProcessor;
import com.ds.input.validator.ValidCommands;

public class CommandExecutorFactory {

	public static CommandProcessor getCommandProcessor(String commandCode) {
		if(ValidCommands.DEPEND.name().equals(commandCode)) {
			return new DependCommandProcessor();
		} else if(ValidCommands.INSTALL.name().equals(commandCode)) {
			return new InstallCommandProcessor();
		} else if(ValidCommands.LIST.name().equals(commandCode)) {
			return new ListCommandProcessor();
		} else if(ValidCommands.REMOVE.name().equals(commandCode)){
			return new RemoveCommandProcessor();
		} else if(ValidCommands.END.name().equals(commandCode)) {
			return new EndCommandProcessor();
		}
		
		return null;
	}
}
