package com.ds.input.processor.impl;

import java.util.ArrayList;
import java.util.List;

import com.ds.command.processor.CommandProcessor;
import com.ds.command.request.CommandRequest;
import com.ds.command.request.InstalledComponent;

public class InstallCommandProcessor implements CommandProcessor {

    @Override
    public CommandRequest processCommand(CommandRequest req) {
        System.out.println(req.getFullCommand());
        String[] words = req.getFullCommand().split(" ");

        if (req.getInstalledSet().contains(new InstalledComponent(words[1]))) {
            System.out.println("\t" + words[1] + " is already installed.");
        } else {
            resolveDependencies(words[1], req, true);
        }
        return req;
    }

    public static void resolveDependencies(String comp, CommandRequest req, boolean isExplicit) {
        if (!req.getInstalledSet().contains(new InstalledComponent(comp))) {
            List<String> deps = req.getDepMap().get(comp);
            if (deps != null && !deps.isEmpty()) {
                deps.forEach(depn -> {
                    List<String> listRev = req.getRevDeps().get(depn);
                    if (listRev == null) {
                        listRev = new ArrayList<>();
                        req.getRevDeps().put(depn, listRev);
                    }
                    listRev.add(comp);
                    resolveDependencies(depn, req, false);
                });

            }
            req.getInstalledSet().add(new InstalledComponent(comp, isExplicit));
            System.out.println("\tInstalling " + comp);
        }
    }
}
