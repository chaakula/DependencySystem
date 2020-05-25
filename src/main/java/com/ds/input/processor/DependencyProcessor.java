package com.ds.input.processor;

import java.util.Arrays;
import java.util.List;

import com.ds.command.processor.CommandProcessor;
import com.ds.command.request.CommandRequest;

public class DependencyProcessor {

	CommandRequest request;

	public List<String> processCommands(List<String> commands) {


		// Refactor don't have time hence keeping everything into single request object
		// even factory is created
		request = CommandRequestFactory.getCommandRequest("END");
		for (String command : commands) {

			List<String> commandList = Arrays.asList(command.split(" "));
			CommandProcessor processor = CommandExecutorFactory.getCommandProcessor(commandList.get(0));

			request.setCommandCode(commandList.get(0));
			request.setFullCommand(command);

			request = processor.processCommand(request);
		}
		return null;
	}

}
