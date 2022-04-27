package interviewquestions;

public class RemoveRepeatedCharacters {

	public static void main(String args[])
	{
		String s = "ZaakkAapppppsss";
		String result = "";

		for(int i=0;i<s.length();i++)
		{
			String temp = Character.toString(s.charAt(i));

			for(int j=i+1;j<s.length();j++)
			{
				String iteration = Character.toString(s.charAt(j));

				if(temp.equals(iteration) && !(result.contains(temp)))
				{
					result=result+temp;
				}
				else if(!(result.contains(temp)))
				{
					result=result+temp;
				}
			}

		}

		System.out.println(result);
	}

}
