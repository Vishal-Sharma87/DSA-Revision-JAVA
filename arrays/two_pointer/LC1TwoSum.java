// Created at: 22 August 2026
// Last revised at: 22 August 2026
// Link: https://leetcode.com/problems/two-sum/

/*
Problem Description:
--------------------
Statement:
Given an integer array nums and an integer target, return the indices of
the two numbers such that they add up to the target.

Each input has exactly one valid solution, and the same element cannot be
used twice.

Example:
Input:
nums = [2,7,11,15], target = 9

Output:
[0,1]

Constraints:
2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
Exactly one valid answer exists.
*/

/*
Approach 1: Brute Force

Idea:
Check every possible pair using two nested loops.

Time Complexity:
O(n²)

Space Complexity:
O(1)

Drawbacks:
Performs unnecessary comparisons and is too slow for large arrays.
*/

/*
Approach 2: HashMap

Idea:
Traverse the array once.

For every number:
1. Compute its required complement.
2. Check whether the complement has already been seen.
3. If found, return both indices.
4. Otherwise, store the current value and its index.

Time Complexity:
O(n)

Space Complexity:
O(n)

Key Insight:
A HashMap provides O(1) average lookup, allowing complements to be found in
a single pass.
*/

/*
Method to Solve:
----------------
1. Create a HashMap to store value-index pairs.
2. Traverse the array.
3. Compute the complement for the current value.
4. If the complement exists, return both indices.
5. Otherwise, store the current element.
*/

// Time Complexity: O(n)
// Space Complexity: O(n)

package arrays.two_pointer;

import java.util.HashMap;

public class LC1TwoSum {

    /**
     * Returns the indices of two numbers whose sum equals the target.
     *
     * @param nums   input array
     * @param target required sum
     * @return indices of the two numbers
     */
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> valueToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            Integer index = valueToIndex.get(complement);

            // complement found
            if (index != null)
                return new int[] { i, index };

            // store current value
            valueToIndex.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}