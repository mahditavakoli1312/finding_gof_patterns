
public class StaffVisitor implements IVisitor{

	public void visit(Principal ceo){
		System.out.println(ceo.getName() + " [Ředitel/ka]");
	}
	public void visit(Teacher t){
		System.out.println(t.getName() + " [Učitel/ka]");
	}
}
