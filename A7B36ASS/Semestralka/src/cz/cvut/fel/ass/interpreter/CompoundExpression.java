package cz.cvut.fel.ass.interpreter;

import java.util.List;

import cz.cvut.fel.ass.ServiceLocator;
// Vzor interpreter 
// předek pro složené příkazy - tedy blok operací, cykly, podmínky, procedury atd...
public abstract class CompoundExpression implements AbstractExpression {
	
	// Udržujeme si seznam 'podpříkazů' na nichž při interpretaci budeme volat metodu interpret
	protected List<AbstractExpression> elements;
	
	/*
	 * Dependency injection via constructor
	 */
	public CompoundExpression(ServiceLocator sl){
		elements = (List<AbstractExpression>) sl.getList();
	}

	@Override
	public void interpret(GameContext context){
		int size = elements.size();
		for(int i = 0; i < size; i++)
			elements.get(i).interpret(context);
		// Při implementaci například cyklu while přpeíšeme tuto metodu tak, aby se výše popsané provedlo X krát podle podmínky ve while
	}
	
	public void addExpression(AbstractExpression ae){
		elements.add(ae);
	}

}
