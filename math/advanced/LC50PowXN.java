package math.advanced;

// Created at: 30-July-2026
// Last revised at: 30-July-2026
// Link: https://leetcode.com/problems/powx-n/

/*
Problem Description:
--------------------
Statement:
Implement pow(x, n), which calculates x raised to the power n (x^n).

Example:
Input: x = 2.00000, n = 10
Output: 1024.00000

Input: x = 2.10000, n = 3
Output: 9.26100

Input: x = 2.00000, n = -2
Output: 0.25000

Constraints:
-100.0 < x < 100.0
-2^31 <= n <= 2^31 - 1
-10^4 <= x^n <= 10^4
*/

/*
Approach 1: Linear Multiplication

Idea:
Multiply x exactly n times.

Time Complexity:
O(n)

Space Complexity:
O(1)

Drawbacks:
Too slow for very large exponents.
*/

/*
Approach 2: Binary Exponentiation (Optimal)

Idea:
Use the binary representation of the exponent.
Whenever the current bit is set, multiply the answer by the current base.
Square the base after processing every bit and halve the exponent.

Time Complexity:
O(log n)

Space Complexity:
O(1)

Key Insight:
Every squaring doubles the exponent represented by the current base, reducing
the number of multiplications dramatically.
*/

/*
Method to Solve:
----------------
1. Convert the exponent to long to safely handle Integer.MIN_VALUE.
2. Store its absolute value if the exponent is negative.
3. Repeatedly process bits of the exponent.
4. Multiply the answer when the current bit is set.
5. Square the base after every iteration.
6. If the original exponent was negative, return its reciprocal.
*/

// Time Complexity: O(log n)
// Space Complexity: O(1)

public class LC50PowXN {

    /**
     * Computes x raised to the power n.
     *
     * @param x base value
     * @param n exponent
     * @return x raised to the power n
     */
    public double myPow(double x, int n) {
        long power = n;

        if (power < 0) {
            power = -power;
        }

        double answer = 1.0;

        while (power > 0) {

            // multiply when current bit is set
            if ((power & 1) == 1) {
                answer *= x;
                power--;
            } else {

                // move to next power of two
                x *= x;
                power >>= 1;
            }
        }

        return n < 0 ? 1.0 / answer : answer;
    }
}