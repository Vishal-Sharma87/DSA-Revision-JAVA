package sorting.medium;

// Created at: 29-July-2026
// Last revised at: 29-July-2026
// Link: <LeetCode 3517 Problem Link>

import java.util.Arrays;

/*
Problem Description:
--------------------
Statement:
Given a palindromic string, rearrange its characters to form the
lexicographically smallest possible palindrome.

Example:
Input:
s = "caaac"

Output:
"acaca"

Constraints:
- The input string is already a palindrome.
- The resulting string must also be a palindrome.
*/

/*
Approach 1: Generate All Palindromes

Idea:
Generate every possible palindrome and return the smallest one.

Time Complexity:
O(k!)

Space Complexity:
O(k!)

Drawbacks:
Completely impractical because of the enormous number of permutations.
*/

/*
Approach 2: Sort Left Half (Optimal)

Idea:
Only the left half determines the entire palindrome.
Sort the left half, keep the middle character unchanged (if present),
and mirror the sorted half to construct the answer.

Time Complexity:
O(n log n)

Space Complexity:
O(n)

Key Insight:
Since the input is already a palindrome, sorting only one half is enough
to obtain the lexicographically smallest valid palindrome.
*/

/*
Method to Solve:
----------------
1. Extract the left half of the palindrome.
2. Sort the left half.
3. Copy it into the answer.
4. Append the middle character for odd-length strings.
5. Mirror the left half in reverse order.
6. Return the constructed string.
*/

public class LC3517SmallestPalindrome {

    /**
     * Returns the lexicographically smallest palindrome.
     *
     * @param s input palindrome
     * @return smallest possible palindrome
     */
    public String smallestPalindrome(String s) {
        int length = s.length();

        char[] leftHalf = extractLeftHalf(s);
        Arrays.sort(leftHalf);

        char[] result = new char[length];
        int index = 0;

        // build left half
        for (char ch : leftHalf) {
            result[index++] = ch;
        }

        // place middle character
        if ((length & 1) == 1) {
            result[index++] = s.charAt(length >> 1);
        }

        // mirror left half
        for (int i = leftHalf.length - 1; i >= 0; i--) {
            result[index++] = leftHalf[i];
        }

        return new String(result);
    }

    /**
     * Extracts the left half of the palindrome.
     *
     * @param s input palindrome
     * @return left half as a character array
     */
    private char[] extractLeftHalf(String s) {
        return s.substring(0, s.length() >> 1).toCharArray();
    }
}

// Time Complexity: O(n log n)
// Space Complexity: O(n)