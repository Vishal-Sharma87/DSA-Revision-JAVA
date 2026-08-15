package bitmanipulation.bitwise_xor;

// Created at: 16-August-2026
// Last revised at: 16-August-2026
// Link: https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/

/*
Problem Description:
--------------------
Statement:
You are given an integer array nums. Return the length of the longest
subsequence in nums whose bitwise XOR is non-zero. If no such subsequence
exists, return 0.

Example:
Input: nums = [1,2,3]
Output: 2
Explanation: One longest subsequence is [2, 3]. XOR = 2 ^ 3 = 1 (non-zero).

Input: nums = [2,3,4]
Output: 3
Explanation: The longest subsequence is [2, 3, 4]. XOR = 2 ^ 3 ^ 4 = 5 (non-zero).

Constraints:
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9
*/

/*
Approach 1: LIS-style O(n^2) DP (rejected — TLE)
Idea:
Model it like standard LIS: dp[i] = best subsequence length ending at i,
tracking the running xor alongside dp[i]. For each i, scan all previous
j < i and extend from the best dp[j].

Time Complexity:
O(n^2)

Space Complexity:
O(n)

Drawbacks:
n can be up to 10^5, so O(n^2) is ~10^10 ops -> TLE. More fundamentally,
the model is wrong: XOR is not orderable like LIS's numeric comparison,
so there's no monotonic structure to binary-search over, and no
"previous index" needs to be tracked at all — see Approach 2.

Approach 2: Global XOR + zero-count (optimal)
Idea:
XOR is commutative and associative, so the XOR of a subsequence depends
only on which elements are chosen, not their order. That kills the whole
"LIS over order" framing — this is a subset-selection / parity problem,
not a chain-building one.
- If XOR of all n elements is non-zero, take everything: answer = n.
- If XOR of all n elements is zero, dropping any single non-zero element
  flips the total to non-zero, so answer = n - 1 — unless every element
  is 0, in which case no subsequence can ever be non-zero: answer = 0.

Time Complexity:
O(n)

Space Complexity:
O(1)

Drawbacks:
None — this is optimal for the problem's constraints.
*/

class LC3702LongestSubsequenceWithNonZeroBitwiseXOR {

    /*
     * Method to Solve:
     * ----------------
     * 1. Walk the array once, XOR-ing every element into a running total.
     * 2. Track whether any element is non-zero.
     * 3. If the total XOR is non-zero, the full array works: return n.
     * 4. Otherwise, if at least one non-zero element exists, dropping it
     * fixes the parity: return n - 1.
     * 5. Otherwise (all zeros), no non-zero subsequence exists: return 0.
     */

    /**
     * Finds the length of the longest subsequence whose bitwise XOR is non-zero.
     *
     * @param nums input array
     * @return length of the longest subsequence with non-zero XOR
     */
    public int longestSubsequence(int[] nums) {
        int length = nums.length;

        int xor = 0;
        boolean nonZeroPresent = false;

        // accumulate total xor and note if any element can break a zero xor
        for (int num : nums) {
            xor ^= num;
            if (num != 0)
                nonZeroPresent = true;
        }

        if (xor != 0)
            return length;

        return nonZeroPresent ? length - 1 : 0;
    }
}
