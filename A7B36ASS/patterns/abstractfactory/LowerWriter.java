package patterns.abstractfactory;

public class LowerWriter implements LineWriter{
	public void print(String str){
		System.out.println(str.toLowerCase());
	}
}
