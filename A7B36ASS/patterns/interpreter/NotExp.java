public class NotExp implements BooleanExp{

	private BooleanExp exp;

	public NotExp(BooleanExp exp){
		this.exp = exp;
	}

	public boolean evaluate(Context c){
		return !exp.evaluate(c);
	}
}
