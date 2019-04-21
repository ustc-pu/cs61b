public class Horse {
	Horse same;
	String jimmy;

	public Horse(String lee) {
		jimmy = lee;
	}

	public Horse same(Horse horse) {
		if (same != null) {  
			System.out.println("what is the address of this same? "+same);
			System.out.println(same.jimmy);
			Horse same = horse; 
			System.out.println("the address of the local same "+same);
			same.same = horse;  
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
		cult.same = cult;
		cult = cult.same(horse);
		System.out.println(cult.jimmy);
		System.out.println(horse.jimmy);
	}
}