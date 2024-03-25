package patterns.strategy;

public class Main{
	public static void main(String[] args){
		Password p = new Password("heslicko");
		p.setHasher(new SimpleHash()); // Zde by se hodila možná nějaká továrna
		System.out.println(p.getPasswordHash());
		p.setHasher(new BetterHash()); 
		System.out.println(p.getPasswordHash());

	}
}
