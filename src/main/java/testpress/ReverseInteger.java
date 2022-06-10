package testpress;

import java.util.Scanner;

public class ReverseInteger {

	public static void main(String args[])
	{
		//Get the input at runtime
		Scanner obj = new Scanner(System.in);
		int n = obj.nextInt();
		
		int rem = 0;
		int result = 0;
		
		while(n>0)
		{
			rem=n%10;
			n=n/10;
			result = (result*10)+rem;
		}
		
		System.out.println(result);
		
		obj.close();
	}
}
