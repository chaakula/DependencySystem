package com.ds.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputReader implements InputReader {

	@Override
	public List<String> readInput() {
		List<String> commands = new ArrayList<>();
		String fileName = "source.txt";
		  ClassLoader classLoader = new FileInputReader().getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		String line;
		try {
			while ((line = br.readLine()) != null) {
				commands.add(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commands;
	}

}
