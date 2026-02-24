package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15ThreeSum {

    // link:https://leetcode.com/problems/3sum/description/
    /*
     * Code
     * Testcase
     * Testcase
     * Test Result
     * 15. 3Sum
     * Solved
     * Medium
     * Topics
     * premium lock icon
     * Companies
     * Hint
     * Given an integer array nums, return all the triplets [nums[i], nums[j],
     * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
     * nums[k] == 0.
     * 
     * Notice that the solution set must not contain duplicate triplets.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * Notice that the order of the output and the order of the triplets does not
     * matter.
     * Example 2:
     * 
     * Input: nums = [0,1,1]
     * Output: []
     * Explanation: The only possible triplet does not sum up to 0.
     * Example 3:
     * 
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     * Explanation: The only possible triplet sums up to 0.
     * 
     * 
     * Constraints:
     * 
     * 3 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     */

    public List<List<Integer>> threeSum(int[] nums) {

        // optimal
        // Two Pointers
        // fixed i and movable j, k

        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        int i = 0;

        while (i < len) {
            int j = i + 1, k = len - 1;
            int prevI = nums[i], prevJ, prevK;

            while (j < len && j < k) {
                int val = nums[i] + nums[j] + nums[k];
                if (val == 0) {
                    // found a valid triplet
                    ans.add(List.of(nums[i], nums[j], nums[k]));

                    // iterate j and k utill they arre different from their previous value

                    prevJ = nums[j];
                    prevK = nums[k];

                    while (j < len && nums[j] == prevJ)
                        j++;
                    while (k > i && nums[k] == prevK)
                        k--;
                } else if (val < 0)
                    j++;
                else
                    k--;
            }
            while (i < len && nums[i] == prevI)
                i++;
        }

        return ans;
    }
}
