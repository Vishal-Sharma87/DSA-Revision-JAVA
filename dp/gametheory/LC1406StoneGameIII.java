package dp.gametheory;

// Created at: 04-August-2026
// Last revised at: 04-August-2026
// Link: https://leetcode.com/problems/stone-game-iii/

/*
Problem Description:
--------------------
Statement:
Alice and Bob are playing a game with a row of stones. Each stone has an
integer value. On each turn, a player can take the first 1, 2, or 3 stones.
Both players play optimally.

Return:
- "Alice" if Alice wins,
- "Bob" if Bob wins,
- "Tie" if both end with the same score.

Example:
Input: [1,2,3,7]
Output: "Bob"

Input: [1,2,3,-9]
Output: "Alice"

Constraints:
- 1 <= stoneValue.length <= 5 * 10^4
- -1000 <= stoneValue[i] <= 1000
*/

/*
Approach 1: Top-Down DP (Memoization)

Idea:
Let dp[i] denote the maximum score difference (current player - opponent)
starting from index i.

Try taking 1, 2, and 3 stones and choose the move that maximizes the score
difference.

Time Complexity:
O(n)

Space Complexity:
O(n)

Drawbacks:
Uses recursion and recursion stack.
*/

/*
Approach 2: Bottom-Up DP (Tabulation)

Idea:
Compute the same score difference iteratively from the end of the array.

For every position, simulate taking 1, 2, or 3 stones and subtract the
opponent's best achievable difference stored in future DP states.

Time Complexity:
O(n)

Space Complexity:
O(n)

Key Insight:
Instead of tracking individual scores of Alice and Bob, storing only the score
difference completely determines the winner.
*/

/*
Method to Solve:
----------------
1. Create a DP array where dp[i] stores the maximum score difference from index i.
2. Traverse from the last stone towards the beginning.
3. At each index, try taking 1, 2, and 3 stones.
4. Subtract the opponent's optimal score difference.
5. Store the maximum achievable difference.
6. Use dp[0] to determine the winner.
*/

class LC1406StoneGameIII {

    /**
     * Determines the winner assuming both players play optimally.
     *
     * @param stoneValue values of the stones
     * @return "Alice", "Bob", or "Tie"
     */
    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            // take one stone
            int current = stoneValue[i];
            int best = current - dp[i + 1];

            // take two stones
            if (i + 1 < n) {
                current += stoneValue[i + 1];
                best = Math.max(best, current - dp[i + 2]);
            }

            // take three stones
            if (i + 2 < n) {
                current += stoneValue[i + 2];
                best = Math.max(best, current - dp[i + 3]);
            }

            dp[i] = best;
        }

        int difference = dp[0];

        if (difference > 0) {
            return "Alice";
        }

        if (difference < 0) {
            return "Bob";
        }

        return "Tie";
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)