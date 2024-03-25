package cz.fel.cvut.ass;

public class Thing {
	protected long ID;
	protected String name;
	protected Person person;
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
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Thing clone(){
		Thing clone = new Thing();
		clone.setID(ID);
		clone.setName(name);
		clone.setPerson(person.clone());
		return clone;
	}


}
