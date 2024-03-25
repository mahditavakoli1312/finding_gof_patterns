package cz.fel.cvut.ass;

public class TeacherFactory extends AbstractFactory{
	protected Thing makeThing(){
		return new Book();
	}


	protected Person makePerson(){
		return new Teacher();
	}
}
