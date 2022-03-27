package leetcode;

import java.util.Arrays;

public class ArrayRotation {
	
	public static void main(String args[])
	{
		int nums[] = {6,7,8,1,2,3,4,5};
		boolean flag = false;
		int count=0;
		int counter=0;
			
		int result[] = new int[nums.length];
		for(int i=0;i<nums.length;i++)
		{
			result[i]=nums[i];
		}
		Arrays.sort(result);
		
		while(flag!=true && counter<nums.length)
		{
			result=swapElements(result,count);
			System.out.println();
			flag = verifyMatchingArray(result,nums);
			counter++;
		}
		
		if(flag)
			System.out.println(true);

		else
			System.out.println(false);
	}
	
	
	public static int[] swapElements(int[] result,int count)
	{
		int temp=result[count];
		
		for(int i=0;i<result.length-1;i++)
		{
			result[i]=result[i+1];
		}
		
		result[result.length-1]=temp;
		
		for(int each:result)
			System.out.print(each+" ");
		
		return result;
	}
	
	public static boolean verifyMatchingArray(int[] result,int[] input)
	{
		boolean flag = true;
		for(int i=0;i<result.length;i++)
		{
			if(result[i]!=input[i])
			{
				flag=false;
				break;
			}
		}
		
		return flag;
	}

}
