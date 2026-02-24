package sorting;

import arrays.ArraysOfVishal;

public class QuickSort {
    public void quickSort(int[] array, int i, int j) {
        if (i >= j)
            return;

        // * 1. choice a pivot element (start, end, random) -> going with start
        // going with first element as pivot

        // * 2. get correct pivot index in range i to j;
        int pivotIndex = getCorrectPivotIndexInArray(array, i, j);

        // * 3. swap the pivot element with the array[pivotIndex];
        ArraysOfVishal.swap(array, i, pivotIndex);

        // * 4. make the array balance,
        // ** all the value in range i, pivotIndex - 1 should be smaller and
        // ** all the value in range pivotIndex + 1, j should be greater
        makeArrayBalancedForQuickSort(array, i, j, pivotIndex);

        // * 5. call the left recursion i, pivotIndex - 1
        quickSort(array, i, pivotIndex - 1);

        // * 6. call the right recursion pivotIndex + 1, j
        quickSort(array, pivotIndex + 1, j);
    }

    private void makeArrayBalancedForQuickSort(int[] array, int i, int j, int pivotIndex) {
        int pivot = array[pivotIndex];

        while (i < pivotIndex && j > pivotIndex) {
            if (array[i] > pivot && array[j] < pivot) {
                ArraysOfVishal.swap(array, i, j);
                i++;
                j--;
            } else if (array[i] > pivot) {
                j--;
            } else {
                i++;
            }
        }

    }

    private int getCorrectPivotIndexInArray(int[] array, int i, int j) {
        int pivot = array[i];

        int count = 0;
        for (int k = i + 1; k <= j; k++) {
            if (array[k] < pivot)
                count++;
        }

        return i + count;
    }
}
