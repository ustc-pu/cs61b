public class Foo {
	public int x, y;

	public Foo (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static void switcheroo (Foo a, Foo b) {
		Foo temp = a;
		a = b;
		b = temp;
	}

	public static void fliperoo (Foo a, Foo b) {
		//new temp variable refer to new address
		//similiar to a, but different
		Foo temp = new Foo(a.x, a.y); 
		a.x = b.x;
		a.y = b.y;
		b.x = temp.x;
		b.y = temp.y;
	}

	public static void swapper (Foo a, Foo b) {
		Foo temp = a; // temp is same as a
		a.x = b.x;
		a.y = b.y;
		b.x = temp.x;
		b.y = temp.y;
	}

	public static void main (String[] args) {
		Foo foobar = new Foo(10, 20);
		Foo baz = new Foo(30, 40);
		switcheroo(foobar, baz);
		fliperoo(foobar, baz);
		swapper(foobar, baz);
		System.out.println(foobar.x+"");

	}
}