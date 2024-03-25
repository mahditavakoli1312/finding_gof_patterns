public class Red extends SemaphoreState{

	private static Red instance;

	public void goNext(Semaphore context){
		System.out.print("Červená ");
		wait(5);
		System.out.println();
		context.setState(Orange.getInstance());
	}

	private Red(){}

	public static SemaphoreState getInstance(){
		if(instance == null)
			instance = new Red();
		return instance;
	}

	public boolean isOpen(){
		return false;
	}
	
}
