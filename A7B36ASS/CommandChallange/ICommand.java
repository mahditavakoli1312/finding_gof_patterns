public abstract class ICommand{
	public abstract void execute();
	public void wait(int sec){
		try{
			Thread.sleep(sec*1000);
		}catch(Exception e){
		}
	}
}
