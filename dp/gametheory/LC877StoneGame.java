package dp.gametheory;

// Created at: 03-August-2026
// Last revised at: 03-August-2026
// Link: https://leetcode.com/problems/stone-game/

import java.util.Arrays;

/*
Problem Description:
--------------------
Statement:
Alice and Bob play a game with piles of stones. There are an even number of
piles arranged in a row, and each pile has a positive integer number of
stones. The total number of stones across all piles is odd, so there are
no ties.

Alice and Bob take turns, with Alice starting first. Each turn, a player
takes the entire pile from either the beginning or the end of the row.
This continues until there are no more piles left, at which point the
person with the most stones wins.

Assuming Alice and Bob play optimally, return true if Alice wins, or
false if Bob wins.

Example:
Input: piles = [5,3,4,5]
Output: true
Explanation: Alice can force a total of 13 stones vs Bob's 4, so she wins.

Constraints:
2 <= piles.length <= 500
piles.length is even
1 <= piles[i] <= 500
sum(piles) is odd
*/

/*
Approach 1: Recursion + Memoization
Idea:
Model the game as a single recursive function instead of tracking two
players' scores separately. f(i, j) returns the maximum score
difference (current picker's stones - opponent's stones) achievable on
the subarray piles[i..j]. The picker chooses whichever end maximizes
their own advantage; whatever the opponent nets on the remaining range
directly subtracts from the picker's advantage, since it's the
opponent's gain relative to the picker.

Time Complexity:
O(n^2) - one state per (i, j) pair, O(1) work per state after memoization.

Space Complexity:
O(n^2) for the memo table + O(n) recursion stack.

Drawbacks:
Extra recursion stack overhead vs. the tabulated version; not an issue
at n <= 500, but tabulation avoids it and is preferred at scale.
*/

/*
Approach 2: Bottom-Up Tabulation (Space Optimized) ★
Idea:
Same recurrence as Approach 1, filled iteratively instead of
recursively. Since f(i, j) depends only on f(i+1, j) (previous row)
and f(i, j-1) (same row, earlier column), the full 2D table collapses
to two 1D rows: prev (row i+1) and curr (row i), swapped after each
outer iteration.

Time Complexity:
O(n^2)

Space Complexity:
O(n) - two rolling arrays instead of a full n x n table.

Drawbacks:
None for this problem size; loses the full table if intermediate
states ever need to be inspected for debugging, so Approach 1 is
easier to trace during development.
*/

public class LC877StoneGame {

    /**
     * Determines whether the first player can force a win in the stone game.
     *
     * @param piles number of stones in each pile, taken from either end
     * @return true if the first player wins with optimal play from both sides
     */
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[] prev = new int[len + 1];
        int[] curr = new int[len + 1];

        // curr represents row i, prev represents row i+1
        for (int i = len - 1; i >= 0; i--) {
            Arrays.fill(curr, 0);
            curr[i] = piles[i];

            for (int j = i + 1; j < len; j++) {
                // take piles[i]; opponent then plays optimally on i+1..j
                int pickI = piles[i] - prev[j];
                // take piles[j]; opponent then plays optimally on i..j-1
                int pickJ = piles[j] - curr[j - 1];

                curr[j] = Math.max(pickI, pickJ);
            }

            // shift row i into prev for the next iteration (row i-1)
            int[] temp = curr;
            curr = prev;
            prev = temp;
        }

        return prev[len - 1] > 0;
    }

    /**
     * Recursive helper computing the max score difference achievable by the
     * player to move on the subarray piles[i..j].
     *
     * @param i     left boundary of the remaining subarray
     * @param j     right boundary of the remaining subarray
     * @param piles original pile values
     * @param dp    memo table caching computed (i, j) results
     * @return max (picker's stones - opponent's stones) achievable on piles[i..j]
     */
    int maximize(int i, int j, int[] piles, Integer[][] dp) {
        if (i == j)
            return piles[i];

        if (dp[i][j] != null)
            return dp[i][j];

        // take left end; opponent optimizes on i+1..j next
        int pickI = piles[i] - maximize(i + 1, j, piles, dp);
        // take right end; opponent optimizes on i..j-1 next
        int pickJ = piles[j] - maximize(i, j - 1, piles, dp);

        return dp[i][j] = Math.max(pickI, pickJ);
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(n) [tabulated] / O(n^2) [memoized]
