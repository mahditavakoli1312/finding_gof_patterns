public class Main{
	public static void main(String[] args){
		Business b = new Business();
		b.doSomeWorkWithUser(0);
		b.doSomeWorkWithUser(1);

		System.out.println(" - Set - ");
		
		b.setInfo(0 ,"Ahoj");
		System.out.println(b.getInfo());
		b.setInfo(1, "Ahojky");
		System.out.println(b.getInfo());
		
	}
}
