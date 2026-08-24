package dp.gametheory;

// Created at: 25-August-2026
// Last revised at: 25-August-2026
// Link: https://leetcode.com/problems/stone-game-viii/

/*
Problem Description:
--------------------
Statement:
There are n stones in a row. On each turn, while more than one stone remains,
a player chooses x > 1, removes the leftmost x stones, and scores their sum.
Alice moves first; both play optimally — Alice maximizes, Bob minimizes the
score difference (Alice's score - Bob's score). Return that final difference.

Example:
Input: stones = [-1,2,-3,4,-5]
Output: 5
Explanation: Alice takes the first 4 stones (score 2), Bob takes the last 2
(score -3). Difference = 2 - (-3) = 5.

Constraints:
n == stones.length
2 <= n <= 10^5
-10^4 <= stones[i] <= 10^4
*/

/*
Approach 1: Memoized Recursion (Two-Loop)
Idea:
For a given boundary `index` (stones 0..index-1 already committed), try every
possible stopping point `i >= index` for the current move, scoring
preSum[i] and subtracting the opponent's best result from i+1 onward.
Memoize on `index` alone, since the accumulated value at that index is always
a fixed prefix sum — not a free dimension.

Time Complexity: O(n^2) — memoized over index, but each call still scans
the remaining suffix.

Space Complexity: O(n) — dp array + recursion stack.

Drawbacks:
Passes correctness but TLEs around n ~ 10^4 due to the O(n) inner loop per index.
*/

/*
Approach 2: ★ Optimal Suffix Max (One Pass)
Idea:
dp[index] = max(dp[index+1], preSum[index] - dp[index+1]).
The "try every i >= index" search from Approach 1 telescopes into this single
comparison once dp[index+1] already holds the best result over every i >= index+1.
Track it with one running variable while scanning right to left.

Time Complexity: O(n)

Space Complexity: O(n) — preSum array (shared with Approach 1 for consistency).

Drawbacks:
None for this problem size; strictly dominates Approach 1.
*/

/*
Method to Solve:
----------------
1. Build prefix sums so any segment's score is a single subtraction.
2. Recognize the DP state is just `index` — the accumulated value at that
   index is always preSum[index-1], not an independent dimension.
3. Define dp[index] as the best score-difference the mover gets, starting
   a fresh move at index.
4. Collapse the "try every stopping point" search into a running best,
   scanned from the last index down to 1.
5. Answer is dp[1], since the first move must cover at least stones[0..1].
*/
public class LC1872StoneGameVIII {

    /**
     * Entry point — delegates to the optimal O(n) approach.
     *
     * @param stones values of the stones in row order
     * @return score difference (Alice - Bob) under optimal play
     */
    public int stoneGameVIII(int[] stones) {
        return solveOptimal(stones);
    }

    /**
     * Optimal one-pass solution using the suffix-max recurrence.
     *
     * @param stones values of the stones in row order
     * @return score difference (Alice - Bob) under optimal play
     */
    private int solveOptimal(int[] stones) {
        int length = stones.length;
        int[] preSum = buildPrefixSum(stones);

        int best = preSum[length - 1];
        // collapses Approach 1's inner loop into one comparison per index
        for (int index = length - 2; index > 0; index--) {
            best = Math.max(best, preSum[index] - best);
        }
        return best;
    }

    /**
     * Memoized top-down solution — kept for revision, not called by the
     * main entry point since it TLEs on large inputs.
     *
     * @param stones values of the stones in row order
     * @return score difference (Alice - Bob) under optimal play
     */
    public int solveMemoized(int[] stones) {
        int length = stones.length;
        int[] preSum = buildPrefixSum(stones);
        Integer[] dp = new Integer[length + 1];
        return recursionMemoized(1, stones, dp, preSum);
    }

    /**
     * Recursive helper for the memoized approach.
     *
     * @param index  current boundary — stones 0..index-1 already committed
     * @param stones values of the stones in row order
     * @param dp     memo table keyed by index
     * @param preSum prefix sums of stones
     * @return best score difference achievable from this boundary onward
     */
    private int recursionMemoized(int index, int[] stones, Integer[] dp, int[] preSum) {
        if (index >= stones.length)
            return 0;
        if (dp[index] != null)
            return dp[index];

        int current = preSum[index - 1] + stones[index];
        int maxi = current - recursionMemoized(index + 1, stones, dp, preSum);

        // try every larger stopping point for this move
        for (int i = index + 1; i < stones.length; i++) {
            current += stones[i];
            maxi = Math.max(maxi, current - recursionMemoized(i + 1, stones, dp, preSum));
        }

        return dp[index] = maxi;
    }

    /**
     * Builds the prefix sum array shared by both approaches.
     *
     * @param stones values of the stones in row order
     * @return prefix sums where preSum[i] = sum of stones[0..i]
     */
    private int[] buildPrefixSum(int[] stones) {
        int[] preSum = new int[stones.length];
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
            preSum[i] = sum;
        }
        return preSum;
    }
}