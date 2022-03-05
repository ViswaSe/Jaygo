package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RelativeSortArray {
	
	public static void main(String args[])
	{
		int a[] = {2,3,1,3,2,4,6,7,9,2,19};
		int b[] = {2,1,4,3,9,6};
		boolean flag = false;
		List<Integer> list = new ArrayList<Integer>();
		
		//verify the common elements present how many times in array a & b
		list.addAll(verifyRelativeSortedArray(a,b));
		
		//Take the elements those are not presented in array a and then add it into a list to print it at the end.
		Arrays.sort(a);
		for(int i=0;i<a.length;i++)
		{
			flag = false;
			for(int j=0;j<b.length;j++)
			{
				if(a[i]==b[j])
				{
					flag = true;
					break;
				}
			}
			if(flag == false)
				list.add(a[i]);
		}	
		
		//print the list for output
		for(int each:list)
		{
			System.out.print(each+" ");
		}
	}
	
	public static List<Integer> verifyRelativeSortedArray(int[] a,int[] b)
	{
		int count=0;
		List<Integer> result_list = new ArrayList<Integer>();
		for(int i=0;i<b.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				if(b[i]==a[j])
					count++;
				else
					continue;
			}
			if(!(result_list.contains(b[i])))
			{
				for(int k=0;k<count;k++)
				{
						result_list.add(b[i]);
				}
			}
			
			count=0;
		}
		
		return result_list;
	}
}
