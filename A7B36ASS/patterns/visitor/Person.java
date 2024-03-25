public abstract class Person{
	protected String name;
	protected int sallary;
	protected int age;

	public void setName(String name){
		this.name = name;
	}

	public void setSallary(int sallary){
		this.sallary = sallary;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){ return this.age; }
	public int getSallary(){ return this.sallary; }
	public String getName(){ return this.name; }

	public abstract void accept(IVisitor v);


}
