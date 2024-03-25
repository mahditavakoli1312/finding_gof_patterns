package patterns.adapter;

public class Main{
	public static void main(String[] args){
		DesiredAnimalInterface adapterI = new AnimalAdapterInherit();
		System.out.println(adapterI.isHungry());	
		adapterI.dailyCare();
	}
}
