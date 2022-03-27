package leetcode;

public class RemoveAllOccurances {

	public static void main(String args[])
	{
		String input = "eddteddyeddheddieddkedd";
		String s = "edd";

		boolean flag = false;
		String reference = input;
		String temp="";

		int count=0;
		while(flag!=true)
		{
			if(count<=reference.length()-s.length())
			{
				temp = reference.substring(count,count+(s.length()));
				if(temp.equals(s))
				{
					reference=reference.replaceFirst(temp, "");
					count=0;
					System.out.println(reference);
				}
				else
					count++;
			}
			else 
				flag = true;
		}
	}

}
