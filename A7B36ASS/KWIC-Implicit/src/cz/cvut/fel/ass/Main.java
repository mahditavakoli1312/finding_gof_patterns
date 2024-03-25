package cz.cvut.fel.ass;

public class Main {
	
	public static void main(String[] args){
		String fileName = "input.txt";
		String outFileName = "output.txt";
		
		LineStorage lineStorage = new LineStorage();

        Input input = new Input();

        CircularShifter cs = new CircularShifter(lineStorage);
        input.addObserver(cs);

        Alphabetizer alphabetizer = new Alphabetizer(lineStorage);
        cs.addObserver(alphabetizer);

        Output output = new Output(lineStorage);
        alphabetizer.addObserver(output);

        input.parse(fileName, lineStorage);
		
	}

}
