package cz.cvut.fel.ass.interpreter;

// Vzor interpreter
public interface AbstractExpression {
	void interpret(GameContext context); // Možná by mohla vyhazovat výjimku. Něco jako "IlegalMove"
	// ta výjimka by se vyhodila například když se budu nažit sebrat značku tam kde neni, nebo cyjedu z hracího pole
	
}
