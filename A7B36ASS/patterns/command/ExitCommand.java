public class ExitCommand implements ICommand{
		
	Document documentModel;
	Main applicationModel;

	public ExitCommand(Document d, Main a){
		documentModel = d;
		applicationModel = a;
	}

	public void execute(){
		if(documentModel.isOpen()){
			String res = applicationModel.askUser("Document is opened, save changes?[y/n]");
			if(res.equals("y")){
				documentModel.close();
			}
		}
		applicationModel.exit();
	}
	
}
