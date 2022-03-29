package leetcode;

public class ArraySorting {
	
	public static void main(String args[])
	{
		int[] arr = {12,5,8,7,3,1,2,26};
		
		int temp;
		
		for(int i=arr.length-1;i>=0;i--)
		{
			for(int j=i-1;j>=0;j--)
			{
				if(arr[i]>arr[j])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
		for(int each:arr)
		{
			System.out.println(each);
		}
	}

}
