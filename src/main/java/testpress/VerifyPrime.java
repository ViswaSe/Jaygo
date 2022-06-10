package testpress;

import java.util.Scanner;

public class VerifyPrime {
	
	public static void main(String args[])
	{
		//Get the input at runtime
		Scanner obj = new Scanner(System.in);
		int n = obj.nextInt();
		
		boolean flag = true;
		
		for(int i=2;i<n;i++)
		{
			if(n%i==0)
			{
				flag = false;
				break;
			}
		}
		
		if(flag)
			System.out.println("Yes");
		else
			System.out.println("No");
		
		obj.close();
	}

}
