package patterns.decorator;

public class ScreenPrinterWithSpaces implements DataStream{
	public void print(String data){
		char[] ds = data.toCharArray();
		for(int i = 0; i < ds.length; i++)
			System.out.print(ds[i] + " ");
		System.out.println();
	}
}
