public class Main{
	public static void main(String[] args){
		
		BooleanExp be = new NotExp(new AndExp(new VariableExp("A"), new OrExp(new VariableExp("B"), new VariableExp("C"))));

		Context c = new Context();
		c.set("A", true);
		c.set("B", false);
		c.set("C", false);
		
		System.out.println(be.evaluate(c));
		
	}
}
