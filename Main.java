import arrays.ArraysOfVishal;
import sorting.MergeSort;

public class Main {
    public static void main(String[] args) {

        int[] a = new int[] { 1 };
        MergeSort sort = new MergeSort();
        sort.mergeSort(a, 0, a.length - 1);
        ArraysOfVishal.printArray(a);
    }
}
