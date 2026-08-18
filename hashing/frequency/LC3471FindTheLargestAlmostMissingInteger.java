package hashing.frequency;

// Created at: 19-August-2026
// Last revised at: 19-August-2026
// Link: https://leetcode.com/problems/find-the-largest-almost-missing-integer/

import java.util.HashMap;
import java.util.Map;

/*
Problem Description:
--------------------
Statement:
Given an integer array nums and an integer k, an integer is called almost missing
if it appears in exactly one subarray of nums of length k.

Return the largest almost missing integer. If no such integer exists, return -1.

Example:
Input: nums = [3,9,2,1,7], k = 3
Output: 9

Constraints:
- 1 <= nums.length <= 50
- 1 <= nums[i] <= 50
- 1 <= k <= nums.length
*/

/*
Approach 1: Brute Force

Idea:
Generate every subarray of length k and count how many such subarrays contain
each integer.

Time Complexity:
O(n * k)

Space Complexity:
O(n)

Drawbacks:
Repeatedly scanning each window is unnecessary. The structure of length-k
windows lets us identify the only possible positions of an almost missing
integer directly.
*/

/*
Approach 2: Frequency + Boundary Observation

Idea:
First count the frequency of every value in the complete array.

If k == n, there is only one subarray, so every distinct value is almost missing.
Therefore, return the largest value in nums.

When k < n, an element can belong to exactly one length-k subarray only when
it occurs at the first or last position of nums. Thus, only nums[0] and
nums[n - 1] need to be considered.

An endpoint value is valid only when its total frequency is exactly one.

For k == 1, every subarray contains one element, so every value with frequency
one is almost missing. Scan the frequency map and return the largest such value.

Time Complexity:
O(n)

Space Complexity:
O(n)

Key Insight:
For k > 1 and k < n, only the two boundary positions can belong to exactly
one length-k subarray. Frequency counting then tells us whether their values
occur only once in the entire array.
*/

/*
Method to Solve:
----------------
1. Build a frequency map for all values in nums.
2. Track the largest value in the array.
3. If k == nums.length, return the largest value.
4. If k > 1, check only the first and last elements.
5. Accept an endpoint only when its frequency is exactly one.
6. If k == 1, return the largest value whose frequency is one.
7. Return -1 when no almost missing integer exists.
*/

public class LC3471FindTheLargestAlmostMissingInteger {

    /**
     * Finds the largest integer that appears in exactly one
     * subarray of length k.
     *
     * @param nums input integer array
     * @param k    length of each subarray
     * @return largest almost missing integer, or -1 if none exists
     */
    public int largestInteger(int[] nums, int k) {
        int length = nums.length;
        int largest = -1;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            largest = Math.max(largest, num);
        }

        if (length == k) {
            return largest;
        }

        if (k > 1) {
            int firstFreq = freq.get(nums[0]);
            int lastFreq = freq.get(nums[length - 1]);

            if (firstFreq == 1 && lastFreq == 1) {
                return Math.max(nums[0], nums[length - 1]);
            }

            if (firstFreq == 1) {
                return nums[0];
            }

            if (lastFreq == 1) {
                return nums[length - 1];
            }

            return -1;
        }

        int largestAlmostMissing = -1;

        for (int num : nums) {
            if (freq.get(num) == 1) {
                largestAlmostMissing = Math.max(largestAlmostMissing, num);
            }
        }

        return largestAlmostMissing;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
