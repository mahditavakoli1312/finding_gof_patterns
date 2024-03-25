package patterns.strategy;

public class BetterHash implements HashStrategy{
	public String getHash(String str){
		char[] hash = { 'O', 'i', 'M', 'z', 'T', 't', 'w'};
		char[] hash2 = { 't', 'e', 'q', 'c', 'm', 'e', 'r'};
		char[] chars = str.toCharArray();
		for(char c : chars){
			for(int i = 0; i <  hash.length ; i++)	{
				hash[i] = (char)(((hash[i] + c)) % 65);
				hash2[i] = (char)(((hash[i] + c) + (hash2[i] % 15) + c ) % 128);
				hash[i] = (char) (((hash[i] + hash2[i]) % 25) + 65);
			}
		}
		return new String(hash);
	}
}
