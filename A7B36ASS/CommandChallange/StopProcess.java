public class StopProcess extends ICommand{
	public void execute(){
		System.out.println("Zastavuji výrobu");
		wait(1);
		System.out.println("Výroba zastavena");
	}
}
