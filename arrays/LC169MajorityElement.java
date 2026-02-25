package arrays;

public class LC169MajorityElement {
    public int find(int[] nums) {

        // link: https://leetcode.com/problems/majority-element/description/
        /*
         * 169. Majority Element
         * Given an array nums of size n, return the majority element.
         * 
         * The majority element is the element that appears more than ⌊n / 2⌋ times. You
         * may assume that the majority element always exists in the array.
         * 
         * 
         * 
         * Example 1:
         * 
         * Input: nums = [3,2,3]
         * Output: 3
         * Example 2:
         * 
         * Input: nums = [2,2,1,1,1,2,2]
         * Output: 2
         * 
         * 
         * Constraints:
         * 
         * n == nums.length
         * 1 <= n <= 5 * 104
         * -109 <= nums[i] <= 109
         * The input is generated such that a majority element will exist in the array.
         * 
         * 
         * Follow-up: Could you solve the problem in linear time and in O(1) space?
         */
        // optimal
        int major = nums[0];
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                major = nums[i];
                cnt++;
            } else if (nums[i] == major) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return major;
    }
}
