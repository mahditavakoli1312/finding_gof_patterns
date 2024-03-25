package cz.cvut.fel.ass.parser;

import cz.cvut.fel.ass.interpreter.Interpreter;

public class ExecutionState extends ParserState {
	protected static ParserState instance; 

	public static ParserState getInstance() {
		if(instance == null)
			instance = new ExecutionState();
		return instance;
	}
	@Override
	public void goNext(ParserStateHandler psh, Interpreter interpreter) {
		//String line = psh.getCurrentLine();
		// Hlavní blok programu je vlastně main metoda v bloku. Proto jí zaregistrujeme 
		// jako main funkci a práci přehodíme na BlockState
		interpreter.addNewProcedure("main");
		BlockState bs = (BlockState) new BlockState(null);
		psh.setState(bs);
		bs.goNext(psh, interpreter); // aby jsme neztratili current line
	}

}
