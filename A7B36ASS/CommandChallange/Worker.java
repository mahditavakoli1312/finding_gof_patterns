import java.util.List;

public class Worker{
	public void work(List<ICommand> wc){
		for(ICommand comm: wc){
			comm.execute();
		}
	}
}
