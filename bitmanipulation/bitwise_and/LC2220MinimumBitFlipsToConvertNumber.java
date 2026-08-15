package bitmanipulation.bitwise_and;

// Created at: 13-July-2026
// Last revised at: 13-July-2026
// Link: https://leetcode.com/problems/minimum-bit-flips-to-convert-number/

/*
Problem Description:
--------------------
Statement:
Given two integers start and goal, return the minimum number of bit flips
required to convert start into goal.

A bit flip changes either a 0 to 1 or a 1 to 0.

Example:
Input:
start = 10, goal = 7

Output:
3

Explanation:
10 -> 1010
 7 -> 0111

The differing bits are flipped to obtain the goal.

Constraints:
- 0 <= start, goal <= 10^9
*/

/*
Approach 1: Compare Every Bit

Idea:
Check every bit position individually and count how many bits differ.

Time Complexity:
O(32)

Space Complexity:
O(1)

Drawbacks:
Always checks all bit positions even if only a few bits differ.
*/

/*
Approach 2: XOR + Brian Kernighan's Algorithm (Optimized)

Idea:
XOR identifies all differing bits.
Each set bit in the XOR result represents one required flip.

Use Brian Kernighan's algorithm to remove the lowest set bit in every
iteration until the number becomes zero.

Time Complexity:
O(k), where k is the number of set bits.

Space Complexity:
O(1)

Key Insight:
Every set bit in (start ^ goal) corresponds to exactly one required bit flip.
*/

/*
Method to Solve:
----------------
1. Compute XOR of start and goal.
2. Count the set bits in the XOR result.
3. Return the count.
*/

public class LC2220MinimumBitFlipsToConvertNumber {

    /**
     * Returns the minimum number of bit flips required to convert
     * start into goal.
     *
     * @param start starting integer
     * @param goal  target integer
     * @return minimum number of bit flips
     */
    public int minBitFlips(int start, int goal) {

        // bits that differ
        int xor = start ^ goal;

        int flipCount = 0;

        // remove one set bit at a time
        while (xor != 0) {
            flipCount++;
            xor &= (xor - 1);
        }

        return flipCount;
    }
}

// Time Complexity: O(k), where k is the number of set bits in (start ^ goal)
// Space Complexity: O(1)
