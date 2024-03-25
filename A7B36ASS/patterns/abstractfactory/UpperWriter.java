package patterns.abstractfactory;

public class UpperWriter implements LineWriter{
	public void print(String str){
		System.out.println(str.toUpperCase());
	}
}
