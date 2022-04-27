package leetcode;

public class IntegerPalindrome {

	public static void main(String args[])
	{
		int n = 842;
		int count = 0;
		int input = n;
		
		while(input>0) //1001>0 //100 >0 //10>0 //1>0 
		{
			input = input/10;
			count++; //count = 4;
		}
		input = n; //input = 1001;
		int reminder;
		int sum = 0;
		
		for(int i=1;i<=count;i++)
		{
			reminder = input%10; //1 //0 //0 //1
			input = input/10; //100 //10 //1 //0
			
			for(int j=i;j<count;j++) //1,2,3 //2,3 //3 
			{
				reminder = reminder*10; //1000 //0 //0 
			}
			
			sum = sum+reminder; //1000+0+0+1
		
		}
		
		System.out.println("Reverse value: "+sum);
		
		if(sum==n)
			System.out.println("Given Integer is palindrome: "+sum);
		else
			System.out.println("Given Integer is not a palindrome: "+n);
	
	}
}
