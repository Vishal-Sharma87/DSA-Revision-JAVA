package arrays.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Created at: 22-August-2026
// Last revised at: 22-August-2026
// Link: https://leetcode.com/problems/3sum/

public class LC15ThreeSum {

    /*
     * Problem Description:
     * --------------------
     * Statement:
     * Given an integer array nums, return all the unique triplets
     * [nums[i], nums[j], nums[k]] such that:
     * 
     * - i, j and k are distinct.
     * - nums[i] + nums[j] + nums[k] == 0.
     * 
     * The solution set must not contain duplicate triplets.
     * 
     * Example:
     * Input:
     * nums = [-1,0,1,2,-1,-4]
     * 
     * Output:
     * [[-1,-1,2],[-1,0,1]]
     * 
     * Constraints:
     * - 3 <= nums.length <= 3000
     * - -10^5 <= nums[i] <= 10^5
     */

    /*
     * Approach 1: Brute Force
     * 
     * Idea:
     * Generate every possible triplet and check whether its sum equals zero.
     * 
     * Time Complexity:
     * O(n^3)
     * 
     * Space Complexity:
     * O(1)
     * 
     * Drawbacks:
     * Too slow for the given constraints.
     */

    /*
     * Approach 2: Sorting + Two Pointers (Optimal)
     * 
     * Idea:
     * Sort the array.
     * Fix one element and use two pointers to search for the remaining
     * two elements whose sum equals the negative of the fixed element.
     * 
     * Skip duplicate values to avoid repeated triplets.
     * 
     * Time Complexity:
     * O(n^2)
     * 
     * Space Complexity:
     * O(1)
     * (excluding the output list)
     * 
     * Key Insight:
     * Sorting allows duplicate removal and enables the two-pointer
     * technique, reducing the complexity from O(n^3) to O(n^2).
     */

    /*
     * Method to Solve:
     * ----------------
     * 1. Sort the array.
     * 2. Fix one element.
     * 3. Use two pointers to search for the remaining pair.
     * 4. Skip duplicate values for all three positions.
     * 5. Store every valid triplet.
     */

    /**
     * Returns all unique triplets whose sum equals zero.
     *
     * @param nums input array
     * @return list of unique triplets
     */
    public List<List<Integer>> threeSum(int[] nums) {

        int length = nums.length;
        List<List<Integer>> answer = new ArrayList<>();

        // sort the array
        Arrays.sort(nums);

        int first = 0;

        // fix the first element
        while (first < length) {

            int left = first + 1;
            int right = length - 1;

            int firstValue = nums[first];

            // search remaining pair
            while (left < right) {

                int currentSum = nums[first] + nums[left] + nums[right];

                if (currentSum == 0) {

                    answer.add(List.of(
                            nums[first],
                            nums[left],
                            nums[right]));

                    // skip duplicates
                    int leftValue = nums[left];
                    int rightValue = nums[right];

                    while (left < right && nums[left] == leftValue) {
                        left++;
                    }

                    while (left < right && nums[right] == rightValue) {
                        right--;
                    }

                } else if (currentSum < 0) {

                    left++;

                } else {

                    right--;
                }
            }

            // skip duplicates for first element
            while (first < length && nums[first] == firstValue) {
                first++;
            }
        }

        return answer;
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(1) excluding the output list
