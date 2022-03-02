package assignments.feb17;

public class StringCharReplaced {

	public static void main(String args[])
	{
		String s = "HelloHelloHello";
		StringCharReplaced obj = new StringCharReplaced();
		System.out.println(obj.replaceChars(s, "ello", "post"));

	}

	public String replaceChars(String input, String charsToBeReplaced, String replaceableChars){


		char[] inputCharArray = input.toCharArray();
		for (int i = 0; i < inputCharArray.length-charsToBeReplaced.length()+1; i++) {
			String temp = "";
			for (int j = 0; j < charsToBeReplaced.length(); j++) {
				temp = temp+Character.toString(inputCharArray[i+j]);
			}
			//System.out.println(temp);
			if (temp.equals(charsToBeReplaced)) {
				for (int j = 0; j < temp.length(); j++) {
					inputCharArray[i+j] = replaceableChars.toCharArray()[j];
				}
			}
		}
		return String.valueOf(inputCharArray);
	}



} 
