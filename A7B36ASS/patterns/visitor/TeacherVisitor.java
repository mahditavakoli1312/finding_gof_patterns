public class TeacherVisitor implements IVisitor{

	private double avg = 0;
	private int num = 0;

	public void visit(Principal ceo){}
	public void visit(Teacher t){
		num++;
		avg += t.getSallary();			
	}
	public double getAverageSallary(){
		return avg/num;
	}
}
