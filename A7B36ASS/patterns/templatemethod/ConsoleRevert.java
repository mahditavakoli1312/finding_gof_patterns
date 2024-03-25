package patterns.templatemethod;


import java.util.Scanner;

public class ConsoleRevert extends Revert{
	protected String input(){
		System.out.print("Zadej větu: ");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		in.close();
		return s;
	}
	protected void output(String out){
		System.out.println(out);
	}
}
