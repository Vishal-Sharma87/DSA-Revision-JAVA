package slidingwindow.shortest_subarray;

// Created at: 28-August-2026

// Last revised at: 28-August-2026
// Link: https://leetcode.com/problems/shortest-beautiful-substring/

/*
Problem Description:
--------------------
Statement:
Given a binary string s and an integer k, find the shortest substring
that contains exactly k occurrences of '1'.

If multiple shortest substrings exist, return the lexicographically
smallest one.

If no such substring exists, return an empty string.

Example:
Input:
s = "100011001", k = 3

Output:
"11001"

Explanation:
The answer must contain exactly 3 ones and have minimum length.
If multiple substrings have the same minimum length, choose the
lexicographically smallest substring.

Constraints:
- 1 <= s.length <= 100
- s consists only of '0' and '1'
- 1 <= k <= s.length
*/

/*
Approach 1: Brute Force

Idea:
Generate every possible substring and count the number of '1's in it.
Among substrings containing exactly k ones, keep the shortest one.
For equal lengths, keep the lexicographically smaller substring.

Time Complexity:
O(n^3) if every substring is constructed and compared directly.

Space Complexity:
O(n) for storing the current and best substring.

Drawbacks:
Repeatedly generating and checking substrings performs unnecessary work.
The same characters may be examined many times.

*/

/*
Approach 2: Sliding Window

Idea:
Use a sliding window to maintain the number of '1's in the current
window.

1. Expand the window using right.
2. Increment freq whenever a '1' enters the window.
3. Once the window contains at least k ones, move left forward.
4. Stop shrinking when removing the next '1' would make the count
   smaller than k.
5. The resulting window contains exactly k ones and is the smallest
   valid window ending at right.
6. Compare it with the previously stored shortest window.
7. If both have the same length, manually compare their characters
   to find the lexicographically smaller one.

Time Complexity:
O(n^2) worst case because lexicographical comparison can inspect
multiple characters for multiple equal-length candidates.

Space Complexity:
O(1) excluding the returned substring.

Key Insight:
For a fixed right boundary, once the window has exactly k ones,
moving left further would remove a required '1'. Therefore, the
current window is the shortest valid window ending at right.

For lexicographical comparison, because both candidate substrings
have the same length, we only need to find their first different
character. Since the string is binary, the substring starting with
'0' at that position is lexicographically smaller.
*/

/*
Method to Solve:
----------------
1. Start both pointers at the beginning of the string.
2. Expand right and count the number of ones.
3. While freq >= k, move left as far as possible without losing
   the kth '1'.
4. When freq == k, the current window is a valid candidate.
5. Update the answer if this window is shorter.
6. For equal lengths, compare the two windows character by character.
7. Return the stored substring after processing the complete string.
*/

class LC2904ShortestBeautifulSubstring {

    /**
     * Checks whether the current substring is lexicographically
     * smaller than the previously selected substring.
     *
     * @param i start index of the current substring
     * @param j end index of the current substring
     * @param l start index of the previously selected substring
     * @param s input binary string
     * @return true if the current substring is lexicographically smaller
     */
    boolean isLexicographicallySmaller(int i, int j, int l, String s) {
        while (i <= j && s.charAt(i) == s.charAt(l)) {
            i++;
            l++;
        }

        // At the first different character, '0' is smaller than '1'.
        if (i < s.length() && i <= j && s.charAt(i) == '0')
            return true;

        return false;
    }

    /**
     * Finds the shortest substring containing exactly k ones.
     * For equal-length substrings, returns the lexicographically
     * smallest one.
     *
     * @param s binary input string
     * @param k required number of ones
     * @return shortest beautiful substring, or empty string if none exists
     */
    public String shortestBeautifulSubstring(String s, int k) {
        int length = s.length();

        int left = 0;
        int right = 0;

        int start = -1;
        int end = -1;

        int shortest = Integer.MAX_VALUE;
        int freq = 0;

        while (right < length) {
            if (s.charAt(right) == '1')
                freq++;

            // Keep exactly k ones while minimizing the window.
            while (freq >= k) {
                if (s.charAt(left) == '1') {
                    if (freq == k)
                        break;
                    freq--;
                }
                left++;
            }

            if (freq == k) {
                if (right - left + 1 < shortest) {
                    shortest = right - left + 1;
                    start = left;
                    end = right;
                } else if (right - left + 1 == shortest
                        && isLexicographicallySmaller(left, right, start, s)) {
                    start = left;
                    end = right;
                }
            }

            right++;
        }

        if (start == -1)
            return "";

        return s.substring(start, end + 1);
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(1)
