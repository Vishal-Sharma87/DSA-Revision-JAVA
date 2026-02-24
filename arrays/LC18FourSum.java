package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18FourSum {
    // link : https://leetcode.com/problems/4sum/description/
    /*
     * 18. 4Sum
     * Solved
     * Medium
     * Topics
     * premium lock icon
     * Companies
     * Given an array nums of n integers, return an array of all the unique
     * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
     * 
     * 0 <= a, b, c, d < n
     * a, b, c, and d are distinct.
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * You may return the answer in any order.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,0,-1,0,-2,2], target = 0
     * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * Example 2:
     * 
     * Input: nums = [2,2,2,2,2], target = 8
     * Output: [[2,2,2,2]]
     * 
     * 
     * Constraints:
     * 
     * 1 <= nums.length <= 200
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        /**
         * 18. 4Sum
         *
         * Given an integer array nums and an integer target, return all the unique
         * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
         *
         * a, b, c, and d are distinct indices
         * nums[a] + nums[b] + nums[c] + nums[d] == target
         *
         * The solution set must not contain duplicate quadruplets.
         *
         * ----------------------------------------------------------
         * APPROACH (Sorting + Two Pointer Optimization)
         * ----------------------------------------------------------
         *
         * Brute force would take O(n^4) by checking every quadruplet.
         * We optimize this using:
         *
         * 1. Sorting the array.
         * 2. Fixing the first and second element.
         * 3. Using a two-pointer technique to find the remaining two.
         *
         * This reduces the complexity to O(n^3).
         *
         * ----------------------------------------------------------
         * WHY SORTING?
         * ----------------------------------------------------------
         * - Enables two-pointer approach.
         * - Helps avoid duplicates efficiently.
         * - Allows pruning of unnecessary searches.
         *
         * ----------------------------------------------------------
         * DUPLICATE HANDLING
         * ----------------------------------------------------------
         * Since the array is sorted:
         * - Skip repeated values for first and second index.
         * - Move pointers while skipping duplicates.
         *
         * ----------------------------------------------------------
         * INTEGER OVERFLOW
         * ----------------------------------------------------------
         * The sum of 4 integers may exceed the range of int.
         * So we convert to long before summation.
         *
         * ----------------------------------------------------------
         * TIME COMPLEXITY
         * ----------------------------------------------------------
         * Sorting: O(n log n)
         * Main logic: O(n^3)
         *
         * ----------------------------------------------------------
         * SPACE COMPLEXITY
         * ----------------------------------------------------------
         * O(1) extra space (excluding output).
         *
         * ----------------------------------------------------------
         * Example:
         * Input: nums = [1,0,-1,0,-2,2], target = 0
         * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
         *
         */
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        if (n < 4)
            return result;

        Arrays.sort(nums);

        long requiredSum = target;

        int first = 0;

        // Fix the first element
        while (first < n - 3) {

            int second = first + 1;

            // Fix the second element
            while (second < n - 2) {

                int left = second + 1;
                int right = n - 1;

                // Two-pointer search for remaining two elements
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

                        // Skip duplicates for third and fourth elements
                        int prevLeft = nums[left];
                        int prevRight = nums[right];

                        while (left < right && nums[left] == prevLeft)
                            left++;
                        while (left < right && nums[right] == prevRight)
                            right--;
                    } else if (currentSum < requiredSum) {
                        left++;
                    } else {
                        right--;
                    }
                }

                // Skip duplicates for second index
                int prevSecond = nums[second];
                while (second < n - 2 && nums[second] == prevSecond) {
                    second++;
                }
            }

            // Skip duplicates for first index
            int prevFirst = nums[first];
            while (first < n - 3 && nums[first] == prevFirst) {
                first++;
            }
        }

        return result;
    }

}
