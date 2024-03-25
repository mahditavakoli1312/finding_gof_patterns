package patterns.state;

public class ApplicationContext{
	private ApplicationState received = null;
	private ApplicationState processed = null;
	private ApplicationState accepted = null;

	private ApplicationState state;

	public Application(){
		// Stavy je možné inicializovat zde, ale volím lazy způsob
		state = null;
	}

	private ApplicationState getReceivedState(){
		if(received == null)
			received = new ReceivedState();
		return received;
	}
	private ApplicationState getProcessedState(){
		if(processed == null)
			processed = new ProcessedState();
		return processed;
	}
	private ApplicationState getAcceptedState(){
		if(accepted == null)
			accepted = new AcceptedState();
		return accepted;
	}

	public void receive(){
		state = getReceivedState();
	}

	public void process(){
		state.process();
	}

}
