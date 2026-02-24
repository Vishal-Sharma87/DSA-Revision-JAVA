package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC229MajorityElements2 {

    public List<Integer> majorityElement(int[] nums) {
        // link: https://leetcode.com/problems/majority-element-ii/description/
        /*
         * 229. Majority Element II
         * Solved
         * Medium
         * Topics
         * premium lock icon
         * Companies
         * Hint
         * Given an integer array of size n, find all elements that appear more than ⌊
         * n/3 ⌋ times.
         * 
         * 
         * 
         * Example 1:
         * 
         * Input: nums = [3,2,3]
         * Output: [3]
         * Example 2:
         * 
         * Input: nums = [1]
         * Output: [1]
         * Example 3:
         * 
         * Input: nums = [1,2]
         * Output: [1,2]
         * 
         * 
         * Constraints:
         * 
         * 1 <= nums.length <= 5 * 104
         * -109 <= nums[i] <= 109
         * 
         * 
         * Follow up: Could you solve the problem in linear time and in O(1) space?
         */
        // Optimization required
        HashMap<Integer, Integer> elementToOccurrance = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;
        int thresHold = len / 3 + 1;

        for (int i = 0; i < len; i++) {
            int occurrence = elementToOccurrance.getOrDefault(nums[i], 0);
            elementToOccurrance.put(nums[i], 1 + occurrence);
            if (occurrence + 1 == thresHold) {
                ans.add(nums[i]);
                if (ans.size() == 2)
                    break;
            }
        }
        return ans;

    }
}
