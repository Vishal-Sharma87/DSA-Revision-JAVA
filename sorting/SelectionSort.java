package sorting;

import arrays.ArraysOfVishal;

public class SelectionSort {
    public void selectionSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[minIndex])
                    minIndex = j;
            }
            ArraysOfVishal.swap(a, i, minIndex);
        }
    }
}
