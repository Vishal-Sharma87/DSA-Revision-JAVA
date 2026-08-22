package math.gcd;

// Created at: 22-August-2026
// Last revised at: 22-August-2026
// Link: https://leetcode.com/problems/gcd-of-odd-and-even-sums/description/

/*
Problem Description:
--------------------
Statement:
Given an integer n, find the GCD of the sum of the first n odd numbers and
the sum of the first n even numbers.

Example:
Input:
n = 3

Output:
6

Explanation:
Odd numbers = 1 + 3 + 5 = 9
Even numbers = 2 + 4 + 6 = 12
GCD(9, 12) = 3

Constraints:
1 <= n <= problem constraints
*/

/*
Approach 1: Generate Both Series

Idea:
Generate the first n odd and even numbers separately, compute their sums,
and then calculate their GCD.

Time Complexity:
O(n)

Space Complexity:
O(1)

Drawbacks:
Iterates through every element even though the sums follow arithmetic progression.
*/

/*
Approach 2: Arithmetic Progression Formula (Optimized)

Idea:
The first n odd and even numbers form arithmetic progressions.
Use the AP sum formula to compute both sums in O(1), then apply the
Euclidean Algorithm to find their GCD.

Time Complexity:
O(log(max(sumOdd, sumEven)))

Space Complexity:
O(1)

Key Insight:
Avoid generating the sequences by directly computing their sums using
the arithmetic progression formula.
*/

/*
Method to Solve:
----------------
1. Compute the sum of the first n odd numbers using the AP formula.
2. Compute the sum of the first n even numbers using the AP formula.
3. Compute the GCD of both sums using the Euclidean Algorithm.
4. Return the GCD.
*/

public class LC3658_GCDOfOddEvenSums {

    /**
     * Computes the sum of an arithmetic progression.
     *
     * @param first      first term of the progression
     * @param difference common difference
     * @param total      number of terms
     * @return sum of the arithmetic progression
     */
    public int calculateAPSum(int first, int difference, int total) {

        return (total * ((2 * first) + (total - 1) * difference)) / 2;
    }

    /**
     * Returns the GCD of the sum of the first n odd numbers and
     * the sum of the first n even numbers.
     *
     * @param n number of terms
     * @return greatest common divisor of both sums
     */
    public int gcdOfOddEvenSums(int n) {

        int evenSum = calculateAPSum(2, 2, n);
        int oddSum = calculateAPSum(1, 2, n);

        return findGCD(oddSum, evenSum);
    }

    /**
     * Computes the Greatest Common Divisor using the Euclidean Algorithm.
     *
     * @param a first number
     * @param b second number
     * @return greatest common divisor
     */
    public int findGCD(int a, int b) {

        while (b != 0) {

            // compute next remainder
            int remainder = a % b;

            // move forward
            a = b;
            b = remainder;
        }

        return a;
    }
}

// Time Complexity: O(log(max(sumOdd, sumEven)))
// Space Complexity: O(1)