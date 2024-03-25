package cz.cvut.fel.stm.kwic.adt;

public class MasterControl {

	public static void main(String[] args) {
		Input input = new Input("/home/dominik/School/ASS/repository/KWIC-ADT/kwic.txt");
		input.input();
		CircularShifts circularShifts = new CircularShifts(input);
		AlphabeticShifts alpShifts = new AlphabeticShifts(circularShifts);
		Output output = new Output(alpShifts);
		output.printLines();
	}

}
