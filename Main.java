import arrays.ArraysOfVishal;
import binarysearch.BinarySearch;
import binarysearch.FindIndexOfTarget;
import sorting.MergeSort;

public class Main {
    public static void main(String[] args) {

        int[] a = new int[] { 1, 2, 3, 4, 7, 8, 9 };

        FindIndexOfTarget obj = new FindIndexOfTarget();
        System.out.println("First: " + obj.find(a, 0, a.length - 1, 5, true));
        System.out.println("Last: " + obj.find(a, 0, a.length - 1, 5, false));

    }
}
