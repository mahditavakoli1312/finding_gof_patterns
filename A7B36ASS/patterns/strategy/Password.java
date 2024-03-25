package patterns.strategy;

public class Password{
	private HashStrategy hs;
	private String passwd;

	public Password(String p){
		this.passwd = p;
	}
	
	public void setHasher(HashStrategy hs){
		this.hs = hs;
	}

	public String getPasswordHash(){
		return hs.getHash(this.passwd);
	}
}
