import java.util.HashMap;

public class Context{
	HashMap<String, Boolean> variables = new HashMap<String, Boolean>();

	public void set(String varName, boolean varValue){
		variables.put(varName, varValue);
	}

	public boolean lookup(String varName){
		return variables.get(varName);
	}

}
