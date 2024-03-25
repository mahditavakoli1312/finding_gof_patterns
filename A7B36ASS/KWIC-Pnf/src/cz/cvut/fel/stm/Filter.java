package cz.cvut.fel.stm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract filter
 * 
 * @author kuba
 * 
 */
public abstract class Filter implements Runnable {

	Pipe input;
	Pipe output;

	public Filter(Pipe input, Pipe output) {
		super();
		this.input = input;
		this.output = output;
	}

	@Override
	public void run() {
		proccesFilter();
	}

	/**
	 * This method contains main functionality of Filter
	 */
	public abstract void proccesFilter();

	/**
	 * This method read line(ended with '\n') form input pipe
	 * 
	 * @return
	 * @throws IOException
	 */
	public String readLine() throws IOException {
		String line = "";
		int c = input.readCharacter();
		char ch = (char) c;
		while (ch != '\n') {
			ch = (char) c;
			line += ch;
			c = input.readCharacter();
		}
		return line;
	}

	/**
	 * Read everything from input pipe and put it in to List Each String in List
	 * is 1 line from input
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<String> readAllLines() throws IOException {
		List<String> lines = new ArrayList<String>();
		String line = "";
		int c = input.readCharacter();

		while (c != -1) {
			if ((char) c == '\n') {
				// line += (char) c; // added '\n' for further use
				lines.add(line);
				line = "";
			} else {
				line += (char) c;
			}
			c = input.readCharacter();
		}
		return lines;
	}

	/**
	 * This method writes the whole line into otuput pipe
	 * 
	 * @param line
	 * @throws IOException
	 */
	public void write(String line) throws IOException {
		output.writeLine(line);
	}

}
