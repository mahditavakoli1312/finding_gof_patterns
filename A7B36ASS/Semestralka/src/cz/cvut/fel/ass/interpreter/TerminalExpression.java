package cz.cvut.fel.ass.interpreter;

public abstract class TerminalExpression implements AbstractExpression {

	@Override
	public abstract void interpret(GameContext context);	
	// Předek pro terminální příkazy, tedy nesložené = move, pick, put, turnleft 
}
