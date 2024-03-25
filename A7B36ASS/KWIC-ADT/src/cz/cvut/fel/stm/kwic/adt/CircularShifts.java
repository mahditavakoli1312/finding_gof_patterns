package cz.cvut.fel.stm.kwic.adt;

import java.util.ArrayList;
import java.util.List;

public class CircularShifts {
	private Input input;
	private List<String> shiftedLines;

	public CircularShifts(Input input) {
		this.input = input;
		shiftedLines = new ArrayList<String>();
	}

	public List<String> getShiftedLines() {
		shiftedLines = input.getLines();
		String line;
		int konec = shiftedLines.size();
		for (int i = 0; i < konec; i++) {
			line = shiftedLines.get(i);
			line = line.trim();
			String[] pole = line.split(" ");
			for (int j = 0; j < pole.length - 1; j++) {
				String novy = "";
				novy += pole[pole.length - 1] + " ";
				for (int k = 0; k < pole.length - 2; k++) {
					novy += pole[k] + " ";
				}
				novy += pole[pole.length - 2];
				pole = novy.split(" ");
				shiftedLines.add(novy);
			}
		}

		return shiftedLines;
	}

}
