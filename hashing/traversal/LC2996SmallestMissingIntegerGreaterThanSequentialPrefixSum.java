package hashing.traversal;
// Created at: 12-August-2026

// Last revised at: 12-August-2026
// Link: https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/

import java.util.HashSet;
import java.util.Set;

/*
Problem Description:
--------------------
Statement:
Given an array of positive integers, find the longest sequential prefix where
each element is exactly one greater than the previous element.

Let sequentialSum be the sum of this sequential prefix.

Return the smallest integer greater than or equal to sequentialSum that does
not appear in the array.

Example:
Input: nums = [1,2,3,2,5]
Sequential prefix = [1,2,3]
sequentialSum = 6
6 is not present, so the answer is 6.

Constraints:
- 1 <= nums.length <= 100
- 1 <= nums[i] <= 100
*/

/*
Approach 1: Brute Force

Idea:
Find the sequential prefix and calculate its sum.
Then repeatedly check whether the current candidate exists in the array.

Time Complexity:
O(n * k), where k is the number of candidates checked.

Space Complexity:
O(1)

Drawbacks:
Repeatedly scanning the array to check each candidate can be inefficient.
*/

/*
Approach 2: Hashing + Traversal

Idea:
1. Traverse the array while the elements remain sequential.
2. Calculate the sum of this sequential prefix.
3. Store relevant remaining values in a HashSet.
4. If sequentialSum is absent, return it.
5. Otherwise, keep increasing the candidate until an absent value is found.

Time Complexity:
O(n) average

Space Complexity:
O(n)

Drawbacks:
Uses additional memory for the HashSet.

Key Insight:
Once the sequential prefix sum is known, only values greater than or equal
to that sum can affect the answer.
*/

public class LC2996SmallestMissingIntegerGreaterThanSequentialPrefixSum {

    /*
     * Method to Solve:
     * ----------------
     * 1. Find the longest sequential prefix.
     * 2. Calculate its sum.
     * 3. Store suffix values that can affect the answer in a HashSet.
     * 4. Start from the prefix sum.
     * 5. Increment until a missing value is found.
     */

    // Time Complexity: O(n) average
    // Space Complexity: O(n)

    /**
     * Finds the smallest integer greater than or equal to the sequential
     * prefix sum that is absent from the array.
     *
     * @param nums input array of positive integers
     * @return smallest missing integer greater than or equal to the prefix sum
     */
    public int missingInteger(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0] + 1;
        }

        int sequentialSum = nums[0];
        int i = 1;

        while (i < len && nums[i] == nums[i - 1] + 1) {
            sequentialSum += nums[i];
            i++;
        }

        Set<Integer> present = new HashSet<>();
        present.add(nums[0]);

        while (i < len) {
            if (nums[i] >= sequentialSum) {
                present.add(nums[i]);
            }
            i++;
        }

        if (!present.contains(sequentialSum)) {
            return sequentialSum;
        }

        sequentialSum++;

        while (present.contains(sequentialSum)) {
            sequentialSum++;
        }

        return sequentialSum;
    }
}