package arrays.greedy;

// Created at: 30-August-2026
// Last revised at: 30-August-2026
// Link: https://leetcode.com/problems/removing-minimum-and-maximum-from-array/

/*
Problem Description:
--------------------
Statement:
Given an integer array nums, remove the minimum and maximum elements from the array
using the minimum number of deletions.

A deletion removes an element from either the beginning or the end of the array.

Return the minimum number of deletions required to remove both the minimum and maximum
elements.

Example:
nums = [2, 10, 7, 5, 4, 1, 8, 6]
Minimum = 1, Maximum = 10

Possible minimum deletions:
- Remove both from the left.
- Remove both from the right.
- Remove minimum from one side and maximum from the other.

Answer: 5

Constraints:
- 1 <= nums.length <= 10^5
- -10^5 <= nums[i] <= 10^5
*/

/*
Approach 1: Brute Force

Idea:
Try all possible ways of removing the minimum and maximum elements from
the left and right ends.

For each combination, calculate the number of deletions and keep the minimum.

Time Complexity:
O(n)

Space Complexity:
O(1)

Drawbacks:
Requires careful handling of multiple deletion configurations.
The optimized approach expresses the three possible configurations directly.
*/

/*
Approach 2: Greedy

Idea:
First find the indices of the minimum and maximum elements.

Let:
- left = smaller index of min/max
- right = larger index of min/max

There are only three relevant ways to remove both elements:

1. Remove both from the left:
   Delete through the larger index.
   Cost = right + 1

2. Remove both from the right:
   Delete from the right through the smaller index.
   Cost = length - left

3. Remove one from each side:
   Remove the leftmost target from the left and the rightmost target from the right.
   Cost = (left + 1) + (length - right)

Return the minimum of these three costs.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Insight:
Only the positions of the minimum and maximum matter.
Once their indices are known, there are exactly three deletion patterns to consider.
*/

/*
Method to Solve:
----------------
1. Handle arrays of size 1 or 2 directly.
2. Find the indices of the minimum and maximum values.
3. Normalize their positions using left and right.
4. Calculate deletion cost from both sides.
5. Calculate deletion cost from the left only.
6. Calculate deletion cost from the right only.
7. Return the minimum cost.
*/

public class LC2091RemovingMinimumAndMaximumFromArray {

    /**
     * Finds the minimum number of deletions required to remove
     * both the minimum and maximum elements from the array.
     *
     * @param nums input integer array
     * @return minimum number of deletions required
     */
    public int minimumDeletions(int[] nums) {
        int length = nums.length;

        if (length <= 2) {
            return length;
        }

        int minValueIndex = 0;
        int maxValueIndex = 0;

        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[minValueIndex]) {
                minValueIndex = i;
            }

            if (nums[i] > nums[maxValueIndex]) {
                maxValueIndex = i;
            }
        }

        int left = Math.min(minValueIndex, maxValueIndex);
        int right = Math.max(minValueIndex, maxValueIndex);

        // remove both targets using both sides
        int fromBothSides = (left + 1) + (length - right);

        // remove both targets from the left
        int fromLeftOnly = right + 1;

        // remove both targets from the right
        int fromRightOnly = length - left;

        return Math.min(
                fromBothSides,
                Math.min(fromLeftOnly, fromRightOnly));
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)