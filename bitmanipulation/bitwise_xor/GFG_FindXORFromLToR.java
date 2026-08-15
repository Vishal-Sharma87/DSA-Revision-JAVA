package bitmanipulation.bitwise_xor;

// Created at: 15-July-2026
// Last revised at: 15-July-2026
// Link: https://www.geeksforgeeks.org/problems/find-xor-of-numbers-from-l-to-r/1

/*
Problem Description:
--------------------
Statement:
Given two integers l and r, find the XOR of all numbers in the range
[l, r].

Example:
Input:
l = 3, r = 8

Output:
11

Constraints:
1 <= l <= r <= 10^9
*/

/*
Approach 1: Brute Force

Idea:
Iterate from l to r and continuously XOR every number.

Time Complexity:
O(r - l + 1)

Space Complexity:
O(1)

Drawbacks:
Too slow for large ranges.
*/

/*
Approach 2: Mathematical Observation

Idea:
The cumulative XOR from 0 to n follows a repeating pattern every four
numbers.

n % 4 == 0 -> n
n % 4 == 1 -> 1
n % 4 == 2 -> n + 1
n % 4 == 3 -> 0

Using this pattern,

XOR(l...r) = XOR(0...r) ^ XOR(0...(l-1))

Time Complexity:
O(1)

Space Complexity:
O(1)

Key Insight:
The cumulative XOR repeats every four values, allowing the answer to be
computed without iterating through the range.
*/

/*
Method to Solve:
----------------
1. Compute XOR from 0 to r.
2. Compute XOR from 0 to l - 1.
3. XOR both results.
4. Return the final answer.
*/

// Time Complexity: O(1)
// Space Complexity: O(1)

public class GFG_FindXORFromLToR {

    /**
     * Computes cumulative XOR from 0 to n.
     *
     * @param n upper limit
     * @return XOR of all numbers from 0 to n
     */
    private int prefixXor(int n) {

        int remainder = n % 4;

        if (remainder == 0)
            return n;

        if (remainder == 1)
            return 1;

        if (remainder == 2)
            return n + 1;

        return 0;
    }

    /**
     * Returns XOR of all numbers in the range [l, r].
     *
     * @param l left boundary
     * @param r right boundary
     * @return XOR of the given range
     */
    public int findXOR(int l, int r) {
        return prefixXor(l - 1) ^ prefixXor(r);
    }
}