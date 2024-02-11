package javaprograms;

import java.util.Scanner;

public class StringPalindrome {
	
	public static void main(String args[])
	{
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter your string: ");
		String s = obj.next();
		String s1="";
		
		for(int i=s.length()-1;i>=0;i--)
		{
			s1=s1+s.charAt(i);
		}
		
		if(s.equals(s1))
			System.out.println("Given strings are palindrome");
		else
			System.out.println("Given strings are not a palindrome");
		
		obj.close();
	}
}
