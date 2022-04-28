package leetcode;

public class ArmstrongNumber {
	
	public static void main(String args[])
	{
		int n = 54748;
		int temp = n;
		int count = 0; 
		
		int final_check = n;
		int result = 0;
		
		while(temp>0)
		{
			count++;
			temp=temp/10;
		}
		
		while(n>0)
		{
			int rem = n%10;
			temp=1;
			
			for(int i=0;i<count;i++)
			{
				temp=temp*rem;
			}
			result = result+temp;
			n=n/10;
		}
		
		System.out.println(result);
		
		if(result==final_check)
			System.out.println("Given number is an armstrong number");
		else
			System.out.println("Given number is not an armstrong number");
	}

}
