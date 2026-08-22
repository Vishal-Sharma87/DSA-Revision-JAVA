package arrays.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Created at: 22-August-2026
// Last revised at: 22-August-2026
// Link: https://leetcode.com/problems/4sum/

public class LC18FourSum {

    /*
     * Problem Description:
     * --------------------
     * Statement:
     * Given an integer array nums and an integer target, return all the unique
     * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
     * 
     * - All indices are distinct.
     * - nums[a] + nums[b] + nums[c] + nums[d] == target.
     * 
     * The solution set must not contain duplicate quadruplets.
     * 
     * Example:
     * Input:
     * nums = [1,0,-1,0,-2,2], target = 0
     * 
     * Output:
     * [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * 
     * Constraints:
     * - 1 <= nums.length <= 200
     * - -10^9 <= nums[i], target <= 10^9
     */

    /*
     * Approach 1: Brute Force
     * 
     * Idea:
     * Generate every possible quadruplet and check whether its sum equals
     * the target.
     * 
     * Time Complexity:
     * O(n^4)
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
     * Fix the first two elements and use the two-pointer technique to find
     * the remaining pair.
     * 
     * Skip duplicates at every level to avoid repeated quadruplets.
     * Use long while computing the sum to prevent integer overflow.
     * 
     * Time Complexity:
     * O(n^3)
     * 
     * Space Complexity:
     * O(1)
     * (excluding the output list)
     * 
     * Key Insight:
     * Sorting enables duplicate removal and allows the remaining search
     * to be performed using two pointers.
     */

    /*
     * Method to Solve:
     * ----------------
     * 1. Sort the array.
     * 2. Fix the first element.
     * 3. Fix the second element.
     * 4. Use two pointers to find the remaining pair.
     * 5. Skip duplicates for all four positions.
     * 6. Store every valid quadruplet.
     */

    /**
     * Returns all unique quadruplets whose sum equals the target.
     *
     * @param nums   input array
     * @param target required sum
     * @return list of unique quadruplets
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        if (n < 4) {
            return result;
        }

        // sort the array
        Arrays.sort(nums);

        long requiredSum = target;

        int first = 0;

        // fix the first element
        while (first < n - 3) {

            int second = first + 1;

            // fix the second element
            while (second < n - 2) {

                int left = second + 1;
                int right = n - 1;

                // search remaining pair
                while (left < right) {

                    long currentSum = (long) nums[first]
                            + nums[second]
                            + nums[left]
                            + nums[right];

                    if (currentSum == requiredSum) {

                        result.add(List.of(
                                nums[first],
                                nums[second],
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

                    } else if (currentSum < requiredSum) {

                        left++;

                    } else {

                        right--;
                    }
                }

                // skip duplicates for second element
                int secondValue = nums[second];

                while (second < n - 2 && nums[second] == secondValue) {
                    second++;
                }
            }

            // skip duplicates for first element
            int firstValue = nums[first];

            while (first < n - 3 && nums[first] == firstValue) {
                first++;
            }
        }

        return result;
    }
}

// Time Complexity: O(n^3)
// Space Complexity: O(1) excluding the output list
