package leetcode;

public class LongestCommonSubstring {
	
	public static void main(String args[])
	{
		String[] s = {"floower","flower","floorwing","flowing"};
		
		String result="";
		boolean flag = true;
		
		while(flag!=false)
		{
			for(int i=0;i<s[0].length();i++)
			{
				String temp = Character.toString(s[0].charAt(i));
				for(int j=1;j<s.length;j++)
				{
					if(s[j].contains(temp))
					{
						flag=true;
						s[j]=s[j].replaceFirst(temp, "");
					}
					else
					{
						flag = false;
						break;
					}
				}
				
				if(flag)
					result=result+temp;
			}
		}
		
		System.out.println(result);
		
	}

}
