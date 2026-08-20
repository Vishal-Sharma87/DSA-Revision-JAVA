// Created at: 21 August 2026
// Last revised at: 21 August 2026
// Link: https://leetcode.com/problems/merge-sorted-array/

/*
Problem Description:
--------------------
Statement:
You are given two sorted integer arrays nums1 and nums2 along with two integers
m and n representing the number of valid elements in each array.

Merge nums2 into nums1 so that nums1 becomes one sorted array.

The first m elements of nums1 are valid, while the remaining n positions are
reserved for the merged result.

Example:
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6], n = 3

Output:
[1,2,2,3,5,6]

Constraints:
- nums1.length == m + n
- nums2.length == n
- 0 <= m, n <= 200
- -10^9 <= nums1[i], nums2[i] <= 10^9
*/

/*
Approach 1: Extra Array

Idea:
Create a temporary array and merge both arrays into it. Copy the merged result
back into nums1.

Time Complexity:
O(m + n)

Space Complexity:
O(m + n)

Drawbacks:
Uses additional memory.
*/

/*
Approach 2: Shift + In-place Merge (Optimized)

Idea:
Move all valid elements of nums1 to its end.

Now:
- Left side of nums1 becomes empty.
- Shifted nums1 and nums2 behave like two sorted arrays.

Merge both arrays from the beginning and store the answer directly into nums1.

Time Complexity:
O(m + n)

Space Complexity:
O(1)

Key Insight:
Shifting the valid elements creates free space at the beginning, allowing an
in-place merge without overwriting unprocessed values.
*/

/*
Method to Solve:
----------------
1. Handle edge cases.
2. Shift valid elements of nums1 to the end.
3. Merge shifted nums1 and nums2 into nums1.
4. Copy any remaining elements from nums2.
*/

package arrays.traversal;

public class LC88MergeSortedArray {

    /**
     * Merges two sorted arrays into nums1.
     *
     * @param nums1 destination array having extra space
     * @param m     number of valid elements in nums1
     * @param nums2 second sorted array
     * @param n     number of elements in nums2
     * @return void
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int length = nums1.length;

        // nothing to merge
        if (n == 0) {
            return;
        }

        // nums1 is empty
        if (m == 0) {
            for (int i = 0; i < length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        // shift valid elements to the end
        int left = m - 1;
        int right = length - 1;

        while (left >= 0) {
            nums1[right--] = nums1[left--];
        }

        int first = right + 1;
        int second = 0;
        int index = 0;

        // merge both sorted arrays
        while (first < length && second < n) {
            if (nums1[first] <= nums2[second]) {
                nums1[index++] = nums1[first++];
            } else {
                nums1[index++] = nums2[second++];
            }
        }

        // copy remaining elements of nums2
        while (second < n) {
            nums1[index++] = nums2[second++];
        }
    }
}

// Time Complexity: O(m + n)
// Space Complexity: O(1)