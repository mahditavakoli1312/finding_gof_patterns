package cz.cvut.fel.ass.interpreter;

public class TurnLeftExpression extends TerminalExpression {

	@Override
	public void interpret(GameContext context) {
		try {
			context.turnLeft();
		} catch (IllegalGameActionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
