package cz.cvut.fel.ass.parser;

public interface SourceIterator {
	LineOfCode next();
	boolean hasNext();
}
