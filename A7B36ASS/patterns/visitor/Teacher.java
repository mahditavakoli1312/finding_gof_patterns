
public class Teacher extends Person{
	public void accept(IVisitor v){
		v.visit(this);
	}

}
