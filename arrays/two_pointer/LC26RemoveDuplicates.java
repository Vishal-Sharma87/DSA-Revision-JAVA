// Created at: 21 August 2026
// Last revised at: 21 August 2026
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

/*
Problem Description:
--------------------
Statement:
Given a sorted integer array nums, remove the duplicates in-place such that
each unique element appears only once.

Return the number of unique elements. The first k elements of the array
should contain the unique values in their original order.

Example:
Input:
nums = [1,1,2]

Output:
2
nums = [1,2,_]

Constraints:
1 <= nums.length <= 3 * 10^4
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.
*/

/*
Approach 1: Extra Array

Idea:
Traverse the array and store every unique element in a separate list or
array. Copy the unique elements back into the original array.

Time Complexity:
O(n)

Space Complexity:
O(n)

Drawbacks:
Uses additional memory.
*/

/*
Approach 2: Two Pointers

Idea:
Maintain two pointers:
- i points to the next position where a unique element should be placed.
- j scans the array.

Whenever nums[j] becomes greater than the previous unique value, move it to
index i and advance both pointers.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Insight:
Since the array is already sorted, every new unique element is greater than
the previous unique element.
*/

/*
Method to Solve:
----------------
1. Handle arrays of size 0 or 1.
2. Store the first element as the previous unique value.
3. Scan the remaining array.
4. Move every new unique value to the next available position.
5. Return the number of unique elements.
*/

// Time Complexity: O(n)
// Space Complexity: O(1)

package arrays.two_pointer;

import arrays.medium.ArraysOfVishal;

public class LC26RemoveDuplicates {

    /**
     * Removes duplicates from the sorted array in-place.
     *
     * @param nums sorted input array
     * @return number of unique elements
     */
    public int solve(int[] nums) {

        if (nums.length <= 1)
            return nums.length;

        // first unique element
        int previousUnique = nums[0];

        // next insertion index and current index
        int i = 1;
        int j = 1;

        while (j < nums.length) {

            // found a new unique value
            if (nums[j] > previousUnique) {
                previousUnique = nums[j];
                ArraysOfVishal.swap(nums, i, j);
                i++;
            }

            j++;
        }

        return i;
    }
}