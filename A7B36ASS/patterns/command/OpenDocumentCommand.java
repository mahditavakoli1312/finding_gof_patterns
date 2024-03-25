public class OpenDocumentCommand implements ICommand{
		
	Document documentModel;
	Main applicationModel;

	public OpenDocumentCommand(Document d, Main a){
		documentModel = d;
		applicationModel = a;
	}

	public void execute(){
		String file = applicationModel.askUser("Zadejte název souboru");	
		documentModel.open(file);
	}
	
}
