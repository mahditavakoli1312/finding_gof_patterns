public class Green extends SemaphoreState{

	private static Green instance;

	public void goNext(Semaphore context){
		System.out.print("Zelená ");
		wait(4);
		System.out.println();
		context.setState(OrangeGreen.getInstance());
	}

	private Green(){}

	public static SemaphoreState getInstance(){
		if(instance == null)
			instance = new Green();
		return instance;
	}

	public boolean isOpen(){
		return true;
	}
	
}
