package patterns.templatemethod;

public class Main{
	public static void main(String[] args){
		Revert r;
		if(args.length == 0){
			r = new ConsoleRevert();
		}else{
			r = new FileRevert(args[0]);
		}
		r.process();
	}
}
