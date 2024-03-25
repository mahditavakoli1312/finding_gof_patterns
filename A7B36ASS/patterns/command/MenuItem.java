import java.util.List;

public class MenuItem{
	protected List<ICommand> actions;
	protected String menuLabel;
	
	public MenuItem(String label, List<ICommand> list){
		menuLabel = label;
		actions = list;
	}

	public void addAction(ICommand action){
		actions.add(action);	
	}

	public void onClicked(){
		for(ICommand c : actions)
			c.execute();
	}

	public String toString(){
		return menuLabel;
	}
}
