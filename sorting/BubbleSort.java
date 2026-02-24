package sorting;

import arrays.ArraysOfVishal;

public class BubbleSort {
    public void bubbleSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            boolean swapped = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    ArraysOfVishal.swap(a, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }
}
