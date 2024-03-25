public class AndExp implements BooleanExp{

	private BooleanExp firstOp;
	private BooleanExp secOp;

	public AndExp(BooleanExp first, BooleanExp sec){
		firstOp = first;
		secOp = sec;
	}

	public boolean evaluate(Context c){
		return firstOp.evaluate(c) && secOp.evaluate(c);
	}
}
