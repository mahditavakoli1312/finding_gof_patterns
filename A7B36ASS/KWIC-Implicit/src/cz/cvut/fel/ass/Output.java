package cz.cvut.fel.ass;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Output extends Observable implements Observer {
	private LineStorage lineStorage;

    public Output(LineStorage lineStorage) {
        this.lineStorage = lineStorage;
    }
    public void printShiftedLines() {
        List<Line> shiftedLines = lineStorage.getShiftedLines();
        for (Line line : shiftedLines) {
            System.out.println(line.toString());
        }
    }

    public void update(Observable o, Object arg) {
        if (o instanceof Alphabetizer && ((Boolean) arg)) {            
            printShiftedLines();
            setChanged();
            notifyObservers(new Boolean(true));
        }
    }

}
