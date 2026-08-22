package greedy.intervals;

// Created at: 08-July-2026
// Last revised at: 08-July-2026
// Link: https://leetcode.com/problems/remove-covered-intervals/

/*
Problem Description:
--------------------
Statement:
Given an array of intervals where intervals[i] = [li, ri], remove all intervals
that are completely covered by another interval in the array.

An interval [a, b] is covered by [c, d] if:
c <= a and b <= d.

Return the number of remaining intervals.

Example:
Input:
intervals = [[1,4],[3,6],[2,8]]

Output:
2

Explanation:
[3,6] is covered by [2,8].

Constraints:
- 1 <= intervals.length <= 1000
- intervals[i].length == 2
- 0 <= li < ri <= 10^5
*/

/*
Approach 1: Brute Force

Idea:
Compare every interval with every other interval and check whether it is
completely covered.

Time Complexity:
O(n²)

Space Complexity:
O(1)

Drawbacks:
Too slow for large inputs because every interval is compared against all others.
*/

/*
Approach 2: Sorting + Greedy (Optimal)

Idea:
1. Sort intervals by starting point in ascending order.
2. If two intervals have the same start, place the longer interval first by
   sorting the ending point in descending order.
3. Track the farthest right endpoint seen so far.
4. If the current interval ends before or at the tracked endpoint, it is covered.
5. Otherwise, it becomes a new valid interval and updates the farthest endpoint.

Time Complexity:
O(n log n)

Space Complexity:
O(1) (Ignoring sorting stack)

Key Insight:
Sorting ensures that every possible covering interval appears before the interval
it can cover. The descending order for equal starting points guarantees the
longest interval is processed first.
*/

/*
Method to Solve:
----------------
1. Sort intervals by start ascending.
2. If starts are equal, sort by end descending.
3. Initialize the farthest right endpoint.
4. Skip intervals whose end is within the current farthest endpoint.
5. Count only uncovered intervals.
*/

import java.util.Arrays;

public class LC1288RemoveCoveredIntervals {

    /**
     * Returns the number of intervals remaining after removing
     * all covered intervals.
     *
     * @param intervals input interval array
     * @return number of uncovered intervals
     */
    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int intervalCount = 0;
        int topRight = intervals[0][1];

        for (int i = 0; i < intervals.length; i++) {

            // keep only uncovered intervals
            if (intervalCount == 0 || intervals[i][1] > topRight) {
                intervalCount++;
                topRight = intervals[i][1];
            }
        }

        return intervalCount;
    }
}

// Time Complexity: O(n log n)
// Space Complexity: O(1)