package assignments.feb28;

public class LongestPalindrome {
	
	public static void main(String args[])
	{
		String s = "habibibah";
		String temp="";String result="";
		int max_length=0;
		
		for(int i=0;i<s.length();i++)
		{
			for(int j=i+1;j<s.length();j++)
			{
				temp=getSubstring(s,i,j+1);
				int count=verifyPalindrome(temp);
				if(max_length<count)
				{
					max_length=count;
					result=temp;
				}
			}
		}
		
		System.out.println("Longest palindrome value: "+ result);
	}
	
	public static String getSubstring(String input,int starting_index, int end_index)
	{
		char[] value = input.toCharArray();
		String temp="";
		for(int i=starting_index;i<end_index;i++)
		{
			temp=temp+value[i];
		}
		return temp;
	}
	
	public static int verifyPalindrome(String input)
	{
		int count=0;
		String temp="";
		for(int i=input.length()-1;i>=0;i--)
		{
			temp=temp+input.charAt(i);
		}
		if(input.equals(temp))
		{
			count=temp.length();
			System.out.println(temp);
		}
			
		
		return count;
	}

}
