package cz.cvut.fel.ass.parser;

import cz.cvut.fel.ass.interpreter.Interpreter;

public class DefineState extends ParserState {
	protected static ParserState instance; 

	public static ParserState getInstance() {
		if(instance == null)
			instance = new DefineState();
		return instance;
	}
	@Override
	public void goNext(ParserStateHandler psh, Interpreter interpreter) {
		String line = psh.getCurrentLine();
		if(!line.equals("BEGIN")){
			psh.setState(new WrongSyntaxState("Očekával jsem BEGIN"));
			return;
		}
		psh.setState( new BlockState(BodyState.getInstance()));
	}

}
