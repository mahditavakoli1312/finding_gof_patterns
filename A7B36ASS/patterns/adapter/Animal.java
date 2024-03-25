package patterns.adapter;


public class Animal{
	protected int hungerLevel = 5;
	
	public void feed(){
		hungerLevel -= (hungerLevel > 0)?  1 : 0;
	}

	public void play(){
		hungerLevel += (hungerLevel < 10)?  1 : 0;
	}

	public void bark(){
		System.out.println("Haf");
	}
}
