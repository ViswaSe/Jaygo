package interviewquestions;

public class SwapProgramWithoutUsingTemp {
	
	public static void main(String args[])
	{
		int a = 120;
		int b = 15;
		
		b = a+b;
		a = b-a;
		b = b-a;
		
		System.out.println("After swapping..");
		
		System.out.println(a);
		System.out.println(b);
	}

}
