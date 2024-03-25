package cz.cvut.fel.stm;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class reads data lines from the input medium and stores them in core for
 * processing by the remaining modules. The characters are packed four to a
 * word. Index is kept to show the starting address of each line
 * 
 * @author kuba
 * 
 */
public class Input extends Filter {

	private String path;

	public Input(Pipe outputPipe, String path) {
		super(null, outputPipe);
		this.path = path;
	}

	/**
	 * This method read data from input file and put it into pipe
	 * 
	 */
	@Override
	public void proccesFilter() {
		File file = new File(path);
		FileInputStream fis = null;
		DataInputStream in = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(file);
			in = new DataInputStream(fis);
			br = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = br.readLine()) != null) {
				output.writeLine(line);
			}
			br.close();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				output.closeWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
