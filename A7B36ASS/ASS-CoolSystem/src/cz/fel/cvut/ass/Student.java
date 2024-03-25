package cz.fel.cvut.ass;

public class Student  extends Person {
	public int level;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	Student(){}
	@Override
	public Person clone() {
		Student clone = (Student)super.clone();
		clone.setLevel(level);
		return clone;
	}
}
