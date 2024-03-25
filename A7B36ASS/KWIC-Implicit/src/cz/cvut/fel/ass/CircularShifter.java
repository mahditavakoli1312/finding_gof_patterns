package cz.cvut.fel.ass;


import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class CircularShifter extends Observable implements Observer {

    private LineStorage lineStorage;

    public CircularShifter(LineStorage lineStorage) {
        this.lineStorage = lineStorage;
    }

    private void shiftAllLines() {
    	List<Line> originalLine = lineStorage.getLines();
        for (Line line : originalLine) {
            shiftLine(line);
        }
    }

    private void shiftLine(Line line) {
        Line shiftedLine;
        final int length = line.getWordCount();
        for (int i = 0; i < length; i++) {
            shiftedLine = new Line(line);
            shiftedLine.shift(i);
            lineStorage.addShiftedLine(shiftedLine);
        }
    }

    public void update(Observable o, Object arg) {
        if (o instanceof Input && ((Boolean) arg)) {            
            this.shiftAllLines();
            setChanged();
            notifyObservers(new Boolean(true));
        }
    }
}
