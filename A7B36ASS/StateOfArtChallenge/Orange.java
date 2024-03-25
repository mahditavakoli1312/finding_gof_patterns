public class Orange extends SemaphoreState{

	private static Orange instance;

	public void goNext(Semaphore context){
		System.out.print("Oranžová ");
		wait(1);
		System.out.println();
		context.setState(Green.getInstance());

	}

	private Orange(){}

	public static SemaphoreState getInstance(){
		if(instance == null)
			instance = new Orange();
		return instance;
	}

	public boolean isOpen(){
		return false;
	}
	
}
