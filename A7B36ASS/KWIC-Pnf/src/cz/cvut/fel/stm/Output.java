package cz.cvut.fel.stm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * This class writes results of KWIC into output file
 * 
 * @author kuba
 * 
 */
public class Output extends Filter {

	public Output(Pipe input, Pipe output) {
		super(input, output);

	}

	@Override
	public void proccesFilter() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(
					"outputKWIC.txt"));
			List<String> lines = readAllLines();
			for (String l : lines) {
				l = l.trim();
				System.out.println(l);
				out.write(l);
				out.newLine();
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
