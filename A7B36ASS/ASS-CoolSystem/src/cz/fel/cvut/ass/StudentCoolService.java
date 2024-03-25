package cz.fel.cvut.ass;

public class StudentCoolService extends CoolService {
	private StudentCoolService(){}
	
	public static CoolService getInstance() {
		if (instance == null)
			instance = new StudentCoolService();
		return instance;
	}

	@Override
	protected Person makePerson() {
		return new Student();
	}

	@Override
	protected Thing makeThing() {
		return new IPad();
	}
	
}
