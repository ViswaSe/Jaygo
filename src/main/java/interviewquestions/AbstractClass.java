package interviewquestions;

public abstract class AbstractClass {
	
	//Abstract class contains both the abstract methods and concrete methods (methods with definition)
	//If the class is abstract then it should contain abstract keyword at class level and method level
	//Abstract methods are undefined it has only method signature not definition
	//If the class is abstract then you can't create object for the class, you can only create the reference of it.
	//If the class is abstract then the class must have atleast one abstract methods

	public abstract void anirudh(); //abstract method example.
	public void vichu()
	{
		System.out.println("This method is defined in the abstract class");
	}
}
