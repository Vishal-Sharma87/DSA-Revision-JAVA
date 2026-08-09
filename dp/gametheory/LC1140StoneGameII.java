package dp.gametheory;

// Created at: 10-August-2026
// Last revised at: 10-August-2026
// Link: https://leetcode.com/problems/stone-game-ii/

/*
Problem Description:
--------------------
Statement:
Alice and Bob play Stone Game II.
There is a row of piles,    and Alice starts the game.

Initially, M = 1.
On each turn, a player can take the first X remaining piles where:
1 <= X <= 2 * M

After taking X piles:
M = max(M, X)

Both players play optimally.

Return the maximum number of stones Alice can collect.

Example:
Input:
piles = [2, 7, 9, 4, 4]

Output:
10

Explanation:
Alice can collect 10 stones when both players play optimally.

Constraints:
1 <= piles.length <= 100
1 <= piles[i] <= 10^4
*/

/*
Approach 1: Brute Force Minimax

Idea:
Try every valid number of piles that the current player can take.
Recursively calculate the opponent's best result for every choice.

The same states are reached repeatedly, making plain recursion
exponential.

Time Complexity:
O(2^n) in the worst case.

Space Complexity:
O(n) recursion stack.

Drawbacks:
Many states are recalculated.
The solution becomes inefficient as the number of piles grows.
*/

/*
Approach 2: Top-Down DP with Score Difference

Idea:
Define recursion(index, M) as the maximum score difference
the current player can achieve from index onward.

For every possible number of piles X:
1. Take the next X piles.
2. Update M as max(M, X).
3. Let the opponent obtain their best score difference.
4. Current player's difference becomes:
   current stones - opponent's difference.

Choose the maximum difference among all valid choices.

After calculating the overall score difference:
Alice's score can be recovered using:

Alice = (total stones + score difference) / 2

Time Complexity:
O(n^3)

Space Complexity:
O(n^2)

Key Insight:
Instead of directly calculating Alice's final score,
calculate the score difference between the current player
and the opponent.

This makes the alternating turns naturally fit into:

current gain - opponent's best difference.
*/

public class LC1140StoneGameII {

    /**
     * Calculates the maximum score difference the current player
     * can achieve from the given state.
     *
     * @param index current starting index in the piles
     * @param M     current maximum take parameter
     * @param piles input array of stone piles
     * @param dp    memoization table for previously solved states
     * @return maximum score difference for the current player
     */
    private int recursion(int index, int M, int[] piles, Integer[][] dp) {
        if (index >= piles.length) {
            return 0;
        }

        if (dp[index][M] != null) {
            return dp[index][M];
        }

        int current = 0;
        int maxi = Integer.MIN_VALUE;

        int allowed = index + (2 * M);

        for (int i = index; i < Math.min(piles.length, allowed); i++) {
            current += piles[i];

            // update M after taking the current number of piles
            int nextM = Math.max(M, i - index + 1);

            int currBest = current
                    - recursion(i + 1, nextM, piles, dp);

            maxi = Math.max(maxi, currBest);
        }

        return dp[index][M] = maxi;
    }

    /**
     * Finds the maximum number of stones Alice can collect
     * when both players play optimally.
     *
     * @param piles array containing the number of stones in each pile
     * @return maximum number of stones Alice can collect
     */
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int sum = 0;

        for (int pile : piles) {
            sum += pile;
        }

        int diff = recursion(
                0,
                1,
                piles,
                new Integer[len + 1][len + 1]);

        return (sum + diff) / 2;
    }
}

// Time Complexity: O(n^3)
// Space Complexity: O(n^2)