package javaprograms;

import java.util.Scanner;

public class IntegerPalindrome {
	
	public static void main(String args[])
	{
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the Integer: ");
		int n = obj.nextInt();
		int n1=n;
		int rem,reverse=0;
		while(n>0)
		{
			rem=n%10;
			reverse=(reverse*10)+rem;
			n=n/10;
		}
		
		
		if(reverse==n1)
			System.out.println("Given Integers are palindrome");
		else
			System.out.println("Given Integers are not a palindrome");
		
		obj.close();
	}

}
