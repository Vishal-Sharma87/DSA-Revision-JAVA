package dp.gametheory;

// Created at: 18-August-2026
// Last revised at: 18-August-2026
// Link: https://leetcode.com/problems/stone-game-v/

/*
Problem Description:
--------------------
Statement:
Given an array of stone values, split the current interval into two non-empty
parts. Compare the sums of both parts and continue the game according to the
rules. Return the maximum score Alice can obtain.

Example:
Input: stoneValue = [6,2,3,4,5,5]
Output: 18

Constraints:
- 2 <= stoneValue.length <= 500
- 1 <= stoneValue[i] <= 10^6
*/

/*
Approach 1: Brute Force Recursion

Idea:
Try every possible separator for every recursive interval without memoization.

Time Complexity:
Exponential.

Space Complexity:
O(n) recursion stack.

Drawbacks:
The same intervals are solved repeatedly.
*/

/*
Approach 2: Recursion + Memoization

Idea:
Treat every interval [start, end] as a DP state.

For every separator, calculate the left and right partition sums using
prefix sums. Continue with the side having the smaller sum. If both sums
are equal, try both sides and keep the better result.

Memoize the result for every interval.

Time Complexity:
O(n^3)

Space Complexity:
O(n^2)

Drawbacks / Key Insight:
There are O(n^2) interval states and O(n) separators per state.
Prefix sums make each partition-sum calculation O(1).
*/

/*
Method to Solve:
----------------
1. Build the prefix-sum array.
2. Start recursion with the complete array.
3. Try every possible separator.
4. Calculate left and right sums in O(1).
5. Continue with the smaller-sum side.
6. If both sums are equal, try both choices.
7. Store each interval result in the memoization table.
*/

// Time Complexity: O(n^3)
// Space Complexity: O(n^2)

class LC1563StoneGameV {

    /**
     * Finds the maximum score Alice can obtain.
     *
     * @param stoneValue array containing the value of each stone
     * @return maximum score Alice can obtain
     */
    public int stoneGameV(int[] stoneValue) {
        int length = stoneValue.length;

        int[] prefixSum = new int[length];

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += stoneValue[i];
            prefixSum[i] = sum;
        }

        Integer[][] dp = new Integer[length + 1][length + 1];

        return recursion(
                0,
                length - 1,
                stoneValue,
                prefixSum,
                dp);
    }

    /**
     * Computes the maximum score obtainable from the given interval.
     *
     * @param start      start index of the interval
     * @param end        end index of the interval
     * @param stoneValue array containing the stone values
     * @param prefixSum  prefix-sum array
     * @param dp         memoization table
     * @return maximum score obtainable from the interval
     */
    private int recursion(
            int start,
            int end,
            int[] stoneValue,
            int[] prefixSum,
            Integer[][] dp) {
        if (start >= end) {
            return 0;
        }

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        int maxScore = 0;

        for (int separator = start + 1; separator <= end; separator++) {
            int leftValue = prefixSum[separator - 1];

            if (start > 0) {
                leftValue -= prefixSum[start - 1];
            }

            int rightValue = prefixSum[end] - prefixSum[separator - 1];

            int currScore;

            if (leftValue < rightValue) {
                currScore = leftValue
                        + recursion(
                                start,
                                separator - 1,
                                stoneValue,
                                prefixSum,
                                dp);
            } else if (rightValue < leftValue) {
                currScore = rightValue
                        + recursion(
                                separator,
                                end,
                                stoneValue,
                                prefixSum,
                                dp);
            } else {
                int leftDiscarded = rightValue
                        + recursion(
                                separator,
                                end,
                                stoneValue,
                                prefixSum,
                                dp);

                int rightDiscarded = leftValue
                        + recursion(
                                start,
                                separator - 1,
                                stoneValue,
                                prefixSum,
                                dp);

                currScore = Math.max(leftDiscarded, rightDiscarded);
            }

            maxScore = Math.max(maxScore, currScore);
        }

        return dp[start][end] = maxScore;
    }
}