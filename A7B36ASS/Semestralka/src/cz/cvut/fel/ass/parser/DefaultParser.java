package cz.cvut.fel.ass.parser;

import cz.cvut.fel.ass.ServiceLocator;
import cz.cvut.fel.ass.interpreter.Interpreter;

// VZOR: Observer
public class DefaultParser implements ParserEventHandler, ParserStateHandler {

	protected ParserState state;
	protected String currentCommand;
	protected Attributes currentAttributes;
	protected Interpreter interpret;
	protected boolean stop = false;
	protected ServiceLocator serviceLocator;

	public DefaultParser(ServiceLocator sl) {
		this.serviceLocator = sl;
		this.interpret = serviceLocator.getInterpreter();
		// System.out.println(interpret);
	}

	@Override
	public void endSource() {
		// Zkontrolujeme, zda jsme skončili ve správném stavu
		if (!(state instanceof FinalState)) {
			throw new RuntimeException(
					"Program má špatnou strukturu - překlad skončil v neočekávaném stavu");
		}
		stop = true;
	}

	@Override
	public void startCommand(String name, int lineNumber, Attributes attr) {
		currentCommand = name;
		currentAttributes = attr;
		currentLineNumber = lineNumber;
		stop = false;
		state.goNext(this, interpret);
	}

	@Override
	public void startComment(String comment, int lineNumber) {
		System.out.println("Komentář: " + comment);

	}

	@Override
	public void startSource() {
		// System.out.println("Začátek parsování");
		state = InitialState.getInstance();
	}

	@Override
	public Attributes getCurrentAttributes() {
		return currentAttributes;
	}

	@Override
	public String getCurrentLine() {
		return currentCommand;
	}

	@Override
	public void setState(ParserState state) {
		this.state = state;
	}

	@Override
	public void stop() {
		this.stop = true;
	}

	@Override
	public boolean check() {
		return !stop;
	}

	public Interpreter getInterpreter() {
		return this.interpret;
	}

	@Override
	public int getCurrentLineNumber() {
		return currentLineNumber;
	}

}
