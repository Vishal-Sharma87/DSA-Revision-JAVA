package arrays;

public class ArraysOfVishal {

    public static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    public static void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void reverseArray(int[] nums, int i, int j) {
        if (i >= j)
            return;

        // we are in valid boundary
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

}
