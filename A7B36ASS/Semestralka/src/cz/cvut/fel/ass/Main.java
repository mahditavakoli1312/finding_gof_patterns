package cz.cvut.fel.ass;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import cz.cvut.fel.ass.interpreter.Interpreter;
import cz.cvut.fel.ass.parser.DefaultParser;
import cz.cvut.fel.ass.parser.FileSource;
import cz.cvut.fel.ass.parser.KarelParser;
import cz.cvut.fel.ass.parser.LineOfCode;
import cz.cvut.fel.ass.parser.ParserState;
import cz.cvut.fel.ass.parser.SourceCode;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File config = new File("rsc/config.ini");
		ServiceLocator sl = new ServiceLocator(config);
		
		
		File file = new File("rsc/sample.karel");
		SourceCode source = new FileSource(file, sl);
		KarelParser kp = new KarelParser();
		ParserState.setServiceLocator(sl); // TODO: nešikovné
		DefaultParser parser = new DefaultParser(sl);
		kp.parse(source, parser);
		Interpreter interpreter = parser.getInterpreter();
		
		interpreter.start();
		
		
		
		
	}


}
