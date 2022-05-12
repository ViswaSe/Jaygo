package leetcode;

public class RemoveDuplicates {
	
	public static void main(String args[])
	{
		String s = "We learn java basics as part of java sessions in java week1 as batch1";
		String[] eachWords = s.split(" ");
	
		String temp = "";
		int count = 0;
		
		for(int i=0;i<eachWords.length;i++)
		{
			String[] temp_split = temp.split(" ");
			count=0;
			
			for(int j=0;j<temp_split.length;j++)
			{
				if(temp_split[j].equals(eachWords[i]))
				{
					count++;
					break;
				}
			}
			
			if(count==0)
				temp=temp+eachWords[i]+" ";
		}	
	
		System.out.println(temp);
	}

}
