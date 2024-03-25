package model.remote;


public class PersonDS1 {
	private Long id;
	private Long salary;
	private Double age;
	private Long partner;
	private String name;

	public PersonDS1() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}


	public Double getAge() {
		return age;
	}

	public void setAge(Double age) {
		this.age = age;
	}

	public Long getPartner() {
		return partner;
	}

	public void setPartner(Long partner) {
		this.partner = partner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
