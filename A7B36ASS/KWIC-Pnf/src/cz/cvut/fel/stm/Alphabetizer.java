package cz.cvut.fel.stm;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * It takes all lines from input pipe, which where processed by CircularShift
 * filter and it sorts them alphabetically
 * 
 * @author kuba
 * 
 */
public class Alphabetizer extends Filter {

	public Alphabetizer(Pipe input, Pipe output) {
		super(input, output);

	}

	@Override
	public void proccesFilter() {
		try {
			List<String> lines = readAllLines();
			Collections.sort(lines);

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
