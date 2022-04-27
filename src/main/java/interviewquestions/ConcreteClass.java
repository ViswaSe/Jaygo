package interviewquestions;

public class ConcreteClass extends AbstractClass{
	
	public static void main(String args[])
	{
		ConcreteClass obj = new ConcreteClass();
		obj.anirudh();
		obj.vichu(); //you can call both the abstract class methods with the help of concrete class objects. 
		
		
		//you can't create abstract class method where as you can create abstract class reference as like below:
		AbstractClass obj1 = new ConcreteClass();
		obj1.anirudh();
		obj1.vichu();
	}

	//If the class extends abstract class then the abstract method should be extended in the child class
	//	 or else the child class should be abstract
	@Override
	public void anirudh() {
		
		System.out.println("This is the abstract class method defined in the concrete class");
		
	}

}
