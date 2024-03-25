package cz.cvut.fel.stm.kwic.adt;

import java.util.List;

public class Output {
	private AlphabeticShifts alphabetizedShifts;

	public Output(AlphabeticShifts alphabetizedShifts) {
		this.alphabetizedShifts = alphabetizedShifts;
	}

	public void printLines() {
		List<String> lines = alphabetizedShifts.getAlphabetizedLines();
		for (String line : lines) {
			System.out.println(line);
		}
	}

}
