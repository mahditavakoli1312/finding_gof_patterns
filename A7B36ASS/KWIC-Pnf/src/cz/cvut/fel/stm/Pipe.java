package cz.cvut.fel.stm;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * This class represent Pipe in the KWIC system, it use PipeReader and
 * PipeWriter as input(reading) pipe and output(writting) pipe from package
 * java.io
 * 
 * @author kuba
 * 
 */
public class Pipe {
	private PipedReader readPipe;
	private PipedWriter writePipe;

	public Pipe() throws IOException {
		this.readPipe = new PipedReader();
		this.writePipe = new PipedWriter();
		this.writePipe.connect(readPipe);
	}

	public int readCharacter() throws IOException {
		return readPipe.read();
	}

	/**
	 * This method writes character into writePipe
	 * 
	 * @param c
	 * @throws IOException
	 */
	public void writeCharacter(int c) throws IOException {
		writePipe.write(c);
	}

	/**
	 * This method writes the whole line into writePipe
	 * 
	 * @param line
	 * @throws IOException
	 */
	public void writeLine(String line) throws IOException {
		writePipe.write(line + "\n");
	}

	/**
	 * This method flus everything from writePipe and then close it
	 * 
	 * @throws IOException
	 */
	public void closeWriter() throws IOException {
		writePipe.flush();
		writePipe.close();
	}

	public void closeReader() throws IOException {
		readPipe.close();
	}

}
