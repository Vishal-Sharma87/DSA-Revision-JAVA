package math.enumeration;

// Created at: 22-August-2026
// Last revised at: 22-August-2026
// Link: https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/

/*
Problem Description:
--------------------
Statement:
Given a positive integer n, determine whether n is divisible by the sum
of its digit sum and digit product.

The digit sum is the sum of all digits of n.
The digit product is the product of all digits of n.

Return true if:
n % (digitSum + digitProduct) == 0

Example:
Input: n = 99

Digit sum = 9 + 9 = 18
Digit product = 9 * 9 = 81
18 + 81 = 99

Since 99 % 99 == 0, return true.

Constraints:
1 <= n <= 10^6
*/

/*
Approach 1: Digit Simulation

Idea:
Extract each digit using modulo 10 and division by 10.
Maintain the digit sum and digit product while traversing the number.

After processing all digits, check whether the original number is
divisible by (sum + product).

Time Complexity:
O(log n), where log n represents the number of digits in n.

Space Complexity:
O(1)

Drawbacks / Key Insight:
There is no need to convert n into a string or store its digits.
The modulo and division operations let us process every digit directly
using constant extra space.
*/

/*
Method to Solve:
----------------
1. Store the original number because n is modified while extracting digits.
2. Initialize digit sum to 0 and digit product to 1.
3. Extract the last digit using n % 10.
4. Add the digit to the sum and multiply it into the product.
5. Remove the last digit using n /= 10.
6. Check whether the original number is divisible by sum + product.
*/

// Time Complexity: O(log n)
// Space Complexity: O(1)

public class LC3622CheckDivisibilityByDigitSumAndProduct {

    /**
     * Checks whether a number is divisible by the sum of its digit sum
     * and digit product.
     *
     * @param n positive integer to check
     * @return true if n is divisible by digit sum + digit product
     */
    public boolean checkDivisibility(int n) {
        int num = n;

        int sum = 0;
        int product = 1;

        while (n > 0) {
            int digit = n % 10;

            sum += digit;
            product *= digit;

            n /= 10;
        }

        return num % (sum + product) == 0;
    }
}