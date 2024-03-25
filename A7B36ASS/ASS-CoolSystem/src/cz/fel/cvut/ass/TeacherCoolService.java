package cz.fel.cvut.ass;

public class TeacherCoolService extends CoolService{
	private TeacherCoolService(){}
	
	public static CoolService getInstance() {
		if (instance == null)
			instance = new TeacherCoolService();
		return instance;
	}
	
	protected Thing makeThing(){
		return new Book();
	}


	protected Person makePerson(){
		return new Teacher();
	}
}
