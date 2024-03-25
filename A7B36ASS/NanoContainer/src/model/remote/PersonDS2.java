package model.remote;

import java.util.Date;


public class PersonDS2 {
	private Long id;
	private Long salaryYear;
	private Date born;
	private Boolean married;
	private String fName;
	private String lName;

	public PersonDS2() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getMarried() {
		return married;
	}

	public void setMarried(Boolean married) {
		this.married = married;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Long getSalaryYear() {
		return salaryYear;
	}

	public void setSalaryYear(Long salaryYear) {
		this.salaryYear = salaryYear;
	}

	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

}
