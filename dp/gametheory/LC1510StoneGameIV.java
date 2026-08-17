package dp.gametheory;

// Created at: 11-August-2026
// Last revised at: 11-August-2026
// Link: https://leetcode.com/problems/stone-game-iv/description/

/*
Problem Description:
--------------------
Statement:
Alice and Bob take turns removing a perfect square number of stones
from a pile containing n stones.

On each turn, a player must remove a non-zero perfect square.
The player who cannot make a move loses.

Return true if Alice can win assuming both players play optimally.

Example:
Input: n = 7
Output: false

Explanation:
The possible moves are 1 and 4.
For every move Alice makes, Bob can respond with a winning position.

Constraints:
1 <= n <= 10^5
*/

/*
Approach 1: Recursion + Memoization

Idea:
------
Treat each remaining number as a game state.

A player can win from `remaining` if there exists a perfect square
such that the opponent loses after that square is removed.

Store already-computed states in a memo array to avoid repeated work.

Time Complexity:
O(n * sqrt(n))

Space Complexity:
O(n)

Drawbacks:
Uses recursion and therefore adds call-stack overhead.
The bottom-up approach avoids recursion while keeping the same
time and space complexity.
*/

/*
Approach 2: Dynamic Programming - Bottom Up

Idea:
------
Let dp[x] represent whether the current player can win when
there are x stones remaining.

For every state `remaining`, try removing every possible perfect square.

If:
    dp[remaining - square] == false

then the opponent is placed in a losing state, so the current player
can win.

Therefore:
    dp[remaining] = true

If no perfect square leads to a losing state, then:
    dp[remaining] = false

Base Case:
dp[0] = false

There are no stones left, so the player whose turn it is cannot move.

Time Complexity:
O(n * sqrt(n))

Space Complexity:
O(n)

Key Insight:
A winning state exists if at least one move leads to a losing state.
This is the standard win/lose state transition for impartial games.
*/

/*
Method to Solve:
----------------
1. Create a dp array where dp[x] represents whether x stones
   is a winning state for the current player.
2. Set dp[0] = false because no move is possible.
3. For every remaining value from 1 to n:
   - Generate all possible perfect squares.
   - Check whether removing a square leads to a losing state.
4. If such a move exists, mark the current state as winning.
5. Otherwise, mark it as losing.
6. Return dp[n].
*/
public class LC1510StoneGameIV {

    /**
     * Determines whether the current player can win using recursion
     * with memoization.
     *
     * @param remaining stones remaining
     * @param dp        memoization array
     * @return true if the current player can force a win
     */
    private boolean canWin(int remaining, Boolean[] dp) {
        if (remaining == 0) {
            return false;
        }

        if (dp[remaining] != null) {
            return dp[remaining];
        }

        for (int i = 1; i * i <= remaining; i++) {
            if (!canWin(remaining - (i * i), dp)) {
                return dp[remaining] = true;
            }
        }

        return dp[remaining] = false;
    }

    /**
     * Determines whether Alice can win using recursive DP.
     *
     * @param n number of stones
     * @return true if Alice can force a win
     */
    public boolean winnerSquareGameMemoization(int n) {
        Boolean[] dp = new Boolean[n + 1];
        dp[0] = false;

        return canWin(n, dp);
    }

    /**
     * Determines whether Alice can win using bottom-up DP.
     *
     * @param n number of stones
     * @return true if Alice can force a win
     */
    public boolean winnerSquareGame(int n) {
        Boolean[] dp = new Boolean[n + 1];
        dp[0] = false;

        for (int remaining = 1; remaining <= n; remaining++) {
            for (int i = 1; i * i <= remaining; i++) {
                if (!dp[remaining - (i * i)]) {
                    dp[remaining] = true;
                    break;
                }
            }

            if (dp[remaining] == null) {
                dp[remaining] = false;
            }
        }

        return dp[n];
    }
}
// Time Complexity: O(n * sqrt(n))
// Space Complexity: O(n)
