package com.ds.input.validator;

import java.util.ArrayList;
import java.util.List;

public class ComandValidator {

	public static List<String> getValidCommands(List<String> commands) {

		List<String> validCommands = new ArrayList<>();

		List<String> allowedCommands = ValidCommands.asList();
		
		// TODO can be replaced with java streams or Drules validators or ESAPI Validations for more error prone scenarios
		for (String command : commands) {
			if (command != null && command.trim().length() > 0) {
				String[] commandCodes = command.split(" ");
				if (commandCodes != null && commandCodes.length > 0 & allowedCommands.contains(commandCodes[0])) {
					validCommands.add(removeEmptySpaces(command));
				}
			}
		}
		return validCommands;
	}

	private static String removeEmptySpaces(String commandCodes) {
		return commandCodes.trim().replaceAll(" +", " ");
	}
}
