package patterns.abstractfactory;

public class SilentDocument implements Document{
	public LineWriter getLineWriter(){
		return new LowerWriter();
	}
}
