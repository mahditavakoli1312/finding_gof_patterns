package patterns.decorator;

public class Main{
	public static void main(String[] args){
		DataStream us = 
			new UpperStream(
			new RevertStream(
			//new ScreenPrinterWithSpaces()));
			new ScreenPrinter()));
			//new ScreenPrinter());
		us.print("Ahoj");
	}
	
}
