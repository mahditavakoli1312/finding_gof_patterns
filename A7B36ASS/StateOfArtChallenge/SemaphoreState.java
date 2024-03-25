public abstract class SemaphoreState{
	public abstract void goNext(Semaphore context);
	public abstract boolean isOpen();
	protected void wait(int sec){
		try{
			for(int i = sec; i > 0; i--){
				System.out.print(i + " ");
				Thread.sleep(1000);
			}
		}catch(Exception e){
		}
	}
}
