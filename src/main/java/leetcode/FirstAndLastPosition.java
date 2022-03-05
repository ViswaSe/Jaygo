package leetcode;

public class FirstAndLastPosition {
	
	public static void main(String args[])
	{
		int[] nums = {8,8,5,7,7,10,9,22,56,78,100,78,65,78};
		
		int starting_index = nums.length;
		int ending_index = 0;
		int count = 0;
		
		int target = 25;
		
		for(int i=0;i<nums.length;i++)
		{
			if(target == nums[i])
			{
				count++;
				if(starting_index>=i)
				{
					starting_index=i+1;
				}
				else if(ending_index<=i)
				{
					ending_index=i+1;
				}
			}
		}
			
		if(count==0)
		{
			starting_index = -1;
			ending_index = -1;
		}
		
		System.out.println(starting_index);
		System.out.println(ending_index);
		
	}

}
