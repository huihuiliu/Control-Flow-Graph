package code_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import projectOfDataClass.Statement;

public class CodeReader {

	public ArrayList<Statement> redeCode(String path) {
		ArrayList<Statement> allLinesOfCurrentFile = new ArrayList<>();
		File file = new File(path);
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			System.out.println("Can not prepare BufferReader :(");
			e1.printStackTrace();
		}

		String st;
		int lineNumber = 1;
		try {
			while ((st = br.readLine()) != null) {
				if(notBlankLine(st))
					allLinesOfCurrentFile.add(new Statement(st, lineNumber));
				lineNumber++;
			}

		} catch (IOException e) {
			System.out.println("Can not read Line from files :(");
			e.printStackTrace();
		}
		return allLinesOfCurrentFile;

	}

	private boolean notBlankLine(String st) {
		int count = 0;
		for(int i = 0; i < st.length(); i++) {
			if(st.charAt(i) == ' ')
				continue;
			else if(st.charAt(i) == '\n')
				continue;
			else if(st.charAt(i) == '\t')
				continue;
			else 
				count++;
		}
		if(count > 0) return true;
		return false;
	}

}
