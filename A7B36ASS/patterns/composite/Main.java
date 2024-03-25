package patterns.composite;

public class Main{
	public static void main(String[] args){
		Function f1 = new Function("Print ABA");
		f1.addChild(new Print("A"))
		  .addChild(new Print("B"))
		  .addChild(new Print("A"));
		Function f2 = new Function("Print CABAC");
		f2.addChild(new Print("C"))
		  .addChild(f1)
		  .addChild(new Print("C"));

		Command nl = new Println();
		Block program = new Block();
		program .addChild(f2)
			.addChild(nl)
			.addChild(f1)
			.addChild(nl)
			.addChild(f2)
			.addChild(nl);
		
		program.execute();
	}
}
