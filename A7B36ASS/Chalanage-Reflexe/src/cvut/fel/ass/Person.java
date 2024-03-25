package cvut.fel.ass;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="Person")
public class Person implements java.io.Serializable{
	private String name;
	private Date born;
	@Column(name="name",nullable=false,length=100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="born",nullable=false)
	@Temporal(javax.persistence.TemporalType.DATE)
	public Date getBorn() {
		return born;
	}
	public void setBorn(Date born) {
		this.born = born;
	}
	
}
