package cz.fel.cvut.ass;

public class Person {
	protected long ID;
	protected String name;
	protected Thing thing;
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Thing getThing() {
		return thing;
	}
	public void setThing(Thing thing) {
		this.thing = thing;
	}
	
	public Person clone(){
		Person p = new Person();
		p.setID(this.ID);
		p.setName(this.name);
		p.setThing(this.thing.clone());
		return p;
	}
	
}
