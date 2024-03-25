package cz.fel.cvut.ass;

public class Teacher extends Person {
	private int salary;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	Teacher(){}
	@Override
	public Person clone() {
		Teacher t = (Teacher) super.clone();
		t.setSalary(salary);
		return t;
	}
	
}
