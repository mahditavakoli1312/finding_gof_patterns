package patterns.composite;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class Block implements Command{
	List<Command> list = new LinkedList<Command>();
	public void execute(){
		Iterator<Command> it = list.iterator();
		while(it.hasNext())
			it.next().execute();
	}
	public Block addChild(Command b){
		list.add(b);
		return this;
	}
}
