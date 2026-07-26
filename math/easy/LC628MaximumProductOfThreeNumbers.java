package math.easy;

import java.util.Arrays;

// Created at: 27-July-2026
// Last revised at: 27-July-2026
// Link: https://leetcode.com/problems/maximum-product-of-three-numbers/

/*
Problem Description:
--------------------
Statement:
Given an integer array nums, find three numbers whose product is maximum
and return the maximum product.

Example:
Input: nums = [1,2,3]
Output: 6

Input: nums = [-1,-2,-3]
Output: -6

Constraints:
3 <= nums.length <= 10^4
-1000 <= nums[i] <= 1000
*/

/*
Approach 1: Sort + Compare Two Candidates
Idea:
Sort the array. The maximum product of three numbers must come from one of
two places:
  - the three largest numbers (handles all-positive / all-negative cases)
  - the two smallest numbers (could be large-magnitude negatives that cancel
    out to a big positive) multiplied by the single largest number
Take the max of these two candidates.

Time Complexity:
O(n log n) for the sort.

Space Complexity:
O(1) extra (ignoring sort's internal space).

Drawbacks:
None significant for this problem size; an O(n) single-pass approach
tracking top-3 and bottom-2 exists but adds complexity for no real gain
at these constraints.
*/

class LC628MaximumProductOfThreeNumbers {

    /**
     * Finds the maximum product obtainable from any three numbers in the array.
     *
     * @param nums input array of integers
     * @return maximum product of three numbers
     */
    public int maximumProduct(int[] nums) {
        int len = nums.length;

        Arrays.sort(nums);

        // two smallest (could be large negatives) * largest
        int twoSmallestTimesLargest = nums[0] * nums[1] * nums[len - 1];

        // three largest
        int threeLargest = nums[len - 1] * nums[len - 2] * nums[len - 3];

        return Math.max(twoSmallestTimesLargest, threeLargest);
    }
}