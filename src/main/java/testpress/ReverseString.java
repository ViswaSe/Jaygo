package testpress;

import java.util.Scanner;

public class ReverseString {
	
	public static void main(String args[])
	{
		//Get the input at runtime	
		Scanner obj = new Scanner(System.in);
		String s = obj.next();
		
		String result = "";
		for(int i=s.length()-1;i>=0;i--)
		{
			result = result+s.charAt(i);
		}
		
		System.out.println(result);
		
		obj.close();
	}

}
