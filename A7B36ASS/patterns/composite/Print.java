package patterns.composite;

public class Print implements Command{
	private String data;

	public Print(String data){
		this.data = data;
	}

	public void execute(){
		System.out.print(this.data);
	}
}
