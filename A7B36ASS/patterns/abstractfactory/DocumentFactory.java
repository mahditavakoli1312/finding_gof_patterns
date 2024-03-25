package patterns.abstractfactory;

public class DocumentFactory{
	public static final int LOUD = 1, SILENT = 2;
	public Document getDocument(int type){
		if(type == 1)
			return new LoudDocument();
		else
			return new SilentDocument();
	}
}
