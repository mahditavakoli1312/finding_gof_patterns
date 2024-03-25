package cz.fel.cvut.ass;

public abstract class AbstractFactory {
	protected abstract Thing makeThing();

	protected abstract Person makePerson();
}
