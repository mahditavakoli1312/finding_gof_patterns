package cz.cvut.fel.stm;

import java.io.IOException;

/**
 * This class is main class of the project it creates several filters and pipes
 * and connect them
 * 
 * @author kuba
 * 
 */
public class KWIC {

	public static void main(String[] args) {
		try {
			Pipe inputPipe = new Pipe();
			Pipe circularOutPipe = new Pipe();
			Pipe alphabetizerOutPipe = new Pipe();

			new Thread(new Input(inputPipe, args[0])).start();
			new Thread(new CircularShift(inputPipe, circularOutPipe)).start();
			new Thread(new Alphabetizer(circularOutPipe, alphabetizerOutPipe))
					.start();
			new Thread(new Output(alphabetizerOutPipe, null)).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
