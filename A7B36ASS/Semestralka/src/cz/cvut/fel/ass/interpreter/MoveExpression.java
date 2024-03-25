package cz.cvut.fel.ass.interpreter;

public class MoveExpression extends TerminalExpression {

	@Override
	public void interpret(GameContext context) {
		// zde bude něco jako context.doMove(); + nějaká ošetření, zda jsem nevyjel z pole apod.
		try{
			context.move();
		}catch(IllegalGameActionException e){
			// TODO : tady nevim přesně jak ošetřit
			context.halt();
		}
	}

}
