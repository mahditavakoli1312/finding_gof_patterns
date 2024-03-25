public class OrExp implements BooleanExp{

	private BooleanExp firstOp;
	private BooleanExp secOp;

	public OrExp(BooleanExp first, BooleanExp sec){
		firstOp = first;
		secOp = sec;
	}

	public boolean evaluate(Context c){
		return firstOp.evaluate(c) || secOp.evaluate(c);
	}
}
