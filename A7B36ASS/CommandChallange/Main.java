import java.util.List;
import java.util.LinkedList;

public class Main{
	public static void main(String[] args){
		List<ICommand> workCard = new LinkedList();
		workCard.add(new StartProcess());
		workCard.add(new Material());
		workCard.add(new Assembly());
		workCard.add(new StopProcess());

		Worker retard = new Worker();
		retard.work(workCard);	
	}
}
