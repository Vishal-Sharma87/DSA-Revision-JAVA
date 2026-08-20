// Created at: 15-January-2026
// Last revised at: 15-January-2026
// Link: https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/

package arrays.traversal;

import java.util.ArrayList;
import java.util.Collections;

/*
Problem Description:
--------------------
Statement:
Given an array of positive integers, find all leader elements.
A leader is an element that is greater than or equal to every element to its right.
The rightmost element is always considered a leader.

Example:
Input:
nums = [16, 17, 4, 3, 5, 2]

Output:
[17, 5, 2]

Constraints:
- 1 <= n <= 10^6
- 1 <= nums[i] <= 10^6
*/

/*
Approach 1: Brute Force

Idea:
For every element, check all elements on its right.
If no larger element exists, mark it as a leader.

Time Complexity:
O(n²)

Space Complexity:
O(1) Auxiliary Space

Drawbacks:
Each element repeatedly scans the remaining array, making it inefficient.
*/

/*
Approach 2: Reverse Traversal (Optimal)

Idea:
Traverse the array from right to left while maintaining the maximum element seen so far.
If the current element is greater than or equal to this maximum, it is a leader.
Since leaders are collected in reverse order, reverse the result before returning.

Time Complexity:
O(n)

Space Complexity:
O(1) Auxiliary Space
(Excluding the output list)

Key Insight:
While moving from right to left, the maximum element seen so far represents the
largest value on the current element's right.
*/

/*
Method to Solve:
----------------
1. Initialize the maximum element seen so far.
2. Traverse the array from right to left.
3. Add an element if it is greater than or equal to the current maximum.
4. Update the maximum.
5. Reverse the collected leaders before returning.
*/

// Time Complexity: O(n)
// Space Complexity: O(1) Auxiliary Space

public class GFG_LeadersInArray {

    /**
     * Finds all leader elements in the given array.
     *
     * @param nums input array
     * @return list of leader elements in original order
     */
    public ArrayList<Integer> findLeaders(int[] nums) {

        ArrayList<Integer> leaders = new ArrayList<>();
        int length = nums.length;

        if (length == 0) {
            return leaders;
        }

        int maximum = -1; // all array elements are positive

        for (int index = length - 1; index >= 0; index--) {

            // found a new leader
            if (nums[index] >= maximum) {
                leaders.add(nums[index]);
                maximum = nums[index];
            }
        }

        // restore original order
        Collections.reverse(leaders);

        return leaders;
    }
}