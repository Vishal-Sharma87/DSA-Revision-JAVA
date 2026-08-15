package bitmanipulation.bitwise_and;

// Created at: 06-July-2026
// Last revised at: 06-July-2026
// Link: https://leetcode.com/problems/power-of-two/

/*
Problem Description:
--------------------

Statement:
Given an integer n, determine whether it is a power of two.

Return true if there exists an integer x such that:
n = 2^x

Otherwise, return false.

Example:
Input:
n = 16

Output:
true

Explanation:
16 = 2^4.

Constraints:

* -2^31 <= n <= 2^31 - 1
  */

/*
Approach 1: Repeated Division

Idea:
Continuously divide the number by 2 while it is even. If the final value
becomes 1, then it is a power of two.

Time Complexity:
O(log n)

Space Complexity:
O(1)

Drawbacks:
Requires multiple division operations.
*/

/*
Approach 2: Bit Manipulation (Implemented)

Idea:
A power of two has exactly one set bit in its binary representation.
Subtracting 1 flips all bits after the set bit, so performing
n & (n - 1) clears the only set bit.

If the result becomes 0, the number had exactly one set bit.

Time Complexity:
O(1)

Space Complexity:
O(1)

Key Insight:
For every positive power of two:
n & (n - 1) == 0
*/

/*
Method to Solve:
----------------

1. Reject non-positive numbers.
2. Compute n & (n - 1).
3. Return true if the result is 0.
   */

class LC231PowerOfTwo {

    /**
     * Checks whether the given number is a power of two.
     *
     * @param number input integer
     * @return true if the number is a power of two, otherwise false
     */
    public boolean isPowerOfTwo(int number) {

        if (number <= 0) {
            return false;
        }

        return (number & (number - 1)) == 0;
    }

}

// Time Complexity: O(1)
// Space Complexity: O(1)
