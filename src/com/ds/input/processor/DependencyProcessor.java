package com.ds.input.processor;

import java.util.Arrays;
import java.util.List;

import com.ds.command.processor.CommandProcessor;
import com.ds.command.request.CommandRequest;

public class DependencyProcessor {

	public List<String> processCommands(List<String> commands) {
		for(String command : commands) {
			
			List<String> commandList = Arrays.asList(command.split(" "));
			CommandProcessor processor = CommandExecutorFactory.getCommandProcessor(commandList.get(0));
			CommandRequest request = CommandRequestFactory.getCommandRequest(commandList.get(0));
			
			processor.processCommand(request);
		}
		return null;
	}
	
}
