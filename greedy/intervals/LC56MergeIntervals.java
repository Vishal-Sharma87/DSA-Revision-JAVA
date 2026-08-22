// Created at: 23-January-2026
// Last revised at: 23-January-2026
// Link: https://leetcode.com/problems/merge-intervals/

/*
Problem Description:
--------------------
Statement:
Given an array of intervals where intervals[i] = [starti, endi], merge all
overlapping intervals and return an array containing only the merged intervals.

Example:
Input:
intervals = [[1,3],[2,6],[8,10],[15,18]]

Output:
[[1,6],[8,10],[15,18]]

Constraints:
- 1 <= intervals.length <= 10^4
- intervals[i].length == 2
- 0 <= starti <= endi <= 10^4
*/

/*
Approach 1: Brute Force

Idea:
Repeatedly compare every interval with every other interval and merge whenever
an overlap is found until no more merges are possible.

Time Complexity:
O(n²)

Space Complexity:
O(n)

Drawbacks:
Repeated comparisons make it inefficient for large inputs.
*/

/*
Approach 2: Sort + Greedy Merge (Optimal)

Idea:
1. Sort intervals by starting time.
2. Keep the current merged interval.
3. If the next interval overlaps, extend the current interval.
4. Otherwise, store the current interval and start a new one.

Time Complexity:
O(n log n)

Space Complexity:
O(n)

Key Insight:
After sorting, overlapping intervals always appear consecutively.
*/

/*
Method to Solve:
----------------
1. Sort intervals based on their starting point.
2. Initialize the current merged interval.
3. Merge consecutive overlapping intervals.
4. Store completed merged intervals.
5. Convert the list into a 2D array.
*/

package greedy.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56MergeIntervals {

    /**
     * Merges all overlapping intervals.
     *
     * @param intervals input intervals
     * @return merged intervals
     */
    public int[][] merge(int[][] intervals) {

        int length = intervals.length;

        if (length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, (first, second) -> {
            if (first[0] == second[0]) {
                return first[1] - second[1];
            }
            return first[0] - second[0];
        });

        List<int[]> mergedIntervals = new ArrayList<>();

        int[] currentInterval = {
                intervals[0][0],
                intervals[0][1]
        };

        for (int index = 1; index < length; index++) {

            if (isOverlapping(currentInterval, intervals[index])) {

                currentInterval[1] = Math.max(currentInterval[1], intervals[index][1]);

            } else {

                mergedIntervals.add(currentInterval);

                currentInterval = new int[] {
                        intervals[index][0],
                        intervals[index][1]
                };
            }
        }

        mergedIntervals.add(currentInterval);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    /**
     * Checks whether two intervals overlap.
     *
     * @param first  first interval
     * @param second second interval
     * @return true if overlapping, otherwise false
     */
    private boolean isOverlapping(int[] first, int[] second) {
        return !(first[0] > second[1] || first[1] < second[0]);
    }

    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
}