/**
In java, there are eight kinds of primitive types. 
The rest is called reference type. For example, the String and the Horse here.
The usage of key word this: 
1) in constructor, this refers to the new object;
2) in normal method, this refers to the object which calls the method.

*/

public class Horse {
	Horse same;
	String jimmy;

	public Horse(String lee) {
		jimmy = lee;
	}

	public Horse same(Horse horse) {
		/**
		the parameter passed is horse (line 38)
		this == cult, which calls the method
		the this.same attribute of cult is not null
		and same here refers to cult, which is a circle
		same.same also refers to cult.
		*/
		if (same != null) {  
			System.out.println("what is the address of this same? "+same);
			System.out.println(same.jimmy);
			Horse same = horse; // the object same refers to horse 38
			System.out.println("the address of the local same "+same);
			same.same = horse;  // horse also becomes a circle
			same = horse.same;  
		}
		System.out.println("again, the address of the same is?? " + same);
		System.out.println("and the address of same.same is "+same.same);
		return same.same;  
	}

	public static void main(String[] args) {
		Horse horse = new Horse("youve been");
		System.out.println("the address of horse "+horse);
		Horse cult = new Horse("horsed");
		System.out.println("the address of cult "+cult);
		cult.same = cult; // now we have a circle and same refer to cult.
		System.out.println("the address of cult.same "+cult.same);
		cult = cult.same(horse); // here cult calls the same method
		System.out.println(cult.jimmy);
		System.out.println(horse.jimmy);
	}
}