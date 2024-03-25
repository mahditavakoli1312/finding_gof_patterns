package cz.cvut.fel.ass.interpreter;

import java.util.List;

import cz.cvut.fel.ass.ServiceLocator;

public class MainProgramExpression extends CompoundExpression {

	public MainProgramExpression(ServiceLocator sl) {
		super(sl);
		// TODO Auto-generated constructor stub
	}
	// Tato třída reprezentuje vrchol stromu příkazů
	// Tedy to co je mezi BEGIN-OF-EXECUTIN a END-OF-EX....
	// Je to něco jako metoda main v JAVE. A bude tak i pojmenovaná v interpreteru.
	// Pak až budeme chcít interpretovat program prostě si necháme vrátit proceduru main pomocí lookup metody a spustímě na ní metodu interpret
	

}
