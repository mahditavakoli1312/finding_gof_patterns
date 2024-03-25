package cz.cvut.fel.ass.interpreter;

import java.util.HashMap;

import cz.cvut.fel.ass.ServiceLocator;

public class Interpreter {

	protected ServiceLocator serviceLocator;
	protected GameContext game;
	// private InterpreterState state;
	AbstractExpression root; // Ukazatel na main funkci - tedy tělo programu
	CompoundExpression current; // Pomocný ukazatel na aktuální blok kódu do
								// kterého se přidávají příkazy

	// Seznam funkcí
	HashMap<String, AbstractExpression> hm;// chybí DI

	public void terminalExpressions() {
		// Jednoduché příkazy definuejem jako procedury - akorát, že zde a ne v
		// kodu
		// Main program bude poté také jen procedura MainProgram
		MoveExpression se = new MoveExpression();
		TurnLeftExpression turnLeftExpression = new TurnLeftExpression();
		addNewProcedure("move");
		addNewCommand(se);
		TurnExpression turn = new TurnExpression();
		addNewProcedure("turnleft");
		addNewCommand(turn);
		// TODO: pick
		// TODO: put
	}

	public Interpreter() {
	}

	public void setServiceLocator(ServiceLocator sl) {
		this.serviceLocator = sl;
		this.game = this.serviceLocator.getGame();
		hm = (HashMap<String, AbstractExpression>) sl.getMap();
		terminalExpressions();
	}

	// přidá příkaz k funkci na kterou ukazuje current. Tedy pokud zrovna čtu
	// proceduru DEFINE <name> AS, tak se sem ukládají příkazy této procedury
	public void addNewCommand(AbstractExpression ae) {
		current.addExpression(ae);
		
	}

	public void addNewProcedure(String name) {
		// zaregistruje novou proceduru a nastaví na ní current, aby se při
		// přidávání dalších příkazů přiřadili právě k této proceduře
		hm.put(name, new ProcedureExpression(this.serviceLocator)); // TODO:
																	// tohle
																	// předávání
																	// závislostí
																	// není moc
																	// košér -
																	// možná
																	// nějaký
																	// service
																	// locator
																	// by
																	// neuškodil
		current = (CompoundExpression) hm.get(name);
	}

	public AbstractExpression procedureLookup(String name) {
		return hm.get(name);
	}

	public void newProcedure(String name) {
		if (procedureLookup(name) != null) {
			throw new RuntimeException(
					"Procedure with this name already exists");
		}
		addNewProcedure(name);
	}

	public void start() {
		this.procedureLookup("main").interpret(game);
	}
	
	public void setCurrent(CompoundExpression ae){
		this.current = ae;
	}

	public CompoundExpression getCurrent() {
		
		return this.current;
	}

}
