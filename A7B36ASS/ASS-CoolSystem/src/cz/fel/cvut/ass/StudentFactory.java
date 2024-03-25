package cz.fel.cvut.ass;

public class StudentFactory extends AbstractFactory{
	@Override
	protected Person makePerson() {
		return new Student();
	}

	@Override
	protected Thing makeThing() {
		return new IPad();
	}
}
