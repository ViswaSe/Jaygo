package leetcode;

public class NumberOfOccurances {

	public static void main(String args[])
	{
		String s = "Jayakrishnna is a wonderful student";
		char[] c = s.toCharArray();
		
		String temp = "";
		int count = 1;
		
		for(int i=0;i<s.length();i++)
		{
			for(int j=i+1;j<s.length();j++)
			{
				if(c[i]==c[j])
				{
					count++;
				}
			}
			
			if((!temp.contains(Character.toString(c[i]))))
			{
				System.out.println(c[i] + "-" +count);
			}
			
			temp=temp+c[i];
			count = 1;
		}
	}
}
