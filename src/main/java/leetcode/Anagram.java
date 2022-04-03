package leetcode;

public class Anagram {

	public static void main(String args[])
	{
		String s = "anirudhramana";
		String s1 = "harishanirudh";
		
		s=s.replaceAll(" ", "");
		s1=s1.replaceAll(" ", "");

		int count = 0;
		boolean flag;
		
		while(s.length()>count)
		{
			flag = false;
			for(int j=0;j<s1.length();j++)
			{
				if(Character.toString(s.charAt(count)).equals(Character.toString(s1.charAt(j))))
				{
					s=s.replaceFirst(Character.toString(s.charAt(count)),"");
					s1=s1.replaceFirst(Character.toString(s1.charAt(j)),"");
					flag = true;
					break;
				}
			}
			
			if(flag==false)
				count++;
		}
		
		System.out.println("first string after removal: " +s);
		System.out.println("second string after removal: " +s1);
		
		
		//print whether the given string is anagram or not!!
		if(s.length()==0 && s1.length()==0)
			System.out.println("Given words are anagram");
		else
			System.out.println("Given words are not an anagram");
	}

}
