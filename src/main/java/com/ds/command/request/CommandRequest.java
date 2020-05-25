package com.ds.command.request;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommandRequest {

	String commandCode;
	String fullCommand;
	List<String> installedSet = new ArrayList<>();
	Map<String, List<String>> map = new LinkedHashMap<>();
	Map<String, Set<String>> revDeps = new LinkedHashMap<>();

	public List<String> getInstalledSet() {
		return installedSet;
	}

	public void setInstalledSet(List<String> installedSet) {
		this.installedSet = installedSet;
	}

	public String getCommandCode() {
		return commandCode;
	}

	public void setCommandCode(String commandCode) {
		this.commandCode = commandCode;
	}

	public String getFullCommand() {
		return fullCommand;
	}

	public void setFullCommand(String fullCommand) {
		this.fullCommand = fullCommand;
	}

	public Map<String, List<String>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<String>> map) {
		this.map = map;
	}

	public Map<String, Set<String>> getRevDeps() {
		return revDeps;
	}

	public void setRevDeps(Map<String, Set<String>> revDeps) {
		this.revDeps = revDeps;
	}

}
