package greedy.intervals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Created at: 20-August-2026
// Last revised at: 20-August-2026
// Link: https://leetcode.com/problems/cinema-seat-allocation/

/*
Problem Description:
--------------------
Statement:
There are n rows in a cinema, with 10 seats in each row.
Some seats are reserved. A family of four can sit together only in one
of these seat groups:

- Seats 2, 3, 4, 5
- Seats 4, 5, 6, 7
- Seats 6, 7, 8, 9

Find the maximum number of families that can be seated.

Example:
Input:
n = 3
reservedSeats = [[1,2], [1,3], [1,8], [2,6]]

Output:
4

Constraints:
- 1 <= n <= 10^9
- 1 <= reservedSeats.length <= min(10^4, 10 * n)
- 1 <= reservedSeats[i][1] <= 10
*/

/*
Approach 1: Brute Force

Idea:
For every row, track all possible groups of four and check whether
each group contains a reserved seat.

Time Complexity:
O(n * 10)

Space Complexity:
O(n)

Drawbacks:
n can be very large, so iterating over every row is not feasible.
Most rows have no reserved seats and can directly accommodate two families.
*/

/*
Approach 2: Greedy / Intervals

Idea:
Start by assuming every row can accommodate two families.

Only rows containing relevant reserved seats need to be processed.
For each affected row, divide the possible seating positions into
three overlapping intervals:

- Left  : 2-5
- Middle: 4-7
- Right : 6-9

A reserved seat can block one or more of these intervals.

For each affected row:
1. Detect whether the left interval is blocked.
2. Detect whether the middle interval is blocked.
3. Detect whether the right interval is blocked.
4. If only the middle is blocked, one family can still sit.
5. If left and right are both blocked, only one family can sit.
6. If only one side is blocked, one family can sit.
7. If none are blocked, two families can sit.

Time Complexity:
O(r), where r is the number of reserved seats.

Space Complexity:
O(r), for storing reserved seats grouped by row.

Key Insight:
Every completely free row contributes two families.
Therefore, start with 2 * n and only adjust the count for rows
that contain reserved seats.
*/
public class LC1386CinemaSeatAllocation {

    /*
     * Method to Solve:
     * ----------------
     * 1. Group relevant reserved seats by row.
     * 2. Start with two families for every row.
     * 3. For each affected row, determine which seating intervals are blocked.
     * 4. Reduce the initial count according to the blocked intervals.
     * 5. Return the maximum number of families.
     */

    // Time Complexity: O(r)
    // Space Complexity: O(r)

    /**
     * Finds the maximum number of four-person families that can be seated.
     *
     * @param n             number of cinema rows
     * @param reservedSeats reserved seat positions represented as [row, seat]
     * @return maximum number of families that can be seated
     */
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            int seat = reservedSeat[1];

            if (seat > 1 && seat < 10) {
                map.computeIfAbsent(row, key -> new ArrayList<>()).add(seat);
            }

        }

        int groupAllotted = n * 2;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            boolean left = false;
            boolean mid = false;
            boolean right = false;

            for (int seat : entry.getValue()) {
                if (seat < 4) {
                    left = true;
                } else if (seat < 6) {
                    left = true;
                    mid = true;
                } else if (seat < 8) {
                    mid = true;
                    right = true;
                } else {
                    right = true;
                }
            }

            if (mid) {
                if (left && right) {
                    groupAllotted -= 2;
                } else {
                    groupAllotted--;
                }
            } else if (left || right) {
                groupAllotted--;
            }
        }

        return groupAllotted;
    }
}