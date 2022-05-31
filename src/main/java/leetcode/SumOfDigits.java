package leetcode;

public class SumOfDigits {
	
	public static void main(String args[])
	{
		int n = 219;
		int sum = 0;
		int rem;
		
		while(n>0)
		{
			rem=n%10;
			sum=sum+rem;
			n=n/10;
		}
		
		System.out.println("Sum of Digits: "+sum);
		
	}

}
