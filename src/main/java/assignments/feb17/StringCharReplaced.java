package assignments.feb17;

public class StringCharReplaced {
	
	public static void main(String args[])
	{
		String s = "HelloHelloHello";
		StringCharReplaced obj = new StringCharReplaced();
		System.out.println(obj.replaceChars(s, "ell", "asa"));
		
	}
	
	public String replaceChars(String input, String charsToBeReplaced, String replaceableChars){

		String temp="";
		String result = "";
		for(int i=0;i<input.length()-1;i++)
		{
			int count=i;
			for(int j=0;j<charsToBeReplaced.length();j++)
			{
				temp=temp+input.charAt(count);
				count++;
			}
			
			System.out.println(temp);
			//temp=temp+input.charAt(i)+input.charAt(i+1);
			
			if(temp.equals(charsToBeReplaced))
			{
				result=result+replaceableChars;
			}
			else if(i!=input.length()-2)
			{
				result=result+temp.charAt(0);
			}
			else
			{
				result=result+temp;
			}
			temp="";
		}
		
		return result;
			
	} 

}
