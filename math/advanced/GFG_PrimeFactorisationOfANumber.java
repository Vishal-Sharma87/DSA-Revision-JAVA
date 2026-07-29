package math.advanced;

// Created at: 24-July-2026
// Last revised at: 24-July-2026
// Link: https://www.geeksforgeeks.org/problems/prime-factor-of-a-number/1

/*
Problem Description:
--------------------
Statement:
Given an integer array queries of length n, return the prime factorization
of every number in sorted order.

Example:
Input:
queries = [2, 3, 4, 5, 6]

Output:
[[2], [3], [2,2], [5], [2,3]]

Constraints:
- 1 <= queries.length
- Each query is a positive integer.
*/

/*
Approach 1: Trial Division

Idea:
For every number, try dividing it by every integer starting from 2 up to √n.
Whenever a divisor is found, keep dividing until it is no longer divisible.
If the remaining value is greater than 1, it is itself a prime factor.

Time Complexity:
O(√N) per query

Space Complexity:
O(k)
where k is the number of prime factors.

Key Insight:
Every composite number has at least one factor less than or equal to √N.
After removing all smaller factors, any remaining number must be prime.
*/

/*
Method to Solve:
----------------
1. Iterate through every query.
2. For each number, check divisibility from 2 to √n.
3. Keep dividing while the divisor divides the number.
4. Store every prime factor.
5. If a value greater than 1 remains, store it as the last prime factor.
6. Return the list of prime factorizations.
*/

import java.util.*;

class GFG_PrimeFactorisationOfANumber {

    /**
     * Returns the prime factorization of a number.
     *
     * @param n input number
     * @return list of prime factors in sorted order
     */
    public List<Integer> primeFactors(int n) {

        List<Integer> factors = new ArrayList<>();

        for (int divisor = 2; divisor * divisor <= n; divisor++) {

            // collect all occurrences of the current prime
            while (n % divisor == 0) {
                factors.add(divisor);
                n /= divisor;
            }
        }

        // remaining value is prime
        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }

    /**
     * Computes prime factorization for every query.
     *
     * @param queries array of numbers
     * @return list containing prime factors for every number
     */
    public List<List<Integer>> primeFactors(int[] queries) {

        List<List<Integer>> answer = new ArrayList<>();

        for (int number : queries) {
            answer.add(primeFactors(number));
        }

        return answer;
    }
}

// Time Complexity: O(Q × √N)
// Space Complexity: O(total prime factors)