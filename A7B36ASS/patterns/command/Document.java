public class Document{
	protected boolean opened = false;
	public void open(String fileName){
		System.out.println("Opening document: "+ fileName);
		opened = true;
	}

	public void close(){
		if(opened)
			System.out.println("Dokument zavřen");
		else
			System.out.println("Žádný dokument není otevřen");
		opened = false;
	}

	public boolean isOpen(){
		return opened;
	}
}
