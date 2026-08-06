package math.enumeration;

// Created at: 06-August-2026
// Last revised at: 06-August-2026
// Link: https://leetcode.com/problems/smallest-divisible-digit-product-i/

/*
Problem Description:
--------------------
Statement:
Given two integers n and t, find the smallest integer greater than or equal to n
whose product of digits is divisible by t.

Example:
Input: n = 10, t = 2
Output: 10

Explanation:
Product of digits = 1 × 0 = 0, and 0 is divisible by 2.

Constraints:
- 1 <= n <= 100
- 1 <= t <= 10
*/

/*
Approach 1: Linear Enumeration

Idea:
Start from n and keep checking each number until its digit product becomes
divisible by t. Compute the digit product by extracting every digit.
If any digit is 0, the product immediately becomes 0, which is divisible
by every positive t.

Time Complexity:
O(k × d)
where k is the number of integers checked and d is the number of digits.

Space Complexity:
O(1)

Key Insight:
Since the constraints are very small, simple enumeration is sufficient and
avoids unnecessary optimizations.
*/

/*
Method to Solve:
----------------
1. Start from n.
2. Compute the product of its digits.
3. If a digit is 0, return true immediately.
4. Check whether the digit product is divisible by t.
5. Otherwise increment n and repeat.
*/

public class LC3345SmallestDivisibleDigitProductI {

    /**
     * Finds the smallest number greater than or equal to n whose
     * digit product is divisible by t.
     *
     * @param n starting number
     * @param t divisor
     * @return smallest valid number
     */
    public int smallestNumber(int n, int t) {

        while (!isDivisible(n, t)) {
            n++;
        }

        return n;
    }

    /**
     * Checks whether the product of digits of a number
     * is divisible by the given divisor.
     *
     * @param num     number to evaluate
     * @param divisor required divisor
     * @return true if divisible, otherwise false
     */
    private boolean isDivisible(int num, int divisor) {

        int product = 1;

        while (num > 0) {

            // extract current digit
            int digit = num % 10;

            // digit product becomes zero
            if (digit == 0) {
                return true;
            }

            product *= digit;
            num /= 10;
        }

        return product % divisor == 0;
    }

}

// Time Complexity: O(k × d)
// Space Complexity: O(1)