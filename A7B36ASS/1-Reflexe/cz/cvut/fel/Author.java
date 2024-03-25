package cz.cvut.fel;

import java.util.Date;


public class Author {
	private String firstName;
	private String lastName;
	private Date birth;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirth() {
		return birth;
	}
	public Author(String firstName, String lastName, Date birth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birth = birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	
	
}
