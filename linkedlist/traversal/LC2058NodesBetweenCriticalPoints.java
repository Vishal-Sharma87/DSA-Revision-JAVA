package linkedlist.traversal;

import linkedlist.singlylinkedlist.ListNode;

// Created at: 01-September-2026
// Last revised at: 01-September-2026
// Link: LeetCode 2058 - Find the Minimum and Maximum Number of Nodes Between Critical Points

/*
Problem Description:
--------------------
Statement:
A critical point in a linked list is a node that is either a local maximum
or a local minimum.

A local maximum is strictly greater than both its previous and next nodes.
A local minimum is strictly smaller than both its previous and next nodes.

Return [minDistance, maxDistance]:
- minDistance = minimum distance between any two critical points.
- maxDistance = maximum distance between any two critical points.

If fewer than two critical points exist, return [-1, -1].

Example:
Input:  [5,3,1,2,5,1,2]
Output: [1,3]

Constraints:
- 2 <= number of nodes <= 10^5
- 1 <= Node.data <= 10^5
*/

/*
Approach 1: Brute Force

Idea:
Store the positions of all critical points during traversal.
Afterward, compare every pair of critical points to find the minimum
and maximum distance.

Time Complexity:
O(n + k^2), where k is the number of critical points.

Space Complexity:
O(k)

Drawbacks:
Requires storing all critical-point positions and comparing pairs.
The quadratic comparison is unnecessary.
*/

/*
Approach 2: Single Pass Traversal

Idea:
Traverse the list using previous, current, and next nodes.

First, locate the first critical point.
Then continue traversing while tracking:
- distanceFromLast: distance from the previous critical point.
- distanceFromFirst: distance from the first critical point.

Whenever another critical point is found:
- update the minimum distance using distanceFromLast.
- update the maximum distance using distanceFromFirst.
- reset distanceFromLast for the next pair.

Only consecutive critical points are needed for the minimum distance.
The first and latest critical points determine the maximum distance.

Time Complexity:
O(n)

Space Complexity:
O(1)

Drawbacks:
The pointer and distance bookkeeping is slightly more involved than
storing all critical-point indices.

Key Insight:
Because critical points are discovered in order:
- minimum distance only needs consecutive critical points.
- maximum distance is the distance between the first and latest
  critical points.
*/

/*
Method to Solve:
----------------
1. Return [-1, -1] if the list has fewer than three nodes.
2. Traverse until the first critical point is found.
3. Start measuring distances from the first critical point.
4. For every subsequent critical point:
   - update the minimum distance.
   - update the maximum distance from the first critical point.
5. Return [-1, -1] if no second critical point exists.
*/

// Time Complexity: O(n)
// Space Complexity: O(1)

public class LC2058NodesBetweenCriticalPoints {

    /**
     * Finds the minimum and maximum distances between critical points.
     *
     * @param head head of the singly linked list
     * @return array containing [minimum distance, maximum distance],
     *         or [-1, -1] when fewer than two critical points exist
     */
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] notExists = new int[] { -1, -1 };

        if (head == null || head.next == null || head.next.next == null) {
            return notExists;
        }

        ListNode prev = head;
        ListNode mover = head.next;

        // Find the first critical point.
        while (mover != null && mover.next != null) {
            ListNode next = mover.next;

            boolean localMinima = prev.data > mover.data && mover.data < next.data;
            boolean localMaxima = prev.data < mover.data && mover.data > next.data;

            if (localMinima || localMaxima) {
                break;
            }

            prev = mover;
            mover = next;
        }

        if (mover == null || mover.next == null) {
            return notExists;
        }

        int distanceFromLast = 1;
        int distanceFromFirst = 1;

        prev = mover;
        mover = mover.next;

        boolean anotherCriticalPointExist = false;

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;

        while (mover != null && mover.next != null) {
            ListNode next = mover.next;

            boolean localMinima = prev.data > mover.data && mover.data < next.data;
            boolean localMaxima = prev.data < mover.data && mover.data > next.data;

            if (localMinima || localMaxima) {
                anotherCriticalPointExist = true;

                minDistance = Math.min(minDistance, distanceFromLast);
                maxDistance = distanceFromFirst;

                distanceFromLast = 1;
                distanceFromFirst++;
            } else {
                distanceFromLast++;
                distanceFromFirst++;
            }

            prev = mover;
            mover = next;
        }

        if (!anotherCriticalPointExist) {
            return notExists;
        }

        return new int[] { minDistance, maxDistance };
    }
}