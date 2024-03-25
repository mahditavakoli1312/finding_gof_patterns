package patterns.templatemethod;

public abstract class Revert{
	public void process(){
		String in = input();
		String out = revert(in);
		output(out);
	}

	protected abstract String input();
	protected String revert(String s){
		return new StringBuffer(s).reverse().toString();
	}
	protected abstract void output(String out);
}
