package cz.cvut.fel.ass.parser;

import cz.cvut.fel.ass.interpreter.Interpreter;

public class FinalState extends ParserState {
	
	protected static ParserState instance; 

	public static ParserState getInstance() {
		if(instance == null)
			instance = new FinalState();
		return instance;
	}
	
	private FinalState(){}

	@Override
	public void goNext(ParserStateHandler psh, Interpreter interpreter) {
		String line = psh.getCurrentLine();
		if(!line.equals("END-OF-PROGRAM")){
			psh.setState(new WrongSyntaxState("Očekáván END-OF-PROGRAM"));
		}

	}

}
