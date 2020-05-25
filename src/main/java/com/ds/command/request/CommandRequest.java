package com.ds.command.request;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CommandRequest {

    String commandCode;
    String fullCommand;
    List<InstalledComponent> installedSet = new ArrayList<>();
    Map<String, List<String>> depMap = new LinkedHashMap<>();
    Map<String, List<String>> revDeps = new LinkedHashMap<>();

    public List<InstalledComponent> getInstalledSet() {
        return installedSet;
    }

    public void setInstalledSet(List<InstalledComponent> installedSet) {
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

    public Map<String, List<String>> getDepMap() {
        return depMap;
    }

    public void setDepMap(Map<String, List<String>> map) {
        this.depMap = map;
    }

    public Map<String, List<String>> getRevDeps() {
        return revDeps;
    }

    public void setRevDeps(Map<String, List<String>> revDeps) {
        this.revDeps = revDeps;
    }

}
