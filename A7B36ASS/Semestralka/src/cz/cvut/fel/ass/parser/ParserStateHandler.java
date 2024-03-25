package cz.cvut.fel.ass.parser;

import cz.cvut.fel.ass.interpreter.AbstractExpression;

public interface ParserStateHandler {
	void setState(ParserState state);
	String getCurrentLine();
	Attributes getCurrentAttributes();
	void stop();
	int getCurrentLineNumber();
}
