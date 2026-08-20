package arrays.two_pointer;

// Created at: 21 August 2026
// Last revised at: 21 August 2026
// Link: https://leetcode.com/problems/move-zeroes/

/*
Problem Description:
--------------------
Statement:
Given an integer array nums, move all 0's to the end of the array while maintaining
the relative order of the non-zero elements. Perform the operation in-place.

Example:
Input:
nums = [0, 1, 0, 3, 12]

Output:
[1, 3, 12, 0, 0]

Constraints:
- 1 <= nums.length <= 10^4
- -2^31 <= nums[i] <= 2^31 - 1
*/

/*
Approach 1: Extra Array

Idea:
Store all non-zero elements in a temporary array, append all zeroes,
and copy the result back to the original array.

Time Complexity:
O(n)

Space Complexity:
O(n)

Drawbacks:
Requires additional memory proportional to the array size.
*/

/*
Approach 2: Two Pointers (Optimal)

Idea:
Maintain the position where the next non-zero element should be placed.
Traverse the array once and swap every non-zero element into its correct position.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Insight:
Each non-zero element is moved at most once while preserving the relative order.
*/

/*
Method to Solve:
----------------
1. Initialize a pointer for the next non-zero position.
2. Traverse the array from left to right.
3. Whenever a non-zero element is found, swap it with the next available position.
4. Increment the non-zero pointer.
5. Continue until the entire array is processed.
*/

// Time Complexity: O(n)
// Space Complexity: O(1)

public class LC283MoveZeroes {

    /**
     * Moves all zeroes to the end while maintaining the relative order
     * of non-zero elements.
     *
     * @param nums input array
     * @return void
     */
    public void solve(int[] nums) {

        if (nums.length == 0) {
            return;
        }

        int nextNonZeroIndex = 0;

        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {

            if (nums[currentIndex] != 0) {
                swap(nums, nextNonZeroIndex, currentIndex);
                nextNonZeroIndex++;
            }
        }
    }

    /**
     * Swaps two elements in the array.
     *
     * @param nums   input array
     * @param first  first index
     * @param second second index
     * @return void
     */
    private void swap(int[] nums, int first, int second) {

        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}