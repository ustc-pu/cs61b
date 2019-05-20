public class replicateSolution {

	public static int[] replicate(int[] arr) {
		int sum = 0;
		for(int items : arr) {
			sum = sum + items;
		}
		int[] temp = new int[sum];

		int i = 0;
		for(int items : arr) {
			for(int j = 0; j < items; j++) {
				temp[i] = items;
				i = i + 1;
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		int[] arr = {3,2,1};
		int[] newArr = replicate(arr);
		for(int items : newArr) {
			System.out.println(items);
		}
	}
}