package interviewquestions;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicateNumbers {
	
	public static void main(String args[])
	{
		List<Integer> list = new ArrayList<Integer>();
		
		int[] a = {1,34,2,34,6,7,7,4,3,7,8,6,2,2,1,9,0,9,0,31,15,64,5,15,5};
		
		for(int each:a)
			list.add(each);
		
		//Removing duplicates from the list
		for(int i=0;i<list.size();i++)
		{
			for(int j=i+1;j<list.size();j++)
			{
				if(list.get(i)==list.get(j))
				{
					list.remove(j);
					j=j-1;
				}
			}
		}
		
		for(int each:list)
			System.out.println(each);
	}

}
