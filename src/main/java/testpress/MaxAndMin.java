package testpress;

public class MaxAndMin {

	public static void main(String args[])
	{
		int input[] = {1005, 54, 546, 548, 60, 75, 6, 981};
		
		int min = input[0];
		int max = input[1];
		
		for(int i=0;i<input.length;i++)
		{
			if(min>input[i])
				min = input[i];
			
			else if(max<input[i])
				max = input[i];
		}
		
		System.out.println("Minimum element in the array: "+min);
		System.out.println("Maximum element in the array: "+max);
	}
}
