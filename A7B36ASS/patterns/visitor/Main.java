import java.util.List;
import java.util.LinkedList;

public class Main{
	public static void main(String[] args){

		List<Person> staff = new LinkedList<Person>();
		Principal p = new Principal();
		Teacher t1 = new Teacher();
		Teacher t2 = new Teacher();
		Teacher t3 = new Teacher();

		p.setSallary(20000);
		p.setName("Petr Principál");
		
		t1.setSallary(10000);
		t1.setName("Lenka Učitelová");
		t2.setSallary(11000);
		t2.setName("Hana Dějepisová");
		t3.setSallary(12000);
		t3.setName("Petra Školní");

		staff.add(p);
		staff.add(t1);
		staff.add(t2);
		staff.add(t3);

		IVisitor tv = new TeacherVisitor();
		IVisitor sv = new StaffVisitor();
		
		for(Person per : staff){
			per.accept(tv);
			per.accept(sv);
		}
		
		System.out.println("Průměrná mzda učitele = " + ((TeacherVisitor)tv).getAverageSallary());

	}
}
