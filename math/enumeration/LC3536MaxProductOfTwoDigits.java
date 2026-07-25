package math.enumeration;

// Created at: 26-July-2026
// Last revised at: 26-July-2026
// Link: https://leetcode.com/problems/max-product-of-two-digits/

/*
Problem Description:
--------------------
Statement:
Given a positive integer n, return the product of the two largest digits in the number.

Example:
Input: n = 4312
Output: 12

Explanation:
The two largest digits are 4 and 3, so the product is 4 × 3 = 12.

Constraints:
- 10 <= n <= 10^9
*/

/*
Approach 1: Enumeration

Idea:
Iterate through every digit of the number while maintaining the largest and
second-largest digits seen so far. After processing all digits, return the
product of these two digits.

Time Complexity:
O(d), where d is the number of digits.

Space Complexity:
O(1)

Key Insight:
The answer can be obtained in a single pass by keeping track of only the two
largest digits encountered.
*/

/*
Method to Solve:
----------------
1. Initialize variables to store the largest and second-largest digits.
2. Extract each digit using modulo operation.
3. Update the two maximum digits accordingly.
4. Remove the processed digit by dividing the number by 10.
5. Return the product of the two largest digits.
*/

class LC3536MaxProductOfTwoDigits {

    /**
     * Returns the product of the two largest digits in the given number.
     *
     * @param n input number
     * @return product of the two largest digits
     */
    public int maxProduct(int n) {
        int first = -1;
        int second = -1;

        while (n > 0) {
            int digit = n % 10;

            // update the two largest digits
            if (digit > second) {
                if (digit > first) {
                    second = first;
                    first = digit;
                } else {
                    second = digit;
                }
            }

            // process the next digit
            n /= 10;
        }

        return first * second;
    }
}

// Time Complexity: O(d)
// Space Complexity: O(1)