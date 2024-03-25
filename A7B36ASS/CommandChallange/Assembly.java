public class Assembly extends ICommand{
	public void execute(){
		System.out.println("Připravuji sestavení");
		wait(2);
		System.out.println("Sestaveno");
	}
}
