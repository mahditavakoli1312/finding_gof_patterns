package cz.cvut.fel.ass.parser;

import cz.cvut.fel.ass.interpreter.Interpreter;

public class BlockState extends ParserState {
	protected static ParserState instance;
	protected ParserState back;
	
	public BlockState(ParserState p){
		back = p;
		System.out.println("This = "+ this);
	}

	public static ParserState getInstance(ParserState previous) {
		if(instance == null)
			instance = new BlockState(previous);
		return instance;
	}
	
	public void setPrevious(ParserState s){
		this.back = s;
	}
	
	@Override
	public void goNext(ParserStateHandler psh, Interpreter interpreter) {
		String line = psh.getCurrentLine();
		// TODO: zde bude vlastně vše, jelikož celý program je v bloku BEGIN - END
		if(line.equals("END")){
			psh.setState(back);
			System.out.println("Varcím se na  "+ back);
			// else if (line.equals("IF")) a podobně pro while - teoreticky by to mohl jít použít taky tento BlockState
		}else if(line.equals("END-OF-EXECUTION")){
			psh.setState(FinalState.getInstance());
		}else if(line.equals("ITERATE")){ // ITERATE [X] TIMES [BEGIN - END]
			try{
				int times = Integer.parseInt(psh.getCurrentAttributes().get(0));
				if(!psh.getCurrentAttributes().get(1).equals("TIMES")){
					psh.setState(new WrongSyntaxState("Očekáváno 'TIMES'"));
	 			}else{
	 				System.out.println("line ("+ line + ")  = " + this);
	 				psh.setState(IterateState.getInstance(times, this));
	 			}
			}catch(Exception e){
				psh.setState(new WrongSyntaxState("Počet iterací musí být číslo"));
			}
 			
		}else if(line.equals("IF")){ // IF [test] THEN [BEGIN - END] ELSE [BEGIN - END]
			
		}else if(line.equals("WHILE")){ // WHILE [test] DO [BEGIN - END]
			
		}else{
			if(interpreter.procedureLookup(line) != null){
				interpreter.addNewCommand(interpreter.procedureLookup(line));
			}else{
				psh.setState(new WrongSyntaxState("Neznámý příkaz: "+ line));
			}
		}
	}

}
