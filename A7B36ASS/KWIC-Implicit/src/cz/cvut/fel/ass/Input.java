package cz.cvut.fel.ass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Observable;


public class Input extends Observable{
	
	public void parse(String fileName, LineStorage lines){
		try{
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			int lineNumber = 0;
			while(line != null){
				lineNumber++;
				lines.addLine(line, lineNumber);
				line = reader.readLine();
			}
		}catch(Exception ex){
		}
		setChanged();
        notifyObservers(new Boolean(true));
	}

}
