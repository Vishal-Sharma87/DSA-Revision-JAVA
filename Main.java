import arrays.ArraysOfVishal;
import binarysearch.BinarySearch;
import sorting.MergeSort;

public class Main {
    public static void main(String[] args) {

        int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.find(a, 0, a.length - 1, 5, -1));

    }
}
