public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if (rest == null) {
			return 1;
		}
		return 1 + this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		IntList p = this;
		int totalSize = 0;
		while (p != null) {
			totalSize += 1;
			p = p.rest;
		}
		return totalSize;
	}

	/** Returns the ith item of this IntList. */
	public int get(int i) {
		if (i == 0) {
			return first;
		}
		return rest.get(i - 1);
	}

	/**return a new IntList and its element is squared using recursion*/
	public static IntList square(IntList list) {
		if (list == null) {
			return list;
		}
		else {
			IntList rest = square(list.rest);
			IntList M = new IntList(list.first * list.first, rest);
			return M;
		}
	}

	/**return a IntList and its element is squared using non recursion*/
	public static IntList squareMutative(IntList list) {
		IntList b = list;
		while(b != null) {
			b.first = b.first * b.first;
			b = b.rest;
		}
		return list;
	}

	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);
		//IntList m = square(L);
		squareMutative(L);
		System.out.println(L.get(2));
	}
} 