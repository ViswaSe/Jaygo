package javaprograms;

public class DiamondProgram {
	
	public static void main(String args[])
	{
		int length=18;
		int temp=1;
		int half=length/2;
		
		for(int i=0;i<half;i++)
		{	
			for(int k=i;k<half;k++)
				System.out.print(" ");
			
			for(int j=0;j<temp;j++)
				System.out.print("*");
			
			for(int k=i;k<half;k++)
				System.out.print(" ");
			
			temp=temp+2;
			System.out.println();
		}
		
		for(int i=half;i<=length;i++)
		{
			for(int k=i;k>half;k--)
				System.out.print(" ");
			
			for(int j=0;j<temp;j++)
				System.out.print("*");
			
			for(int k=i;k>half;k--)
				System.out.print(" ");
			
			temp=temp-2;
			System.out.println();
		}
	}

}
