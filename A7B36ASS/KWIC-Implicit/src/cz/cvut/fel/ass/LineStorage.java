package cz.cvut.fel.ass;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.StringTokenizer;

public class LineStorage extends Observable{
	
	private List<Line> lines = new ArrayList<Line>();
	private List<Line> shiftedLines = new ArrayList<Line>();

	
	
	public void addLine(String line, int lineNumber){
		lines.add(parseLine(line, lineNumber));
	}
	public void addShiftedLine(Line shiftedLine) {
        shiftedLines.add(shiftedLine);
    }
	public List<Line> getShiftedLines() {
        return shiftedLines;
    }

	public List<Line> getLines() {
		return lines;
	}
	
	public Line parseLine(String line, int lineNum){
		Line l = new Line(lineNum);
		StringTokenizer tokenizer = new StringTokenizer(line);
        while (tokenizer.hasMoreTokens()) {
            l.addWord(tokenizer.nextToken());
        }
        return l;
	}

}
