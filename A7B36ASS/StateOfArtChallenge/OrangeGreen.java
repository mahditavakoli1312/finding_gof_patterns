public class OrangeGreen extends SemaphoreState{

	private static OrangeGreen instance;

	public void goNext(Semaphore context){
		System.out.print("Oranžová ");
		wait(1);
		System.out.println();
		context.setState(Red.getInstance());

	}

	private OrangeGreen(){}

	public static SemaphoreState getInstance(){
		if(instance == null)
			instance = new OrangeGreen();
		return instance;
	}

	public boolean isOpen(){
		return false;
	}
	
}
