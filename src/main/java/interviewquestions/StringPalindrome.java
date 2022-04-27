package interviewquestions;

public class StringPalindrome {
	
	public static void main(String args[])
	{
		String s = "madam";
		
		String s1 = "";
		
		for(int i=s.length()-1;i>=0;i--)
		{
			s1=s1+s.charAt(i);
		}
		
		System.out.println(s1);
		
		if(s.equals(s1))
		{
			System.out.println("Given String is a palindrome");
		}
		
		else
		{
			System.out.println("Given string is not a palindrome");
		}
	}

}
