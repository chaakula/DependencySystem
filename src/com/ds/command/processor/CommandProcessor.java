package com.ds.command.processor;

import com.ds.command.request.CommandRequest;

public interface CommandProcessor {

	void processCommand(CommandRequest command);
	
}
