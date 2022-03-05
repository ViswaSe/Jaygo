package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LongestCommonPrefix {
	
	public static void main(String args[])
	{
		String[] str= {"cautionee","cautioneing","cautionel","cautione","cautioney"};
		
		Map<Integer,String> map = new HashMap<Integer,String>();
		for(int i=0;i<str.length;i++)
		{
			map.put(str[i].length(), str[i]);
		}
		
		int count=str[0].length();
		String temp = str[0];
		
		for(Entry<Integer, String> eachEntry:map.entrySet())
		{
			if(eachEntry.getKey()<count)
			{
				temp=eachEntry.getValue();
				count=eachEntry.getKey();
			}
		}
				
		boolean flag = false;
		for(int i=temp.length()-1;i>=0;i--)
		{
			String s = temp.substring(0,i+1);
			for(int j=0;j<str.length;j++)
			{
				if(str[j].contains(s))
				{
					flag = true;
				}
				else
				{
					flag = false;
					break;
				}
			}
			
			if(flag)
			{
				System.out.println(s);
				break;
			}
		}

	} 

}
