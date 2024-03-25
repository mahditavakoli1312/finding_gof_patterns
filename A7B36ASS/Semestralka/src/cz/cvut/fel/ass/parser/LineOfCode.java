package cz.cvut.fel.ass.parser;
// VZOR: Value Object
public final class LineOfCode {
	private final String line;
	private final int lineNumber;
	
	public LineOfCode(String line, int lineNumber){
		this.line = line;
		this.lineNumber = lineNumber;
	}
	
	public String getLine(){
		return line;
	}
	public int getLineNumber(){
		return lineNumber;
	}
	
	@Override
	public boolean equals(Object o){
		return false;
	}
}
