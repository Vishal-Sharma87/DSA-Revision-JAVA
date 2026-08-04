package hashing.traversal;

// Created at: 05-August-2026
// Last revised at: 05-August-2026
// Link: https://leetcode.com/problems/find-missing-elements/description/

/*
Problem Description:
--------------------
Statement:
Given an integer array, return all integers missing between the smallest and
largest element in the array (excluding both endpoints).

Example:
Input:
nums = [3, 7, 1]

Output:
[2, 4, 5, 6]

Constraints:
- Elements may appear multiple times.
- Order of the input does not matter.
*/

/*
Approach 1: HashSet + Range Traversal

Idea:
1. Store every number in a HashSet.
2. Track the minimum and maximum values.
3. Traverse from (minimum + 1) to (maximum - 1).
4. Any value not present in the set is a missing number.

Time Complexity:
O(n + (max - min))

Space Complexity:
O(n)

Key Insight:
HashSet provides O(1) average lookup, allowing efficient detection of missing
numbers while scanning the range only once.
*/

/*
Method to Solve:
----------------
1. Insert every element into a HashSet.
2. Find the smallest and largest values.
3. Traverse numbers between them.
4. Add numbers absent from the HashSet.
5. Return the collected missing numbers.
*/

import java.util.*;

/**
 * Finds all missing integers between the smallest and largest values.
 */
public class LC3731FindMissingElements {

    /**
     * Returns all missing integers between the minimum and maximum values.
     *
     * @param nums input array
     * @return list of missing integers
     */
    public List<Integer> findMissingElements(int[] nums) {

        Set<Integer> present = new HashSet<>();

        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        // build lookup and track range
        for (int num : nums) {
            present.add(num);
            smallest = Math.min(smallest, num);
            largest = Math.max(largest, num);
        }

        List<Integer> missing = new ArrayList<>();

        // collect missing values
        for (int value = smallest + 1; value < largest; value++) {
            if (!present.contains(value)) {
                missing.add(value);
            }
        }

        return missing;
    }
}

// Time Complexity: O(n + (max - min))
// Space Complexity: O(n)