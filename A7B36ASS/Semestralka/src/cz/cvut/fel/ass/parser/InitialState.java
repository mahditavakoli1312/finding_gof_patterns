package cz.cvut.fel.ass.parser;

import cz.cvut.fel.ass.interpreter.Interpreter;

// VZOR: State, Singleton
public class InitialState extends ParserState {
	protected static ParserState instance; 
	
	@Override
	public void goNext(ParserStateHandler psh, Interpreter interpreter) {
		String command = psh.getCurrentLine();
		if(command.equals("BEGIN-OF-PROGRAM")){
			psh.setState(BodyState.getInstance());
		}else{ 
			ParserState ps = new WrongSyntaxState("Jako první musí být begin-of-program");
			psh.setState(ps);
		}
	}

	
	public static ParserState getInstance() {
		if(instance == null)
			instance = new InitialState();
		return instance;
	}

	private InitialState(){};
}
