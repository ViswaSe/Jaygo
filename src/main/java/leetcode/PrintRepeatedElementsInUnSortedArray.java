package leetcode;

public class PrintRepeatedElementsInUnSortedArray {
	
	public static void main(String args[])
	{
		int arr[] = {50, 20, 10, 40, 20, 10, 10, 60, 20, 30, 70, 70};
		int count=0;
		
		int temp;
		int last_match=0;
		
		System.out.println("Repeated Elements: ");
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					count++;
					temp=arr[i+1];
					arr[i+1]=arr[j];
					arr[j]=temp;
				}
			}
			
			if(count>0 && arr[i]!=last_match)
			{
				System.out.print(arr[i]+" ");
				last_match=arr[i];
			}
			
			count=0;
		}
	}

}
