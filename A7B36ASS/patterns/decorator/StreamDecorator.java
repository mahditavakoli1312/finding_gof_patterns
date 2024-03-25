package patterns.decorator;

public class StreamDecorator implements DataStream{
	protected DataStream stream;
	public StreamDecorator(DataStream s){
		this.stream = s;
	}
	public void print(String data){
		stream.print(data);
	}
}
