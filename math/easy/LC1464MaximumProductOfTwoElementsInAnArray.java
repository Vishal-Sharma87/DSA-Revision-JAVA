package math.easy;

// Created at: 28-July-2026
// Last revised at: 28-July-2026
// Link: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

/*
Problem Description:
--------------------
Statement:
Given an integer array nums, choose two different indices i and j such that
(nums[i] - 1) * (nums[j] - 1) is maximized.

Return the maximum possible value.

Example:
Input: nums = [3,4,5,2]
Output: 12

Explanation:
Choose 5 and 4.
(5 - 1) * (4 - 1) = 4 * 3 = 12

Constraints:
2 <= nums.length <= 500
1 <= nums[i] <= 1000
*/

/*
Approach 1: Sorting

Idea:
Sort the array and use the last two elements to compute the answer.

Time Complexity:
O(n log n)

Space Complexity:
O(1) / O(log n) depending on sorting implementation.

Drawbacks:
Sorting is unnecessary since only the largest two elements are required.
*/

/*
Approach 2: One Pass Maximum Tracking (Optimal)

Idea:
Traverse the array once while maintaining the largest and second-largest
elements seen so far. After the traversal, compute the required product.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Insight:
Only the top two values influence the final answer, so sorting can be avoided.
*/

/*
Method to Solve:
----------------
1. Maintain the largest and second-largest elements.
2. Update them while traversing the array once.
3. Return (largest - 1) * (secondLargest - 1).
*/

class LC1464MaximumProductOfTwoElementsInAnArray {

    /**
     * Returns the maximum product after subtracting one from the two
     * largest elements.
     *
     * @param nums input array
     * @return maximum product
     */
    public int maxProduct(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : nums) {

            // update the two largest values
            if (num > second) {
                if (num > first) {
                    second = first;
                    first = num;
                } else {
                    second = num;
                }
            }
        }

        return (first - 1) * (second - 1);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
