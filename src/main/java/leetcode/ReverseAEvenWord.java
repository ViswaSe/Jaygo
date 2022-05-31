package leetcode;

public class ReverseAEvenWord {
	
	public static void main(String args[])
	{
		String s = "Both Vichu and Jay are brothers";
		
		String[] values = s.split(" ");
		String result = "";
		
		for(int i=0;i<values.length;i++)
		{
			if(i%2!=0)
			{
				result = result+reverseString(values[i])+ " ";
			}
			else
				result = result+values[i]+" ";
		}
		
		System.out.println(result);
	}
	
	public static String reverseString(String s)
	{
		String temp="";
		
		for(int i=s.length()-1;i>=0;i--)
		{
			temp=temp+s.charAt(i);
		}
		
		return temp;
	}

}
