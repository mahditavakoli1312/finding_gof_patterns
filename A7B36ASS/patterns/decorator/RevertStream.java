package patterns.decorator;

public class RevertStream extends StreamDecorator{
	public RevertStream(DataStream s){
		super(s);
	}

	public void print(String data){
		StringBuilder strBuilder = new StringBuilder();
        	char[] strChars = data.toCharArray();
	        for (int i = strChars.length - 1; i >= 0; i--) {
	            strBuilder.append(strChars[i]);
	        }
		stream.print(strBuilder.toString());
	}
}
