package slidingwindow.variable_subarray;

// Created at: 13-August-2026
// Last revised at: 13-August-2026
// Link: https://leetcode.com/problems/length-of-the-longest-subarray-with-at-most-k-frequency/

/*
Problem Description:
--------------------
Statement:
Given an integer array nums and an integer k, find the length of the longest
subarray such that no value appears more than k times in the subarray.

Example:
Input: nums = [1, 2, 3, 1, 2, 3, 1, 2], k = 2
Output: 6

Explanation:
The longest valid subarray is [1, 2, 3, 1, 2, 3].
Each value appears at most 2 times.

Constraints:
- 1 <= nums.length <= 100000
- 1 <= nums[i] <= 100000
- 1 <= k <= nums.length
*/

/*
Approach 1: Brute Force

Idea:
Generate every possible subarray and maintain the frequency of each value.
Reject a subarray as soon as any value appears more than k times.

Time Complexity:
O(n^2)

Space Complexity:
O(n)

Drawbacks:
Many overlapping subarrays are checked repeatedly, making the solution
too slow for large input sizes.
*/

/*
Approach 2: Sliding Window

Idea:
Maintain a window [left, right] where every value appears at most k times.

1. Expand the window by moving right.
2. Add nums[right] to the frequency map.
3. If nums[right] appears more than k times, move left forward until
   the window becomes valid again.
4. Update the maximum window length.

The key insight is that once a frequency exceeds k, shrinking from the left
is enough to restore the window because only the newly added value can have
created the violation.

Time Complexity:
O(n)

Space Complexity:
O(n)

Drawbacks:
Requires a frequency map to track occurrences inside the current window.
*/

/*
Method to Solve:
----------------
1. Initialize left and right pointers at the start of the array.
2. Expand the window by adding nums[right] to the frequency map.
3. If the current value exceeds k occurrences, move left forward.
4. Decrease the frequency of every element removed from the window.
5. Record the maximum valid window length.
6. Continue until right reaches the end of the array.
*/

import java.util.HashMap;
import java.util.Map;

public class LC2958LengthOfLongestSubarrayWithAtMostKFrequency {

    /**
     * Finds the longest subarray where every value appears at most k times.
     *
     * @param nums input integer array
     * @param k    maximum allowed frequency for each value
     * @return length of the longest valid subarray
     */
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];

            freq.put(num, freq.getOrDefault(num, 0) + 1);

            while (freq.get(num) > k) {
                int leftNum = nums[left];
                freq.put(leftNum, freq.get(leftNum) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
