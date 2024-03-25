package patterns.adapter;

public class AnimalAdapterInherit extends Animal implements DesiredAnimalInterface{

	public boolean isHungry(){ // nyní můžeme přistupovat k protected vlastnostem, takže lze implementovat
		if(hungerLevel < 3) return true;
		return false;
	}

	public void dailyCare(){
		feed(); // Snídaně
		play(); // Podrbání před odchodem do práce
		bark(); // Osamocen naříká
		play(); // Odpolední procházka
		feed(); // Večeře
	}	
}
