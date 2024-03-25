package patterns.adapter;

public class AnimalAdapterCompose implements DesiredAnimalInterface{
	protected Animal adaptee = new Animal();

	public boolean isHungry(){
		// Nelze tímto stylem implementovat - nevidíme protected prvek Animal
		return false;
	}

	public void dailyCare(){
		adaptee.feed(); // Snídaně
		adaptee.play(); // Podrbání před odchodem do práce
		adaptee.bark(); // Osamocen naříká
		adaptee.play(); // Odpolední procházka
		adaptee.feed(); // Večeře
	}	
}
