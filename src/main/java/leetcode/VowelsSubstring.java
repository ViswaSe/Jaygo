package leetcode;

public class VowelsSubstring {

	public static void main(String args[])
	{
		String s = "cuaieuouac";
		char[] ch= {'a','e','i','o','u'};
		boolean flag = false;
		
		String temp="";
		int count=0;
		
		for(int i=0;i<s.length()-1;i++)
		{
			for(int j=i+1;j<s.length();j++)
			{
				temp=s.substring(i,j+1);
				if(temp.length()>=5)
				{
					flag = verifyVowelsPresent(temp,ch);
					if(flag)
					{
						flag = verifyAllVowelsPresent(temp,ch);
						if(flag)
						{
							System.out.println(temp);
							count++;
						}
					}
						
				}
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean verifyAllVowelsPresent(String temp,char[] ch)
	{
		boolean flag = false;
		for(int i=0;i<ch.length;i++)
		{
			flag = false;
			for(int j=0;j<temp.length();j++)
			{
				if(ch[i]==temp.charAt(j))
				{
					flag = true;
					break;
				}
			}
			if(flag==false)
				break;
		}
		
		return flag;
	}
	
	public static boolean verifyVowelsPresent(String s, char[] ch)
	{
		boolean flag = false;
		String char_temp=new String(ch);
		for(int i=0;i<s.length();i++)
		{
			if(!(char_temp.contains(Character.toString(s.charAt(i)))))
			{
				flag = false;
				break;
			}
			else
				flag = true;
		}
		
		return flag;
	}
}

