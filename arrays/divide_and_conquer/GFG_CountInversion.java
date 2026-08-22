// Created at: 29-Jan-2026
// Last revised at: 29-June-2026
// Link: https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

package arrays.divide_and_conquer;

/*
Problem Description:
--------------------
Statement:
Given an integer array, count the number of inversions present in it.

An inversion is a pair (i, j) such that:

1. i < j
2. arr[i] > arr[j]

Examples:

Input:
arr = [2, 4, 1, 3, 5]

Output:
3

Explanation:
The inversions are:
(2,1)
(4,1)
(4,3)

Input:
arr = [2,3,4,5,6]

Output:
0

Input:
arr = [10,10,10]

Output:
0

Constraints:
1 <= arr.length <= 100000
1 <= arr[i] <= 10000
*/

/*
Approach 1: Brute Force

Idea:
Check every pair (i, j) where i < j and count whenever arr[i] > arr[j].

Time Complexity:
O(n²)

Space Complexity:
O(1)

Drawbacks:
Too slow for n = 100000.
*/

/*
Approach 2: Merge Sort (Optimal)

Idea:
While merging two sorted halves, if an element from the right half is
smaller than an element from the left half, then every remaining element
in the left half also forms an inversion.

Instead of counting one inversion at a time, count all of them together.

Important:
The inversion count can become as large as:

n × (n - 1) / 2

For n = 100000,

100000 × 99999 / 2
= 4,999,950,000

This exceeds the maximum value of Java's int (2,147,483,647).

Therefore, the inversion count must be stored in a long.

Time Complexity:
O(n log n)

Space Complexity:
O(n)

Key Insight:
Merge Sort naturally compares two sorted halves, allowing multiple
inversions to be counted in one comparison.
*/

/*
Method to Solve:
----------------
1. Divide the array into two halves.
2. Recursively sort both halves.
3. Merge the two sorted halves.
4. Whenever an element from the right half is smaller than the current
   left element, count all remaining elements in the left half as inversions.
5. Return the total inversion count.
*/

public class GFG_CountInversion {

    /**
     * Counts inversions while performing merge sort.
     *
     * @param nums  input array
     * @param start starting index
     * @param end   ending index
     * @return total inversion count
     */
    private long mergeSort(int[] nums, int start, int end) {

        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;

        long count = 0;

        // sort left half
        count += mergeSort(nums, start, mid);

        // sort right half
        count += mergeSort(nums, mid + 1, end);

        int[] merged = new int[end - start + 1];

        int left = start;
        int right = mid + 1;
        int index = 0;

        // merge two sorted halves
        while (left <= mid && right <= end) {

            if (nums[left] <= nums[right]) {
                merged[index++] = nums[left++];
            } else {

                // every remaining element in left half is greater
                count += (mid - left + 1);

                merged[index++] = nums[right++];
            }
        }

        // copy remaining left elements
        while (left <= mid) {
            merged[index++] = nums[left++];
        }

        // copy remaining right elements
        while (right <= end) {
            merged[index++] = nums[right++];
        }

        // copy back
        for (int i = 0; i < merged.length; i++) {
            nums[start + i] = merged[i];
        }

        return count;
    }

    /**
     * Returns the inversion count of the array.
     *
     * @param arr input array
     * @return total inversion count
     */
    public long inversionCount(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

}

// Time Complexity: O(n log n)
// Space Complexity: O(n)
