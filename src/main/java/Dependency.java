/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author jagad
 */
public class Dependency {

	/**
	 * @param args
	 *            the command line arguments
	 */
	static Map<String, List<String>> map = new LinkedHashMap<>();
	static List<String> installedSet = new ArrayList<>();
	static Map<String, Set<String>> revDeps = new LinkedHashMap<>();

	public static void main(String[] args) {
		readFile();

	}

	public static void readFile() {

		try {
			File file = new File("C:\\Users\\jagad\\Desktop\\apple\\sample.txt"); // creates a new file instance
			FileReader fr = new FileReader(file); // reads the file
			BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
			String line;
			while ((line = br.readLine()) != null) {
				String[] words = line.split(" ");
				System.out.println(line);
				if (words.length > 0) {
					switch (words[0]) {
					case "DEPEND":
						List<String> set = new ArrayList<>();
						for (int i = 2; i < words.length; i++) {
							set.add(words[i]);
						}
						map.put(words[1], set);

						break;
					case "INSTALL":
						if (installedSet.contains(words[1])) {
							System.out.println(words[1] + " is already installed");
						} else {

							resolveDependencies(words[1]);

						}
						break;
					case "LIST":
						System.out.println(installedSet);
						break;
					case "REMOVE":
						if (installedSet.contains(words[1])) {
							Set<String> deps = revDeps.get(words[1]);
							if (deps == null || deps.isEmpty()) {
								System.out.println("    Removing " + words[1]);
								installedSet.remove(words[1]);
							} else {
								removeDependency(words[1]);
							}
						}

					}
				}
			}
			fr.close(); // closes the stream and release the resources
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void resolveDependencies(String comp) {
		if (!installedSet.contains(comp)) {
			List<String> deps = map.get(comp);
			if (deps != null && !deps.isEmpty()) {
				deps.forEach(depn -> {
					Set<String> listRev = revDeps.get(depn);
					if (listRev == null) {
						listRev = new HashSet<>();
						revDeps.put(depn, listRev);
					}
					listRev.add(comp);
					resolveDependencies(depn);
				});

			}
			installedSet.add(comp);
			System.out.println("    Installing " + comp);
		}
	}

	public static void removeDependency(String comp) {
		Set<String> deps = revDeps.get(comp);
		if (deps == null || deps.isEmpty() || deps.size() == 1) {
			System.out.println("    Removing " + comp);
			installedSet.remove(comp);
		} else {
			System.out.println("\t " + comp + " is still needed.");
		}
	}

}
