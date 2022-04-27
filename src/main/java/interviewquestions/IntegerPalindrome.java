package interviewquestions;

public class IntegerPalindrome {
	
	public static void main(String args[])
	{
		int i = 848;
		
		int input = i;
		int result=0;
		int reminder;
		int count=1;
		
		while(input>=10)
		{
			input=input/10;
			count=count*10;
		}
		input=i;
		
		while(input>0)
		{
			reminder = input%10; 
			result = result+(reminder*count);
			input = input/10;
			count=count/10;
		}
		
		System.out.println(result);
		
		if(result==i)
			System.out.println("Integer Palindrome");
		else
			System.out.println("Not an Integer Palindrome");
	}

}
