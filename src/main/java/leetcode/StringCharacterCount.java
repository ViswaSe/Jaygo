package leetcode;

public class StringCharacterCount {
	
	public static void main(String args[])
	{
		String s = "aswathramana";
		String temp = "";
		
		int count = 1;
		
		for(int i=0;i<s.length();i++)
		{
			for(int j=i+1;j<s.length();j++)
			{
				if(s.charAt(i)==s.charAt(j))
				{
					count++;
				}
			}

			if(!(temp.contains(Character.toString(s.charAt(i)))))
			{
				System.out.println(s.charAt(i)+"-"+count);
			}
			
			temp=temp+s.charAt(i);
			count=1;
		}
	}

}
