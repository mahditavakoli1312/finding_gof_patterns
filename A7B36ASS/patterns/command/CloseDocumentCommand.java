public class CloseDocumentCommand implements ICommand{
		
	Document documentModel;

	public CloseDocumentCommand(Document d){
		documentModel = d;
	}

	public void execute(){
		documentModel.close();
	}
	
}
