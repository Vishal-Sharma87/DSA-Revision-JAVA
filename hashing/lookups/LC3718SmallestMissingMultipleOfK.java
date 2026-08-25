package hashing.lookups;

// Created at: 26-August-2026

// Last revised at: 26-August-2026
// Link: LeetCode 3718 - Smallest Missing Multiple of K

/*
Problem Description:
--------------------
Statement:
Given an integer array nums and an integer k, return the smallest positive
multiple of k that is missing from nums.

A multiple of k is any positive integer divisible by k.

Example:
Input: nums = [8,2,3,4,6], k = 2
Output: 10

Explanation:
The multiples of 2 are 2, 4, 6, 8, 10, ...
The first multiple missing from nums is 10.

Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 100
1 <= k <= 100
*/

/*
Approach 1: Brute Force

Idea:
Start from k and check whether each multiple exists in nums.
For every candidate multiple, scan the entire array.

Time Complexity:
O(n^2)

Space Complexity:
O(1)

Drawbacks:
Each membership check requires a linear scan of nums.
Using a HashSet avoids this repeated work.
*/

/*
Approach 2: Hashing + Lookup

Idea:
Store all numbers from nums in a HashSet.
Start from k and generate multiples in increasing order.
The first multiple not present in the set is the answer.

Time Complexity:
O(n) average

Space Complexity:
O(n)

Drawbacks:
Uses extra space for the HashSet.

Key Insight:
The answer must be one of k, 2k, 3k, ...
Hashing lets us check whether each candidate is present in O(1)
on average instead of scanning the array.
*/

/*
Method to Solve:
----------------
1. Store all elements of nums in a HashSet.
2. Start with the first positive multiple, k.
3. Check whether the current multiple exists in the set.
4. If it exists, move to the next multiple by adding k.
5. Return the first missing multiple.
*/

import java.util.HashSet;
import java.util.Set;

public class LC3718SmallestMissingMultipleOfK {

    /**
     * Finds the smallest positive multiple of k missing from nums.
     *
     * @param nums input array
     * @param k    value whose multiples are checked
     * @return smallest positive multiple of k missing from nums
     */
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> present = new HashSet<>();

        for (int num : nums) {
            if (num % k == 0) {
                present.add(num);
            }
        }

        int curr = k;

        while (present.contains(curr)) {
            curr += k;
        }

        return curr;
    }
}

// Time Complexity: O(n) average
// Space Complexity: O(n)
