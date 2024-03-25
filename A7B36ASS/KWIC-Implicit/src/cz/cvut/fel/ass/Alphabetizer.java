package cz.cvut.fel.ass;

import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Alphabetizer extends Observable implements Observer{
	private LineStorage lineStorage;

    public Alphabetizer(LineStorage lineStorage) {
        this.lineStorage = lineStorage;
    }

    public void alphabetize() {
        Collections.sort(lineStorage.getShiftedLines());
    }


    public List<Line> getShiftedLines() {
        return lineStorage.getShiftedLines();
    }

    public List<Line> getOriginalLines() {
        return lineStorage.getLines();
    }
	@Override
	public void update(Observable observable, Object arg) {
		if (observable instanceof CircularShifter && ((Boolean) arg)) {            
            this.alphabetize();
            setChanged();
            notifyObservers(new Boolean(true));
        }
	}

}
