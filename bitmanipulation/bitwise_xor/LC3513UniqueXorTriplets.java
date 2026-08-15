package bitmanipulation.bitwise_xor;

// Created at: 24-July-2026
// Last revised at: 24-July-2026
// Link: https://leetcode.com/problems/number-of-unique-xor-triplets-i/

/*
Problem Description:
--------------------
Statement:
You are given an integer array nums of length n, where nums is a permutation
of the numbers in the range [1, n].
A XOR triplet is defined as the XOR of three elements nums[i] XOR nums[j] XOR nums[k]
where i <= j <= k.
Return the number of unique XOR triplet values from all possible triplets (i, j, k).

Example:
Input: nums = [1,2,3]
Output: 4
Explanation: All triplets produce XOR values {0, 1, 2, 3}.

Constraints:
1 <= n == nums.length <= 10^5
1 <= nums[i] <= n
nums is a permutation of integers from 1 to n.
*/

/*
Approach 1: Brute Force
Idea:
Generate every triplet (i, j, k) with i <= j <= k, XOR the three values and
throw them into a set to dedupe.

Time Complexity:
O(n^3)

Space Complexity:
O(n^3) in the worst case for the set of unique XOR values

Drawbacks:
n goes up to 10^5, so n^3 blows past 10^15 operations - TLEs immediately.
Doesn't use the fact that nums is a permutation of [1, n] at all.

Approach 2: Bit-bound counting ★
Idea:
Since nums is a permutation of [1, n], every value is bounded by n. If a
number needs b bits to represent (i.e. n < 2^b), XOR of any combination of
such numbers can never produce a bit higher than b-1 - XOR only combines
existing bits, it never creates a new higher one. So every triplet XOR is
bounded within [0, 2^b - 1], giving an upper bound of 2^b unique values.

That bound turns out to be tight: with repeated indices allowed (i <= j <= k),
every value in [0, 2^b - 1] is actually achievable once n >= 3, since a
"helper" value can always be paired with a repeated element to isolate any
target bit pattern. n = 1 and n = 2 are just too small to have this room, so
they're handled as direct edge cases.

Time Complexity:
O(1) - numberOfLeadingZeros is a constant-time intrinsic

Space Complexity:
O(1)

Drawbacks:
None for this problem's constraints - relies on nums always being exactly
the permutation [1, n], not an arbitrary array.
*/

class LC3513UniqueXorTriplets {

    /**
     * Brute force: enumerate every triplet and collect unique XOR values.
     * Kept for reference - TLEs for n close to 10^5.
     *
     * @param nums permutation of [1, n]
     * @return number of unique XOR triplet values
     */
    public int uniqueXorTripletsBruteForce(int[] nums) {
        int len = nums.length;
        java.util.Set<Integer> uniqueXor = new java.util.HashSet<>();

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                for (int k = j; k < len; k++) {
                    uniqueXor.add(nums[i] ^ nums[j] ^ nums[k]);
                }
            }
        }
        // Time Complexity: O(n^3)
        // Space Complexity: O(n^3)
        return uniqueXor.size();
    }

    /**
     * Optimal: count unique XOR values using only the bit-width of n.
     *
     * @param nums permutation of [1, n]
     * @return number of unique XOR triplet values
     */
    public int uniqueXorTripletsOptimal(int[] nums) {
        int len = nums.length;
        if (len <= 2)
            return len;

        // bits needed to represent len
        int bits = 32 - Integer.numberOfLeadingZeros(len);

        // Time Complexity: O(1)
        // Space Complexity: O(1)
        return 1 << bits;
    }
}