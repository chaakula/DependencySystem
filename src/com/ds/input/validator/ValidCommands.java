package com.ds.input.validator;

import java.util.ArrayList;
import java.util.List;

public enum ValidCommands {
	DEPEND, INSTALL, REMOVE, LIST, END;

	public static List<String> asList() {
		List<String> list = new ArrayList<>();
		for (ValidCommands com : ValidCommands.values()) {
			list.add(com.name());
		}
		return list;
	}
}
