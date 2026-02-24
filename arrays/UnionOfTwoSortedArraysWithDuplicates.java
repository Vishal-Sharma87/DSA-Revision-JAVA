package arrays;

import java.util.ArrayList;

public class UnionOfTwoSortedArraysWithDuplicates {
    public static ArrayList<Integer> getUnion(int[] a, int[] b) {
        ArrayList<Integer> union = new ArrayList<>();
        if (a.length == 0 && b.length == 0)
            return union;

        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            int temp;
            if (a[i] == b[j]) {
                insertIfUnique(union, a[i]);
                i++;
                j++;
            } else {
                if (a[i] < b[j]) {
                    temp = a[i];
                    i++;
                } else {
                    temp = b[j];
                    j++;
                }
                insertIfUnique(union, temp);
            }

        }

        while (i < a.length) {
            insertIfUnique(union, a[i]);
            i++;
        }
        while (j < b.length) {
            insertIfUnique(union, b[j]);
            j++;
        }
        return union;
    }
    private static void insertIfUnique(ArrayList<Integer> a, int val) {
        if (a.size() == 0 || a.getLast() != val) {
            a.add(val);
        }
    }


}
