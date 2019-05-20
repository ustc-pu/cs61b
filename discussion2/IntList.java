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

	public void addLast(int x) {
		IntList list = this;
		if(list.rest == null) {
			list.rest = new IntList(x, null);
		}
		else{
			list.rest.addLast(x);
		}
	}

	/**simplified version of square*/
	public static IntList squareList(IntList list) {
		if (list == null) {
			return list;
		}
		else{
			return new IntList(list.first*list.first, squareList(list.rest));
		}
	}

	/**return a new IntList and its element is squared using non recursion*/
	public static IntList squareIteration(IntList list) {
		if(list == null) {
			return list;
		}
		IntList res = new IntList(list.first * list.first, null);
		IntList ptr = res;
		list = list.rest;
		while(list != null) {
			ptr.rest = new IntList(list.first * list.first, null);
			ptr = ptr.rest;
			list = list.rest;
		}
		return res;
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
		IntList m = squareIteration(L);
		//squareMutative(L);
		L.addLast(23);
		L.addLast(19);
		System.out.println(L.get(4));
	}
} 