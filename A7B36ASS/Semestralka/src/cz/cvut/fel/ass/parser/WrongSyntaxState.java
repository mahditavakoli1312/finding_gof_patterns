package cz.cvut.fel.ass.parser;

import cz.cvut.fel.ass.interpreter.Interpreter;


public class WrongSyntaxState extends ParserState {

	private String message;
	
	public WrongSyntaxState(String msg){
		message = msg;
	}
	
	@Override
	public void goNext(ParserStateHandler psh, Interpreter interpreter) {
		System.out.println("Chyba syntaxe: "+ message);
		psh.stop();
	}

}
