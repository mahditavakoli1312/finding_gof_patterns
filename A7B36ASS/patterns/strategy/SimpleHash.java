package patterns.strategy;

public class SimpleHash implements HashStrategy{
	public String getHash(String str){
		char[] hash = { 'a', 'b', 'c', 'd', 'e'};
		char[] chars = str.toCharArray();
		for(char c : chars){
			for(int i = 0; i <  hash.length ; i++)	{
				hash[i] = (char)((((hash[i] + c)) % 25) + 65);
			}
		}
		return new String(hash);
	}
}
