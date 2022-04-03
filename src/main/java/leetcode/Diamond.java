package leetcode;

public class Diamond {
	
	public static void main(String args[])
	{
		int n = 10;
		int count=0;
		
		for(int i=0;i<n;i++)
		{ 
			for(int k=n;k>i+1;k--)
			{
				System.out.print(" ");
			}
			
			for(int j=0;j<=count;j++)
			{
				System.out.print("*");
			}
			System.out.println();
			count = count+2;
			
		}
		
		count = count-1;
		
		for(int i=0;i<n;i++)
		{
			count = count-2;
			for(int j=0;j<=i;j++)
			{
				System.out.print(" ");
			}
			
			for(int k=count;k>0;k--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
