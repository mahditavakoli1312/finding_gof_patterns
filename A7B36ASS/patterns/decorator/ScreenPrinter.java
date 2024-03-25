package patterns.decorator;

public class ScreenPrinter implements DataStream{
	public void print(String data){
		System.out.println(data);
	}
}
