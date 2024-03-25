package patterns.abstractfactory;

public class Main{
	
	public static void main(String[] args){
		DocumentFactory df = new DocumentFactory(); // Document factory není součástí tohoto vzrou. DocumentFactory je vlastně druhý vzor a to factory method. 
	 	Application app = new Application(df.getDocument(DocumentFactory.LOUD)); 
		app.run();
	}
}
