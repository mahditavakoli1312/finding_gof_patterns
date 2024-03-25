package cz.cvut.fel.ass.interpreter;

import cz.cvut.fel.ass.ServiceLocator;


public class IterateExpression extends CompoundExpression {
	private int times ;
	public IterateExpression(int times, ServiceLocator sl) {
		super(sl);
		this.times  = times;
	}

	@Override
	public void interpret(GameContext context) {
		int size = elements.size();
		for(int j = 0; j < times; j++){
			for(int i = 0; i < size; i++){
				elements.get(i).interpret(context);
			}
		}
	}

}
