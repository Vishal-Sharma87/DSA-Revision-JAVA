import arrays.ArraysOfVishal;
import binarysearch.BinarySearch;
import binarysearch.FindIndexOfTarget;
import binarysearch.LC34FindFirstAndLastOccurrences;
import sorting.MergeSort;

public class Main {
    public static void main(String[] args) {

        int[] a = new int[] { 1, 2, 3, 4, 7, 8, 9 };

        int target = -1;
        int[] range = new LC34FindFirstAndLastOccurrences().searchRange(a, target, 0, a.length - 1);

        System.out.println("Printinf first and last occurneces of " + target);
        for (int val : range) {
            System.out.println(val);
        }

    }
}
