package cz.cvut.fel.ass.parser;

import cz.cvut.fel.ass.interpreter.Interpreter;

public class BodyState extends ParserState {
	protected static ParserState instance;

	public static ParserState getInstance() {
		if (instance == null)
			instance = new BodyState();
		return instance;
	}

	@Override
	public void goNext(ParserStateHandler psh, Interpreter interpreter) {
		String line = psh.getCurrentLine();
		// Pokud definuje proceduru
		if (line.equals("DEFINE")) {
			Attributes attr = psh.getCurrentAttributes();
			if (attr.size() != 2) {
				psh.setState(new WrongSyntaxState("Chybná hlavička funkce"));
				return;
			}
			if (!attr.get(1).equals("AS"))
				psh.setState(new WrongSyntaxState("Chybná hlavička funkce"));

			interpreter.addNewProcedure(psh.getCurrentAttributes().get(0));
			psh.setState(DefineState.getInstance());
			// pokud narazil na zacatek EXECUTION bloku
		} else if (line.equals("BEGIN-OF-EXECUTION")) {
			psh.setState(ExecutionState.getInstance());
		}
	}

}
