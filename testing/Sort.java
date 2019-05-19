public class Sort {
    public static void sort(String[] x) {
        //find the smallest item
        //swap the first item and smallest item
        //sort the rest items
        sort(x,0);
    }

    public static int findSmallest(String[] x, int start) {
        int smallIndex = start;
        for(int i = start + 1; i < x.length; i = i + 1) {
            int result = x[smallIndex].compareTo(x[i]);
            if(result > 0) {
                smallIndex = i;
            }
        }
        return smallIndex;
    }

    public static void swap(String[] x, int i, int j) {
        String temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

    private static void sort(String[] x, int start) {
        if (start == x.length) {
            return ;
        }
        int smallIndex = findSmallest(x, start);
        swap(x, start, smallIndex);
        sort(x, start + 1);
    }
}
