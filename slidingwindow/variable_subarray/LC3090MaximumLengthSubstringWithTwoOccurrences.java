package slidingwindow.variable_subarray;

// Created at: 14-August-2026
// Last revised at: 14-August-2026
// Link: https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/

/*
Problem Description:
--------------------
Statement:
Given a string s, find the length of the longest substring in which
each character appears at most twice.

Example:
Input: s = "bcbbbcba"
Output: 4

Explanation:
The longest valid substring is "bcbb", where each character appears
at most twice.

Constraints:
- 2 <= s.length <= 100
- s consists only of lowercase English letters.
*/

/*
Approach 1: Brute Force

Idea:
Generate every substring and count character frequencies.
Keep the longest substring where no character appears more than twice.

Time Complexity:
O(n^2)

Space Complexity:
O(1)

Drawbacks:
Checking all substrings is inefficient for larger strings.
*/

/*
Approach 2: Sliding Window

Idea:
Maintain a window [left, right] where every character appears at most
twice.

Expand the window by moving right. If the newly added character appears
more than twice, move left forward until the window becomes valid again.

Track the maximum valid window length.

Time Complexity:
O(n)

Space Complexity:
O(1)

Drawbacks / Key Insight:
Each character is added and removed from the window at most once.
The fixed-size frequency array keeps the extra space constant.
*/

/*
Method to Solve:
----------------
1. Create a frequency array for the 26 lowercase English letters.
2. Expand the window by moving right.
3. Increase the frequency of the current character.
4. If its frequency becomes greater than 2, move left until valid.
5. Update the maximum window length.
6. Return the maximum length found.
*/

public class LC3090MaximumLengthSubstringWithTwoOccurrences {

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    /**
     * Finds the longest substring where every character appears at most twice.
     *
     * @param s input string containing lowercase English letters
     * @return length of the longest valid substring
     */
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];

        int left = 0;
        int maxi = 0;

        for (int right = 0; right < s.length(); right++) {
            int current = s.charAt(right) - 'a';
            freq[current]++;

            while (freq[current] > 2) {
                int removed = s.charAt(left) - 'a';
                freq[removed]--;
                left++;
            }

            maxi = Math.max(maxi, right - left + 1);
        }

        return maxi;
    }
}