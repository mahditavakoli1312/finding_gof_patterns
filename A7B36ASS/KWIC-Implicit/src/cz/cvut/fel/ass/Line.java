package cz.cvut.fel.ass;

import java.util.LinkedList;
import java.util.List;

public class Line implements Comparable<Line> {

	private LinkedList<String> words;
	private int lineNumber;

	public Line(int lineNumber) {
		words = new LinkedList<String>();
		this.lineNumber = lineNumber;
	}

	public Line(Line line) {
		words = new LinkedList<String>(line.getWords());
		this.lineNumber = line.getLineNumber();
	}

	public Line(String line) {
		words = new LinkedList<String>();
		words.add(line);
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public List<String> getWords() {
		return words;
	}

	public int getWordCount() {
		return words.size();
	}

	public boolean addWord(String word) {
		return words.add(word);
	}

	public void shift(int num) {
		for (int i = 0; i < num; i++) {
			words.add(words.getFirst());
			words.removeFirst();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String string : words) {
			sb.append(" " + string);
		}
		if (sb != null && sb.indexOf(" ") == 0) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	@Override
	public int compareTo(Line o) {
		return this.toString().compareToIgnoreCase(o.toString());
	}

}
