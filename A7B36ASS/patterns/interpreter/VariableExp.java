public class VariableExp implements BooleanExp{

	private String variableName;


	public VariableExp(String name){
		this.variableName = name;
	}

	public boolean evaluate(Context c){
		return c.lookup(variableName);
	}
}
