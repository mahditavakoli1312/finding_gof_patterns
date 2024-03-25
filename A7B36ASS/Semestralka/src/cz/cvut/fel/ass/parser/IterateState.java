package cz.cvut.fel.ass.parser;

import cz.cvut.fel.ass.interpreter.AbstractExpression;
import cz.cvut.fel.ass.interpreter.CompoundExpression;
import cz.cvut.fel.ass.interpreter.Interpreter;
import cz.cvut.fel.ass.interpreter.IterateExpression;

public class IterateState extends ParserState {
	protected static ParserState instance;
	private int times;
	private boolean flag = false;
	private CompoundExpression oldCurrent;
	protected static ParserState old; 

	public IterateState(int times) {
		this.times = times;
	}
	public static ParserState getInstance(int times, ParserState state) {
		if (instance == null)
			instance = new IterateState(times);
		old = state;
		return instance;
	}
	@Override
	public void goNext(ParserStateHandler psh, Interpreter interpreter) {
		if(flag){
			flag = false;
			psh.setState(old);
			System.out.println("old = "+ old);
			System.out.println("curentline = " + psh.getCurrentLine() + ", " + psh.getCurrentLineNumber());
			
			old.goNext(psh, interpreter);
			interpreter.setCurrent(oldCurrent);
			return;
		}
		oldCurrent = interpreter.getCurrent();
		CompoundExpression ce = new IterateExpression(this.times, serviceLocator);
		interpreter.addNewCommand(ce);
		interpreter.setCurrent(ce);
		String line = psh.getCurrentLine();
		if(line.equals("BEGIN")){
			System.out.println("V iteraci vytvářím blok");
			psh.setState(new BlockState(this));
			flag = true;
		}else{
			AbstractExpression ae = interpreter.procedureLookup(line);
			if(ae == null){
				psh.setState(new WrongSyntaxState("Neznámý příkaz: " + line));
			}else{
				interpreter.addNewCommand(ae);
				interpreter.setCurrent(oldCurrent);
				psh.setState(old);
				System.out.println(old);
			}
				
		}
	}

}
