package cz.cvut.fel.stm;

import java.io.IOException;
import java.util.List;

/**
 * The purpose of CircularShift module is to make shifts of all lines in input
 * pipe and send result to output pipe
 * 
 * @author kuba
 * 
 */
public class CircularShift extends Filter {

	public CircularShift(Pipe input, Pipe output) {
		super(input, output);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void proccesFilter() {
		try {
			List<String> lines = readAllLines();
			String line;
			int konec = lines.size();
			for (int i = 0; i < konec; i++) {
				line = lines.get(i);
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
					// novy += "\n";
					lines.add(novy);
				}
			}

			for (String l : lines) {
				write(l);
			}
			output.closeWriter();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
