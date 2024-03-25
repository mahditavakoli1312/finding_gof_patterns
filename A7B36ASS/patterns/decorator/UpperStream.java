package patterns.decorator;

public class UpperStream extends StreamDecorator{
	public UpperStream(DataStream s){
		super(s);
	}

	public void print(String data){
		stream.print(data.toUpperCase());
	}
}
