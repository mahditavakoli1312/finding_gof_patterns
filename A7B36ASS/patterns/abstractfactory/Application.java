package patterns.abstractfactory;

public class Application{
	private Document doc;
	public Application(Document doc){
		this.doc = doc;
	}
	
	public void run(){
		LineWriter lw = doc.getLineWriter();
		lw.print("Něco Tady Writnu");
	}
}
