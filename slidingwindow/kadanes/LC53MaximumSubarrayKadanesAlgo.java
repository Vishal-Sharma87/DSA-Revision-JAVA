// Created at: 22-January-2026
// Last revised at: 22-January-2026
// Link: https://leetcode.com/problems/maximum-subarray/

/*
Problem Description:
--------------------
Statement:
Given an integer array nums, find the contiguous subarray having the largest
sum and return its sum.

Example:
Input:
nums = [-2,1,-3,4,-1,2,1,-5,4]

Output:
6

Explanation:
The subarray [4,-1,2,1] has the maximum sum.

Constraints:
- 1 <= nums.length <= 10^5
- -10^4 <= nums[i] <= 10^4
*/

/*
Approach 1: Brute Force

Idea:
Generate every possible subarray and compute its sum.

Time Complexity:
O(n²)

Space Complexity:
O(1)

Drawbacks:
Too slow for large inputs.
*/

/*
Approach 2: Kadane's Algorithm (Optimal)

Idea:
Maintain the maximum subarray sum ending at the current index.
Whenever the running sum becomes negative, discard it and start a new subarray.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Insight:
A negative running sum can never improve the answer for future elements.
*/

/*
Method to Solve:
----------------
1. Maintain a running sum.
2. Update the maximum answer after every addition.
3. Reset the running sum whenever it becomes negative.
4. Continue until the end of the array.
*/

package slidingwindow.kadanes;

public class LC53MaximumSubarrayKadanesAlgo {

    /**
     * Returns the maximum subarray sum using Kadane's Algorithm.
     *
     * @param nums input array
     * @return maximum subarray sum
     */
    public int maxSubArray(int[] nums) {

        int currentSum = 0;
        int maximumSum = Integer.MIN_VALUE;

        for (int number : nums) {

            currentSum += number;
            maximumSum = Math.max(maximumSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maximumSum;
    }

    /**
     * Prints one maximum sum subarray.
     *
     * @param nums input array
     * @return void
     */
    public void printMaximumSumSubArray(int[] nums) {

        if (nums.length == 0) {
            return;
        }

        int currentSum = 0;
        int maximumSum = Integer.MIN_VALUE;

        int temporaryStart = 0;
        int start = 0;
        int end = 0;

        for (int index = 0; index < nums.length; index++) {

            if (currentSum == 0) {
                temporaryStart = index;
            }

            currentSum += nums[index];

            if (currentSum > maximumSum) {
                maximumSum = currentSum;
                start = temporaryStart;
                end = index;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        System.out.println("Printing subarray with maximum sum:");

        for (int index = start; index <= end; index++) {
            System.out.print(nums[index] + " ");
        }

        System.out.println();
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
}