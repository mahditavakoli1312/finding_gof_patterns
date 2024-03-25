package cz.cvut.fel.stm.kwic.adt;

import java.util.Collections;
import java.util.List;

public class AlphabeticShifts {

	private CircularShifts circulatShifter;

	public AlphabeticShifts(CircularShifts circulatShifter) {
		this.circulatShifter = circulatShifter;
	}

	public List<String> getAlphabetizedLines() {
		List<String> alphabetizedLines = circulatShifter.getShiftedLines();
		Collections.sort(alphabetizedLines);
		return alphabetizedLines;
	}

}
