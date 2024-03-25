public class Business{
	String info;

	public void doSomeWorkWithUser(int uid){
		System.out.println("Some priviledged work with root user");	
	}
	public String getInfo(){
		return info;
	}

	public void setInfo(int uid, String str){
		this.info = str;
	}
}
