package patterns.abstractfactory;

public class LoudDocument implements Document{
	public LineWriter getLineWriter(){
		return new UpperWriter();
	}
}
