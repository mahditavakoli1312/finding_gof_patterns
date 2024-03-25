package cz.cvut.fel.ass.parser;

import cz.cvut.fel.ass.ServiceLocator;
import cz.cvut.fel.ass.interpreter.Interpreter;

public abstract class ParserState {
	
	protected static ServiceLocator serviceLocator;
	
	public static void setServiceLocator(ServiceLocator sl){
		serviceLocator = sl;
	}
	
	
	public abstract void goNext(ParserStateHandler psh, Interpreter interpreter);
	
}
