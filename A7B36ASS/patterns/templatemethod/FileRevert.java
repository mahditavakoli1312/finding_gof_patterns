package patterns.templatemethod;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileRevert extends Revert{
	private File f;

	protected String input(){
		try{
			Scanner s = new Scanner(f);		
			return s.nextLine();
		}catch(FileNotFoundException e){
			System.out.println("Nelze otevřít soubor");
			return "";
		}
	}
	protected void output(String out){
		System.out.println(out);
	}

	public FileRevert(String fileName){
		f = new File(fileName);
	}
}
