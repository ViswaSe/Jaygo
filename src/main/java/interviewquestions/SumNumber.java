package interviewquestions;

public class SumNumber {
	
	public static void main(String args[])
	{
		int n = 846;
		int result=0;
		
		while(n>0)
		{
			result = result+n%10;
			n=n/10;
		}
		
		System.out.println("Sum of the numbers: "+result);
	}

}
