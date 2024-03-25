package cz.cvut.fel.ass.parser;

public interface ParserEventHandler {
	/*
	 * Volá se při zahájení parsování
	 */
	void startSource();
	
	/*
	 * Volá se po dokončení parsování
	 */
	void endSource();
	
	/*
	 * Volá se, pokud narazíme na začátek jakéhokoliv příkazu
	 */
	void startCommand(String name, int lineNumber, Attributes attr);
	/*
	 * Volá se při komentáři
	 */
	void startComment(String comment, int lineNumber);

	boolean check();
	
	
}
