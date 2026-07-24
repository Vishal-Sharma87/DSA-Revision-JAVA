// Created at: 25-July-2026
// Last revised at: 25-July-2026
// Link: <problem-link>

/*
Problem Description:
--------------------
Statement:
Given an integer array nums, return the number of distinct XOR values
obtainable by selecting three indices (repetition allowed as defined by
the problem) and computing:

nums[i] ^ nums[j] ^ nums[k]

Example:
Input:
nums = [1,2]

Possible XOR values:
1^1^1 = 1
1^1^2 = 2
1^2^2 = 1

Answer:
2

Constraints:
- 1 <= nums.length <= ...
- XOR value is within the range [0, 2047]
*/

/*
Approach 1: Brute Force

Idea:
Generate every possible triplet and insert its XOR value into a set.

Time Complexity:
O(n³)

Space Complexity:
O(2048)

Drawbacks:
Too slow for large input sizes.
*/

/*
Approach 2: Pair XOR Precomputation (Optimized)

Idea:
First compute every distinct XOR value obtainable using two numbers.
Then XOR each stored pair XOR with every array element to generate all
possible triplet XOR values.

Time Complexity:
O(n² + 2048 × n)

Space Complexity:
O(2048)

Key Insight:
The XOR domain is very small (2048 values), allowing boolean arrays
instead of hash sets.
*/

/*
Method to Solve:
----------------
1. Compute every distinct XOR value of all pairs.
2. Store them in a boolean array.
3. XOR each stored pair XOR with every array element.
4. Track distinct triplet XOR values.
5. Return the total count.
*/

package bitmanipulation.interviewfavourites;

public class LC3514UniqueXorTriplets {

    /**
     * Counts the number of distinct XOR values obtainable from triplets.
     *
     * @param nums input array
     * @return number of distinct triplet XOR values
     */
    public int uniqueXorTriplets(int[] nums) {

        int n = nums.length;

        boolean[] pairXor = new boolean[2048];

        // compute all pair XOR values
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }

        boolean[] tripletXor = new boolean[2048];

        int count = 0;

        // build triplet XOR values
        for (int value : nums) {
            for (int xor = 0; xor < 2048; xor++) {

                if (!pairXor[xor]) {
                    continue;
                }

                int current = xor ^ value;

                if (!tripletXor[current]) {
                    tripletXor[current] = true;
                    count++;
                }
            }
        }

        return count;
    }
}

// Time Complexity: O(n² + 2048 × n)
// Space Complexity: O(2048)