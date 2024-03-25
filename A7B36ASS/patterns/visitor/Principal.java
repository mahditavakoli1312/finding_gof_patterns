public class Principal extends Person{
	public void accept(IVisitor v){
		v.visit(this);
	}

}
