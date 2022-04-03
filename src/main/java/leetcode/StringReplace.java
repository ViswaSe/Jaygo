package leetcode;

public class StringReplace {
	
	public static void main(String args[])
	{
		String s = "vidhyavishveshwar";
		
		String s1="vishveshwar";
		String s2="angel";
		
		int count=0;
		
		String temp,result="";
		
		for(int i=0;i<=s.length()-s1.length();i++)
		{
			temp = s.substring(i,i+s1.length());
			
			if(temp.equals(s1))
			{
				result=result+s2;
				i=i+(s1.length()-1);
			}
			else
			{
				result=result+s.charAt(i);
			}
			count = i;
		}
		
		for(int i=count+1;i<s.length();i++)
		{
			result=result+s.charAt(i);
		}
			
		System.out.println(result);
	}

}
