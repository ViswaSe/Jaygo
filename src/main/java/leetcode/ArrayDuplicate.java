package leetcode;

public class ArrayDuplicate {
	
	public static void main(String[] args) 	
	{		

		int a[]= {30,10,10,10,20,20,30,40,50,60,70,70,50,20};
		int n = a.length;
		int count = 0;

		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(a[i]==a[j] && count!=a[i])
				{
					count=a[i];  
					System.out.println(a[i]);  

				}
			}
		}
	}
}
