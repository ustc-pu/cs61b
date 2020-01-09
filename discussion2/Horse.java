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
		the parameter passed is horse (line )
		the current object this is cult, which calls the method
		the this.same is not null because it points to cult instance(line ), 
		it seems like a circle.
		So same.same also refers to cult.

		We then have a local instance same and it points to horse(para passed in)
		same.same is really horse.same, which now ponits to horse itself
		and that is whta if clause does, make its same points to itself
		*/
		if (same != null) {  
			System.out.println("what is the address of this same? " + same);
			System.out.println(same.jimmy);
			Horse same = horse; // the object same refers to horse 38
			System.out.println("the address of the local same " + same);
			same.same = horse;  // horse also becomes a circle
			same = horse.same;
			System.out.println("the address of horse " + horse);
			System.out.println("the address of horse.same " + horse.same);
			System.out.println("the address of the local same " + same);
			System.out.println("the address of same.same " + same.same);
		}
		System.out.println("again, the address of the same is?? " + same);
		System.out.println("and the address of same.same is "+same.same);
		return same.same;  
	}

	public static void main(String[] args) {
		Horse horse = new Horse("youve been");
		System.out.println("the address of horse "+ horse);
		Horse cult = new Horse("horsed");
		System.out.println("the address of cult "+ cult);
		cult.same = cult; // now we have a circle and same refers to cult.
		System.out.println("the address of cult.same "+ cult.same);
		cult = cult.same(horse); // here cult calls the same method
		System.out.println(cult.jimmy);
		System.out.println(horse.jimmy);
	}
}