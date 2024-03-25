package patterns.composite;

public class Function extends Block{
	private String name;
	
	public String getName(){ return this.name; }

	public Function(String name){
		this.name = name;
	}
}
