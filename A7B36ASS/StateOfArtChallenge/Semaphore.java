public class Semaphore{
	SemaphoreState state;

	public Semaphore(){
		state = Red.getInstance();
	}
	public void setState(SemaphoreState state){
		this.state = state;
	}

	public void goNext(){
		this.state.goNext(this);
	}	
		
	public boolean isOpen(){
		return state.isOpen();
	}
}
