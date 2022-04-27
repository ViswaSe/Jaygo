package interviewquestions;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicateString {
	
	public static void main(String args[])
	{
		List<String> list = new ArrayList<String>();
		
		String[] s = {"vichu","jay","ramana","anirudh","ramana","vichu","vidhya","jay"};
		
		for(String each:s)
			list.add(each);
		
		//Removing duplicates from the list
		for(int i=0;i<list.size();i++)
		{
			for(int j=i+1;j<list.size();j++)
			{
				if(list.get(i).equals(list.get(j)))
				{
					list.remove(j);
					j=j-1;
				}
			}
		}
		
		for(String each:list)
			System.out.println(each);
	}

}
