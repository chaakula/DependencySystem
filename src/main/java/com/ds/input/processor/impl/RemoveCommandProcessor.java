package com.ds.input.processor.impl;

import java.util.List;

import com.ds.command.processor.CommandProcessor;
import com.ds.command.request.CommandRequest;
import com.ds.command.request.InstalledComponent;

public class RemoveCommandProcessor implements CommandProcessor {

    @Override
    public CommandRequest processCommand(CommandRequest req) {
        String[] words = req.getFullCommand().split(" ");
        System.out.println(req.getFullCommand());
        if (req.getInstalledSet().contains(new InstalledComponent(words[1]))) {

            List<String> deps = req.getRevDeps().get(words[1]);
            if (deps != null && deps.size() > 0) {
                System.out.println("\t" + words[1] + " is still needed");
            } else {
                removeDependency(words[1], req, true);
            }

        } else {
            System.out.println("\t" + words[1] + " is not installed");
        }
        return req;
    }

    public static boolean removeDependency(String comp, CommandRequest req, boolean isExplicit) {
        List<String> deps = req.getRevDeps().get(comp);

        int index = req.getInstalledSet().indexOf(new InstalledComponent(comp));

        if ((deps == null || deps.isEmpty()) && index > -1
                && (isExplicit || !req.getInstalledSet().get(index).getIsExplicit())) {
            System.out.println("\tRemoving " + comp);
            req.getInstalledSet().remove(new InstalledComponent(comp));
            List<String> comps = req.getDepMap().get(comp);
            if (comps != null) {
                comps.forEach(depn -> {
                    List<String> get = req.getRevDeps().get(depn);
                    if (get != null && !get.isEmpty()) {
                        get.remove(comp);
                    }
                    removeDependency(depn, req, false);
                });
            }
        }
        return false;
    }
}
