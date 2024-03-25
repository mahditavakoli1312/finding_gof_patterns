public class StartProcess extends ICommand{
	public void execute(){
		System.out.println("Startuji výrobu");
		wait(2);
		System.out.println("Výroba nastartována");
	}
}
