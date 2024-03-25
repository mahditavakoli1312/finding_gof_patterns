import java.io.*;
import java.util.LinkedList;

public class Main{
	protected boolean alive = true;
	protected LinkedList<MenuItem> menu;

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args){
	
		Main application = new Main();

		Document model = new Document();
	
		application.menu = new LinkedList<MenuItem>();
		
		MenuItem open = new MenuItem("Oteřít dokument", new LinkedList<ICommand>());
		open.addAction(new OpenDocumentCommand(model, application)); 		

		MenuItem close = new MenuItem("Zavřít dokument", new LinkedList<ICommand>());
		close.addAction(new CloseDocumentCommand(model));

		MenuItem exit = new MenuItem("Ukončit", new LinkedList<ICommand>());
		exit.addAction(new ExitCommand(model, application));

		application.menu.add(open);
		application.menu.add(close);
		application.menu.add(exit);

		while(application.alive){
			int i = 1;
			for(MenuItem mi : application.menu)	{
				System.out.println(i + ": " + mi);
				i++;
			}
			Integer item = Integer.parseInt(application.askUser("Zvolte"));
			application.menu.get(item - 1).onClicked();
		}		
	}

	public void exit(){
		alive = false;
	}

	public String askUser(String prompt){
		System.out.print(prompt + ": ");
		try{
			String res = br.readLine();
			return res;
		}catch(IOException e){
			System.out.println("Unable to read user input");
		}
		return "";
	}
}
