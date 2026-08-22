// Created at: 28-January-2026
// Last revised at: 28-January-2026
// Link: https://leetcode.com/problems/reverse-pairs/

package arrays.divide_and_conquer;

/*
Problem Description:
--------------------
Statement:

Given an integer array nums, return the number of reverse pairs.

A reverse pair is a pair (i, j) such that:

1. i < j
2. nums[i] > 2 * nums[j]

Examples:

Input:
nums = [1,3,2,3,1]

Output:
2

Explanation:
Reverse pairs are:
(3,1)
(3,1)

Input:
nums = [2,4,3,5,1]

Output:
3

Constraints:

1 <= nums.length <= 5 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
*/

/*
Approach 1: Brute Force

Idea:
Check every pair (i, j) and count whenever
nums[i] > 2 * nums[j].

Time Complexity:
O(n²)

Space Complexity:
O(1)

Drawbacks:
Too slow for the given constraints.
*/

/*
Approach 2: Merge Sort (Optimal)

Idea:
While merging two sorted halves, count all reverse pairs before the
actual merge.

Since both halves are already sorted:

- Fix an element in the left half.
- Move a pointer through the right half while
  nums[left] > 2 * nums[right].
- Every valid right element contributes one reverse pair.

The right pointer never moves backward, making the counting phase linear.

Important:

Always compare using:

(long) nums[left] > 2 * (long) nums[right]

The multiplication can overflow if performed using int because
nums[i] can be as large as 2^31 - 1.

Casting to long ensures the comparison remains correct.

Time Complexity:
O(n log n)

Space Complexity:
O(n)

Key Insight:
Count reverse pairs before merging because after merging the original
left/right partition no longer exists.
*/

/*
Method to Solve:
----------------
1. Divide the array into two halves.
2. Recursively sort both halves.
3. Count reverse pairs using two pointers.
4. Merge both sorted halves.
5. Return the accumulated count.
*/

public class LC493ReversePairs {

    /**
     * Performs merge sort while counting reverse pairs.
     *
     * @param nums input array
     * @param start starting index
     * @param end ending index
     * @return total reverse pairs
     */
    private int mergeSort(int[] nums, int start, int end) {

        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;

        int count = 0;

        // sort left half
        count += mergeSort(nums, start, mid);

        // sort right half
        count += mergeSort(nums, mid + 1, end);

        // count reverse pairs
        int right = mid + 1;

        for (int left = start; left <= mid; left++) {

            while (right <= end &&
                    (long) nums[left] > 2L * nums[right]) {
                right++;
            }

            count += right - (mid + 1);
        }

        // merge two sorted halves
        int[] merged = new int[end - start + 1];

        int left = start;
        right = mid + 1;
        int index = 0;

        while (left <= mid && right <= end) {

            if (nums[left] <= nums[right]) {
                merged[index++] = nums[left++];
            } else {
                merged[index++] = nums[right++];
            }
        }

        while (left <= mid) {
            merged[index++] = nums[left++];
        }

        while (right <= end) {
            merged[index++] = nums[right++];
        }

        for (int i = 0; i < merged.length; i++) {
            nums[start + i] = merged[i];
        }

        return count;
    }

    /**
     * Returns the number of reverse pairs.
     *
     * @param nums input array
     * @return reverse pair count
     */
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}

// Time Complexity: O(n log n)
// Space Complexity: O(n)
