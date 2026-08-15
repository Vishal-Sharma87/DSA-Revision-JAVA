package bitmanipulation.bitwise_and;

// Created at: 08-July-2026
// Last revised at: 08-July-2026
// Link: https://leetcode.com/problems/number-of-1-bits/

/*
Problem Description:
--------------------
Statement:
Given a positive integer n, return the number of set bits (1's) present in its
binary representation.

Example:
Input:
n = 11

Output:
3

Explanation:
11 = 1011₂
It contains three set bits.

Constraints:
- 1 <= n <= 2^31 - 1
*/

/*
Approach 1: Bit-by-Bit Traversal

Idea:
Check the least significant bit using (n & 1), count it if set, then right shift
the number until it becomes zero.

Time Complexity:
O(number of bits)

Space Complexity:
O(1)

Drawbacks:
Visits every bit even if only a few bits are set.
*/

/*
Approach 2: Brian Kernighan's Algorithm (Optimal)

Idea:
Every operation:
    n = n & (n - 1)
removes the rightmost set bit from the number.

Repeat until the number becomes zero.
The number of iterations equals the number of set bits.

Time Complexity:
O(number of set bits)

Space Complexity:
O(1)

Key Insight:
Instead of checking every bit, directly remove one set bit in each iteration,
making the algorithm faster for sparse binary representations.
*/

/*
Method to Solve:
----------------
1. Initialize the set bit counter.
2. While the number is non-zero:
   - Remove the rightmost set bit.
   - Increment the counter.
3. Return the total count.
*/

public class LC191NumberOf1Bits {

    /**
     * Counts the number of set bits in the binary representation.
     *
     * @param n input integer
     * @return number of set bits
     */
    public int hammingWeight(int n) {

        int setBitCount = 0;

        while (n > 0) {

            // remove the rightmost set bit
            n &= (n - 1);
            setBitCount++;
        }

        return setBitCount;
    }
}

// Time Complexity: O(number of set bits)
// Space Complexity: O(1)