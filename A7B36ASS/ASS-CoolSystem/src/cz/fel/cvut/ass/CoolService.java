package cz.fel.cvut.ass;

public abstract class CoolService {
	protected static CoolService instance;

	protected CoolService() {
	}

	

	final public void wireUp(AbstractFactory af) {
		Person p = af.makePerson();
		Thing t = af.makeThing();
		p.setThing(t);
		t.setPerson(p);
	}

}
