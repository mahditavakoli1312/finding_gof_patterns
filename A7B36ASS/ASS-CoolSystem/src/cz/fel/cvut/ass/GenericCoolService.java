package cz.fel.cvut.ass;

public class GenericCoolService<P extends Person, T extends Thing> extends CoolService {
	protected P person;
	protected T thing;
	
	@Override
	protected Person makePerson() {
		return person.clone();
	}
	@Override
	protected Thing makeThing() {
		return thing.clone();
	}

}
